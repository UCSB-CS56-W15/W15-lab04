//stuff
package edu.ucsb.cs56.w15.drawings.gaberome.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
        
    Thread anim;   
    
    private int x = 0;
    private int y = 0;
    
    private int dx = 5;
    private int dy = 10;

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

          g2.setColor(Color.BLACK);
          DragonBall test = new DragonBall(x, y, 75);
          g2.draw(test);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {	     
	    int YCor=240;
          while (true) {

            if (x >= 560) { dx = -15; }
            if (x <= 70) { dx = 15; }
	    if(y <= YCor) { dy = 20;}
	    if(y >= 380 && YCor <= 360) { dy = -20;}
	    if (y ==380) {YCor =YCor+40;}
	    if (y>= 530) {YCor = 240; y =-80;}
	    y += dy;
	    x += dx;
            panel.repaint();
            Thread.sleep(70);
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

