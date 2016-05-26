/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessDatabase;
import java.sql.*;
/**
 *
 * @author THaskioglu
 */
public class DBcon {
    
    private static DBcon instance;
    protected Connection con;
    protected Statement stmt;
    private String serverName="localhost";
    private String portNumber="3306";
    private String databaseName="autover";
    private String url="jdbc:mysql://localhost:3306/"+databaseName;
    private String userName="root";
    private String password="root";
    
    private String getConnectionUrl(){
    
    return url;
    
    }
    
    public Connection connectDB(){
    con=null;
    
    try{
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    con=DriverManager.getConnection(getConnectionUrl(),userName,password);
    stmt=con.createStatement();
    
    
    }catch(Exception ex){
    
    return null;
    
    }
    return con;
    }
    
    public void disConnectDB(){
    try{
    stmt.close();
    con.close();
    
    }catch(Exception ex){}
    
    }
    
    public Statement getStmt(){
    
    
    return stmt;
    
    }
    
     public static DBcon getInstance(){
        if (instance == null){
            instance = new DBcon();
        }
        return instance;
    }
    
}
