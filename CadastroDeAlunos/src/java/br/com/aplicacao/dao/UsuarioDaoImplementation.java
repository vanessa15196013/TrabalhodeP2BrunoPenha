package br.com.aplicacao.dao;

import br.com.aplicacao.connection.JdbcConnection;
import br.com.aplicacao.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fabiano
 */
public class UsuarioDaoImplementation implements UsuarioDao {

    private Connection conn;

    public UsuarioDaoImplementation() {
        conn = JdbcConnection.getConnection();
    }

    @Override
    public String autenticar(Usuario usuario) {
        String mensagemDeRetorno = "";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        if (usuario.getLogin().isEmpty() || usuario.getSenha().isEmpty()){
            mensagemDeRetorno += "Nome de usuário ou senha errados. Por favor tente outra vez.";
            return mensagemDeRetorno;
        }
        
        try {
            String query = "select login, senha from usuario where login='"+usuario.getLogin()+"'";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                Usuario armazenado = new Usuario();
                
                armazenado.setLogin(resultSet.getString("login"));
                armazenado.setSenha(resultSet.getString("senha"));
                
                if(!armazenado.getSenha().equals(usuario.getSenha())){
                    mensagemDeRetorno += "Senha invalida!"; 
                }
            } else {
                mensagemDeRetorno += "Usuario não existe na base de dados!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnection.close(conn, preparedStatement, resultSet);
        } 
        return mensagemDeRetorno;
    }
}
