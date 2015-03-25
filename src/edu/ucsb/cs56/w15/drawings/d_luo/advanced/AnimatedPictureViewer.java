package edu.ucsb.cs56.w15.drawings.d_luo.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer{
	private DrawPanel panel = new DrawPanel();
	
	private SwordAndHilt sword = new SwordAndHilt(100, 100, 100, 20);
	
	Thread anim;

	private int x = 100;
	private int y = 300;
	
	private int dx = 5; 

	public static void main (String[] args){
		new AnimatedPictureViewer().go();
	}

	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel); 
		frame.setSize(640,480);
		frame.setVisible(true); 
		frame.getContentPane().addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e){
			System.out.println("mouse input received");
			anim = new Animation();
			anim.start();
		}
		public void mouseExited(MouseEvent e){
			System.out.println("Mouse exited");
			//kill animation 
			anim.interrupt();
			while(anim.isAlive()){}
			anim = null;
			panel.repaint();
		}
		});
	}
	
	class DrawPanel extends JPanel{
		public void paintComponent(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
		// clear the panel first
		g2.setColor(Color.white);
		g2.fillRect(0,0,this.getWidth(), this.getHeight());
		g2.setColor(Color.RED);
		SwordAndHilt aSword = new SwordAndHilt(x,y,100,20); 
		g2.draw(aSword); 
		}
	}

	class Animation extends Thread {
		public void run(){
		try{
			while(true){
			if(x>=400) {dx = -5; }
			if (x<= 50) {dx = 5; }
			
			x += dx;
			panel.repaint();
			Thread.sleep(50);
			}
		}catch(Exception ex){
		if(ex instanceof InterruptedException){
		// do nothing - expected of mouse exited
		}else{
			ex.printStackTrace();
			System.exit(1); 
		}
		}
		}
	}
}
