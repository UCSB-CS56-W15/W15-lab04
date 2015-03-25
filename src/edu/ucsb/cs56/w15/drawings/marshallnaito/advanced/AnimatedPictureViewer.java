package edu.ucsb.cs56.w15.drawings.marshallnaito.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    /** 
    Creates the animation of driving under a stoplight
    */


    
    Thread anim;   
    
    private int startwidth = 4;
    private int startheight = 25;

    private int x = 250; //starting x-pos
    private int y = 350; //starting y-pos
    
    private int dx = 3;

    private int delay1 = 50;
    private int delay2 = 500;

    private DrawPanel panel = new DrawPanel();
    private StopLight stoplight = new StopLight(x,y,startwidth,startheight);

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
        // animate when mouse in in panel
        public void mouseEntered(MouseEvent e){
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          // Kill the animation thread
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
      });
      
    }

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the StopLight
          g2.setColor(Color.BLUE);
          StopLight test = new StopLight(x,y,startwidth,startheight);
          g2.draw(test);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {

            // get bigger up to a boundary
            if (x >= 450) { x = 0; }
            //reset when get to boundary
            if (startheight >= 300 || startwidth >=50){
              startwidth = 4;
              startheight = 25;
              x = 250;
            }
            //animate slower when farther away
            if (x >= 350) {
              startheight += 10;
              startwidth += 1;
              x -= dx;
              stoplight = new StopLight(x,y,startwidth, startheight);
              panel.repaint();
              Thread.sleep(delay2);
           }
            if (x < 350) {
              startheight += 10;
              startwidth += 1;
              x -= dx;
              stoplight = new StopLight(x,y,startwidth, startheight);
              panel.repaint();
              Thread.sleep(delay1);
           }
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
}