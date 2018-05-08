package agentie.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private Properties jdbcProp;

    /*public JdbcUtils(Properties props){
        jdbcProp=props;
    }*/

    private Connection instance=null;
    private Connection getNewConncetion(){
        String driver="org.sqlite.JDBC";
        String url="jdbc:sqlite:F:\\AgentieRMI\\Agentie";
        String user=null;
        String pass=null;
        Connection con=null;
        try{
            Class.forName("org.sqlite.JDBC");
            if(user!=null&&pass!=null)
                con= DriverManager.getConnection(url,user,pass);
            else
                con=DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public Connection getConnection(){
        try{
            if(instance==null || instance.isClosed())
                instance=getNewConncetion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance;
    }
}
