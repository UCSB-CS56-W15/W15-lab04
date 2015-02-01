package edu.ucsb.cs56.w15.drawings.tngo.advanced;

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
 * @author Phill Conrad, Tamky Ngo 
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few fish 
     */

    public static void drawPicture1(Graphics2D g2) {

	Fish f1 = new Fish(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(f1);
	
	// Make a black fish that's half the size, 
	// and moved over 150 pixels in x direction

	Shape f2 = ShapeTransforms.scaledCopyOfLL(f1,0.5,0.5);
	f2 = ShapeTransforms.translatedCopyOf(f2,150,0);
	g2.setColor(Color.BLACK); g2.draw(f2);
	
	// Here's a fish that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	f2 = ShapeTransforms.scaledCopyOfLL(f2,4,4);
	f2 = ShapeTransforms.translatedCopyOf(f2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xFFD700)); 
	g2.draw(f2); 
	
	// Draw two fish with gills and a fin
	
	FishWithFinAndGills fgf1 = new FishWithFinAndGills(50,350,40,75);
	FishWithFinAndGills fgf2 = new FishWithFinAndGills(200,350,200,100);
	
	g2.draw(fgf1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(fgf2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A couple fish by Tamky Ngo", 20,20);
    }


    /** Draw a picture with a few houses, coffee cups, and fish
     */
    public static void drawPicture2(Graphics2D g2) {

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
	
	//Draw a couple fish
	Fish f1 = new Fish(150,20,100,50);
	Fish f2 = new Fish(50,50,250,100);
	g2.setColor(new Color(0xCC00CC));
	g2.draw(f1);
	g2.setColor(new Color(0xFF00FF));
	g2.draw(f2);

	//Rotate fish 60 degrees around its center
	Shape f3 = ShapeTransforms.rotatedCopyOf(f1, Math.PI/3);
	g2.draw(f3);
	
	//Make a new fish with fin and gills
	FishWithFinAndGills fgf= new FishWithFinAndGills(20,20,50,75);
	g2.setColor(Color.RED);
	
	//Make this fish twice as big, move it 100 pixels down, and rotate it 90 degrees
	Shape fgf2 = ShapeTransforms.scaledCopyOfLL(fgf,2,2);
	fgf2 = ShapeTransforms.translatedCopyOf(fgf,0,100);
	fgf2 = ShapeTransforms.rotatedCopyOf(fgf, Math.PI/2);
	g2.draw(fgf2);
	
	
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Coffee Cups and a few houses by Phill Conrad and a bunch of fish by Tamky Ngo", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Coffee Cups by Phill Conrad and a bunch of fish by Tamky Ngo", 20,20);

	
	// Draw some coffee cups.
	
       CoffeeCup large = new CoffeeCup(100,50,225,150);
       CoffeeCup smallCC = new CoffeeCup(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);

       //Draw some fish
       Fish f1 = new Fish(200,300,200,100);
       FishWithFinAndGills f2 = new FishWithFinAndGills(300,200,100,200);
       g2.setColor(Color.BLUE);
       g2.draw(f1);
       g2.setColor(new Color(0x00FF00));
       g2.draw(f2);
       
       
    }
    

}
