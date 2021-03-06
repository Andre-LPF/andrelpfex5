package cadastroaluno;

import java.sql.*;
import jdk.nashorn.internal.ir.ForNode;

public class Conexao {
    String driver = "com.mysql.jdbc.Driver";
    String banco = "CadAluno";
    String host = "localhost";
    String stringDeConexao = "jdbc:mysql://" + host + ":3306/" + banco + "?serverTimezone=UTC";
    String usuario = "root";
    String senha = "1234";
    
    public Connection conexao;
    public Conexao(){        
    }
    
    public Connection getConexao(){
        try
        {
            Class.forName(driver);
            return DriverManager.getConnection(this.stringDeConexao,usuario, senha);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return conexao;
        }
    }
    
    public ResultSet getResultSet(String sentenca){
        try
        {
            Statement stm = new ConexaoBanco().getInstanceStatement();
            ResultSet rs = stm.executeQuery(sentenca);
            return rs;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public String atualizarBanco(String sentenca)
    {
        try
        {
            Statement stm = new ConexaoBanco().getInstanceStatement();
            stm.executeUpdate(sentenca);
            return "1";
        }
        catch (SQLException e)
        {
            return e.getMessage();
        }
        
        catch (Exception ex)
        {
            return ex.getMessage();
        }
    }
}
