package edu.ucsb.cs56.w15.drawings.triptisinghal.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private Ant ant = new Ant(100, 250, 50);
    private AntWithFace antwf = new AntWithFace(100, 350, 30);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    
    private int dx = 5;
    private int dy = 5;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(720,500);
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

          // Draw the Ant
	  Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 
	  Stroke orig=g2.getStroke();
	  g2.setStroke(thick);
	  AntWithFace testAntWF = new AntWithFace(x, y, 50);
	  g2.setColor(Color.BLUE);
	  g2.draw(testAntWF);
	  if(x >= 400 || x <= 0){
          	g2.setColor(Color.RED);
		g2.draw(testAntWF);
	  }
	  if(y >= 350 || y <= 0){
		g2.setColor(Color.GREEN);
		g2.draw(testAntWF);
	  }
		
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 400){
		dx = -5;
	    }
            if (x <= 0){
		dx = 5;
	    }
	    if (y >= 350){
		dy = -5;
	    }
	    if (y <= 0){
		dy = 5;
	    }
            
            x += dx; 
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
