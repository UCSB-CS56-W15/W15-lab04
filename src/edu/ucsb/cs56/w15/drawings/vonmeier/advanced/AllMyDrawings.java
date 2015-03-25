package edu.ucsb.cs56.w15.drawings.vonmeier.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Arc2D; //Arcs
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
 * @author Phill Conrad, Ishi von Meier 
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few balls 
     */

    public static void drawPicture1(Graphics2D g2) {

	Balls t1 = new Balls(100,250,50,75);
	g2.setColor(Color.GREEN); g2.draw(t1);
	
	// Make a black balls that's half the size, 
	// and moved over 150 pixels in x direction

	Shape t2 = ShapeTransforms.scaledCopyOfLL(t1,0.5,0.5);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	g2.setColor(Color.BLACK); g2.draw(t2);
	
	// Here's a balls that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	t2 = ShapeTransforms.scaledCopyOfLL(t2,4,4);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	
	g2.setColor(new Color(0x458B00)); 
	g2.draw(t2); 
	
	// Draw two trees with ornaments
	
	TreeWithBalls tb1 = new TreeWithBalls(50,350,75,150);
	TreeWithBalls tb2 = new TreeWithBalls(200,350,250,250);
	
	g2.draw(tb1);
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	
	g2.setColor(new Color(0x78AB46)); g2.draw(tb2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few trees by Ishi von Meier", 20,20);
    }


    /** Draw a picture with a few trees amd some with ornaments
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some coffee cups.
	
	TreeWithBalls large = new TreeWithBalls(100,50,225,150);
	TreeWithBalls smallCC = new TreeWithBalls(20,50,40,30);
	TreeWithBalls tallSkinny = new TreeWithBalls(20,150,20,40);
	TreeWithBalls shortFat = new TreeWithBalls(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Tree t1 = new Tree(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(t1);
	
	// Make a black tree that's half the size, 
	// and moved over 150 pixels in x direction
	Shape t2 = ShapeTransforms.scaledCopyOfLL(t1,0.5,0.5);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	g2.setColor(Color.BLACK); g2.draw(t2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	t2 = ShapeTransforms.scaledCopyOfLL(t2,4,4);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(t2); 
	
	// Draw two trees with ornaments
	
	TreeWithBalls tb1 = new TreeWithBalls(50,350,60,90);
	TreeWithBalls tb2 = new TreeWithBalls(200,350,200,100);
	
	g2.draw(tb1);
	g2.setColor(new Color(0x4A7023)); 

	// Rotate the second Tree 45 degrees around its center.
	Shape tb3 = ShapeTransforms.rotatedCopyOf(tb2, Math.PI/4.0);

	g2.draw(tb3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Trees and some with Ornaments by Ishi von Meier", 20,20);
    }
  
    /** Draw a different picture with a few trees
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Trees by Ishi von Meier", 20,20);

	
	// Draw some coffee cups.
	
       Tree large = new Tree(100,50,225,150);
       Tree smallT = new Tree(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallT);
       
       
    }
    

}
