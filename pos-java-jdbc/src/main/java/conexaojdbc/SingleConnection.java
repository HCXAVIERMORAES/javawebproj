package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	/**classe de conexão com o BD postgre. Como cada classe deve ter uma única responsabilidade usa-se um padrão singleton
	 tem como definição garantir que uma classe tenha apenas uma instância de si mesma e que forneça um ponto global de acesso 
	 a ela. 
	 O padrão Singleton permite criar objetos únicos para os quais há apenas uma instância. Este padrão oferece um ponto
	 de acesso global, assim como uma variável global, porém sem as desvantagens das variáveis globais. 
	 Apenas esta classemussa-se satatic*/
	
	private static String url = "jdbc:postgresql://localhost:5432/posjava";     			// banco
	private static String password = "Bel2107";  			//senha
	private static String user = "postgres";      			//usuario 
	private static Connection connection= null; 	//Objeto Connectiondo pacote java.sql
	
	/**static para que sempre que, em qualquer lugar, precisar invocar o SingleCannection ele vai chamar o conectar
	 * ficando automatizado*/
	static {
		conectar();
	}
	
	
	//construtor
	public SingleConnection() {
		// chama o metodo conectar()
		conectar();
	}
	
	//Metodo privado para ser acessivel apena dentro do objeto
	private static void conectar () {
		
		try {
			/** verificação de se a conexão for nula, pois a conexão é aberta uma vez e deve ser mantida, o que se abre
			e fecha são secões, não faz nada senão abrir conexão*/ 
			if(connection == null) {
				/*1ª - fazer o carregamento do driver a ser usado, de acordo com o BD usado
				 *2ª - passar o endereço do BD, o usuario e a senha*/
				Class.forName("org.postgresql.Driver");//1ª
				connection = DriverManager.getConnection(url, user, password);//objeto conection (conexao)
				connection.setAutoCommit(false); //para não salvar automaticamente no BD
				System.out.println("conexão bem sucesdida "); //mesagem se houver conectado
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Método publico que retorna o objeto connetion, para ser acessado por outros lugares
	public static Connection getConnection() {
		return connection;
	}
	
}
