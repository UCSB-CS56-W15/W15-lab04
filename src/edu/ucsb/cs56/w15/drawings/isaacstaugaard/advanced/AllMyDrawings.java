package edu.ucsb.cs56.w15.drawings.isaacstaugaard.advanced;

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
    /** Draw a picture with backboard 
     */

    public static void drawPicture1(Graphics2D g2) {

	BasketballHoop h1 = new BasketballHoop(130,100,400,250);
	//	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	//Stroke orig = g2.getStroke();
	//g2.setStroke(thick);
	g2.setColor(Color.RED);
	g2.draw(h1);
	
	//Make a black backboard that's half the size, 
	// and moved over 50 pixels in -x direction and 40 pixels in y direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,-50,40);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a backboard that's 1.5x as big 
	// and moved over 30 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,1.5,1.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,30,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw backboard with basketball and man dunking!
	
	BasketballHoopWithBall b1 = new BasketballHoopWithBall(50,50,100,100);
		 
	g2.draw(b1);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A backboard by Isaac Staugaard", 20,20);
    }


    /** Draw a picture with basketball hoops!
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some basketball hoops.
	
	BasketballHoop nbaSize = new BasketballHoop(100,50,225,150);
	BasketballHoop kidSize = new BasketballHoop(20,50,40,30);
	BasketballHoop tallHoop = new BasketballHoop(20,150,20,40);
	BasketballHoop shortHoop = new BasketballHoop(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(nbaSize);
	g2.setColor(Color.GREEN);   g2.draw(kidSize);
	g2.setColor(Color.BLUE);    g2.draw(tallHoop);
	g2.setColor(Color.MAGENTA); g2.draw(shortHoop);
	

	/*	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);                            */
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	//g2.draw(h2); 
	
	// Draw two houses with Windows
	
	/*	HouseWithWindows hw1 = new HouseWithWindows(50,350,40,75);
	HouseWithWindows hw2 = new HouseWithWindows(200,350,200,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);

	g2.draw(hw3);                      */
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("The basketball courts by Isaac Staugaard", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Coffee Cups by Phill Conrad", 20,20);

	
	// Draw some coffee cups.
	
       CoffeeCup large = new CoffeeCup(100,50,225,150);
       CoffeeCup smallCC = new CoffeeCup(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);
       
       
    }
    

}
