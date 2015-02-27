package edu.ucsb.cs56.w15.drawings.zakary94.advanced;

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
 * @author Zak Blake 
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    /** Draw a picture of some Shovels 
     */

    public static void drawPicture1(Graphics2D g2) {

	Shovel s1 = new Shovel(250,50,200);
	g2.setColor(Color.BLACK);
	g2.draw(s1);
	Stroke orig=g2.getStroke();

	ShovelWithDetail s2 = new ShovelWithDetail(100,100,300);
     
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	g2.setStroke(thick);
        g2.setColor(new Color(0x002FA7)); 
        g2.draw(s2);

	Shovel s3 = new ShovelWithDetail(300,300, 100);
	g2.setColor(Color.PINK); g2.draw(s3);

	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString(" 'Shovels' by Zak Blake", 20,20);

    }


    /** Draw a picture with a few more shovels
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some coffee cups.
	
//	CoffeeCup large = new CoffeeCup(100,50,225,150);
//	CoffeeCup smallCC = new CoffeeCup(20,50,40,30);
//	CoffeeCup tallSkinny = new CoffeeCup(20,150,20,40);
//	CoffeeCup shortFat = new CoffeeCup(20,250,40,20);
	ShovelWithDetail large = new ShovelWithDetail(100,100,200);
	Shovel smallCC = new Shovel(400,300,100);
	ShovelWithDetail tallSkinny = new ShovelWithDetail(200,400,300);
	Shovel shortFat = new Shovel(50,50,100);


	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Shovel S1 = new Shovel(300,50,200);
	Shape S2 = ShapeTransforms.rotatedCopyOf(S1,Math.PI/4.0);
//      Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);
//
	g2.setColor(Color.CYAN); g2.draw(S2);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
//	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
//	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
//	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
//	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
//	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
//	g2.setStroke(thick);
//	g2.setColor(new Color(0x002FA7)); 
//	g2.draw(h2); 
	
	// Draw two houses with Windows
	
//	HouseWithWindows hw1 = new HouseWithWindows(50,350,40,75);
//	HouseWithWindows hw2 = new HouseWithWindows(200,350,200,100);
	
//	g2.draw(hw1);
//	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
//	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);

//	g2.draw(hw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("More of Zak's Shovels", 20,20);
    }
  
    /** Draw a different picture with 3 nice shovels
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Even More Shovels by Zak", 20,20);
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

	ShovelWithDetail sh1 = new ShovelWithDetail(50,200,100);
	g2.setStroke(thick);
	g2.draw(sh1);

	Shape myS;
 		myS = ShapeTransforms.scaledCopyOfLL(sh1,2,2);
		myS = ShapeTransforms.translatedCopyOf(myS,150,0);
    	g2.setColor(Color.BLUE);
	g2.draw(myS);

	Shape z = ShapeTransforms.rotatedCopyOf(myS,Math.PI);
		z= ShapeTransforms.translatedCopyOf(z,150,0);
	g2.setColor(Color.RED);
	g2.draw(z);





	}
}
