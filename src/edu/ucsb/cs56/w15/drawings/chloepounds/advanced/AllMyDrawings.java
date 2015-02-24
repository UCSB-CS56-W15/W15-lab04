package edu.ucsb.cs56.w15.drawings.chloepounds.advanced;

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
 * A class with static methods for drawing kids and kids with balloons
 * 
 * @author Chloe Pounds
 * @version for CS56, lab04, Winter 2015
 */

public class AllMyDrawings
{
    /** Draw a picture of 3 kids and 3 kids with a balloon.  
     */
    public static void drawPicture1(Graphics2D g2) {
	
	//Create and draw a blue kid. 

	Kid k1 = new Kid(100,350,50,-100);
	g2.setColor(Color.BLUE); g2.draw(k1);
	
	// Make a green kid that's half the size, 
	// and moved over 150 pixels in x direction

	Shape k2 = ShapeTransforms.scaledCopyOfLL(k1,0.5,0.5);
	k2 = ShapeTransforms.translatedCopyOf(k2,150,0);
	g2.setColor(Color.GREEN); g2.draw(k2);
	
	// A kid rescaled 3x the size of the original and moved 100 pixels over

	k2 = ShapeTransforms.scaledCopyOfLL(k2,6,6);
	k2 = ShapeTransforms.translatedCopyOf(k2,100,0);
	
	//k2 drawn with a thicker stroke 
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, 
					BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.)
	// http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(Color.PINK); 
	g2.draw(k2); 
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few kids by Chloe Pounds", 20,20);

	//draw a kid with a balloon
    	KidWithBalloon chloe = new KidWithBalloon(100,200,50,-100);
	g2.setColor(Color.MAGENTA);
	g2.draw(chloe);

	//rotate chloe 45 degree around its center and move her 100 pixels 
	//to the left and 50 pixels up
	Shape hanna = ShapeTransforms.rotatedCopyOf(chloe, Math.PI/4.0);
	hanna = ShapeTransforms.translatedCopyOf(hanna, 100, -50);
	g2.setColor(Color.orange);
	g2.draw(hanna);
	
	//move hanna 300 pixels to the right and 50 pixels down
	Shape kelsey = ShapeTransforms.translatedCopyOf(hanna, 300, 50);
	g2.setColor(Color.yellow);
	g2.draw(kelsey);

    }

    public static void drawPicture2(Graphics2D g2) {
	KidWithBalloon k1 = new KidWithBalloon(100,450,100,-200);
        g2.setColor(Color.BLUE); g2.draw(k1);

	Shape k2 = ShapeTransforms.scaledCopyOfLL(k1,0.5,0.5);
	k2 = ShapeTransforms.translatedCopyOf(k2,150,0);
	g2.setColor(Color.BLACK); g2.draw(k2);


    }

    public static void drawPicture3(Graphics2D g3) {
	Kid k1 = new Kid(0,350,75,-100);
        g3.setColor(Color.pink); g3.draw(k1);
    
	KidWithBalloon k2 = new KidWithBalloon(100,350,75,-100);
	g3.draw(k2);


	Shape k3 = ShapeTransforms.scaledCopyOfLL(k2,0.5,0.5);
	k3 = ShapeTransforms.translatedCopyOf(k3,150,0);
	g3.setColor(Color.orange); g3.draw(k3);
    }
    
}
