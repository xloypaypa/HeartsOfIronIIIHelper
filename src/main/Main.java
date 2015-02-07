package main;

import java.io.File;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import dataBase.HHD;
import logic.*;

public class Main {
	public static void main(String[] args){
		UI ui=new UI();
		String s=HHD.getAppPath()+"/gamePath.txt";
		if (HHD.fileExiste(s)){
			Vector <String> file=HHD.readFile(s);
			Game.gamePath=file.get(0);
			ui.CreateWindow();
		}else{
			JOptionPane.showMessageDialog(null,"请选择游戏的那个 hoi3.exe", "message", JOptionPane.INFORMATION_MESSAGE);
			
			JFileChooser fc=new JFileChooser();
			String path=new String();
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int ret=fc.showSaveDialog(fc);
			if (ret==JFileChooser.APPROVE_OPTION){
				path=fc.getSelectedFile().getAbsolutePath();
				File file=new File(path);
				path=file.getParent();
				Game.gamePath=path;
				HHD.writeFile(s, path);
				ui.CreateWindow();
			}
		}
	}
}
