package edu.ucsb.cs56.w15.drawings.omeedrabani.advanced;

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
 * @author Phill Conrad 
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    /** Draw a picture with a few clocks 
     */

    public static void drawPicture1(Graphics2D g2) {

	Clock c1 = new Clock (100, 100, 50);
	g2.setColor(Color.RED);
	g2.draw(c1);
	
	// Make a blue clock that's 1/2 the size, 
	// and moved over 200 pixels in x direction

	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,200,0);
	g2.setColor(Color.BLUE);
	g2.draw(c2);
	
	// Here's a clock that's 2x as big (2x the original)
	// and moved over 200 more pixels to down.
	c2 = ShapeTransforms.scaledCopyOfLL(c1,2,2);
	c2 = ShapeTransforms.translatedCopyOf(c2,0,200);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2); 
	

	g2.setStroke(orig);
	// Draw two GrandfatherClocks
	GrandfatherClock gc1 = new GrandfatherClock(300, 200, 200);
	GrandfatherClock gc2 = new GrandfatherClock(400, 100, 250);

	g2.draw(gc1);
	g2.setColor(new Color(0x8F00FF));
	g2.draw(gc2);
	
	/*
	// Draw two houses with Windows
	
	HouseWithWindows hw1 = new HouseWithWindows(50,350,40,75);
	HouseWithWindows hw2 = new HouseWithWindows(200,350,200,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(hw2);
	*/
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few clocks and grandfather clocks by Omeed Rabani", 20,20);
    }


    /** Draw a picture with a few clocks and grandfather clocks
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some clocks and grandfather clocks.
	Clock c1 = new Clock (50, 100, 25);
	Clock c2 = new Clock (200, 300, 50);
	Clock c3 = new Clock (100, 200, 100);
	Clock c4 = new Clock (400, 100, 35);
	GrandfatherClock gc1 = new GrandfatherClock(100, 100, 75);
	GrandfatherClock gc3 = new GrandfatherClock(300, 200, 200);

	g2.setColor(Color.RED);     g2.draw(c1);
	g2.setColor(Color.GREEN);   g2.draw(c2);
	g2.setColor(Color.BLUE);    g2.draw(c3);
	g2.setColor(Color.MAGENTA); g2.draw(c4);

	// Draw GrandfatherClock gc1
	g2.setColor(Color.CYAN); g2.draw(gc1);

	// Make a GrandfatherClock h2 that is 1.5 times as big and shifted 50 pixels to the right
	Shape h2 = ShapeTransforms.scaledCopyOfLL(gc1,1.5,1.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,50,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Make h2 a 2.5 times sized copy of gc1, and shift it to the right 200 pixels, and down 100 pixels.
	h2 = ShapeTransforms.scaledCopyOfLL(gc1,2.5,2.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,200,100);

	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);  

	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #FFBF00 is "Amber" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xFFBF00)); 
	g2.draw(h2);

	g2.setStroke(orig);
	
	// Rotate gc3 90 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(gc3, Math.PI/2.0);

	g2.draw(hw3);

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of clocks and grandfather clocks by Omeed Rabani", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Some clocks and grandfather clocks by Omeed Rabani", 20,20);

	
	// Draw some clocks and grandfather clocks.
	
	Clock c1 = new Clock (400, 200, 80);
	GrandfatherClock gc1 = new GrandfatherClock(100, 25, 350);
	
	Shape h1 = ShapeTransforms.rotatedCopyOf(gc1, (11.0/6.0)*Math.PI);
	Shape h2 = ShapeTransforms.scaledCopyOfLL(c1,1.5,1.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,0,50);
	h2 = ShapeTransforms.rotatedCopyOf(h2, (6.0/7.0)*Math.PI);
	g2.setColor(Color.DARK_GRAY); g2.draw(h2);


       g2.setColor(Color.MAGENTA);     g2.draw(c1);
       g2.setColor(Color.ORANGE);   g2.draw(gc1);
       g2.setColor(Color.BLACK); g2.draw(h1);
       
    }
    

}
