package edu.ucsb.cs56.w15.drawings.jazariethach.advanced;

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
 * @author Jazarie Thach 
 * @version for CS10, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {

	// Make a yellow sun at some part of the screen

	Sun s1 = new Sun(150,275,50,50);
	g2.setColor(Color.YELLOW); g2.draw(s1);

	// Make a black sun that's half the size, 
	// and moved over 150 pixels in x direction

	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	g2.setColor(Color.BLACK); g2.draw(s2);
	
	// Here's a sun that's 4x as big (2x the original)
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
	g2.setColor(new Color(0x008FA9)); 
	g2.draw(s2); 
	
	// Draw two suns with glasses
       	
	SunWithGlasses sg1 = new SunWithGlasses(75,100,50,50);
      	SunWithGlasses sg2 = new SunWithGlasses(200,350,25,25);
	
	g2.draw(sg1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(sg2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few suns by Jazarie Thach", 20,20);
    }


    /** Draw a picture with a few suns and suns with sunglasses
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some coffee cups.
	
	Sun large = new Sun(400,275,100,100);
	Sun small = new Sun(20,40,30,30);
	Sun tallSkinny = new Sun(70,150,20,50);
	Sun shortFat = new Sun(300, 50,80,40);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
  
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	SunWithGlasses sg1 = new SunWithGlasses(50,350,40,75);	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);     
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(sg1); 
	
	// Draw two suns with glasses
	

	SunWithGlasses sg2 = new SunWithGlasses(200,350,100,50);
	

	// Rotate the second sun 45 degrees around its center.
	Shape sg3 = ShapeTransforms.rotatedCopyOf(sg2, Math.PI/4.0);
	g2.setColor(new Color(0xaaa027));
	g2.draw(sg3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of suns and a few suns with sunglasses by Jazarie Thach", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of suns by Jazarie Thach", 20,20);

	
	// Draw some suns
	
	Sun large = new Sun(300,300,100,100);
       Sun small = new Sun(120,80,40,40);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(small);
       
       
    }
    

}
