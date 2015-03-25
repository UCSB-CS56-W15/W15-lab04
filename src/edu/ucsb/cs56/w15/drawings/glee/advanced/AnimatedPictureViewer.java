package edu.ucsb.cs56.w15.drawings.glee.advanced;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();

    private CarWithWindows car1 = new CarWithWindows(100, 100, 100, 100);
    private CarWithWindows car2 = new CarWithWindows(100, 100, 100, 100);
    Thread anim;

    private int x = 100;
    private int y = 100;
    private int x2 = 400;
    private int dx = 5;
    private int dx2 = 5;
    private int dy = 5;
    private String color1 = "BLUE";
    private String color2 = "RED";
    public static void main (String[] args) {
	new AnimatedPictureViewer().go();
    }

    public void go() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(panel);
	frame.setSize(640,480);
	frame.setVisible(true);

	frame.getContentPane().addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent e){
		    System.out.println("mouse entered");
		    anim = new Animation();
		    anim.start();
		}

		public void mouseExited(MouseEvent e){
		    System.out.println("Mouse exited");
		    // Kill the animation thread                                                    
		    anim.interrupt();
		    while (anim.isAlive()){}
		    anim = null;
		    panel.repaint();
		}
	    });

    } // go()                                                                             

    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g) {

	    Graphics2D g2 = (Graphics2D) g;

	    // Clear the panel first                                                         
	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(), this.getHeight());

	    // Draw the Ipod                                                    
	    if (color1 == "RED"){            
		g2.setColor(Color.MAGENTA);
	    }
	    else{
		g2.setColor(Color.BLUE);
	    }
	    CarWithWindows test = new CarWithWindows(x, y, 150, 150);
	    CarWithWindows test2 = new CarWithWindows(x2, y, 150, 150);
	    g2.draw(test);
	    if (color2 == "RED"){
		g2.setColor(Color.CYAN);
	    }
	    else{
		g2.setColor(Color.PINK);
	    }
	    g2.draw(test2);

	}
    }

    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    // Bounce off the walls   
		    if (x+150 >= x2) { 
			dx = -5;
			if (color1 == "RED"){
			    color1 = "BLUE";
			}
			else{
			    color1 = "RED";
			}
		    }
		    if (x <= 1) { dx = 5; }
		    if (x2 >= 472) { dx2 = -5;}
		    if (x2 <= x+150) { 
			dx2 = 5;
			if (color2 == "BLUE"){
			    color2 = "RED";
			}
			else{
			    color2 = "BLUE";
			}
		    }
		    if (y >= 280) { dy = -5;}
		    if (y <= 1) { dy = 5; }
		    x += dx;
		    x2 += dx2;
		    y += dy;
		    panel.repaint();
		    Thread.sleep(50);
		}
	    } catch(Exception ex) {
		if (ex instanceof InterruptedException) {
		    // Do nothing - expected on mouseExited                                       
		} else {
		    ex.printStackTrace();
		    System.exit(1);
		}
	    }
	}
    }

}

