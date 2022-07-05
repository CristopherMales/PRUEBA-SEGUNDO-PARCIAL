package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;

import Model.query;

public class Hilo implements Runnable{
	private int productos;
	private double capital;
	private double utilidad;
	JLabel producto_label, capital_label, utilidad_label;
	private query q = new query();
	private ResultSet res;
	public Hilo(JLabel producto_label, JLabel capital_label, JLabel utilidad_label) {
		productos = 0;
		capital = 0;
		utilidad = 0;
		this.producto_label = producto_label;
		this.capital_label = capital_label;
		this.utilidad_label  = utilidad_label;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			productos = 0;
			capital = 0;
			utilidad = 0;
			try {
				res = q.getQuery("select * from registro_producto");
				
				try {
					while(res.next()) {
						
						productos += res.getInt("unidades");
						capital += res.getInt("unidades") + res.getDouble("precio");
						
						
					}
					utilidad = capital*0.25;
					producto_label.setText(String.valueOf(productos));
					capital_label.setText(String.valueOf(capital));
					utilidad_label.setText(String.valueOf(utilidad));
					q.closeConn();
				}catch(SQLException e) {
					e.printStackTrace();			
				}
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
