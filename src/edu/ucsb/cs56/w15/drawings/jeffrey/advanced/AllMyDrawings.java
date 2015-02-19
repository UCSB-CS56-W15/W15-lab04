package edu.ucsb.cs56.w15.drawings.jeffrey.advanced;

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

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Jeffrey Chen
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings {
    /** Draw a picture with a few clocks 
     */

    public static void drawPicture1(Graphics2D g2) {
    	Stroke thick = new BasicStroke (8.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
		Stroke orig=g2.getStroke();


		Clock c1 = new Clock(20, 350, 50);
		g2.setColor(Color.BLACK);
		g2.draw(c1);

		// Make a red clock that's half the size

		Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
		c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
		g2.setColor(Color.RED);
		g2.draw(c2);
		
		
		// Here's a clock that's 4x as big (2x the original)
		Shape c3 = ShapeTransforms.scaledCopyOfLL(c1,4,4);
		c3 = ShapeTransforms.translatedCopyOf(c3,200,0);
		
		// We'll draw this with a thicker stroke    
		g2.setStroke(thick);
		
		// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
		// #002FA7 is "International Klein Blue" according to Wikipedia
		// In HTML we use #, but in Java (and C/C++) its 0x
		g2.setColor(new Color(0x002FA7)); 
		g2.draw(c3); 
		
		// Draw two alarm clocks
		
		AlarmClock ac1 = new AlarmClock(50,75,75);
		AlarmClock ac2 = new AlarmClock(100,250,50);
		
		g2.setStroke(orig);
		g2.draw(ac1);
		g2.setColor(new Color(0x8F00FF));
		g2.draw(ac2);
		
		// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
		
		g2.setColor(Color.BLACK); 
		g2.drawString("A few clocks by Jeffrey", 20,20);
	    }


    /** Draw a picture with a clocks and alarm clocks
     */
    public static void drawPicture2(Graphics2D g2) {
		// Draw some clocks
		Clock c1 = new Clock(100,50,150);
		Clock c2 = new Clock(20,50,30);
		g2.setColor(Color.RED);
		g2.draw(c1);
		g2.setColor(Color.GREEN);
		g2.draw(c2);
		
		AlarmClock ac1 = new AlarmClock(20,275,75);
		g2.setColor(Color.CYAN);
		g2.draw(ac1);
		
		// Make a black alarm clock that's half the size, 
		// and moved over 150 pixels in x direction
		Shape ac2 = ShapeTransforms.scaledCopyOfLL(ac1,0.5,0.5);
		ac2 = ShapeTransforms.translatedCopyOf(ac2,200,25);
		ac2 = ShapeTransforms.rotatedCopyOf(ac2, Math.PI);
		g2.setColor(Color.BLACK);
		g2.draw(ac2);
		
		// Here's a alarm clock that's 4x as big (2x the original)
		// and moved over 150 more pixels to right.
		ac2 = ShapeTransforms.scaledCopyOfLL(ac2,4,4);
		ac2 = ShapeTransforms.translatedCopyOf(ac2,100,0);

		// We'll draw this with a thicker stroke
		Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
		Stroke orig=g2.getStroke();
		g2.setStroke(thick);
		g2.setColor(new Color(0x002FA7)); 
		ac2 = ShapeTransforms.rotatedCopyOf(ac2, Math.PI/2);
		g2.draw(ac2); 
		
		// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
		
		g2.setStroke(orig);
		g2.setColor(Color.BLACK); 
		g2.drawString("A bunch of clocks and alarm clocks by Jeffrey Chen", 20,20);
	    }
	  
	    /** Draw a different picture with a few clocks and alarm clocks
	     */

    public static void drawPicture3(Graphics2D g2) {
		// label the drawing
		g2.drawString("A tasteful assortment of timepieces by Jeffrey Chen", 20,20);
		
		// Draw some clocks
	    Clock c1 = new Clock(20,50,100);

	   	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	   	Stroke orig=g2.getStroke();
	    g2.setStroke(thick);
	    g2.setColor(Color.GREEN);
	    g2.draw(c1);

	    Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
		c2 = ShapeTransforms.translatedCopyOf(c2,50,150);
		c2 = ShapeTransforms.rotatedCopyOf(c2, -Math.PI/2);
		g2.setColor(Color.BLUE);
		g2.setStroke(orig);
		g2.draw(c2);

	    AlarmClock ac1 = new AlarmClock(320, 50, 50);
	    g2.setColor(Color.RED);
	    g2.draw(ac1);

		Shape ac2 = ShapeTransforms.scaledCopyOfLL(ac1,2,2);
		ac2 = ShapeTransforms.translatedCopyOf(ac2,-50,250);
		ac2 = ShapeTransforms.rotatedCopyOf(ac2, Math.PI/2);
	    g2.setStroke(thick);
	    g2.setColor(Color.ORANGE);
	    g2.draw(ac2);
	}
}