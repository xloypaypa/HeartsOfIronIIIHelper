package allInterface;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;
import javax.swing.filechooser.*;

import dataBase.HHD;
import logic.Game;
import main.UI;

public class FixError implements ShowInterface {
	JPanel show;
	JButton saveGames,screenshots,fullScreen,flagError,history,german,country,science,buffer,exit,deleteAll;
	public FixError() {
		show=new JPanel();
		show.setLayout(null);
		show.setBounds(0, 0, 800, 600);
		
		saveGames=new JButton("�Ҳ����浵�ĵ�����");
		saveGames.setBounds(0, 0, 400, 100);
		saveGames.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileSystemView fsv=FileSystemView.getFileSystemView();
				String tfh,ftm;
				tfh=fsv.getDefaultDirectory().getPath()+"/Paradox Interactive/Hearts of Iron III/save games";
				ftm=Game.gamePath+"/save games";
				Game.openFolder(tfh);
				Game.openFolder(ftm);
			}
		});
		show.add(saveGames);
		
		screenshots=new JButton("�Ҳ�����ͼ�ĵ�����");
		screenshots.setBounds(400, 0, 400, 100);
		screenshots.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileSystemView fsv=FileSystemView.getFileSystemView();
				String tfh,ftm;
				tfh=fsv.getDefaultDirectory().getPath()+"/Paradox Interactive/Hearts of Iron III/Screenshots";
				ftm=Game.gamePath+"/Screenshots";
				Game.openFolder(tfh);
				Game.openFolder(ftm);
			}
		});
		show.add(screenshots);
		
		fullScreen=new JButton("�޸�ȫ����ȫ��");
		fullScreen.setBounds(0, 100, 400, 100);
		fullScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] obj=new Object[2];
				obj[0]="yes"; obj[1]="no";
				String aim = (String) JOptionPane.showInputDialog(null,"choose type:\n", "choose type", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), obj, obj[0]);
				if (aim==null) return ;
				else{
					String message="fullScreen="+aim;
					Game.changeSetting("fullScreen", message);
				}
				
				JOptionPane.showMessageDialog(null,"�������գ��Ѿ��޸�����", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		show.add(fullScreen);
		
		flagError=new JButton("û�����ģ���������ȫ�Ǻ�ɫ������");
		flagError.setBounds(400, 100, 400, 100);
		flagError.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tfh,ftm;
				tfh=Game.gamePath+"/tfh/gfx/flags/flagfiles.tga";
				ftm=Game.gamePath+"/gfx/flags/flagfiles.tga";
				HHD.deleteFile(ftm);
				HHD.deleteFile(tfh);
				
				JOptionPane.showMessageDialog(null,"�������գ�ƶ���Ѿ�����", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		show.add(flagError);
		
		german=new JButton("�¹��ı�ģû����������");
		german.setBounds(0, 200, 400, 100);
		german.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String aim=Game.gamePath+"/interface/ger_XPRostInfantry_avatars.gfx";
				HHD.deleteFile(aim);
				
				JOptionPane.showMessageDialog(null,"�������գ�ƶ���Ѿ�����", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		show.add(german);
		
		science=new JButton("�Ƽ���ʾ������������");
		science.setBounds(400, 200, 400, 100);
		science.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.deleteCache();
				
				JOptionPane.showMessageDialog(null,"�������գ�ƶ���Ѿ����£����о��л��ɶ�������", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		show.add(science);
		
		buffer=new JButton("������������(������֮Դ)");
		buffer.setBounds(0, 300, 400, 100);
		buffer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.deleteCache();
				JOptionPane.showMessageDialog(null,"�������գ����������ĵ�ͼ�����Ѿ�ɾ��", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		show.add(buffer);
		
		country=new JButton("��������ѡ����Һ���������");
		country.setBounds(400, 300, 400, 100);
		country.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.changeSetting("master_volume", "master_volume=0.000000");
				JOptionPane.showMessageDialog(null,"�������գ�ƶ���Ѿ�����", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		show.add(country);
		
		history=new JButton("Ӧ����ʷʱ���������");
		history.setBounds(0, 400, 400, 100);
		history.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.changeSetting("fullScreen", "fullScreen=no");
				Game.changeSetting("master_volume", "master_volume=0.000000");
				Game.changeSetting("alwaysCounters", "alwaysCounters=yes");
				
				FileSystemView fsv=FileSystemView.getFileSystemView();
				String path,item;
				path=fsv.getDefaultDirectory().getPath()+"/Paradox Interactive/Hearts of Iron III/";
				item="/logs"; HHD.deleteFolder(path+item);
				item="/map"; HHD.deleteFolder(path+item);
				item="/music"; HHD.deleteFolder(path+item);
				
				HHD.writeFile(Game.gamePath+"/userdir.txt", "./tfh");
				
				JOptionPane.showMessageDialog(null,"�������գ�ƶ���Ѿ�����", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		show.add(history);
		
		deleteAll=new JButton("ɾ�����ҵ��ĵ��ڵ��������� �����浵(�����ťҲ��һ��)");
		deleteAll.setBounds(400, 400, 400, 100);
		deleteAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileSystemView fsv=FileSystemView.getFileSystemView();
				String path=fsv.getDefaultDirectory().getPath()+"/Paradox Interactive/Hearts of Iron III/";
				HHD.deleteFolder(path);
				
				JOptionPane.showMessageDialog(null,"�������գ�һ����Ե��", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		show.add(deleteAll);
		
		exit=new JButton("������������� (һ�������� @�������� �ṩ)");
		exit.setBounds(0, 500, 800, 100);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop desktop = Desktop.getDesktop();   
					URI uri=new URI("http://tieba.baidu.com/p/2039711535");
					desktop.browse(uri);
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				UI.window.dispose();
			}
		});
		show.add(exit);
	}
	@Override
	public void show() {
		UI.window.add(show);
	}
	@Override
	public void back() {
		
	}
	@Override
	public void submit() {
		
	}
}
