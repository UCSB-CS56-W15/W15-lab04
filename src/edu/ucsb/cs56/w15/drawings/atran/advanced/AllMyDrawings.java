package edu.ucsb.cs56.w15.drawings.atran.advanced;

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
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {

	LightBulb LB1 = new LightBulb(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(LB1);
	
	// Make a black lightbulb that's half the size, 
	// and moved over 150 pixels in x direction

	Shape LB2 = ShapeTransforms.scaledCopyOfLL(LB1,0.5,0.5);
	LB2 = ShapeTransforms.translatedCopyOf(LB2,150,0);
	g2.setColor(Color.BLACK); g2.draw(LB2);
	
	// Here's a lightbulb that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	LB2 = ShapeTransforms.scaledCopyOfLL(LB2,4,4);
	LB2 = ShapeTransforms.translatedCopyOf(LB2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(LB2); 
	
	// Draw two lightbulbs with switches
	
	LightBulbWithSwitch LBS1 = new LightBulbWithSwitch(50,350,40,75);
	LightBulbWithSwitch LBS2 = new LightBulbWithSwitch(200,350,200,100);
	
	g2.draw(LBS1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(LBS2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few lightbulbs by Andrew Tran", 20,20);
    }


    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some lightbulbs.
	
	LightBulb large = new LightBulb(100,50,225,150);
	LightBulb smallLB = new LightBulb(20,50,40,30);
	LightBulb tallSkinny = new LightBulb(20,150,20,40);
	LightBulb shortFat = new LightBulb(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallLB);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	LightBulb lb1 = new LightBulb(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(lb1);
	
	// Make a black lightbulb that's half the size, 
	// and moved over 150 pixels in x direction
	Shape lb2 = ShapeTransforms.scaledCopyOfLL(lb1,0.5,0.5);
	lb2 = ShapeTransforms.translatedCopyOf(lb2,150,0);
	g2.setColor(Color.BLACK); g2.draw(lb2);
	
	// Here's a lightbulb that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	lb2 = ShapeTransforms.scaledCopyOfLL(lb2,4,4);
	lb2 = ShapeTransforms.translatedCopyOf(lb2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(lb2); 
	
	// Draw two lightbulbs with switches
	
	LightBulbWithSwitch lbs1 = new LightBulbWithSwitch(50,350,40,75);
	LightBulbWithSwitch lbs2 = new LightBulbWithSwitch(200,350,200,100);
	
	g2.draw(lbs1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second lightbulb 45 degrees around its center.
	Shape lbs3 = ShapeTransforms.rotatedCopyOf(lbs2, Math.PI/4.0);

	g2.draw(lbs3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of LightBulbs and a few with swithces by Andrew Tran", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
	Modified to also draw some LightBulbs
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Coffee Cups by Phill Conrad and LightBulbs by Andrew Tran", 20,20);

	
	// Draw some coffee cups.
	
       LightBulbWithSwitch large = new LightBulbWithSwitch(100,50,225,150);
       LightBulbWithSwitch smallLB = new LightBulbWithSwitch(20,50,40,30);
       LightBulb gapTest = new LightBulb(150,200,75,400);
       LightBulb widthTest = new LightBulb(50,50,50,50);
       LightBulbWithSwitch testSwitch = new LightBulbWithSwitch(50,150,100,200);


       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallLB);
       g2.setColor(Color.BLUE);    g2.draw(gapTest);
       g2.draw(widthTest);
       g2.setColor(Color.RED);     g2.draw(testSwitch);
       
    }
    

}
