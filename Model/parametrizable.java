package Model;

public interface parametrizable {
	public final String ip="localhost",
			port="3306",
			user="root",
			passw="",
			bbdd="prueba_productos",//el nombre de la base de datos
			driver="com.mysql.cj.jdbc.Driver";
	public default String getURL() {
		return "jdbc:mysql://"+ip+":"+port+"/"+bbdd+"?user="+user+"&password"+passw+"&useSSL=false&serverTimezone=UTC";
	}
}
