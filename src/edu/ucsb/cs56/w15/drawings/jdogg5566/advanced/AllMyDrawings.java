package edu.ucsb.cs56.w15.drawings.jdogg5566.advanced;

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
 * @author Jonathan Easterman
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with sweatshirts 
     */

    public static void drawPicture1(Graphics2D g2) {

    	// First create a cyan colored sweatshirt
		Sweatshirt s1 = new Sweatshirt(250,150,200,120);
		g2.setColor(Color.CYAN); g2.fill(s1); g2.draw(s1);
	

		// Make a black sweatshirt that's half the size, 
		// and moved over 150 pixels in x direction
		Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
		s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
		g2.setColor(Color.BLACK); g2.fill(s2); g2.draw(s2);
	

		// Here's a sweatshirt that's 3x as big (1.5x the original)
		// and moved 150 more pixels to left.
		s2 = ShapeTransforms.scaledCopyOfLL(s2,3,3);
		s2 = ShapeTransforms.translatedCopyOf(s2,-150,300);
	
		// We'll draw this with a thicker stroke
		Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
		// Save the original stroke and use the thick stroke 
		Stroke orig=g2.getStroke();
		g2.setStroke(thick);
		g2.setColor(new Color(0x002FA7)); 
		g2.fill(s2);
		g2.draw(s2); 
	
	
		// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
		g2.setStroke(orig);
		g2.setColor(Color.BLACK); 
		g2.drawString("A few sweatshirts by Jonathan Easterman", 20,20);
    }


    /** Draw a picture with a sweatshirt with a smiley face logo
     */
    public static void drawPicture2(Graphics2D g2) {
		
		SweatshirtWithLogo s = new SweatshirtWithLogo(250,150,200,120);
		
		// Draw a large green sweatshirt with a smiley face logo
		g2.setColor(Color.GREEN);
      	g2.fill(s);
      	g2.draw(s);

      	// The head of the smiley is red
      	g2.setColor(Color.RED); 
      	g2.fill(s.logoHead);
      	g2.draw(s.logoHead);

      	// The eyes and mouth of the smiley is blue
      	g2.setColor(Color.BLUE);
     	g2.fill(s.logoFace);
      	g2.draw(s.logoFace);
	
		
		// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
		
		g2.setColor(Color.BLACK); 
		g2.drawString("A sweatshirt with a logo by Jonathan Easterman", 20,20);
	   }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
		// label the drawing
		
		g2.drawString("One sweatshirt and one sweatshirt with logo", 20,20);

		Sweatshirt s = new Sweatshirt(100, 100, 200, 120);
		SweatshirtWithLogo s2 = new SweatshirtWithLogo(300, 300, 200, 120);

		Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 

		g2.setStroke(thick);
		g2.setColor(new Color(0x002FA7));
		g2.fill(s);
		g2.draw(s);
		
        // I somehow need to get a SweatShirtWithLogo
       	// Copy of s2 because the logo is made of member variables
       	// of the SweatShirtWithLogo class
       	// They are member variables so they can be a different color
       	// From the color of the sweatshirt body

      g2.setColor(Color.BLACK);
      g2.fill(s2);
      g2.draw(s2);

      g2.setColor(Color.YELLOW); // Need to figure out how to draw the smiley with transformed sweatshirt
      g2.fill(s2.logoHead);
      g2.draw(s2.logoHead);

      g2.setColor(Color.BLACK);
      g2.fill(s2.logoFace);
      g2.draw(s2.logoFace);

       
    }
}
