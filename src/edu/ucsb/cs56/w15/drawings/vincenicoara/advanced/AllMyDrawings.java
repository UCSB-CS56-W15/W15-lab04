package edu.ucsb.cs56.w15.drawings.vincenicoara.advanced;

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
	
	Face f1 = new Face(200 , 200, 100);
	g2.setColor(Color.BLACK); 
	g2.draw(f1);



	
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(f1,0.5,0.5);
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

	FaceWithFancyMustache ffm1 = new FaceWithFancyMustache(400, 400, 125);
	FaceWithFancyMustache ffm2 = new FaceWithFancyMustache(400, 100, 75);
	g2.draw(ffm1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(ffm2);
	
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	//g2.setStroke(orig);
	//g2.setColor(Color.BLACK); 
	g2.drawString("Faces by Vince", 20,20);
    }


    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some coffee cups.
	
	Face large = new Face(100,50,225);
	Face small = new Face(20,50,40);
	Face medium = new Face(20,150,80);
	Face regular = new Face(300,250,160);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(medium);
	g2.setColor(Color.MAGENTA); g2.draw(regular);
	
	FaceWithFancyMustache f1 = new FaceWithFancyMustache(100,250,50);
	g2.setColor(Color.CYAN); g2.draw(f1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(f1,0.5,0.5);
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
	
	FaceWithFancyMustache f2 = new FaceWithFancyMustache(50, 50, 50);
	
	g2.draw(f2);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape hw3 = ShapeTransforms.rotatedCopyOf(f1, Math.PI/4.0);

	g2.draw(hw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWINGg2.drawString("A bunch of regular and fancy faces", 20,20);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of regular and fancy faces", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("3 faces by Vince", 20,20);

	
	// Draw some coffee cups.
	
       Face small = new Face(400, 200, 75);
       FaceWithFancyMustache large = new FaceWithFancyMustache(300, 200, 200);
       
       Shape hw3 = ShapeTransforms.rotatedCopyOf(large, Math.PI/4.0);
       g2.draw(hw3);
       
       g2.setColor(Color.RED);     g2.draw(small);
       g2.setColor(Color.GREEN);   g2.draw(large);

       
       
    }
    

}
