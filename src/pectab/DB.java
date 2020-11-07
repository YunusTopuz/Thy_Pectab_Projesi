package pectab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import spring.PectabEntity;

public class DB {

	ArrayList<PectabEntity> pectabListesi = new ArrayList<>();
	Connection con = null;
	
    public String pectabGetir() {
    	
    		String pectab = null;
        try {
        	Class.forName("org.h2.Driver");
			con = DriverManager.getConnection(
					"jdbc:h2:~/test", "root", "root");
            
            String query = "SELECT PECTAB FROM BP ORDER BY ID DESC LIMIT 1";
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            //Sonuçlar içerisinde dönerek verileri listeye ekliyoruz
            while (rs.next()) {
 
                pectab = rs.getString("pectab");
                System.out.println(pectab);               
                //pectabListesi.add(new PectabEntity(pectab,null));                
 
            }
            st.close();
            
            
 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    //Datatable bir dizi veya listi alıp işleyebilir bizde bir liste göndereceğiz
        return pectab;
 
    }
    
    public String streamGetir() {
    	String stream=null;
        try {
        	Class.forName("org.h2.Driver");
			con = DriverManager.getConnection(
					"jdbc:h2:~/test", "root", "root");
            String query = "SELECT STREAM FROM BP ORDER BY ID DESC LIMIT 1";
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            //Sonuçlar içerisinde dönerek verileri listeye ekliyoruz
            while (rs.next()) {
 
                stream = rs.getString("stream");
                
 
            }
            st.close();
 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    //Datatable bir dizi veya listi alıp işleyebilir bizde bir liste göndereceğiz
        return stream;
 
    }
    public String templateGetir() {
    	String template=null;
        try {
        	Class.forName("org.h2.Driver");
			con = DriverManager.getConnection(
					"jdbc:h2:~/test", "root", "root");
            String query = "SELECT TEMPLATE FROM BP ORDER BY ID DESC LIMIT 1";
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            //Sonuçlar içerisinde dönerek verileri listeye ekliyoruz
            while (rs.next()) {
 
                template = rs.getString("template");
                
 
            }
            st.close();
 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    //Datatable bir dizi veya listi alıp işleyebilir bizde bir liste göndereceğiz
        return template;
 
    }
}
