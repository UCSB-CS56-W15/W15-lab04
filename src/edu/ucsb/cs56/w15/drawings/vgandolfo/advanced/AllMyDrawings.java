package edu.ucsb.cs56.w15.drawings.vgandolfo.advanced;

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
 * @author Vincent Gandolfo
 * @version for CS56, lab04, Winter 15
 */


public class AllMyDrawings
{
    /** Draw a picture with a few Iphones
     */

    public static void drawPicture1(Graphics2D g2) {

	Iphone i1 = new Iphone(100,300,50,100);
	g2.setColor(Color.CYAN); g2.draw(i1);
	
	// Make a black iphone that's half the size, 
	// and moved over 150 pixels in x direction

	Shape i2 = ShapeTransforms.scaledCopyOfLL(i1,0.5,0.5);
	i2 = ShapeTransforms.translatedCopyOf(i2,150,0);
	g2.setColor(Color.BLACK); g2.draw(i2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	i2 = ShapeTransforms.scaledCopyOfLL(i2,4,4);
	i2 = ShapeTransforms.translatedCopyOf(i2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(i2); 
	
	// Draw two Iphones with Apps
	
	IphoneWithApps iwa1 = new IphoneWithApps(50,50,150,225);
	IphoneWithApps iwa2 = new IphoneWithApps(350,35,75,150);
	
	g2.draw(iwa1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(iwa2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few Iphones by Vincent Gandolfo", 20,20); 
    }


    /** Draw a picture with a few Iphones and Iphones with Apps
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some Iphones.
	
	Iphone large = new Iphone(100,50,150,225);
	Iphone small = new Iphone(20,50,30,50);
	IphoneWithApps tallSkinny = new IphoneWithApps(20,150,20,50);
	IphoneWithApps shortFat = new IphoneWithApps(20,250,40,60);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Iphone i1 = new Iphone(100,250,50,90);
	g2.setColor(Color.CYAN); g2.draw(i1);
	
	// Make a black Iphone that's half the size, 
	// and moved over 150 pixels in x direction
	Shape i2 = ShapeTransforms.scaledCopyOfLL(i1,0.5,0.5);
	i2 = ShapeTransforms.translatedCopyOf(i2,150,0);
	g2.setColor(Color.BLACK); g2.draw(i2);
	
	// Here's an Iphone that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	i2 = ShapeTransforms.scaledCopyOfLL(i2,4,4);
	i2 = ShapeTransforms.translatedCopyOf(i2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(i2); 
	
	// Draw two Iphones with Apps
	
	IphoneWithApps iw1 = new IphoneWithApps(50,350,40,75);
	IphoneWithApps iw2 = new IphoneWithApps(200,350,100,200);
	
	g2.draw(iw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second Iphone 45 degrees around its center.
	Shape iw3 = ShapeTransforms.rotatedCopyOf(iw2, Math.PI/4.0);

	g2.draw(iw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Iphones and Iphones with Apps by Vincent Gandolfo", 20,20); 
    }
  
    /** Draw a different picture with a few Iphones and Iphones with Apps
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Iphones with Apps by Vincent Gandolfo", 20,20);

	
	// Draw some coffee cups.
	
       IphoneWithApps large = new IphoneWithApps(100,50,150,225);
       Iphone small = new Iphone(20,50,30,50);
       IphoneWithApps third = new IphoneWithApps(40, 350, 90, 130);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(small);
       g2.setColor(Color.BLUE);   g2.draw(third);
	
       
    }
    

}
