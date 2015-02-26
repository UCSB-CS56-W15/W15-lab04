package edu.ucsb.cs56.w15.drawings.arda.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale

import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;



import java.awt.geom.Arc2D;  // ARCS
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.GeneralPath; // combinations of lines and curves
*/


// import java.awt.Shape; // general class for shapes
 import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
// import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;


public class AnimatedPictureViewer {

	/*	@@@@@@@@@@@@@@ PLEASE READ @@@@@@@@@@@@@@@


	 - - - - - - - OVERALL - - - - - - - 

	Our animation will be a black BetterCat, with a thick Stroke,
	rolling around at the bottom of our frame.





	 - - - - - - - ORIGINAL POSITION - - - - - - - 

	The BetterCat (BC) will start centered in x, and "resting" on
	on the bottom of the frame; the BC's center will have to be it's
	radius above the bottom of the frame.
	 - The frame is 640 * 480.
	 - BC's radius will be 100.
	 - BC will start at (320, HeightOfWindow - RadiusOfBetterCat)
	




	 - - - - - - - ROLLING MOTION - - - - - - - 

	The "rolling" will be accomplished by using the function sin
	to act as a factor of how much it rotates (and gets translated
	according to it's rotation, which would accordingly be a factor
	of the BC's circumference (so that it looks connected to the bottom
	of the frame and not "slipping"))
	 - The rotation will start with the BC face up.
	 - The rotation's furthest extreme in either direction will be to
	   the BC being upside down; the rotation will range from positive
	   to negative pi.
	 - x-translation will range from positive to negative (pi*2*radius)
	




	 - - - - - - - HOW TO MAKE THE ROLLING "SMOOTH"? - - - - - - - 

	We need a factor to scale both the rolling and rotation so that they can
	look "natural" and not a linearly (aka harshly) zip from one side of the 
	window to the other, or rotate similarly linearly. Therefore, our 
	"natural" periodic motion will mapped to a sin function, since sin
	smoothly transitions between changes of direction.

	We will use a factor derived from sin to scale the rotation and 
	translation that occurs on the BC: when sin is at its max or min
	will map to the extremes of our BC's motion.

	Please do not confuse this factor with the desired displacement itself:
	 - DESIRED_DISPLACEMENT = pi
	 - factor = sin(some mapping of time)
	 - displacement (angular or translational) = factor*DESIRED_DISPLACEMENT





	 - - - - - - - SYNCHRONIZE THE ROLLING WITH TIME - - - - - - -

	What is "some mapping of time"? We need a way to map the time elapsed
	to an input of sin such that sin will output its maximum, 1, when the 
	desired *period* of our animatino has occured.
	
	The BC will roll to upside down after 1 second. Thus, we need to map 
	sin(foo) = 1 to cause the maximum rotation (and tranlsation) to be 
	synced with 1 second. Therefore, foo must be 1/2.
	 - we need to scale 1 second to map to pi/2, using foo:
	 - 1000 ms = pi/2 rotation  ==>  1 ms = pi/2000 rotation 

	 - let  foo = msElapsed * (pi/2000)
	 - then, our factor = sin(foo). Why does this work? Let's look at some
	   examples:
	
	 - EXAMPLE 1: when msElapsed = 1000,  foo = pi/2
	 	 - if foo = pi/2,  sin(foo) = 1
	 	 - therefore, factor = 1 after 1 second. the BC is at the right
	 	   extreme of the motion
	 - EXAMPLE 2: if 2 seconds have elapsed, foo = pi
		 - foo = sin(pi), so sin(foo) = 0
		 - therefore, factor = 0 at t = 2 secs, and the BC will 
		   have returned to it's original location.
	 - EXAMPLE 3: if 3 seconds have elapsed, foo = 3000 * pi / 2000
	 	 - foo = (3/2)* pi, so sin(foo) = -1
	 	 - therefore, factor = -1, the opposite extreme of the animation.
	
	Once again, the key is that sin smoothly transitions between these
	changes of direction, which is why we're using it, even though it
	does add an extra barrier between the time elapsed and redrawing the frame

	*/





	// private final double DESIRED_DISPLACEMENT = Math.PI;

	// the variable that will be a function on sin
	private double factor = 0;

	// how we'll keep track of time
	private int msElapsed = 0;


	// we know our frame will be 640*480, so we can initialize the 
	// BetterCat's position from these hard-coded points:
	private final int FRAME_W = 640;
	private final int FRAME_H = 480;

	// private final int X_ORIG = 320; // 640/2 

	// private final double CAT_RADIUS = 100.0;



	private DrawPanel panel = new DrawPanel();
		
	Thread anim;   







	// this should execute every 50 ms, from the timer.
	ActionListener calcFactor  = new ActionListener()	{
		public void actionPerformed(ActionEvent e)	{
			msElapsed +=25;
			factor = Math.sin((msElapsed)*(Math.PI/2000.0));
		}
	};


	Timer timer = new Timer(25,calcFactor); // 25 millisecond delay








	public static void main (String[] args) {
		new AnimatedPictureViewer().go();
	}




	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(panel);
		frame.setSize(FRAME_W,FRAME_H);
		frame.setVisible(true);






		
		frame.getContentPane().addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e){
					System.out.println("mouse entered");
					timer.start();
					anim = new Animation();
					anim.start();
				}
	
				public void mouseExited(MouseEvent e){ 
					timer.stop();       
					System.out.println("Mouse exited");
					// Kill the animation thread
					anim.interrupt();
					while (anim.isAlive()){}
					anim = null;         
					panel.repaint();        
				}
			} // MouseAdapter
			); //addMouseListenere
	} // go()






	class DrawPanel extends JPanel {
		 public void paintComponent(Graphics g) {

			Graphics2D g2 = (Graphics2D) g;

			// Clear the panel first
			g2.setColor(Color.white);
			g2.fillRect(0,0,this.getWidth(), this.getHeight());


			double CAT_RADIUS = Math.min(this.getWidth(),2*this.getHeight())/10.0;
			double DESIRED_DISPLACEMENT = this.getWidth()/(Math.PI*CAT_RADIUS);


			// draw the BetterCat!
			// start by placing the cat at it's original location, 
			// then translate and rotate it.
			Shape bc = new BetterCat(
								this.getWidth()/2.0, 
								this.getHeight()-CAT_RADIUS,
								CAT_RADIUS
						); // bc
			bc = ShapeTransforms.translatedCopyOf(
									bc,
									factor*DESIRED_DISPLACEMENT*CAT_RADIUS,
									0
								);
			bc = ShapeTransforms.rotatedCopyOf(bc, factor*DESIRED_DISPLACEMENT);


			float STROKE = (float) (CAT_RADIUS/20.0f);

			// set the stroke to thick
			Stroke thick = new BasicStroke (
									STROKE, 
									BasicStroke.CAP_BUTT, 
									BasicStroke.JOIN_BEVEL);       
			g2.setStroke(thick);

			g2.setColor(Color.BLACK); 
			g2.draw(bc); 
		 }
	}
	




	class Animation extends Thread {
		public void run() {
			try {
				while (true) {
				// nothing to do but redraw at some arbitrary frame rate, 
				// so once per 50 ms.           
				panel.repaint();
				Thread.sleep(25);
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
