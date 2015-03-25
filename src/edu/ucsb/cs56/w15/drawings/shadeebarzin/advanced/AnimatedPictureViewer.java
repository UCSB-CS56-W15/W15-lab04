package edu.ucsb.cs56.w15.drawings.shadeebarzin.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *Class to animate a FlowerWithStem and make it bounce off the edges of the frame
 *
 * @author Shadee Barzin
 * @version for UCSB CS56, W15, 02/20/2015
 */

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    private FlowerWithStem fs = new FlowerWithStem(300,300,300);

    private int x = 300;
    private int y = 200;
    private int dx = 5;
    private int dy = 3;

    Thread animation;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(800,800);
      frame.setTitle("Shadee Barzin's Animated Drawing");
      frame.setVisible(true);

      frame.getContentPane().addMouseListener(new MouseAdapter() {
	      public void mouseEntered(MouseEvent e){
		  System.out.println("Mouse Entered");
		  // start animation thread
		  animation = new Animation();
		  animation.start();
	      }

	      public void mouseExited(MouseEvent e){
		  System.out.println("Mouse Exited");
		  // kill animation thread
		  animation.interrupt();
		  while (animation.isAlive()){}
		  animation = null;
		  panel.repaint();        
	      }
	  });
    }


    class DrawPanel extends JPanel {
      public void paintComponent(Graphics g) {
	   Graphics2D g2 = (Graphics2D) g;

	   // set background
	   g2.setColor(Color.WHITE);
	   g2.fillRect(0,0,this.getWidth(), this.getHeight());
	   
	   // draw flower
	   g2.setColor(new Color(0xCCCCFF));
	   Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	   g2.setStroke(thick);
	   FlowerWithStem fs2 = new FlowerWithStem(x,y,200);
	   g2.draw(fs2);
       }
    } // DrawPanel

    
    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    // bounce off walls
		    if (x >= 600)
			dx = -5;
		    if (x <= 50)
			dx = 5;
		    if (y >= 380)
			dy = -4;
		    if (y <= 50)
			dy = 4;
		    x += dx;
		    y += dy;
		    panel.repaint();
		    Thread.sleep(50);
		}
	    } catch(Exception ex) {
		if (ex instanceof InterruptedException) {
		    // do nothing: expected on mouseExited
		} else {
		    ex.printStackTrace();
		    System.exit(1);
		}
	    }
	}
    } // Animation
    
} // AnimatedPictureViewer
