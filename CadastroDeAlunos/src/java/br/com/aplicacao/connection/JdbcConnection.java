package br.com.aplicacao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabiano
 */
public class JdbcConnection {
    public static Connection getConnection(){
        Connection conn = null;			
        try {		
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb?autoReconnect=true&useSSL=false", "root", "root");				
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        return conn;			
    }
		
    public static void close(Connection conn, PreparedStatement pstm, ResultSet rs){			
        try {
            if(conn != null)
                    conn.close();

            if (pstm != null)
                    pstm.close();

            if (rs != null)
                    rs.close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
}
