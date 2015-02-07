package main;

import java.awt.event.*;

import javax.swing.*;

import allInterface.*;

public class UI {
	static public JFrame window;
	
	public UI(){
		if (window==null){
			window=new JFrame("Bank 1.0");
		}
	}
	
	public void CreateWindow(){
		window.setSize(850, 650);
		window.setLocation(200, 100);
		window.setLayout(null);
		window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		window.addComponentListener(new ComponentListener(){
			@Override
			public void componentResized(ComponentEvent e) {
			}
			@Override
			public void componentHidden(ComponentEvent e) {}
			@Override
			public void componentMoved(ComponentEvent e) {}
			@Override
			public void componentShown(ComponentEvent e) {}
			});
		
		UpdateWindow();
		
		window.setVisible(true);
		window.setResizable(false);
	}
	static public void MoveToSteep(int steep){
		UpdateWindow();
	}
	static public void UpdateWindow(){
		ShowInterface si;
		
		si=new FixError();
		
		si.show();
	}
}
