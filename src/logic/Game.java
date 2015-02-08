package logic;

import java.io.IOException;
import java.util.Vector;

import javax.swing.filechooser.FileSystemView;

import dataBase.HHD;

public class Game {
	public static String gamePath;
	
	public static void openFolder(String path){
		String[] cmd = new String[5];  
        cmd[0] = "cmd";  
        cmd[1] = "/c";  
        cmd[2] = "start";  
        cmd[3] = " ";  
        cmd[4] = path;  
        try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	public static void changeSetting(String title,String message){
		FileSystemView fsv=FileSystemView.getFileSystemView();
		String tfh,ftm;
		tfh=fsv.getDefaultDirectory().getPath()+"/Paradox Interactive/Hearts of Iron III/settings.txt";
		ftm=Game.gamePath+"/settings.txt";
		
		Vector <String> file=HHD.readFile(tfh);
		String ans=new String();
		for (int i=0;i<file.size();i++){
			if (file.get(i).contains(title)){
				ans+=message+"\r\n";
			}else{
				ans+=file.get(i)+"\r\n";
			}
		}
		HHD.writeFile(tfh, ans);
		
		file=HHD.readFile(ftm);
		ans=new String();
		for (int i=0;i<file.size();i++){
			if (file.get(i).contains(title)){
				ans+=message+"\r\n";
			}else{
				ans+=file.get(i)+"\r\n";
			}
		}
		HHD.writeFile(ftm, ans);
	}
	public static void deleteCache(){
		FileSystemView fsv=FileSystemView.getFileSystemView();
		String tfh;
		tfh=fsv.getDefaultDirectory().getPath()+"/Paradox Interactive/Hearts of Iron III/map/cache";
		HHD.deleteFolder(tfh);
	}
}
