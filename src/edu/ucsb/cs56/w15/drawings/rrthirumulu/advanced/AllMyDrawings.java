package edu.ucsb.cs56.w15.drawings.rrthirumulu.advanced;

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
 * @author Raghav Raju
 * @version for CS56, lab04, W15
 */


public class AllMyDrawings
{
    /** Draw a picture with a few bottles
     */

    public static void drawPicture1(Graphics2D g2) {

	Bottle b1 = new Bottle(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(b1);
	
	// Make a black bottle that's half the size, 
	// and moved over 150 pixels in x direction

	Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	g2.setColor(Color.BLACK); g2.draw(b2);
	
	// Here's a bottle that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	b2 = ShapeTransforms.scaledCopyOfLL(b2,4,4);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(b2); 
	
	// Draw two bottles with corks
	
	BottleWithCork bot1 = new BottleWithCork(50,350,40,75);
	BottleWithCork bot2 = new BottleWithCork(200,350,200,100);
	
	g2.draw(bot1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(bot2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few bottles by Raghav Raju", 20,20);
    }


    /** Draw a picture with a few bottles, scaled and transformed
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some bottles.
	
	Bottle large = new Bottle(100,50,225,150);
	Bottle smallCC = new Bottle(20,50,40,30);
	Bottle tallSkinny = new Bottle(20,150,20,40);
	Bottle shortFat = new Bottle(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Bottle b1 = new Bottle(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(b1);
	
	// Make a black bottle that's half the size, 
	// and moved over 150 pixels in x direction
	Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	g2.setColor(Color.BLACK); g2.draw(b2);
	
	// Here's a bottle that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	b2 = ShapeTransforms.scaledCopyOfLL(b2,4,4);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(b2); 
	
	// Draw two bottles with corks
	
	BottleWithCork bot1 = new BottleWithCork(50,350,40,75);
	BottleWithCork bot2 = new BottleWithCork(200,350,200,100);
	
	g2.draw(bot1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second bottle 45 degrees around its center.
	Shape bot3 = ShapeTransforms.rotatedCopyOf(bot2, Math.PI/4.0);

	g2.draw(bot3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of bottles and a few bottles with corks by Raghav Raju", 20,20);
    }
  
    /** Draw a different picture with a few bottles
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of bottles by Raghav Raju", 20,20);

	
	// Draw some coffee cups.
	
       Bottle large = new Bottle(100,50,225,150);
       BottleWithCork smallCC = new BottleWithCork(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);
       
       
    }
    

}
