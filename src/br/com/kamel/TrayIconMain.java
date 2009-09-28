package br.com.kamel;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrayIconMain {
	
	public TrayIconMain(){
		SystemTray tray = SystemTray.getSystemTray();

		Image image = Toolkit.getDefaultToolkit().getImage("icon/bird.png");
		image=image.getScaledInstance(15, 15, Image.SCALE_FAST);

		ActionListener listener = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("press: "+arg0.getActionCommand());
				System.out.println("FINISHING");
				System.exit(0);
			}
		};
		
		PopupMenu popup = new PopupMenu();		
        	MenuItem Item = new MenuItem("Menu1");
        	Item.addActionListener(listener);
        	        	        	
        	PopupMenu popup2 = new PopupMenu("Menu2");        	
	        	MenuItem Item2 = new MenuItem("Menu2_2");
	        	Item2.addActionListener(listener);        	
        	popup2.add(Item2);
        	
        popup.add(Item);
        popup.add(popup2);
		
		TrayIcon trayIcon = new TrayIcon(image, "TrayIconDemo", popup);
		
		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		System.out.println("COMPLETE");	
	}
	
	public static void main(String[] args) {
		
		if (!SystemTray.isSupported()){
			System.err.println("SystemTray not supported");
			System.exit(-1);
		}
		
		new TrayIconMain();
	}

}
