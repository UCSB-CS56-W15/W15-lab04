package edu.ucsb.cs56.w15.drawings.weiers.advanced;

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
/*
	House h1 = new House(100,250,50,75);
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
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two houses with Windows
	
	HouseWithWindows hw1 = new HouseWithWindows(50,350,40,75);
	HouseWithWindows hw2 = new HouseWithWindows(200,350,200,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(hw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few houses by Phill Conrad", 20,20);
*/  
        // simple power outlet in cyan
        PowerOutlet o1 = new PowerOutlet(50,50,100,150);
        g2.setColor(Color.CYAN);
        g2.draw(o1);
    
        // power outler similar to above but scaled and moved right
        Shape o2 = ShapeTransforms.scaledCopyOfLL(o1,.5,.5);
        o2 = ShapeTransforms.translatedCopyOf(o2,150,0);
        
        g2.setColor(Color.BLACK);
        g2.draw(o2);
 
        // power outlet with ground to the right of the others
        PowerOutletWithGround p = new PowerOutletWithGround(300,50,100,150);
        g2.draw(p);

        g2.setStroke(g2.getStroke());
        g2.setColor(Color.BLACK);
        g2.drawString("A few outlets by William Eiers", 20, 20);
    }


    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {

/*
	// Draw some coffee cups.

	CoffeeCup large = new CoffeeCup(100,50,225,150);
	CoffeeCup smallCC = new CoffeeCup(20,50,40,30);
	CoffeeCup tallSkinny = new CoffeeCup(20,150,20,40);
	CoffeeCup shortFat = new CoffeeCup(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	House h1 = new House(100,250,50,75);
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
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two houses with Windows
	
	HouseWithWindows hw1 = new HouseWithWindows(50,350,40,75);
	HouseWithWindows hw2 = new HouseWithWindows(200,350,200,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);

	g2.draw(hw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Coffee Cups and a few houses by Phill Conrad", 20,20);
  */
        // power outlet rotated 45 degrees
        PowerOutlet p1 = new PowerOutlet(100,100,100,150);
        Shape p2 = ShapeTransforms.rotatedCopyOf(p1, Math.PI/4.0);
        g2.draw(p2);

        // power outlet with ground rotated 180
        PowerOutletWithGround pp = new PowerOutletWithGround(200,100,60,90);
        Shape p3 = ShapeTransforms.rotatedCopyOf(pp, Math.PI);
        g2.draw(p3);

        // scaled copy of power outlet with ground rotated 180
        p3 = ShapeTransforms.scaledCopyOf(p3,2,2);
        p3 = ShapeTransforms.translatedCopyOf(p3,100,0);
        g2.draw(p3);

        Stroke orig = g2.getStroke();
        g2.setStroke(orig);
        g2.setColor(Color.BLACK);
        g2.drawString("A rotated power outlet, cause why not, by William Eiers", 20, 20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	/*
	// label the drawing
	
	g2.drawString("A bunch of Coffee Cups by Phill Conrad", 20,20);

	
	// Draw some coffee cups.
	
       CoffeeCup large = new CoffeeCup(100,50,225,150);
       CoffeeCup smallCC = new CoffeeCup(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);
      */
    
    // my drawings
    // normal red power outlet with ground
    g2.drawString("Just an oversized outlet and his little brother, by William Eiers", 20,20);
    PowerOutletWithGround normal = new PowerOutletWithGround(50,50, 100, 150);
    g2.setColor(Color.RED);
    g2.draw(normal);

    // bigger version of the above poweroutlet, blue and moved right/up
    Shape p = ShapeTransforms.scaledCopyOf(normal,3,3);
    p = ShapeTransforms.translatedCopyOf(p,150,-180);
    g2.setColor(Color.BLUE);
    g2.draw(p);
    
    // scaled, translated, and rotated copy of above
    Shape p2 = ShapeTransforms.scaledCopyOf(normal, 0.25, .25);
    p2 = ShapeTransforms.translatedCopyOf(p2,50,-150);
    p2 = ShapeTransforms.rotatedCopyOf(p2,Math.PI/3);
    g2.setColor(Color.GREEN);
    g2.draw(p2);
    }
    

}
