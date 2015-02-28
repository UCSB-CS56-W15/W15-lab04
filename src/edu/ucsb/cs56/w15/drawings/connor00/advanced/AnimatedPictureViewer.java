package edu.ucsb.cs56.w15.drawings.connor00.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private ParabolicStar star = new ParabolicStar(0, 0, 500, 500, 1);
    private ParabolicStar star2 = new ParabolicStar(0, 0, 500, 500, 1);
    
    Thread anim;
    
    private int x = 0;
    private int y = 0;
    private double theta = 0.0; 

    private int dl = 1;
    private int ds = 5;
    private double dt = Math.PI / 45.0;

    private int lines = 1;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the Star
	  
          ParabolicStar base = new ParabolicStar(x, y, 700 - (x * 2), 700 - (y * 2), lines);
	  Shape star1paint = ShapeTransforms.rotatedCopyOf(base, theta);
	  Shape star2paint = ShapeTransforms.rotatedCopyOf(base, Math.PI/4 - theta);
	  Shape star3paint = ShapeTransforms.rotatedCopyOf(base, Math.PI/3 + theta);
	  Shape star4paint = ShapeTransforms.rotatedCopyOf(base, Math.PI/6 - theta);
	  g2.setColor(new Color(0xDD0000));
	  g2.draw(star1paint);
	  g2.setColor(new Color(0x000099));
	  g2.draw(star2paint);
	  g2.setColor(new Color(0x009900));
	  g2.draw(star3paint);
	  g2.setColor(new Color(0xDDDD00));
	  g2.draw(star4paint);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {

            if (x >= 350) { 
		ds = -5;
		dl = -1;
	    }
            if (x <= 5) { 
		ds = 5;
		dl = 1;
	    }

            x += ds;
	    y += ds;
	    lines += dl;
	    theta += dt;

            panel.repaint();
            Thread.sleep(100 - lines);
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
}
