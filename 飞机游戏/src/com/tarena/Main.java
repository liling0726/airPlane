package com.tarena;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
JFrame j=new JFrame();
JPanel jp=new FlyPanel();
j.add(jp);
j.setTitle("·É»ú´óÕ½");
j.setResizable(false);
j.setSize(400, 656);
j.setLocationRelativeTo(null);
j.setDefaultCloseOperation(3);
j.setVisible(true);
	}

}
