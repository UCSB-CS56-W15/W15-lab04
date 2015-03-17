package edu.ucsb.cs56.w15.drawings.atran.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.Math;

/** A comment
    @author A. Tran
    @version for UCSB CS56, W15, 02/19/2015
 */

public class AnimatedPictureViewer {
    private DrawPanel panel = new DrawPanel();
    private LightBulb lightbulb = new LightBulb(0,0,100,200);
    Thread anim;
    // following private ints needed for orig anim, change as needed
    private int x = 100;
    private int y = 100;

    private double dx = 5;
    private double dy = 0;
    final private double vecMag = 5; 

    public static void main(String[] args) {
	new AnimatedPictureViewer().go();
    }

    public void go() {
	JFrame frame = new JFrame();
	// Set size of frame to width 640 and height 480
	frame.getContentPane().add(panel);
	frame.setSize(640,480);
	frame.setVisible(true);
	// Set title to "Andrew Tran's Animated Drawing"
	frame.setTitle("Andrew Tran's Animated Drawing");
	// Ensure red X works to close the window
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent e){
		    System.out.println("mouse entered");
		    anim = new Animation();
		    anim.start();
		}
		public void mouseExited(MouseEvent e){
		    System.out.println("mouse exited");
		    anim.interrupt();
		    while(anim.isAlive()){}
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

          // Draw the LightBulb
          g2.setColor(Color.BLUE);
          LightBulb test = new LightBulb(x, y, 100.0, 200.0);
          g2.draw(test);
       }
    }

    // Helper function to find other component in vector of magnitude 5
    // First parameter takes other component, second checks for sign of return value
    private double vecComponent(double comp, double sign) {
	double result = Math.sqrt( Math.pow(vecMag,2.0) - Math.pow(comp,2.0) );
        if (sign < 0)
	    result = -result;
	return result;
    }

    class Animation extends Thread {
	public void run() {
	    try {
		Random rand = new Random();
		while (true) {
		    // Check if LightBulb is in bounds

		    // If x collision, dx flips sign, dy maintains sign
		    if ( x >= 400 ) {
			dx = 5*rand.nextDouble() - 5.0;
			dy = vecComponent(dx,dy);
		    }
		    else if ( x <= 50 ) { 
			dx = 5*rand.nextDouble();
			dy = vecComponent(dx,dy);
		    }

		    // If y collision, dx maintains sign, dy flips sign
		    if ( y >= 400 ) {
			dy = 5*rand.nextDouble() - 5.0;
			dx = vecComponent(dy,dx);
		    }
		    else if ( y <= 50 ) {
			dy = 5*rand.nextDouble();
			dx = vecComponent(dy,dx);
		    }
		    x += dx;
		    y += dy;

		    panel.repaint();
		    Thread.sleep(50);
		}
	    } catch(Exception ex) {
		if (ex instanceof InterruptedException) {
		    // expected on mouseExited
		} else {
		    ex.printStackTrace();
		    System.exit(1);
		}
	    }
	}
    }

}
