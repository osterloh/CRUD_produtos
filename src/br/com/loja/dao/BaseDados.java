package br.com.loja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JTextField;

public class BaseDados {

	private static Connection con = null;
	
	private static String usuario = null;
	private static String passwd = null;
	private static boolean conectado = false;
	
	public static boolean usuario(JTextField txtUsuario, JTextField txtSenha) {
		usuario = txtUsuario.getText();
		passwd = txtSenha.getText();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/produto?useSSL=false", usuario, passwd);
			conectado = true;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conectado = false;
		}
		
		return conectado;
	}
	
	public Connection getConnection() {
		return con;
	}

}
