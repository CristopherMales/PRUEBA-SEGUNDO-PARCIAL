package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class query extends conection_bbdd{
	
	/**
	 * Sirve para hacer consultas a la base de datos mediante instruccion SQL SELECT
	 * @param busquedaSQL Ejemplo: SELECT * FROM table
	 * @return ResultSet
	 */
	public ResultSet getQuery(String busquedaSQL) {
		try {
			this.stmt=(Statement)openConn().createStatement();//aqui se abre la conexion 
			res=stmt.executeQuery(busquedaSQL);//manteniendo la conexion
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR AL ABRIR LA CONSULTA");
		}
		
		return res;
	}
	/**
	 * Permite implementar operaciones SQL tales como: INSERT, UPDATE, DELETE
	 * @param sentenciaSQL Ejemplo: DELETE * FROM table WHERE id_table=1
	 * @return Boolean
	 */
	public boolean setQuery(String sentenciaSQL) {
		try {
			this.stmt=(Statement)openConn().createStatement();
			this.stmt.executeUpdate("insert into registro_producto (producto,unidades,precio) values ("+sentenciaSQL+");");
			
			return closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR AL REALIZAR UNA OPERACION DE ACTUALIZACION EN LA BBDD");
			return false;
		}
	}
	
}
