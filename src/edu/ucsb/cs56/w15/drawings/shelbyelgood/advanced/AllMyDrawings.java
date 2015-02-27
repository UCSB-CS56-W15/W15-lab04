package edu.ucsb.cs56.w15.drawings.shelbyelgood.advanced;

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
 * @author Shelby Elgood
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few cups 
     */

    public static void drawPicture1(Graphics2D g2) {
        // label the drawing
        g2.drawString("A bunch of Cups by Shelby Elgood", 20,20);
        
	// Draw some cups.
        Cup large = new Cup(300,300,80,200);
        Cup medium = new Cup(100,300,60,150);
        Cup small = new Cup(100,200,30,100);
       
        //rotated version of small
        Shape rotated = ShapeTransforms.rotatedCopyOf(small, Math.PI/4.0);
	rotated = ShapeTransforms.translatedCopyOf(rotated,150,0);	
     	
	g2.setColor(Color.GREEN);       g2.draw(large);
     	g2.setColor(Color.ORANGE);      g2.draw(small);
     	g2.setColor(Color.YELLOW);      g2.draw(medium);
      	g2.setColor(Color.RED);         g2.draw(rotated);	

    }

 	 /**
 	Draw a picture of various cups with straws
 	**/

   public static void drawPicture2(Graphics2D g2) {

        // label the drawing
        
      	g2.drawString("A bunch of Cups With Straws by Shelby Elgood", 20,20);
        
     
       	// Draw some cups with straws.
       	CupWithStraw large = new CupWithStraw(300,300,80,200);
	CupWithStraw medium = new CupWithStraw(100,250,60,140);
	CupWithStraw small = new CupWithStraw(200,100,30,60);
 
	//rotated version of medium
	Shape rotated = ShapeTransforms.rotatedCopyOf(medium, Math.PI/4.0);
       
     	g2.setColor(Color.GREEN);     	g2.draw(large);
	g2.setColor(Color.RED);		g2.draw(rotated);
	g2.setColor(Color.BLUE);	g2.draw(medium);
    	g2.setColor(Color.ORANGE);   	g2.draw(small);
        
        
     	}
 
	/**
 	Draw a different picture with Cups with and without straws
	**/

   public static void drawPicture3(Graphics2D g2) {

	//label the drawing
	g2.drawString("A bunch of Cups with and without straws by Shelby Elgood",20,20);

	//create cup and cup with straw objects
	Cup largeCup = new Cup(50,250,100,200);
	CupWithStraw large = new CupWithStraw(300,300,80,200);
        CupWithStraw medium = new CupWithStraw(100,250,60,140);

	//rotated, translated version of medium
	Shape rotated = ShapeTransforms.rotatedCopyOf(medium, Math.PI/4.0);
	rotated = ShapeTransforms.translatedCopyOf(rotated,150,0);

	//draw cups
        g2.setColor(Color.GREEN);       g2.draw(large);
        g2.setColor(Color.RED);         g2.draw(rotated);
	
	//set thicker stroke
        Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);	
        g2.setStroke(thick);
	g2.setColor(Color.BLUE);        g2.draw(medium);


	}                                                           
        
	    
}
