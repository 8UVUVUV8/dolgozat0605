
package formula1;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Formula1 {
    String pilota;
    String szulEv;
    String nemzetiseg;
    String rajtszam;

    public Formula1(String pilota, String szulEv, String nemzetiseg, String rajtszam) {
        this.pilota = pilota;
        this.szulEv = szulEv;
        this.nemzetiseg = nemzetiseg;
        this.rajtszam = rajtszam;
    }

    @Override
    public String toString() {
        return "Formula1{" + "pilota=" + pilota + ", szulEv=" + szulEv + ", nemzetiseg=" + nemzetiseg + ", rajtszam=" + rajtszam + '}';
    }



   
    
    

    public static void main(String[] args) throws SQLException {
    ArrayList<Formula1> pilotak = new ArrayList<Formula1>();
    ArrayList<Integer> szulEv = new ArrayList<Integer>();
      try {
        File file = new File("C:\\Users\\diak\\Desktop\\SZA mappa\\pilotak.csv");
        Scanner scan = new Scanner(file);
        scan.nextLine();
        while (scan.hasNextLine()) {
            String data = scan.nextLine();
            //ystem.out.println(data);
            String[] dataSplited = data.split(";");
            if (dataSplited.length==4){
                Formula1 pilota = new Formula1(dataSplited[0],dataSplited[1],dataSplited[2],dataSplited[3]);
                pilotak.add(pilota);
            }else{
            Formula1 pilota = new Formula1(dataSplited[0],dataSplited[1],dataSplited[2],"NULL");
            pilotak.add(pilota);
            }
            
        }
        scan.close();
        }
      catch (FileNotFoundException e) {
        System.out.println("File nem találhato");
        e.printStackTrace();
        }
        
        dataBaseConnect.DBdelet();
            
        for (int i = 0; i < pilotak.size(); i++) {
            String szulTime =pilotak.get(i).szulEv; 
            //System.out.println(szulTime);
            dataBaseConnect.DBconnect(pilotak.get(i).pilota, pilotak.get(i).szulEv, pilotak.get(i).nemzetiseg, pilotak.get(i).rajtszam);
            String[] szulTimeSplited = szulTime.split(".");
            //System.out.println(szulTimeSplited);
        }
        
        
        int DBlength =pilotak.size();
        System.out.println("3. Feladat: "+DBlength);
        System.out.println("4. Feladat: "+pilotak.get(DBlength-1).pilota);
        
        
    }
    
    
}
