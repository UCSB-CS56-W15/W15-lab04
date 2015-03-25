package edu.ucsb.cs56.w15.drawings.yamen.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();

    Thread anim;   
    
    private int x = 200;
    private int y = 200;
    private float z = 1.0f;
    private double r = 2 * Math.PI;
    
    private int dx = 5;
    private int dy = 5;
    private float dz = .1f;
    private double dr = Math.PI / 18;

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
	  
	  //Change the size of the Stroke
	  Stroke s = new BasicStroke(z, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	  g2.setStroke(s);
	  
          // Draw a random colored Apple Tree
	  int red = (int) (Math.random() * 255);
	  int green = (int) (Math.random() * 255);
	  int blue = (int) (Math.random() * 255);

	  Color randColor = new Color(red, green, blue);
	  
          g2.setColor(randColor);
          TreeWithApples test = new TreeWithApples(x, y, 150, 150);

	  // Implement Rotation of Apple Tree
	  
	  Shape t1 = ShapeTransforms.rotatedCopyOf(test, r);
	  
          g2.draw(t1);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls diagonally

            if (x >= 400) { dx = -5; }
            if (x <= 150) { dx = 5; }
	    if (y >= 400) { dy = -5;}
	    if (y <= 150) { dy = 5;}
	    if (z >= 5.0)   { dz = -.1f;}
	    if (z <= 1.0)   { dz = .1f;}
            
            x += dx;
	    y += dy;
	    z += dz;
	    r += dr;
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
