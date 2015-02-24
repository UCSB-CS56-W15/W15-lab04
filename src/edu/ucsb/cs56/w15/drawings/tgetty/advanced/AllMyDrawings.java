package edu.ucsb.cs56.w15.drawings.tgetty.advanced;

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
 * @author Taylor Getty
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few doors 
     */

    public static void drawPicture1(Graphics2D g2) {

	Door d1 = new Door(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(d1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction

	Shape d2 = ShapeTransforms.scaledCopyOfLL(d1,0.5,0.5);
	d2 = ShapeTransforms.translatedCopyOf(d2,150,0);
	g2.setColor(Color.BLACK); g2.draw(d2);
	
	// Here's a door that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	d2 = ShapeTransforms.scaledCopyOfLL(d2,4,4);
	d2 = ShapeTransforms.translatedCopyOf(d2,100,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(d2); 
	
	// Draw two doors with Windows
	
	DoorWithWindow dw1 = new DoorWithWindow(50,350,40,75);
	DoorWithWindow dw2 = new DoorWithWindow(175,50,200,100);
	
	g2.setColor(Color.PINK);   g2.draw(dw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(dw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few doors by Taylor Getty", 20,20);
    }


    /** Draw a picture with a few doors
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some doors
	
	Door large = new Door(100,50,225,150);
	Door smallD = new Door(20,50,40,30);
	Door tallSkinny = new Door(20,150,20,40);
	Door shortFat = new Door(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallD);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Door d1 = new Door(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(d1);
	
	Door d2 = new Door(200,50,20,30);
	g2.setColor(Color.GRAY); g2.draw(d2);
	
	
	// Draw two doors with Windows
	
	DoorWithWindow dw1 = new DoorWithWindow(50,350,40,75);
	DoorWithWindow dw2 = new DoorWithWindow(200,350,200,100);
	
	g2.draw(dw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape dw3 = ShapeTransforms.rotatedCopyOf(dw2, Math.PI/4.0);
	dw3 = ShapeTransforms.translatedCopyOf(dw3,0,-90);
	// Rotate the first house 90 degrees around its center
	Shape dw4 = ShapeTransforms.rotatedCopyOf(dw1, Math.PI/2.0);
	dw4 =  ShapeTransforms.translatedCopyOf(dw4,290,-150);

	g2.draw(dw3);
	g2.setColor(Color.ORANGE);  g2.draw(dw4);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of doors by Taylor Getty", 20,20);
    }
  
    /** Draw a different picture with a few doors
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Doors by Taylor Getty", 20,20);

	
	// Draw some doors
	
       Door large = new Door(20,200,225,150);
       Door smallD = new Door(20,100,40,30);
       
       g2.setColor(Color.PINK);     g2.draw(large);
       g2.setColor(Color.RED);   g2.draw(smallD);

       DoorWithWindow big = new DoorWithWindow(250,200,225,150);
       DoorWithWindow small = new DoorWithWindow(80,100,40,30);

       g2.setColor(Color.BLUE);   g2.draw(big);
       g2.setColor(Color.GREEN);    g2.draw(small);

       Shape rotateSmall = ShapeTransforms.rotatedCopyOf(small, Math.PI/4.0);
       rotateSmall = ShapeTransforms.translatedCopyOf(rotateSmall,150,0);
       g2.setColor(Color.CYAN);
       g2.draw(rotateSmall);
       
       
    }
    

}
