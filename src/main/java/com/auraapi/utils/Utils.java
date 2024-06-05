package com.auraapi.utils;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utils {

	public static void main(String[] args) { // GENERACION DE CONTRASEÑAS ENCRIPTADAS PERSONALIZADAS SOLO PRUEBAS
		String password = JOptionPane.showInputDialog("Pass to Convert: ");
		JTextArea textArea = new JTextArea( new BCryptPasswordEncoder().encode(password) + "" );
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		
		int height = textArea.getFontMetrics(textArea.getFont()).getHeight();
		int width = textArea.getLineCount();
		int preferedHg = (width + 2 ) * height;
		scroll.setPreferredSize(new java.awt.Dimension(400, preferedHg));
		
		JOptionPane.showMessageDialog(null, scroll , "Password Encrypt ", JOptionPane.INFORMATION_MESSAGE);
	}

}
