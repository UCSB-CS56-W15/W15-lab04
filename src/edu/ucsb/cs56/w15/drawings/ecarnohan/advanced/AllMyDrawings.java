package edu.ucsb.cs56.w15.drawings.ecarnohan.advanced;

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
 * @author Erica Carnohan 
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few turtles and turtles with details 
     */

    public static void drawPicture1(Graphics2D g2) {

	Turtle t1 = new Turtle(100,250,75,50);
	g2.setColor(new Color(0x33AA44)); g2.draw(t1);
	
	// Make a black turtle that's half the size, 
	// and moved over 250 pixels in x direction and 100 pixels down

	Shape t2 = ShapeTransforms.scaledCopyOfLL(t1,0.5,0.5);
	t2 = ShapeTransforms.translatedCopyOf(t2,250,100);
	g2.setColor(Color.BLACK); g2.draw(t2);
	
	// Here's a turtle that's 4x as big (2x the original)
	// and moved over 100 more pixels to right and 50 pixels up
	t2 = ShapeTransforms.scaledCopyOfLL(t2,4,4);
	t2 = ShapeTransforms.translatedCopyOf(t2,100,-50);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x66AA77)); 
	g2.draw(t2); 
	
	// Draw 2 TurtleWithDetails
	
	TurtleWithDetails td1 = new TurtleWithDetails(150,500,75,75);
        TurtleWithDetails td2 = new TurtleWithDetails(200,100,200,100);
	
	g2.draw(td1);
	g2.setColor(new Color(0x33CC66)); g2.draw(td2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few turtles, some with details by Erica Carnohan", 20,20);
    }


    /** Draw a picture with a few turtles and turtles with details
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some turtles.
	
	Turtle large = new Turtle(100,50,225,150);
	Turtle smallT = new Turtle(20,50,40,30);
	Turtle tallSkinny = new Turtle(20,150,20,40);
	Turtle shortFat = new Turtle(20,250,40,20);
	
	g2.setColor(new Color(0x3366BB));     g2.draw(large);
	g2.setColor(new Color(0x009955));   g2.draw(smallT);
	g2.setColor(new Color(0xCC7700));    g2.draw(tallSkinny);
	g2.setColor(new Color(0x665588)); g2.draw(shortFat);
	
	// This one's huge
	Turtle t1 = new Turtle(100,250,75,50);
	g2.setColor(new Color(0xFF4477)); g2.draw(t1);
	
	// Make a black turtle that's half the size, 
	// and moved over 150 pixels in x direction
	Shape t2 = ShapeTransforms.scaledCopyOfLL(t1,0.5,0.5);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	g2.setColor(Color.BLACK); g2.draw(t2);
	
	// Here's a turtle that's 4x as big (2x the original)
	// and moved over 200 more pixels to right and 100 pixels up, rotated
	t2 = ShapeTransforms.scaledCopyOfLL(t2,4,4);
	t2 = ShapeTransforms.rotatedCopyOf(t2, Math.PI*1.75);
	t2 = ShapeTransforms.translatedCopyOf(t2,200,-100);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(t2); 
	
	// Draw two turtles with Details
	
	TurtleWithDetails td1 = new TurtleWithDetails(75,450,75,50);
	TurtleWithDetails td2 = new TurtleWithDetails(350,350,200,200);
	
	g2.setColor(new Color(0x991155));
	g2.draw(td1);
	g2.setColor(new Color(0x00CC88)); 

	// Rotate the second turtle 45 degrees around its center.
	Shape td3 = ShapeTransforms.rotatedCopyOf(td2, Math.PI/4.0);

	g2.draw(td3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Turtles by Erica Carnohan", 20,20);
    }
  
    /** Draw a different picture with a few turtles
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A Turtle couple by Erica Carnohan", 20,20);

	// girl turtle has details (because girls are more complex)
	
       Turtle boy = new Turtle(350,250,200,150);
       Shape rotatedBoy = ShapeTransforms.rotatedCopyOf(boy, Math.PI);
       TurtleWithDetails girl = new TurtleWithDetails(50,250,200,150);
       
       Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

       g2.setStroke(thick);
       g2.setColor(new Color(0xFF6688));     g2.draw(girl);
       g2.setColor(new Color(0x66AADD));   g2.draw(rotatedBoy);
       
       
    }
    

}
