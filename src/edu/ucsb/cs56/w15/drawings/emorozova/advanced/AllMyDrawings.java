package edu.ucsb.cs56.w15.drawings.emorozova.advanced;

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
    /** Draw a picture with a few basic lighthouses     */

    public static void drawPicture1(Graphics2D g2) {

	Lighthouse h1 = new Lighthouse(100,400,80,210);
	g2.setColor(Color.BLACK); 
	g2.draw(h1);
	
	// Make a red lighthouse that's half the size, 
	// and moved over 150 pixels in x direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1, 0.5, 0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2, 150, 0);
	g2.setColor(Color.RED);
	g2.draw(h2);
	
	// Here's a house that's 3x as big (1.5x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,3,3);
	h2  = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few basic lighthouses by Elena Morozova", 20,20);
    }


    /** Draw a picture with a few different lighthouses
     */
    public static void drawPicture2(Graphics2D g2) {

	Lighthouse h1 = new Lighthouse(100,400,50,190);
	g2.setColor(Color.BLACK); g2.draw(h1);

	StripedLighthouse s1 = new StripedLighthouse(200,400,80,190);
	g2.setColor(Color.PINK); g2.draw(s1);
	
	// Make a black house that's half the size, 
	// and moved over 180 pixels in x direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,190,0);
	g2.setColor(Color.RED); g2.draw(h2);
	
	// Here's a striped house that's 2x the height of the original
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(s1,1,2);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few different lighthouses by Elena Morozova", 20,20);
    }
  
    /** Draw a different picture with a rotated lighthouse
     */

    public static void drawPicture3(Graphics2D g2) {
	
	StripedLighthouse h1 = new StripedLighthouse(100,250,50,160);
	g2.setColor(Color.BLACK); g2.draw(h1);

	Shape h2 = ShapeTransforms.rotatedCopyOf(h1, Math.PI/2.0);
	h2 = ShapeTransforms.translatedCopyOf(h2, 150, 90);
	g2.draw(h2);

	g2.drawString("Poorly built lighthouse after a storm by Elena Morozova", 20,20);
        
       
       
    }
    

}
