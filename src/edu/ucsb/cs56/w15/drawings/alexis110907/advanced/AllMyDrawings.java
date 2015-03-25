package edu.ucsb.cs56.w15.drawings.alexis110907.advanced;

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
 * @author Alexis Jimenez 
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few santa hats 
     */

    public static void drawPicture1(Graphics2D g2) {

	SantaHat s1 = new SantaHat(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(s1);
	
	// Make a black santa hat that's half the size, 
	// and moved over 150 pixels in x direction

	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	g2.setColor(Color.BLACK); g2.draw(s2);
	
	// Here's a santa hat that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	s2 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(s2); 
	
	// Draw two santa hats with faces
	
	SantaHatWithFace sf1 = new SantaHatWithFace(50,350,40,75);
	SantaHatWithFace sf2 = new SantaHatWithFace(200,350,200,100);
	
	g2.draw(sf1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(sf2);
	
	// @@@ FINALLY SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few santa hats and faces  by Alexis Jimenez", 20,20);
    }

    
    /** Draw a picture with a santa hats  and santa hats with faces
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some santa hats with faces.
	
	SantaHatWithFace smallCC = new SantaHatWithFace(20,50,40,30);
	SantaHatWithFace tallSkinny = new SantaHatWithFace(20,150,20,40);
	SantaHatWithFace shortFat = new SantaHatWithFace(20,250,40,20);
	
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	SantaHat s1 = new SantaHat(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(s1);
	
	// Make a black santa hat that's half the size, 
	// and moved over 150 pixels in x direction
	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	g2.setColor(Color.BLACK); g2.draw(s2);
	
	// Here's a santa hat that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	s2 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(s2); 
	
	// Draw two santa hats with faces
	
	SantaHatWithFace sf1 = new SantaHatWithFace(50,350,40,75);
	SantaHatWithFace sf2 = new SantaHatWithFace(200,350,200,100);
	
	g2.draw(sf1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second santa hat 45 degrees around its center.
	Shape sf3 = ShapeTransforms.rotatedCopyOf(sf2, Math.PI/4.0);

	g2.draw(sf3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Santa hats with faces and  Santa hats and by Alexis Jimenez", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Santa Hats with faces by Alexis Jimenez", 20,20);

	
	// Draw some coffee cups.
	
       SantaHatWithFace large = new SantaHatWithFace(700,50,225,150);
       SantaHatWithFace smallCC = new SantaHatWithFace(50,50,40,30);
       SantaHatWithFace medium = new SantaHatWithFace(100,200,60,50);
       SantaHatWithFace xsmall = new SantaHatWithFace(80,600,20,10);



       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);
       g2.setColor(Color.BLUE);     g2.draw(medium);
       g2.setColor(Color.YELLOW);     g2.draw(xsmall);


       
    }
    

}
