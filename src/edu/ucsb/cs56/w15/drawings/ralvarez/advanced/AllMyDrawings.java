package edu.ucsb.cs56.w15.drawings.ralvarez.advanced;

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
 * @author Richard Alvarez (changed to Person drawings)
 * @version for CS56 2-12-15
 */


public class AllMyDrawings
{
    /** Draw a picture with a few people
     */

    public static void drawPicture1(Graphics2D g2) {

	Person s1 = new Person(100,250,50,75);
	g2.setColor(Color.YELLOW); g2.draw(s1);
	
	// Make a Person that's half the size, 
	// and moved over 150 pixels in x direction

	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	g2.setColor(Color.BLACK); g2.draw(s2);
	
	// Here's a person that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	s2 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(s2); 
	
	// Draw Supermen
	
	Superman S1 = new Superman(50,350,40,75);
	Superman S2 = new Superman(200,350,200,100);
	
	g2.draw(S1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(S2);
	
	//SIGN AND LABEL
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A community by Richard Alvarez", 20,20);
    }


    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some people.
	
	Person large = new Person(100,50,225,150);
	Person small = new Person(20,50,40,30);
	Person tallSkinny = new Person(20,150,20,40);
	Person shortFat = new Person(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Person s1 = new Person(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(s1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
	g2.setColor(Color.BLACK); g2.draw(s2);
	
	// Here's a house that's 4x as big (2x the original)
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
	
	// Draw Superman
	
	Superman S1 = new Superman(50,350,40,75);

	g2.setColor (Color.RED);
	g2.draw(S1);
	g2.setColor(new Color(0x8F00FF)); 


	
	// SIGN AND LABEL 
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of People with Superman by Richard Alvarez", 20,20);
    }
  
    /** Draw a different picture with only one Superman     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of people by Richard Alvarez", 20,20);
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL); 
	g2.setStroke(thick);
	// Draw some people
	
	Person large = new Person(200,100,80,100);
	Person small = new Person(400,100,80,100);
       	Superman S4 = new Superman(300,100,80,150);

       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(small);
       g2.setColor(Color.BLUE);   g2.draw(S4);

       
    }
    

}
