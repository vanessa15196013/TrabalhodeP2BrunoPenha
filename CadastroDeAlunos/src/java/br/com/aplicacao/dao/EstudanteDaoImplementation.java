package br.com.aplicacao.dao;

import br.com.aplicacao.connection.JdbcConnection;
import br.com.aplicacao.model.Estudante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabiano
 */
public class EstudanteDaoImplementation implements EstudanteDao{

    private Connection conn;

    public EstudanteDaoImplementation() {
        conn = JdbcConnection.getConnection();
    }
    
    @Override
    public void addEstudante(Estudante estudante) {
        PreparedStatement preparedStatement = null;
        try {
            String query = "insert into estudante (primeiroNome, ultimoNome, curso) values (?,?,?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, estudante.getPrimeiroNome());
            preparedStatement.setString(2, estudante.getUltimoNome());
            preparedStatement.setString(3, estudante.getCurso());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnection.close(null, preparedStatement, null);
        }
    }

    @Override
    public void deleteEstudante(int idEstudante) {
        PreparedStatement preparedStatement = null;
        
        try {
            String query = "delete from estudante where idEstudante=?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, idEstudante);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnection.close(null, preparedStatement, null);
        }
    }

    @Override
    public void updateEstudante(Estudante estudante) {
        PreparedStatement preparedStatement = null;
        
        try {
            String query = "update estudante set primeiroNome = ?, ultimoNome = ?, curso = ?  where idEstudante = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, estudante.getPrimeiroNome());
            preparedStatement.setString(2, estudante.getUltimoNome());
            preparedStatement.setString(3, estudante.getCurso());
            preparedStatement.setInt(4, estudante.getIdEstudante());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnection.close(null, preparedStatement, null);
        }        
    }

    @Override
    public List<Estudante> getAllEstudantes() {
        
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Estudante> estudanteList = new ArrayList<Estudante>();
 
        try {
            preparedStatement = conn.prepareStatement("select * from estudante");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                    Estudante estudante = new Estudante();
                    estudante.setIdEstudante(resultSet.getInt(1)); 
                    estudante.setPrimeiroNome(resultSet.getString(2)); 
                    estudante.setUltimoNome(resultSet.getString(3));
                    estudante.setCurso(resultSet.getString(4));	
                    estudanteList.add(estudante);
            }            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnection.close(null, preparedStatement, resultSet);
        } 
        return estudanteList;        
    }

    @Override
    public Estudante getEstudanteById(int idEstudante) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Estudante estudante = new Estudante();
        try {
            String query = "select * from estudante where idEstudante = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, idEstudante);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                estudante.setIdEstudante(resultSet.getInt("idEstudante"));
                estudante.setPrimeiroNome(resultSet.getString("primeiroNome"));
                estudante.setUltimoNome(resultSet.getString("ultimoNome"));
                estudante.setCurso(resultSet.getString("curso"));             
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnection.close(null, preparedStatement, resultSet);
        } 
        return estudante;       
    }    
}
