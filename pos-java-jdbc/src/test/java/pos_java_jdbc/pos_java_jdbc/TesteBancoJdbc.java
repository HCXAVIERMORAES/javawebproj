package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import DAO.UserPosDAO;
import model.UserposJava;

public class TesteBancoJdbc {
	/*Para executar apenar um metodo dar-se 2 clik nele e mando executar*/
	
	//metodo para testar a coneão. anotação de teste
	/*Ao usar o id no banco de forma automatica, não é mais necessario passa-lo na aplicação podendo então se 
	 * retirado**/
	@Test
	public void initBanco() { //metodo de insert
		//após testar a conexão esse objeto não mais é necessário
		//SingleConnection.getConnection(); //chama a conexão
		
		//novo teste. insert no BD. usando a classe UserPosDAO, e dela chamando a conexão
		UserPosDAO userPosDAO = new UserPosDAO(); //instancia de DAO
		//tbm é preciso do objeto de modelo
		UserposJava userposJava = new UserposJava();
		
		//setando os dados para deixa-los dinámico
		 //userposJava.setId(6L); apos o banco estar com id automatico
		 userposJava.setNome("Id automatico");
		 userposJava.setEmail("testeidauto@yahoo.com.br");
		
		//setando os objetos para eles terem dados
		 userPosDAO.salvar(userposJava); //chamando o metodo para salvar no BD
		 
		 //a classe Teste insere no BD
		
	}
	
	//testando o select
	/*Para o teste cria-se um metodo que deve ser publico e sempre chama-se o objeto UserPosDAO.
	 * Tendo o objeto 'dao' adicionamos em uma lista do tipo de objeto que vem do BD, no caso um UserposJava, lembra de 
	 * tratar a exeção, intera-se um forecht para varrer os objetos da lista.
	 * Para ficar mais facíl de exibir os resultados sobreescreve com o método tostring (na classe UserposJava),
	 * assim se passa o objeto direto no sysout, ou passondo os gets recuperando os atributos**/
	@Test
	public void initListar() {
		//instancia o objeto Dao
		UserPosDAO dao = new UserPosDAO();
		
		try {
			List<UserposJava> list = dao.listar();
			
			//iterando a lista com for
			for (UserposJava userposJava : list) {
				System.out.println("Lista completa: " + userposJava);
				System.out.println("Nome: "+ userposJava.getNome());
				System.out.println("-------*******------******---------");				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//metodo para buscar pelo id um único dado
	/*É como no método listar porem sem a lista**/
	@Test
	public void initBuscar() {
		UserPosDAO dao = new UserPosDAO();
		
		try {
			UserposJava userposJava = dao.buscar(5L);
			System.out.println(userposJava);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//meto de teste do update
	/* faz-se um método para atualizar buscando 1ª no DAO
	 * Depois se faz uma consulta ao BD e com isso tendo o Id 
	 * Seta-se o atributo a ser mudado e chama o metodo de atualizar no BD**/
	@Test
	public void initAtualizar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			UserposJava objetoBanco = dao.buscar(2L);
			objetoBanco.setNome("nome mudado com metodo atualizar");
			dao.atualizar(objetoBanco);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Método para deletar no BD
	@Test
	public void initDeletar() {
		try {
			
			UserPosDAO dao = new UserPosDAO();		
			dao.deletar(8L);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
