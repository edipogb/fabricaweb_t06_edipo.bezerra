package cjweb;

import java.util.List;
import java.util.Scanner;

import br.com.fabricadeprogramador.persistencia.DAO.UsuarioDAOJDBC;
import br.com.fabricadeprogramador.persistencia.entidade.Usuario;



public class TesteUsuarioDAO {
	
		

	public static void main(String[] args) {
		
		//Instancia de Scanner
		Scanner leitor = new Scanner(System.in);
		
		//Instancia de UsuárioDAO
		UsuarioDAOJDBC dao = new UsuarioDAOJDBC();
		
		//Instancia de Usuário
		Usuario usu = new Usuario();
		
		
		testeCadastrar(usu, dao, leitor);
		//testeAlterar(usu, dao, leitor);
		//testeExcluir(usu, dao, leitor);
		//testeSalvar(usu, dao, leitor);
		//testeBuscaPorId(dao, leitor);
		//testeBuscarTodos(dao);
		
	}

	public static void testeAutenticar(UsuarioDAOJDBC dao, Usuario usu,
			Scanner leitor) {

		System.out.println("Login do usuário: ");
		usu.setLogin(leitor.nextLine());

		System.out.println("Senha do usuário: ");
		usu.setSenha(leitor.nextLine());
		
		Usuario retornado = dao.autenticar(usu);
		// Imprimir

		System.out.println();
		System.out.println("Nome: " + retornado.getNome());
		System.out.println("Login: " + retornado.getLogin());
		System.out.println("Senha: " + retornado.getSenha());
		System.out.println("ID: " + retornado.getId());
		System.out.println();

	}
	
	public static void testeBuscarTodos(UsuarioDAOJDBC dao){
		List<Usuario> lista = dao.buscaTodos();
		for (Usuario usu : lista){
			System.out.println("ID: " + usu.getId());
			System.out.println("Nome: " + usu.getNome());
			System.out.println("Login: " + usu.getLogin());
			System.out.println("Senha: " + usu.getSenha());
		}
	}
	
	
	public static void testeBuscaPorId(UsuarioDAOJDBC dao, Scanner leitor) {
		
		System.out.println("Entre com o ID do Usuário: ");
		Integer id = leitor.nextInt();
		
		//Invocar o metido excluir
		Usuario usuRetornado = dao.buscaPorId(id);
		if (usuRetornado != null){
			//Imprimindo Usuário de retorno
			System.out.println("Nome: " + " " + usuRetornado.getNome());
			System.out.println("Login: " + " " +  usuRetornado.getLogin());
			System.out.println("Senha: " + " " + usuRetornado.getSenha());
			System.out.println("ID: " + " " + usuRetornado.getId());
			
		}
		
	}

	public static void testeSalvar(Usuario usu, UsuarioDAOJDBC dao, Scanner leitor) {
		
		System.out.println("Entre com o ID do Usuário: ");
		usu.setId(leitor.nextInt());
		System.out.println("Entre com o Nome de Usuário: ");
		usu.setNome(leitor.next());
		System.out.println("Entre com o Login fo Usuário: ");
		usu.setLogin(leitor.next());
		System.out.println("Entre com a Senha do Usuário: ");
		usu.setSenha(leitor.next());
		
		dao.cadastrar(usu);
		System.out.println("Usuario Salvo com sucesso!");
	}

	public static void testeExcluir(Usuario usu, UsuarioDAOJDBC dao, Scanner leitor) {
		
		System.out.println("Entre com o ID do Usuário: ");
		usu.setId(leitor.nextInt());
		
		dao.cadastrar(usu);
		System.out.println("Usuário Excluido com sucesso!");
	}

	public static void testeAlterar(Usuario usu, UsuarioDAOJDBC dao, Scanner leitor) {
		
		System.out.println("Entre com o ID do Usuário: ");
		usu.setId(leitor.nextInt());
		System.out.println("Entre com o Nome de Usuário: ");
		usu.setNome(leitor.next());
		System.out.println("Entre com o Login fo Usuário: ");
		usu.setLogin(leitor.next());
		System.out.println("Entre com a Senha do Usuário: ");
		usu.setSenha(leitor.next());
		
		dao.cadastrar(usu);
		System.out.println("Usuario Alterado com sucesso!");
	}

	public static void testeCadastrar(Usuario usu, UsuarioDAOJDBC dao, Scanner leitor) {
		
		System.out.println("Entre com o Nome de Usuário: ");
		usu.setNome(leitor.next());
		System.out.println("Entre com o Login fo Usuário: ");
		usu.setLogin(leitor.next());
		System.out.println("Entre com a Senha do Usuário: ");
		usu.setSenha(leitor.next());
			dao.cadastrar(usu);
			System.out.println("Usuario Cadastrado com sucesso!");
	}

}
