
package formula1statistic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Formula1Statistic {

        static void DBconnect() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/";
        String dbName = "dolgozat0605";
        String tableName = "pilotak";
        String userName = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(url+dbName,userName,password);
            
            Statement statement=connection.createStatement();
            
            //ez minden ki irva
            ResultSet resultSet=statement.executeQuery("SELECT * FROM pilotak");
            
            while (resultSet.next()){
                //System.out.println(resultSet.getString(1)+","+resultSet.getString(2)+","+resultSet.getString(3)+","+resultSet.getString(4));
            }
            
            //ez a harmadik feladat
            ResultSet feladat3 =statement.executeQuery("SELECT COUNT(pilotak.nev) FROM pilotak;");
            
            while(feladat3.next()){
            System.out.println("3. Feladat: "+feladat3.getString(1));
            }
            
            //ez a negyedik feladat
            ResultSet feladat4=statement.executeQuery("SELECT pilotak.nev FROM pilotak;");
            
            String feladat4Nev = "";
            while (feladat4.next()){
                feladat4Nev =(feladat4.getString(1));
            }
            System.out.println("4. feladat: "+feladat4Nev);
            
            //ez az 6. feladat
            ResultSet feladat6 =statement.executeQuery("SELECT pilotak.nemzetiseg FROM `pilotak` WHERE pilotak.rajtszam IS NOT NULL ORDER BY pilotak.rajtszam ASC LIMIT 1;");
            
            while(feladat6.next()){
            System.out.println("6. Feladat: "+feladat6.getString(1));
            }
            
            //ez az 7. feladat
            ResultSet feladat7 =statement.executeQuery("SELECT COUNT(nev),pilotak.rajtszam FROM pilotak WHERE pilotak.rajtszam IS NOT NULL GROUP BY pilotak.rajtszam HAVING COUNT(nev) > 1;");
            
            System.out.print("7. Feladat:");
            while(feladat7.next()){
            System.out.print(" "+feladat7.getString(2)+",");
            }
            
            connection.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("A Connector nem található!");
        }
  }
        
    public static void main(String[] args) throws SQLException {
        DBconnect();
    }
    
}
