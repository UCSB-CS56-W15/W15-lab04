package edu.ucsb.cs56.w15.drawings.ryanpeffers.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private Wheels fullCar = new Wheels(200, 200, 140, 40);
    
    Thread anim;   
    
    private int x = 100;
    private int y = 100;
    
    private int dx = 5;


    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }
    // the go function builds the Frame and monitors when the mouse cursor is on the Panel
    // to determine when the car should be moving around from animation
    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("Mouse entered panel");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse exited panel");
          // Kill the animation thread
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
      });
      
    } //go

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);  //white background
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the car 
          g2.setColor(new Color(0xCD5C5C));
          Wheels test = new Wheels(x, y, 140, 40);
          g2.draw(test);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Start the car moving from left to right then teleport
	    // back to the start

            if (x >= 400) { dx = -375; }
            if (x <= 50) { dx = 5; }
            
            x += dx;                
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
