package edu.ucsb.cs56.w15.drawings.ryanpeffers.advanced;

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
 * @author Ryan Peffers
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few cars 
     */

    public static void drawPicture1(Graphics2D g2) {

	Car h1 = new Car(100,250,105,30);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x00FFFF)); //Cyan 
	g2.draw(h2); 
	
	// Draw two cars with wheels, windows and door
	
	Wheels hw1 = new Wheels(50,350,140,40);
	Wheels hw2 = new Wheels(300,350,70,20);
	
	g2.draw(hw1);
	g2.setColor(new Color(0xCD5C5C));  //Indian Red
	g2.draw(hw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few cars by Ryan Peffers", 20,20);
    }


    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some coffee cups.
	
	Car c1 = new Car(50,150,35,8);
	Car c2 = new Car(150,350,175,40);
	Wheels c3 = new Wheels(450,250,90,30);
	Wheels c4 = new Wheels(235,200,70,20);
	
	
	g2.setColor(Color.RED);     g2.draw(c1);
	g2.setColor(Color.GREEN);   g2.draw(c2);
	g2.setColor(Color.BLUE);    g2.draw(c3);
	g2.setColor(Color.MAGENTA); g2.draw(c4);
	
	
	// Make a black car that's half the size, 
	// and moved over 250 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(c4,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,250,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a car that's 4x as big (2x the original)
	// and moved over 150 more pixels to the left.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,-150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xDAA520)); //Goldenrod
	g2.draw(h2); 
	

	// Rotate the car 45 degrees around its center.
	Shape cw3 = ShapeTransforms.rotatedCopyOf(c3, Math.PI/4.0);

	g2.draw(cw3);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of cars with wheels and some without by Ryan Peffers.", 20,20);
	
    }

  
    /** Draw a different picture with more cars
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("2 cars by Ryan Peffers", 20,20);

	
	// Draw some cars
	
	Wheels hot = new Wheels(150, 250, 140,60);
	Wheels hotRod = new Wheels(250, 150, 170,60);
       
       g2.setColor(Color.RED);     g2.draw(hot);
       g2.setColor(Color.ORANGE);   g2.draw(hotRod);
       
	
    }
    

}
