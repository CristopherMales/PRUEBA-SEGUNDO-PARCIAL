package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import Controller.Ejecutador;
import Controller.Hilo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class pn_registro extends JPanel {
	private JComboBox cmb_producto;
	private JTextField txt_unidades;
	private JTextField txt_precio;

	/**
	 * Create the panel.
	 */
	public pn_registro() {
		setLayout(null);
		
		JPanel pn_datos = new JPanel();
		pn_datos.setBorder(new TitledBorder(null, "REGISTRO DE DATOS", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(240, 255, 255)));
		pn_datos.setBackground(new Color(70, 130, 180));
		pn_datos.setBounds(0, 0, 402, 254);
		add(pn_datos);
		pn_datos.setLayout(null);
		
		JLabel lb_etiqueta_1 = new JLabel("PRODUCTO:");
		lb_etiqueta_1.setForeground(new Color(245, 255, 250));
		lb_etiqueta_1.setFont(new Font("Century", Font.BOLD, 16));
		lb_etiqueta_1.setBackground(new Color(240, 255, 255));
		lb_etiqueta_1.setBounds(33, 53, 116, 25);
		pn_datos.add(lb_etiqueta_1);
		
		JLabel lb_etiqueta_2 = new JLabel("UNIDADES:");
		lb_etiqueta_2.setForeground(new Color(245, 255, 250));
		lb_etiqueta_2.setFont(new Font("Century", Font.BOLD, 16));
		lb_etiqueta_2.setBackground(new Color(240, 255, 255));
		lb_etiqueta_2.setBounds(33, 93, 116, 25);
		pn_datos.add(lb_etiqueta_2);
		
		JLabel lb_etiqueta_3 = new JLabel("PRECIO:");
		lb_etiqueta_3.setForeground(new Color(245, 255, 250));
		lb_etiqueta_3.setFont(new Font("Century", Font.BOLD, 16));
		lb_etiqueta_3.setBackground(new Color(240, 255, 255));
		lb_etiqueta_3.setBounds(33, 138, 86, 25);
		pn_datos.add(lb_etiqueta_3);
		
		cmb_producto = new JComboBox();
		cmb_producto.setBounds(157, 52, 203, 30);
		pn_datos.add(cmb_producto);

		ArrayList<String> nombres = new Ejecutador().nombre_productos();
		for (String nombre: nombres) {
			cmb_producto.addItem(nombre);
			
		}
		
		txt_unidades = new JTextField();
		txt_unidades.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				digitos(evt);
			}
		});
		txt_unidades.setFont(new Font("Century", Font.BOLD, 16));
		txt_unidades.setBounds(157, 90, 203, 30);
		pn_datos.add(txt_unidades);
		txt_unidades.setColumns(10);
		
		txt_precio = new JTextField();
		txt_precio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				digitos(e);
			}
		});
		txt_precio.setFont(new Font("Century", Font.BOLD, 16));
		txt_precio.setColumns(10);
		txt_precio.setBounds(157, 135, 203, 30);
		pn_datos.add(txt_precio);
		
		JButton btn_agregar = new JButton("");
		btn_agregar.setIcon(new ImageIcon(pn_registro.class.getResource("/icon/save.png")));
		btn_agregar.setForeground(SystemColor.text);
		btn_agregar.setBackground(SystemColor.controlDkShadow);
		btn_agregar.setFont(new Font("Century", Font.BOLD, 16));
		btn_agregar.setBounds(167, 175, 75, 69);
		pn_datos.add(btn_agregar);
		btn_agregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Ejecutador().registrar_producto(cmb_producto.getSelectedItem().toString(), txt_precio.getText(), txt_unidades.getText());
				txt_precio.setText("0");
				txt_unidades.setText("0");
			}
		});
		
		JButton btn_autor = new JButton("");
		btn_autor.setBackground(new Color(70, 130, 180));
		btn_autor.setIcon(new ImageIcon(pn_registro.class.getResource("/icon/infoautor.jpg")));
		btn_autor.setBounds(356, 10, 36, 38);
		pn_datos.add(btn_autor);
		btn_autor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "T nombre");
				
			}
		});
		
		JPanel pn_info = new JPanel();
		pn_info.setBorder(new TitledBorder(null, "BI", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pn_info.setBackground(SystemColor.info);
		pn_info.setBounds(0, 259, 402, 139);
		add(pn_info);
		pn_info.setLayout(null);
		
		JLabel lb_etiqueta_3_1 = new JLabel("PRODUCTOS:");
		lb_etiqueta_3_1.setForeground(new Color(0, 128, 0));
		lb_etiqueta_3_1.setFont(new Font("Century", Font.BOLD, 16));
		lb_etiqueta_3_1.setBackground(new Color(128, 128, 0));
		lb_etiqueta_3_1.setBounds(26, 21, 133, 25);
		pn_info.add(lb_etiqueta_3_1);
		
		JLabel lb_etiqueta_3_1_1 = new JLabel("CAPITAL:           $");
		lb_etiqueta_3_1_1.setForeground(new Color(0, 128, 0));
		lb_etiqueta_3_1_1.setFont(new Font("Century", Font.BOLD, 16));
		lb_etiqueta_3_1_1.setBackground(new Color(128, 128, 0));
		lb_etiqueta_3_1_1.setBounds(26, 56, 149, 25);
		pn_info.add(lb_etiqueta_3_1_1);
		
		JLabel lb_etiqueta_3_1_1_1 = new JLabel("UTILIDAD:        $");
		lb_etiqueta_3_1_1_1.setForeground(new Color(0, 128, 0));
		lb_etiqueta_3_1_1_1.setFont(new Font("Century", Font.BOLD, 16));
		lb_etiqueta_3_1_1_1.setBackground(new Color(128, 128, 0));
		lb_etiqueta_3_1_1_1.setBounds(26, 90, 149, 25);
		pn_info.add(lb_etiqueta_3_1_1_1);
		
		JLabel lbl_productos = new JLabel("0");
		lbl_productos.setForeground(new Color(220, 20, 60));
		lbl_productos.setFont(new Font("Century", Font.BOLD, 16));
		lbl_productos.setBackground(new Color(128, 128, 128));
		lbl_productos.setBounds(170, 21, 133, 25);
		pn_info.add(lbl_productos);
		
		JLabel lbl_capital = new JLabel("0.0");
		lbl_capital.setForeground(new Color(220, 20, 60));
		lbl_capital.setFont(new Font("Century", Font.BOLD, 16));
		lbl_capital.setBackground(Color.GRAY);
		lbl_capital.setBounds(170, 56, 133, 25);
		pn_info.add(lbl_capital);
		
		JLabel lbl_utilidad = new JLabel("0.0");
		lbl_utilidad.setForeground(new Color(220, 20, 60));
		lbl_utilidad.setFont(new Font("Century", Font.BOLD, 16));
		lbl_utilidad.setBackground(Color.GRAY);
		lbl_utilidad.setBounds(170, 90, 133, 25);
		pn_info.add(lbl_utilidad);
		
		Hilo mihilo = new Hilo(lbl_productos, lbl_capital, lbl_utilidad);
		Thread th = new Thread(mihilo);
		th.start();
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(pn_registro.class.getResource("/icon/bbdd.jpg")));
		lblNewLabel.setBounds(272, 10, 120, 119);
		pn_info.add(lblNewLabel);

	}
	
	public void digitos(KeyEvent evt) {
		char car = evt.getKeyChar();
        if((car<'0' || car>'9') && (car<',' || car>'.')) evt.consume();
	}
}
