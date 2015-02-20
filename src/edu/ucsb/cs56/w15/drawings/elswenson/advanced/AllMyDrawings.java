package edu.ucsb.cs56.w15.drawings.elswenson.advanced;

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
 * @author Eric Swenson
 * @version for CS56 W15 Lab04
 */


public class AllMyDrawings
{
    /** Draws a picture with a few droids
     */

    public static void drawPicture1(Graphics2D g2) {

	Droid h1 = new Droid(200,175,30,50);
	g2.setColor(Color.RED);
	g2.draw(h1);

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.3,0.3);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK);
	g2.draw(h2);
	
	
	h2 = ShapeTransforms.scaledCopyOfLL(h2,6,6);
	h2 = ShapeTransforms.translatedCopyOf(h2,80,0);
	
	Stroke thick = new BasicStroke (3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x848482)); 
	g2.draw(h2); 
	
	R4 d2 = new R4(60,250,50,75);
	R4 d3 = new R4(200,350,200,100);
	
	g2.draw(d2);
	g2.setColor(new Color(0x8FAAFF)); g2.draw(d3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Dazzling Droids by Eric Swenson", 20,20);
    }


    /** Draw a picture with a few rotated droids
     */
    public static void drawPicture2(Graphics2D g2) {
	
	Droid large = new Droid(120,50,225,150);
	Droid smallCC = new Droid(20,50,40,30);
	Droid tallSkinny = new Droid(20,150,20,40);
	Droid shortFat = new Droid(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Droid h1 = new Droid(100,250,50,75);
	g2.setColor(Color.ORANGE); g2.draw(h1);
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.PINK); 
	g2.draw(h2);
	
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
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
	
	R4 hw1 = new R4(50,350,40,75);
	R4 hw2 = new R4(420,25,80,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotated 45 degrees
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);

	g2.draw(hw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Many deneric droids, a few R4 droids by Eric Swenson", 20,20);
    }
  
    /** Draw a different picture with a few generic Droids and a few R4 Droids.
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Ro-re tate-size, the slightly more understandable droid-language by Eric Swenson", 20,20);

	
	// Draw some R4 droids
	
        R4 large = new R4(100,50,225,150);
        R4 small = new R4(20,50,40,30);
	Shape largeRotated = ShapeTransforms.rotatedCopyOf(large, Math.PI/8);
	Shape largeRotatedTranslated = ShapeTransforms.translatedCopyOf(largeRotated, 270, 0);	
	Shape smallTranslated = ShapeTransforms.translatedCopyOf(small,60,300);
        Shape resized = ShapeTransforms.scaledCopyOfLL(smallTranslated,5,5);
	Shape rotatedResized = ShapeTransforms.rotatedCopyOf(resized, 3*Math.PI/4);
        g2.setColor(Color.RED);     g2.draw(large);
        g2.setColor(Color.BLACK);   g2.draw(small);
	g2.setColor(new Color(0x225612));    g2.draw(rotatedResized);
	g2.setColor(Color.BLUE);    g2.draw(largeRotatedTranslated);
       
       
    }
    

}
