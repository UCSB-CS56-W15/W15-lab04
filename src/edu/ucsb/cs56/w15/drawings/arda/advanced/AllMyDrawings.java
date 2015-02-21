package edu.ucsb.cs56.w15.drawings.arda.advanced;

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
 *  @author P. Conrad,
 *  @author Arda Ungun (modified to run my own graphics)
 *  @version for UCSB CS56, W15, 02/20/2015
 */

public class AllMyDrawings
{
    /** Draw Cats and BetterCats of various shapes, colors, and sizes. 
     */
	public static void drawPicture1(Graphics2D g2) {

		Cat c1 = new Cat(200,250,100);
		g2.setColor(Color.CYAN); 
		g2.draw(c1);
		


		// Make a black cat that's half the size, 
		// and moved over 150 pixels in x direction
		Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
		c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
		g2.setColor(Color.BLACK); g2.draw(c2);
		


		// Here's a cat that's 4x as big (2x the original)
		// and moved over 150 more pixels to right.
		c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
		c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
		


		// We'll draw this with a thicker stroke
		Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
		
		// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
		// #002FA7 is "International Klein Blue" according to Wikipedia
		// In HTML we use #, but in Java (and C/C++) its 0x
		
		Stroke orig=g2.getStroke();
		g2.setStroke(thick);
		g2.setColor(new Color(0x002FA7)); 
		g2.draw(c2); 
		



		// Draw two BetterCats
		BetterCat bc1 = new BetterCat(50,350,75);
		BetterCat bc2 = new BetterCat(200,350,100);
		
		g2.setColor(Color.GREEN);			g2.draw(bc1);
		g2.setColor(new Color(0x8F00FF));	g2.draw(bc2);
		

		// sign and label the drawing
		g2.setStroke(orig);
		g2.setColor(Color.BLACK); 
		g2.drawString("A few simple and more detailed cats by Arda Ungun", 20,20);

    }








    /** Draw a picture with Cats, BetterCats, of differing colors, sizes, rotations, etc.
     */
    public static void drawPicture2(Graphics2D g2) {

		// Draw some regular cats at the corners of the window (640*480)
    	//	- they're all centered 100px away their respective window edges
    	//	- each of radius 30, and have different colors.
		Cat catTopL = new Cat(100,100,30);
		Cat catTopR = new Cat(540,100,30);
		Cat catBotL = new Cat(100,380,30);
		Cat catBotR = new Cat(540,380,30);


		g2.setColor(Color.RED);     g2.draw(catTopL);
		g2.setColor(Color.GREEN);   g2.draw(catTopR);
		g2.setColor(Color.BLUE);    g2.draw(catBotR);
		g2.setColor(Color.MAGENTA); g2.draw(catBotL);



		// make some rotated BetterCats
		//	- create one, then create the others by scaling and copying the first BetterCat
		BetterCat bc0 = new BetterCat(240,300,100);
		g2.setColor(Color.CYAN); g2.draw(bc0);



		// Make a black cat that's half the size, 
		// and moved upwards by 100 pixels
		Shape bc1 = ShapeTransforms.scaledCopyOfLL(bc0,0.5,0.5);
		bc1 = ShapeTransforms.translatedCopyOf(bc1,150,0);
		
		g2.setColor(Color.BLACK); 
		g2.draw(bc1);


		// take the same object, rotate it and draw it to the right of previous BetterCat
		Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
		Stroke orig=g2.getStroke();
		g2.setStroke(thick);
		bc1 = ShapeTransforms.scaledCopyOfLL(bc1,4,4);
		bc1 = ShapeTransforms.translatedCopyOf(bc1,150,0);
		bc1 = ShapeTransforms.rotatedCopyOf(bc1, Math.PI/4.0);
		g2.setColor(Color.YELLOW);
		g2.draw(bc1);


		// draw another, to the far left side of our window, with a thicker stroke, and rotated
		g2.setStroke(orig);
		bc1 = ShapeTransforms.scaledCopyOfLL(bc1,0.2,0.2);
		bc1 = ShapeTransforms.translatedCopyOf(bc1,-400,-200);
		bc1 = ShapeTransforms.rotatedCopyOf(bc1, -5.0*(Math.PI/6.0));


		g2.setStroke(thick);
		g2.setColor(new Color(0x0B0B0B)); // a Gray color for this one
		g2.draw(bc1); 


		// sign and label the drawing	
		g2.setStroke(orig);
		g2.setColor(Color.BLACK); 
		g2.drawString("A crazy bunch of Cats and BetterCats by Arda Ungun", 20,20);
    }
  








    /** Draws a different picture of a few Cats with various sizes and colors
     */
    public static void drawPicture3(Graphics2D g2) {
		
		// label the drawing
		g2.drawString("Cats of various sizes by Arda Ungun", 20,20);

		Cat smallCat = new Cat(40,40,20);
		Cat mediumCat = new Cat(400,150,100);
		Cat megaCat = new Cat(300,250,200);

		g2.setColor(Color.BLUE);     g2.draw(smallCat);
		g2.setColor(Color.RED);   	g2.draw(mediumCat);
		g2.setColor(Color.GREEN);	g2.draw(megaCat);

       
    }
    

}
