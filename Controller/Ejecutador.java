package Controller;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

import Model.*;
import View.Principal;

public class Ejecutador {
	
	private query q = new query();
	private ResultSet res;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}
	
	public void registrar_producto(String producto, String precio, String unidades) {
		res = q.getQuery("select id_producto from producto where product_name = '"+producto+"'");
		try {
			while(res.next()) {			
				String id_producto = res.getString("id_producto");
				System.out.println("encontoro " +id_producto + " nombre" +producto);
				q.setQuery(id_producto+","+unidades+","+precio);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> nombre_productos() {		
		res = q.getQuery("select product_name from producto");
		ArrayList<String> nombre =new ArrayList<String>();
		
		try {
			while(res.next()) {
				nombre.add(res.getString("product_name"));
				
			}
			q.closeConn();
		}catch(SQLException e) {
			e.printStackTrace();			
		}
		return nombre;
	}

}
