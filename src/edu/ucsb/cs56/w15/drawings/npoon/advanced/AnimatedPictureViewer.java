package edu.ucsb.cs56.w15.drawings.npoon.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private ThreePointCourt court = new ThreePointCourt(200, 200, 400);
    
    Thread anim;   
    
    //ball dimensions
    private int x = 50;
    private int y = 212;
    private int size = 25;
    
    //court dimensions
    private int cx = x;
    private int cy = y-125+(size/2);
    private int csize = size * 20;
    
    //increment
    private int sz = 5;

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
	int CLICK_COUNTER = 0;
        public void mouseClicked(MouseEvent e){
	
	if(CLICK_COUNTER%2 == 0)
        	{ 
		  //CLICK TO START
		  System.out.println("Mouse clicked - starting animation!");
        	  anim = new Animation();
        	  anim.start();
		  CLICK_COUNTER++;
		}
	
	else if (CLICK_COUNTER%2!=0)
		{
		 //CLICK TO STOP
		 System.out.println("Mouse clicked - stopping animation!");
         	 anim.interrupt();
         	 while (anim.isAlive())    
         	 panel.repaint();  
		 CLICK_COUNTER--;
		}
			
        }

      });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

          // Clear panel
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());
 
	  // Draw out directions
	  g2.setColor(Color.black);
	  g2.drawString("Click on the window to start and stop animation!", 150, 40);	  
          // Draw the court
          g2.setColor(Color.blue);
          ThreePointCourt court = new ThreePointCourt(cx, cy, csize);
          g2.draw(court);
	  //Draw ball
	  g2.setColor(Color.orange);
	  g2.fillOval(x,y, size,size);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the court borders

            if (x >= 500+size) { sz = -5; }
            if (x <= 50) { sz = 5; }
     
	    x += sz;                
            panel.repaint();
            Thread.sleep(30);
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
