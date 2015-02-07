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
		
		saveGames=new JButton("找不到存档的点这里");
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
		
		screenshots=new JButton("找不到截图的点这里");
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
		
		fullScreen=new JButton("修改全屏或不全屏");
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
				
				JOptionPane.showMessageDialog(null,"善哉善哉，已经修改完了", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		show.add(fullScreen);
		
		flagError=new JButton("没有旗帜，或者旗帜全是黑色点这里");
		flagError.setBounds(400, 100, 400, 100);
		flagError.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tfh,ftm;
				tfh=Game.gamePath+"/tfh/gfx/flags/flagfiles.tga";
				ftm=Game.gamePath+"/gfx/flags/flagfiles.tga";
				HHD.deleteFile(ftm);
				HHD.deleteFile(tfh);
				
				JOptionPane.showMessageDialog(null,"善哉善哉，贫道已尽人事", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		show.add(flagError);
		
		german=new JButton("德国的兵模没武器点这里");
		german.setBounds(0, 200, 400, 100);
		german.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String aim=Game.gamePath+"/interface/ger_XPRostInfantry_avatars.gfx";
				HHD.deleteFile(aim);
				
				JOptionPane.showMessageDialog(null,"善哉善哉，贫道已尽人事", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		show.add(german);
		
		science=new JButton("科技显示不正常点这里");
		science.setBounds(400, 200, 400, 100);
		science.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.deleteCache();
				
				JOptionPane.showMessageDialog(null,"善哉善哉，贫道已尽人事，不行就切换成独显试试", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		show.add(science);
		
		buffer=new JButton("清楚缓存点这里(清楚万恶之源)");
		buffer.setBounds(0, 300, 400, 100);
		buffer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.deleteCache();
				JOptionPane.showMessageDialog(null,"善哉善哉，理论上万恶的地图缓存已经删了", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		show.add(buffer);
		
		country=new JButton("正常运行选择国家后出错点这里");
		country.setBounds(400, 300, 400, 100);
		country.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.changeSetting("master_volume", "master_volume=0.000000");
				JOptionPane.showMessageDialog(null,"善哉善哉，贫道已尽人事", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		show.add(country);
		
		history=new JButton("应用历史时出错点这里");
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
				
				JOptionPane.showMessageDialog(null,"善哉善哉，贫道已尽人事", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		show.add(history);
		
		deleteAll=new JButton("删除在我的文档内的所有内容 包括存档(这个按钮也就一试)");
		deleteAll.setBounds(400, 400, 400, 100);
		deleteAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileSystemView fsv=FileSystemView.getFileSystemView();
				String path=fsv.getDefaultDirectory().getPath()+"/Paradox Interactive/Hearts of Iron III/";
				HHD.deleteFolder(path);
				
				JOptionPane.showMessageDialog(null,"善哉善哉，一切随缘吧", "message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		show.add(deleteAll);
		
		exit=new JButton("其他问题点这里 (一切资料由 @国家理念 提供)");
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
