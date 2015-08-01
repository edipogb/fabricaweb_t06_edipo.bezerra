package br.com.fabricadeprogramador.persistencia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.ConexaoFactory;

public class UsuarioDAOJDBC {

	// Pegar a conexão com o Factory
	private Connection con = ConexaoFactory.getConection();

	
	
	
	public void cadastrar(Usuario usu) {

		// Montar o SQL
		String sql = "INSERT INTO usuario (nome, login, senha) VALUES(?, ?, md5(?))";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			// substituindo os paramentros do DQL pelos valores do objeto
			// usuario
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			// Executa o SQL
			preparador.execute();
		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao cadastrar o Usuário!", ex);
		}
	}

	public void alterar(Usuario usu) {

		// Montar o SQL
		String sql = "update usuario set nome=?, login=?, senha=md5(?) WHERE id=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			preparador.execute();

		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao alterar usuário!", ex);
		}
	}

	public void excluir(Integer id) {

		// Montar o SQL
		String sql = "DELETE from usuario where id=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setInt(1, id);
			preparador.execute();

		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao deletar!", ex);
		}
	}

	public void salvar(Usuario usu) {
		if (usu.getId() != null && usu.getId() > 0) {
			alterar(usu);
		} else {
			cadastrar(usu);
		}
	}
	
	public Usuario buscaPorId(Integer id){
		
		String sql = "SELECT * FROM usuario WHERE id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			
			//Objeto de retorno do método
			Usuario usuRetorno = null;
			
			
			preparador.setInt(1, id);
			
			//Retorno da consulta em ResultSet
			ResultSet resultado = preparador.executeQuery();
			//Se tem registro
			if(resultado.next()){
				//Instancía o objeto Usuário
				usuRetorno = new Usuario();
				usuRetorno.setId(resultado.getInt("id"));
				usuRetorno.setNome(resultado.getString("nome"));
				usuRetorno.setLogin(resultado.getString("login"));
				usuRetorno.setSenha(resultado.getString("senha"));
				
				//Retorno do meu usuario ja preenchido
				return usuRetorno;
				
			}else{
				System.out.println("Usuário não existe! ");
				return null;
			}
			
			
		} catch (SQLException ex) {
			throw new RuntimeException("Id não encontrado! ", ex);
		}
		
		
	}
	
	public List<Usuario> buscaTodos(){
		
		//Objeto de retorno do método
		List<Usuario> listaRetorno = new ArrayList<Usuario>();
		
		// Montar o SQL
		String sql = "select * from usuario order by id";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			
			//Retorno da consulta em resultset
			ResultSet resultado = preparador.executeQuery();
			//navegando nos registros
			while (resultado.next()){
				//Instancia do objeto Usuário
				Usuario usu = new Usuario();
				
				//Carga de dados no Usuário
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("Login"));
				usu.setSenha(resultado.getString("senha"));
				
				// Adciona na Lista
				listaRetorno.add(usu);
				
			}
			
		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao buscar a lista!", ex);
			
		}
		return listaRetorno;
	}
	
public Usuario autenticar(Usuario usu){
		
		//sql
		String sql = "SELECT * FROM usuario WHERE login=? and senha=md5(?)";
		
		try (PreparedStatement preparador = con.prepareStatement(sql))
		{
			
			preparador.setString(1, usu.getLogin());
			preparador.setString(2, usu.getSenha());
			
			ResultSet result = preparador.executeQuery();
			if(result.next()){
				
				Usuario retorno = new Usuario();
				retorno.setId(result.getInt("id"));
				retorno.setNome(result.getString("nome"));
				retorno.setLogin(result.getString("login"));
				retorno.setSenha(result.getString("senha"));
				
				return retorno;
			}else{
				return null;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao autenticar!", e);
		}
	}
}
