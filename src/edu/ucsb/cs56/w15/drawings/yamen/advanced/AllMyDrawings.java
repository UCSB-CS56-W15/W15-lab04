package edu.ucsb.cs56.w15.drawings.yamen.advanced;

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
 * @author Phil Conrad
 * @author Yamen Alghrer
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few Trees
     *  Trees come out nicer when width and height are equal
     */

    public static void drawPicture1(Graphics2D g2) {

	Tree  t1 = new Tree (50 ,250,200,200);
	g2.setColor(Color.CYAN); g2.draw(t1);
	
	// Make a Green Tree that's half the size, 
	// and moved over 150 pixels in x direction

	Shape t2 = ShapeTransforms.scaledCopyOfLL(t1,0.5,0.5);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	g2.setColor(Color.GREEN); g2.draw(t2);
	
	// Here's a tree that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	t2 = ShapeTransforms.scaledCopyOfLL(t2,1.5,1.5);
	t2 = ShapeTransforms.translatedCopyOf(t2,50,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #0xFFFF33 is "Electric Yellow" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xFFFF33)); 
	g2.draw(t2); 
	
		// Draw a rotated and translated copy of the first tree
	
	Shape t3 = ShapeTransforms.rotatedCopyOf(t1, Math.PI/4);
	t3 = ShapeTransforms.translatedCopyOf(t3,300,50);
	
	g2.draw(t3);
	g2.setColor(new Color(0xFF00FF)); g2.draw(t3); //The Color is Fuchsia
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few trees by Yamen Alghrer", 20,20);
    }


    /** Draw a picture with a few Apple Trees
     */
    public static void drawPicture2(Graphics2D g2) {

	
	TreeWithApples t1 = new TreeWithApples(100,300,200,200);
      	TreeWithApples t2 = new TreeWithApples(20,100,50, 50);
	TreeWithApples t3 = new TreeWithApples(200,50,30,30);
	TreeWithApples t4 = new TreeWithApples(250,150,100,100);
	g2.setColor(Color.RED);     g2.draw(t1);
	g2.setColor(Color.GREEN);   g2.draw(t2);
	g2.setColor(Color.BLUE);    g2.draw(t3);
	g2.setColor(Color.MAGENTA); g2.draw(t4);

	Stroke orig=g2.getStroke();
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few Apple Trees by Yamen Alghrer", 20,20);
	    }
  
    /** Draw a different picture with a couple of trees and apple trees
     */

    public static void drawPicture3(Graphics2D g2) {
	
 	
	g2.drawString("Trees and Apple Trees by Yamen Alghrer", 20,20);

	Tree  t1 = new Tree (50 ,250,100,100);
	g2.setColor(Color.ORANGE); g2.draw(t1);
		
	Shape t2 = ShapeTransforms.scaledCopyOf(t1,0.75,0.75);
	t2 = ShapeTransforms.translatedCopyOf(t2,150,0);
	g2.setColor(Color.RED); g2.draw(t2);

	TreeWithApples t3 = new TreeWithApples(200,125,125,125);
	g2.setColor(Color.CYAN); g2.draw(t3);

	Shape t4 = ShapeTransforms.rotatedCopyOf(t3,Math.PI/5);
	t4 = ShapeTransforms.translatedCopyOf(t4,100,30);
	g2.setColor(Color.GREEN); g2.draw(t4);
	
       
    }
    

}
