package cjweb;

import java.util.List;
import java.util.Scanner;

import br.com.fabricadeprogramador.persistencia.DAO.UsuarioDAO;
import br.com.fabricadeprogramador.persistencia.entidade.Usuario;



public class TesteUsuarioDAO {
	
	//Classe para testar o UsuarioDAO

	public static void main(String[] args) {
		
		//Instancia de Scanner
		Scanner leitor = new Scanner(System.in);
		
		//Instancia de UsuárioDAO
		UsuarioDAO dao = new UsuarioDAO();
		
		//Instancia de Usuário
		Usuario usu = new Usuario();
		
		
		testeCadastrar(usu, dao, leitor);
		//testeAlterar(usu, dao, leitor);
		//testeExcluir(usu, dao, leitor);
		//testeSalvar(usu, dao, leitor);
		//testeBuscaPorId(dao, leitor);
		//testeBuscarTodos(dao);
		
	}

	
	public static void testeBuscarTodos(UsuarioDAO dao){
		List<Usuario> lista = dao.buscaTodos();
		for (Usuario usu : lista){
			System.out.println("ID: " + usu.getId());
			System.out.println("Nome: " + usu.getNome());
			System.out.println("Login: " + usu.getLogin());
			System.out.println("Senha: " + usu.getSenha());
		}
	}
	
	
	public static void testeBuscaPorId(UsuarioDAO dao, Scanner leitor) {
		
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

	public static void testeSalvar(Usuario usu, UsuarioDAO dao, Scanner leitor) {
		
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

	public static void testeExcluir(Usuario usu, UsuarioDAO dao, Scanner leitor) {
		
		System.out.println("Entre com o ID do Usuário: ");
		usu.setId(leitor.nextInt());
		
		dao.cadastrar(usu);
		System.out.println("Usuário Excluido com sucesso!");
	}

	public static void testeAlterar(Usuario usu, UsuarioDAO dao, Scanner leitor) {
		
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

	public static void testeCadastrar(Usuario usu, UsuarioDAO dao, Scanner leitor) {
		
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
