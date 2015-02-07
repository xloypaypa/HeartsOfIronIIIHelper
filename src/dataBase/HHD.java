package dataBase;

import java.io.*;
import java.util.*;

public class HHD {
	public static boolean fileExiste(String path){
		File f=new File(path);
		return f.exists();
	}
	public static boolean folderExiste(String path){
		File f=new File(path);
		return f.exists();
	}
	public static void createFolder(String Path,String Name){
		File path=new File(Path+Name);
		if (!path.exists()){
			path.mkdirs();
		}
	}
	public static void deleteFile(String path){
		File file=new File(path);
		if (!file.exists()) return ;
		else if (!file.isFile()) return ;
		else file.delete();
	}
	public static void deleteFolder(String path){
		File folder=new File(path);
		if (!folder.exists()) return ;
		if (!folder.isDirectory()) return ;
		
		deleteFolder(folder);
	}
	private static void deleteFolder(File folder){
		File[] files=folder.listFiles();
		for (int i=0;i<files.length;i++){
			if (files[i].isFile()){
				files[i].delete();
			}else if (files[i].isDirectory()){
				deleteFolder(files[i]);
			}
		}
		folder.delete();
	}
	public static void createFile(String Path,String Name){
		try{
			File path=new File(Path);
			if (!path.exists()){
				path.mkdirs();
			}
			File dir=new File(path,Name);
			if (!dir.exists()){
				dir.createNewFile();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void cleanFile(String path){
		try{
			FileOutputStream fos = new FileOutputStream(new File(path));
			fos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void writeFile(String path,String message){
		try{
			PrintWriter fos = new PrintWriter(new File(path));
			fos.write(message+"\r\n");
			fos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void addWriteFile(String path,String message){
		try{
			FileWriter fos=new FileWriter(new File(path),true);
			PrintWriter pw = new PrintWriter(fos);
			pw.println(message);
			pw.flush();
			pw.close();
			fos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static Vector <String> readFile(String path){
		 try {
			 Vector <String > ans=new Vector <String>();
			 BufferedReader fos=new BufferedReader(new FileReader(path));
		     String data = null;
		     while ((data = fos.readLine()) != null) {
		    	 ans.add(data);
		     }
		     fos.close();
		     return ans;
		 }catch(IOException e){
			 e.printStackTrace();
		 }
		 return new Vector <String>();
	}
	public static String getAppPath(){
		return System.getProperty("user.dir");
	}
}
