package edu.ucsb.cs56.w15.drawings.michelehaque.advanced;

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
 * @author Michele Haque
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few GameBoys 
     */

    public static void drawPicture1(Graphics2D g2) {

	GameBoy gb1 = new GameBoy(10,200,100,200);
	g2.setColor(Color.CYAN); g2.draw(gb1);
	
	// Make a black GameBoy that's half the size, 
	// and moved over 150 pixels in x direction

	Shape gb2 = ShapeTransforms.scaledCopyOfLL(gb1,0.5,0.5);
	gb2 = ShapeTransforms.translatedCopyOf(gb2,150,0);
	g2.setColor(Color.BLACK); g2.draw(gb2);
	
	// Here's a GameBoy that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	gb2 = ShapeTransforms.scaledCopyOfLL(gb2,4,4);
	gb2 = ShapeTransforms.translatedCopyOf(gb2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(gb2); 
	
	
	// Draw two GameBoys with Buttons
	
	GameBoyWithButtons gbb1 = new GameBoyWithButtons(50,50,40,65);
	GameBoyWithButtons gbb2 = new GameBoyWithButtons(200,50,100,200);
	g2.setStroke(orig);
	g2.draw(gbb1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(gbb2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	//g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few GameBoys by Michele Haque", 20,20);
    }


    /** Draw a different picture with GameBoys
     */
    public static void drawPicture2(Graphics2D g2) {

	GameBoy gb1 = new GameBoy(100,50,50,75);
	g2.setColor(Color.RED); g2.draw(gb1);
	
	// Make a green GameBoy that's half the size, 
	// and moved down 50 pixels in y direction
	Shape gb2 = ShapeTransforms.scaledCopyOfLL(gb1,0.5,0.5);
	gb2 = ShapeTransforms.translatedCopyOf(gb2,0,50);
	g2.setColor(Color.GREEN); g2.draw(gb2);
	
	// Here's a GameBoy that's 2x as small (4x smaller than the original)
	// and moved over 50 more pixels down.
	gb2 = ShapeTransforms.scaledCopyOfLL(gb2,0.5,0.5);
	gb2 = ShapeTransforms.translatedCopyOf(gb2,0,50);    
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(gb2); 
	
	// Draw two GameBoys with Buttons but rotated 90 degrees
	
	g2.setColor(Color.GRAY);

	GameBoyWithButtons gb3  = new GameBoyWithButtons(50,350,40,75);
	GameBoyWithButtons gb4 = new GameBoyWithButtons(200,350,20,50);
	
	Shape gb5 = ShapeTransforms.rotatedCopyOf(gb3, Math.PI/2);
	Shape gb6 = ShapeTransforms.rotatedCopyOf(gb4, Math.PI/2);

	g2.draw(gb5);
	g2.setColor(Color.BLACK);
	g2.draw(gb6);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.drawString("More GameBoys by Michele Haque", 20,20);
    }
  
    /** Draw a different picture with GameBoys
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("GameBoys in many directions by Michele Haque", 20,20);

	
	// Draw 2 GameBoys and 2 GameBoysWithButtons
	
	GameBoy gb1 = new GameBoy(50,200,75,125);
	GameBoyWithButtons gb2 = new GameBoyWithButtons(200,50,75,125);
	Shape gb3 = ShapeTransforms.rotatedCopyOf(gb1, Math.PI/2);
	
	Shape gb4 = ShapeTransforms.rotatedCopyOf(gb3, Math.PI);
	Shape gb5 = ShapeTransforms.translatedCopyOf(gb4, 4*75, 0);
	Shape gb6 = ShapeTransforms.translatedCopyOf(gb2, 0, 2*125);
	Shape gb7 = ShapeTransforms.rotatedCopyOf(gb6, Math.PI);

       
	g2.setColor(Color.RED);     g2.draw(gb2);          g2.draw(gb7);
	g2.setColor(Color.GREEN);   g2.draw(gb3);          g2.draw(gb5);
       
       
    }
    

}
