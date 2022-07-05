package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class conection_bbdd implements parametrizable {

	protected Connection conn=null;
	protected Statement stmt=null;
	protected ResultSet res=null;
	//metodo para abrir la coneccion 
	/**
	 * Metodo que se encarga de abrir la conexion con la base de datos
	 * @return
	 */
	public Connection openConn() {
		try {
			Class.forName(driver);
			this.conn=DriverManager.getConnection(getURL());
			if(conn!=null) {
				System.out.println("Conexion exitosa");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas con el Driver");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la conexion con la URL");
		}
		return conn;
		
	}
	public boolean closeConn() {
		
			try {
				if(conn!=null) {
				conn.close();
				if(stmt!=null)
					stmt.close();
				return true;
				}
				else 
					return false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Problemas para cerrar la conexion");
				return false;
			}
		
	}

}
