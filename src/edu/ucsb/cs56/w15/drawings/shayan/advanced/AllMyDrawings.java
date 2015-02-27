package edu.ucsb.cs56.w15.drawings.shayan.advanced;

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
 * @author Shayan Sadigh
 * @version for CS56, lab04, W14
 */


public class AllMyDrawings
{
    /** Draw a picture with a blank DDR Pads
     */

    public static void drawPicture1(Graphics2D g2) {

	DDRPadBlank h1 = new DDRPadBlank(200);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a blank DDR Pad that's half the size, 
	// and moved over 250 pixels in x direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,250,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a blank DDR Pad that's 2x as big
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,2,2);
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
	
	// Draw two DDR Pads with arrows
	
	DDRPad hw1 = new DDRPad(50);
	DDRPad hw2 = new DDRPad(200);
	h2 = ShapeTransforms.translatedCopyOf(hw1,210,50);
	g2.draw(h2);
	h2 = ShapeTransforms.translatedCopyOf(hw2,0,230);
	g2.setColor(new Color(0x8F00FF)); g2.draw(h2);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few DDRPads by Shayan Sadigh", 20,20);
    }


    /** Draw a picture with a few blank DDR Pads and DDR Arrows
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some DDR Arrows.

	
	DDRArrow large = new DDRArrow(100);
	DDRArrow small = new DDRArrow(20);
	DDRArrow medium = new DDRArrow(50);
	
	Shape copy = ShapeTransforms.translatedCopyOf(large,0,150);
	g2.setColor(Color.RED);     g2.draw(copy);
	copy = ShapeTransforms.translatedCopyOf(small,100,150);
	g2.setColor(Color.GREEN);   g2.draw(copy);
	copy = ShapeTransforms.translatedCopyOf(medium,100,200);
	copy = ShapeTransforms.rotatedCopyOf(copy,Math.PI/4);
	g2.setColor(Color.BLUE);    g2.draw(copy);
	
	DDRPadBlank h1 = new DDRPadBlank(100);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a blank DDR Pad that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a house that's 2x as big
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,2,2);
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
	
	// Draw two DDR Pads with arrows
	
	DDRPad hw1 = new DDRPad(50);
	DDRPad hw2 = new DDRPad(200);
	Shape hw3 = ShapeTransforms.translatedCopyOf(hw1, 200, 200);
	g2.draw(hw3);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second DDR Pad 45 degrees around its center.
	hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);
    hw3 = ShapeTransforms.translatedCopyOf(hw3, 300, 120);

	g2.draw(hw3);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("DDRArrows and DDRPads by Shayan Sadigh", 20,20);
    }
  
    /** Draw a different picture with a DDR Arrows
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("DDR Arrows by Shayan Sadigh", 20,20);

	
	// Draw some DDR Arrows
	
       DDRArrow large = new DDRArrow(200);
       DDRArrow medium = new DDRArrow(100);
       DDRArrow small = new DDRArrow(50);
       Shape smallMoved = ShapeTransforms.translatedCopyOf(small, 100, 100);
       g2.setColor(Color.RED);     g2.draw(smallMoved);
	   Shape mediumMoved = ShapeTransforms.translatedCopyOf(medium, 300, 0);
       g2.setColor(Color.GREEN);   g2.draw(mediumMoved);
	   Shape largeFlipped = ShapeTransforms.rotatedCopyOf(large, Math.PI/2);
	   largeFlipped = ShapeTransforms.translatedCopyOf(largeFlipped, 200, 150);
	   g2.setColor(Color.BLUE);   g2.draw(largeFlipped);
       
       
    }
    

}
