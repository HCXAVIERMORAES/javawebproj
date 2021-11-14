package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.UserposJava;

public class UserPosDAO {
	/*Parte de persistencia: esta classe será responsavel por fazer os inserts,delete, etc
	 * 1ª se estabelece a conexão
	 *2ª fazer o construtor que quando se iniciar este objeto ele vai injetar para dentro do objeto connection o
		 SingleConnection da classe de conexão.
	 *Assim poderá fazer as operações de salvar, update, etc*/
	private Connection connection; //1ª
	
	//construtor
	public UserPosDAO() {
		connection = SingleConnection.getConnection(); //2ª
	}
	
	//metodo de inserção. O metodo rebe um objeto UserposJava (classe), o objeto com os dados
	public void salvar(UserposJava userposJava) {
		try {
			//mondando o sql igual ao do banco, passando interrogaçoes no lugar dos atributos no BD
			String sql = "insert into userposjava (id , nome , email) values (?,?,?)";
			
			/*Esse objeto,PreparedStatement,retorna de destro de uma conexão passando um objeto que vai ser jagado no BD */
			PreparedStatement insert = connection.prepareStatement(sql); //é quem faz o insert. ele recebe um sql
			//passa-se os parámetro a serem passado na mesma posição do BD
			insert.setLong(1, userposJava.getId());  //id
			insert.setString(2,userposJava.getNome());	//nome
			insert.setString(3,userposJava.getEmail());  //email
			insert.execute();  //executa o insert
			connection.commit(); //salva no BD
			/* este só pode rodar uma vez, pois devido a restrição, chave primaria só pode haver um id no banco
			 * logo se tentar rodar mais de uma vez ele salva a primeira e na segund, como já haverá um id: 3, ele 
			 * retorna um erro. Então os dados devem ser trocados antes(dados estaticos: insert.setLong(1, 4); 
			 * insert.setString(2, "egidio salvar DAO novo id");  insert.setString(3,"alex.egidio@gmail.com"); 
			 * Para deixar dinamico devemossetar os dados, ex na classe Teste, e depois recuperar do objeto os dados de insert
			 *  */
			
		} catch (Exception e) {
			//dando um rollback
			try {
				connection.rollback(); //reverte operação, se houver problema
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			e.printStackTrace(); //retorna o erro se houver
		}
	}
	
	/*Metodo de consulta ao BD, todos os dados. Usando uma lista do tipo UserposJava*/	
	public List<UserposJava> listar() throws Exception{
		
		List<UserposJava> list = new ArrayList<UserposJava>();
		
		//variavel que receberá o comando do sql
		String sql = "select * from userposjava";
		
		PreparedStatement statement = connection.prepareStatement(sql); //prepara o objeto para receber o sql
		ResultSet resultado = statement.executeQuery(); //executa o sql
		
		//percorre a lista enquanto hover resultado
		while(resultado.next()) {
			
			UserposJava userposJava = new UserposJava();
			userposJava.setId(resultado.getLong("id")); //seta o objeto e recupera o atributo (conforme o tipo)
			userposJava.setNome(resultado.getString("nome"));
			userposJava.setEmail(resultado.getString("email"));
			
			list.add(userposJava); //adiciona na lista                                                                                          
			
		}
		
		return list;
	}
	
	/*Busca retornando apenas um elemento do BD conforme o Id sendo passado por parametro.
	 * É como no metodo listar(), porem retorna apenas um ou nenhum objeto ão inves de uma lista, acrescentado a clausula
	 * WHERE no sql concatenando com o id passado por parametro*/	
	public UserposJava buscar(Long id) throws Exception{
		
		UserposJava retorno = new UserposJava();
		
		String sql = "select * from userposjava where id = " + id;
		
		PreparedStatement statement = connection.prepareStatement(sql); 
		ResultSet resultado = statement.executeQuery(); 
		
		while(resultado.next()) {
			
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));			
		}
		
		return retorno;
	}	

}
