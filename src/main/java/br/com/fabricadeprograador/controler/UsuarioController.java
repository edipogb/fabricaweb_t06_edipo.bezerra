package br.com.fabricadeprograador.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.persistencia.DAO.UsuarioDAO;
import br.com.fabricadeprogramador.persistencia.entidade.Usuario;


@WebServlet("/usucontroller")
public class UsuarioController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//pegando os dados da requisição
		
		String acao = req.getParameter("acao");
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		//Instanciar o Usuário
		Usuario usu = new Usuario();
		
		//Instanciando o UsuarioDAO
		UsuarioDAO dao = new UsuarioDAO();
		
		//Qual ação tomar
		if(acao.equalsIgnoreCase("cad")){
		
			usu.setNome(nome);
			usu.setLogin(login);
			usu.setSenha(senha);
			
			dao.cadastrar(usu);
				
		}else if(acao.equalsIgnoreCase("alt")){
			
			if(id != null && !id.isEmpty() && Integer.parseInt(id)>0){
				
				usu.setId(Integer.parseInt(id));
				usu.setNome(nome);
				usu.setLogin(login);
				usu.setSenha(senha);
				
				dao.alterar(usu);
				
			}else {
				//Mandar uma mensagem para o Usuário
				resp.getWriter().print("<h1>ID incorreto!</h1>");
			}
		}else if(acao.equalsIgnoreCase("exc")){
			
			dao.excluir(Integer.parseInt("id"));
			
		}
		
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);
		
		
		dao.cadastrar(usu);
		
		
//		System.out.println("----------DADOS------------");
//		System.out.println("Nome: "+ nome);
//		System.out.println("Login: "+ login);
//		System.out.println("senha: "+ senha);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//Pega os dados da tela
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		if(id != null && !id.isEmpty() && Integer.parseInt(id)>0){
			
			//Instancia o Usuário
			Usuario usu = new Usuario();
			usu.setId(Integer.parseInt(id));
			usu.setNome(nome);
			usu.setLogin(login);
			usu.setSenha(senha);
			
			//Instamcia de UsuárioDAO
			UsuarioDAO dao = new UsuarioDAO();
			dao.alterar(usu);
			
			//Fazer o Response
			resp.getWriter().print("O usuário " + nome + " foi alterado com sucesso!");
		}else{
			
			//Instancia o Usuário
			Usuario usu = new Usuario();
		
			usu.setNome(nome);
			usu.setLogin(login);
			usu.setSenha(senha);
			
			//Instamcia de UsuárioDAO
			UsuarioDAO dao = new UsuarioDAO();
			dao.cadastrar(usu);
			
			//Fazer o Response
			resp.getWriter().print("O usuário " + nome + " foi cadastrado com sucesso!");
		}
		
		
		
		
		
//		System.out.println("\n------------------Método Post------------------------\n");
//		System.out.println("Nome: "+nome);
//		System.out.println("Login: "+login);
//		System.out.println("Senha: "+senha);
		
		

	}
}
