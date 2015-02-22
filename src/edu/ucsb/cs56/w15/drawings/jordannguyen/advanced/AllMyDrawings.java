package edu.ucsb.cs56.w15.drawings.jordannguyen.advanced;

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
 * @author Jordan Nguyen
 * @version for CS56, Lab05, W15
 */


public class AllMyDrawings
{
    /** Draw a picture with a few doors 
     */

    public static void drawPicture1(Graphics2D g2) {

	Door d1 = new Door(100,250,50, 100);
	g2.setColor(Color.CYAN); g2.draw(d1);
	
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(d1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a door that's 4x as big (2x the original)
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
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw a set of bathroom doors
		
	BathroomDoors bd1 = new BathroomDoors(50, 30, 70, 140, 10);

	g2.draw(bd1);
	g2.setColor(new Color(0x8F00FF));
	
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few doors by Jordan Nguyen", 20,20);
    }


    /** Draw a picture with a few doors and bathroom doors
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some doors and bathroom doors
	
	Door large = new Door(25,25,150,300);
	Door small = new Door(180,25,20,40);
	BathroomDoors tallSkinny = new BathroomDoors(400,350,40,100,10);

	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	
	Door d1 = new Door(200,150,50,100);
	g2.setColor(Color.CYAN); g2.draw(d1);
	
	// Make a black door that's half the size, 
	// and moved over 150 pixels in x direction
	Shape d2 = ShapeTransforms.scaledCopyOfLL(d1,0.5,0.5);
	d2 = ShapeTransforms.translatedCopyOf(d2,150,0);
	g2.setColor(Color.BLACK); g2.draw(d2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	d2 = ShapeTransforms.scaledCopyOfLL(d2,4,4);
	d2 = ShapeTransforms.translatedCopyOf(d2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(d2); 
	
	// Draw a set of bathroom doors that are rotated 45 degrees about the center
	
	BathroomDoors bd1 = new BathroomDoors(50,350,75,150,20);

	Shape hw3 = ShapeTransforms.rotatedCopyOf(bd1, Math.PI/4.0);
	g2.setColor(new Color(0x8F00FF));
	g2.draw(hw3);
		
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of doors and bathroom doors by Jordan Nguyen", 20,20);
    }
  
    /** Draw a different picture with a doors and bathroom doors
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of doors by Jordan Nguyen", 20,20);

	
	// Draw some doors.
	
       Door large = new Door(20,200,125,225);
       Door smallDoor = new Door(20,50,30,60);
       BathroomDoors bigDoors = new BathroomDoors(150,50,200,400,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallDoor);
       g2.setColor(Color.BLACK);   g2.draw(bigDoors);
       
       
    }
    

}
