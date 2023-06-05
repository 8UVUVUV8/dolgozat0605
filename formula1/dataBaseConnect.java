package formula1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dataBaseConnect {
    
    static void DBdelet() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/";
        String dbName = "dolgozat0605";
        String tableName = "pilotak";
        String userName = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(url+dbName,userName,password);
            
            Statement statement=connection.createStatement();
            
            statement.execute("DELETE FROM "+tableName+";");
            
            connection.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("A Connector nem található!");
        }
  }
    
    static void DBconnect(String data1,String data2,String data3,String data4) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/";
        String dbName = "dolgozat0605";
        String tableName = "pilotak";
        String userName = "root";
        String password = "";
        //System.out.println("INSERT INTO "+tableName+"(nev,szuletesi_datum,nemzetiseg,rajtszam) VALUES('"+data1+"','"+data2+"','"+data3+"','"+data4+"')");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(url+dbName,userName,password);
            
            Statement statement=connection.createStatement();
            
            
            if (data4=="NULL") {
                statement.execute("INSERT INTO "+tableName+"(nev,szuletesi_datum,nemzetiseg,rajtszam) VALUES('"+data1+"','"+data2+"','"+data3+"',NULL)");
            }else{
            statement.execute("INSERT INTO "+tableName+"(nev,szuletesi_datum,nemzetiseg,rajtszam) VALUES('"+data1+"','"+data2+"','"+data3+"','"+data4+"')");
            }
            connection.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("A Connector nem található!");
        }
  }
}
