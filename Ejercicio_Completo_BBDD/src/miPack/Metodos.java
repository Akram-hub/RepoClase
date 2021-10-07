package miPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

//import java.time.LocalDate;
//import java.util.Date;


public class Metodos extends Persona {
	
	public void SelectBBDD() {
		try {
			
			Connection cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/jr", "root", "");
			Statement st = cx.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM PERSONA");
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

			while(rs.next()) {
			    for(int i = 1; i <= columnCount; i++) {
			        Object object = rs.getObject(i);
			        System.out.printf("%s, ", object == null ? "NULL" : object.toString());
			    }
			    System.out.printf("%n");
			}
			
		} catch(Exception e) {
			System.out.println("!BBDD no encontrada�");
			e.printStackTrace();
		}
	}
	
	public void InsertBBDD(String nombre, int id, String fecha_nac) {
		try {
			
			Connection cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/jr", "root", "");
			String query = " insert into PERSONA (NOMBRE, ID, FECHA_NAC)"
				       + " values (?, ?, ?)";
			PreparedStatement preparedStmt = cx.prepareStatement(query);
				 preparedStmt.setString(1, nombre);
			     preparedStmt.setInt(2, id);
//			     preparedStmt.setString(3, fecha_nac);
			     preparedStmt.setDate(3, java.sql.Date.valueOf(fecha_nac));
			      
			     preparedStmt.execute();
			     cx.close();
			
		} catch(Exception e) {
			System.out.println("!BBDD no encontrada�");
			e.printStackTrace();
		}
	}
	
	public void UpdateBBDD(String nombre, int id, String fecha_nac, int id_mod) {
		try {
			
			Connection cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/jr", "root", "");
			String query = "update PERSONA set NOMBRE = ?, ID = ?, FECHA_NAC = ? where ID = ?";
			PreparedStatement preparedStmt = cx.prepareStatement(query);
				preparedStmt.setString(1, nombre);
				preparedStmt.setInt(2, id);
//				preparedStmt.setString(3, fecha_nac);
				preparedStmt.setDate(3, java.sql.Date.valueOf(fecha_nac));
				preparedStmt.setInt(4, id_mod);
			 
				preparedStmt.execute();
			 
				cx.close();
			
		} catch(Exception e) {
			System.out.println("!BBDD no encontrada�");
			e.printStackTrace();
		}
	}
	
	public void Delete(int id) {
		try {
			
			Connection cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/jr", "root", "");
			String query = "delete from PERSONA where ID = ?";
			PreparedStatement preparedStmt = cx.prepareStatement(query);
			 preparedStmt.setInt(1, id);
				
			 preparedStmt.execute();
			 cx.close();
		} catch(Exception e) {
			System.out.println("!BBDD no encontrada�");
			e.printStackTrace();
		}
	}
	
}

