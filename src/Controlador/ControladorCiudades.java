package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ControladorCiudades {

	
	
	
	
	public void guardarenbasesededatos(String ciudad, int codigopostal){
		
		
		
		try {
			Class.forName("org.sqlite.JDBC");
			String url="jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\dj\\base de datos\\prueba.txt";
			
			Connection conexion = DriverManager.getConnection(url);
			
			if(conexion!=null) {
				
				System.out.println("Hay conección");
				
			}else {
				
				System.out.println("No hay conección");
				
			}
			
			
			var pt = conexion.prepareStatement("INSERT INTO Ciudades VALUES ( ?,?)");
			pt.setString(1, ciudad);
			pt.setInt(2, codigopostal);

			pt.executeUpdate();
			
			if(conexion!=null) {
				
				conexion.close();
			
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public boolean exiteenbasdedatos(String ciudad) {
		
		try {
			Class.forName("org.sqlite.JDBC");
			String url="jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\dj\\base de datos\\prueba.txt";
			
			Connection conexion = DriverManager.getConnection(url);
			
			if(conexion!=null) {
				
				System.out.println("Hay conección");
				
			}else {
				
				System.out.println("No hay conección");
				
			}
			
			
			var pt = conexion.prepareStatement("SELECT * FROM Ciudades WHERE nombre= ?");
			pt.setString(1, ciudad);
			ResultSet rs = pt.executeQuery();
			
			
			
			
			if(conexion!=null) {
				
				conexion.close();
			
			}
			
			return rs.next();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}


		return false;
		
	}
	
	
	
	public String listarbasededatos() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			String url="jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\dj\\base de datos\\prueba.txt";
			
			Connection conexion = DriverManager.getConnection(url);
			
			if(conexion!=null) {
				
				System.out.println("Hay conección");
				
			}else {
				
				System.out.println("No hay conección");
				
			}
			
			
			var pt = conexion.prepareStatement("SELECT * FROM Ciudades");
			ResultSet rs = pt.executeQuery();
			
			
			String mensage= "";
			
			while (rs.next()) {
				
			mensage +=	rs.getString(1)+" "+ rs.getInt(2);
				mensage += "\n";
			}
			
			if(conexion!=null) {
				
				conexion.close();
			
			}
			
		
			return mensage;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return null;
	}
	
	
	public void eliminardelabasededatos(String ciudad) {
		
		try {
			Class.forName("org.sqlite.JDBC");
			String url="jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\dj\\base de datos\\prueba.txt";
			
			Connection conexion = DriverManager.getConnection(url);
			
			if(conexion!=null) {
				
				System.out.println("Hay conección");
				
			}else {
				
				System.out.println("No hay conección");
				
			}
			
			
			var pt = conexion.prepareStatement("DELETE  FROM Ciudades WHERE nombre= ?");
			pt.setString(1, ciudad);
			

			pt.executeUpdate();
			
			if(conexion!=null) {
				
				conexion.close();
			
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return ;
	}
	
	public void modificarenbasadedatos(String ciudad, int codigopostal) {
		
		
		try {
			Class.forName("org.sqlite.JDBC");
			String url="jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\dj\\base de datos\\prueba.txt";
			
			Connection conexion = DriverManager.getConnection(url);
			
			if(conexion!=null) {
				
				System.out.println("Hay conección");
				
			}else {
				
				System.out.println("No hay conección");
				
			}
			
			
			var pt = conexion.prepareStatement("UPDATE Ciudades SET codigoPostal=? WHERE nombre=?");
			pt.setString(2, ciudad);
			pt.setInt(1, codigopostal);

			pt.executeUpdate();
			
			if(conexion!=null) {
				
				conexion.close();
			
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
