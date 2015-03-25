package edu.ucsb.cs56.w15.drawings.aferguson.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
   
    private Unicycle unicycle = new Unicycle(200, 200, 50);
    Thread anim;   
    
    private int x = 200;
    private int y = 200;
    

    private UniTop top1 = new UniTop(x, y, 60);
    private Wheel wheel1 = new Wheel(x, y, 60);

    private Shape uniWheel = ShapeTransforms.scaledCopyOfLL(wheel1, 1, 1);
    private Shape uniTop = ShapeTransforms.scaledCopyOfLL(top1, 1, 1);
    
    private int dx = 5;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(850,600);
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

          // Draw the Unicycle
          g2.setColor(Color.BLUE);
	  if(dx==5){
	      uniWheel = ShapeTransforms.translatedCopyOf(uniWheel, 5, 0);
	      uniWheel = ShapeTransforms.rotatedCopyOf(uniWheel, Math.PI/10.0*(-1));
	      uniTop = ShapeTransforms.translatedCopyOf(uniTop, 5, 0);
	  }	  
	  else{
	      uniWheel = ShapeTransforms.translatedCopyOf(uniWheel, -5, 0);
	      uniWheel = ShapeTransforms.rotatedCopyOf(uniWheel,Math.PI/10.0);
	      uniTop = ShapeTransforms.translatedCopyOf(uniTop, -5, 0);
          }
	  //	  UniTop uniTop = new UniTop(x, y, 60);
	  //UniTop uniTop = new UniTop(x, y, 60);
          g2.draw(uniTop);
	  g2.draw(uniWheel);
          }
    }    

    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 725) { dx = -5; }
            if (x <= 0) { dx = 5; }
            
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
