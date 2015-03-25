package edu.ucsb.cs56.w15.drawings.dcwang.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
        
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    private int length = 70;
    private int width = 50;
    private int dwidth=-1;
    private int dlength = -1;
    private int dx = 3;
    private int dy = 3;

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
        System.out.println("Mouse entered");
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
          g2.setColor(Color.BLACK);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the TableWithWheels
          g2.setColor(Color.GREEN);
          TableWithWheels test = new TableWithWheels(x, y, width, length);
          g2.draw(test);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 400) { dx = -3; }
            if (x <= 50) { dx = 3; }
            
	    if(y >= 330) {dy = -3;}
	    if(y <= 100) {dy = 3;}

            x += dx;
	    y += dy;

	    if(length<=30) { dlength = 1; }
	    if(length>=70) { dlength = -1; }
	   
	    if(width<=30) { dwidth = 1; }
	    if(width>=50) { dwidth = -1;}

	    width += dwidth;
	    length += dlength;

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
