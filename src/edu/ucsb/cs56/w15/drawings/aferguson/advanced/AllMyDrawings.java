package edu.ucsb.cs56.w15.drawings.aferguson.advanced;

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
 * @author Andrew Ferguson 
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few wheels 
     */

    public static void drawPicture1(Graphics2D g2) {

	
	// label the drawing

	g2.drawString("Wheels by Andrew Ferguson", 20,20);

	
	// Draw a wheel.
	
	Wheel wheel1 = new Wheel(100,50,60);
	Wheel wheel2 = new Wheel(100,250,60);
	Wheel wheel3 = new Wheel(100,450,60);



       g2.setColor(Color.BLUE);     g2.draw(wheel1);
       g2.setColor(Color.RED);      g2.draw(wheel2);
       g2.setColor(Color.YELLOW);   g2.draw(wheel3);


    }


    /** Draw a picture with a wheels and unicycles
     */
    public static void drawPicture2(Graphics2D g2) {
 
	// Draw some unicycles.
	Unicycle uni1 = new Unicycle(50,300,30);
	Unicycle uni2 = new Unicycle(150,300,30);
	Unicycle uni3 = new Unicycle(250,300,30);
	
	g2.setColor(Color.RED);     g2.draw(uni1);
	g2.setColor(Color.GREEN);   g2.draw(uni2);
	g2.setColor(Color.BLUE);    g2.draw(uni3);

	// Make a black unicycle that's half the size, 
	// and moved down 200 pixels in y direction
	Shape uni4 = ShapeTransforms.scaledCopyOfLL(uni1,.5,.5);
	uni4 = ShapeTransforms.translatedCopyOf(uni1,0,200);
	g2.setColor(Color.BLACK); g2.draw(uni4);


	// Here's a unicycle that's 4x as big (2x the original)
	// and moved over 400 more pixels to right.
	uni4 = ShapeTransforms.scaledCopyOfLL(uni4,4,4);
	uni4 = ShapeTransforms.translatedCopyOf(uni4,400,0);

	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);     	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(uni4); 

	// Rotate the first house 45 degrees around its center.
	g2.setStroke(orig);
	g2.setColor(Color.MAGENTA);
        Shape uni5 = ShapeTransforms.rotatedCopyOf(uni1, Math.PI/4.0);

      	g2.draw(uni5);



	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of unicycles by Andrew Ferguson", 20,20);
    }
  
    /** Draw a different picture with a wheel and unicycle
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing

	g2.drawString("Wheel and Unicycle by Andrew Ferguson", 20,20);

	
	// Draw a wheel.
	
	Wheel wheel1 = new Wheel(100,100,60);
	Unicycle uni1 = new Unicycle(300,300,60);
       g2.setColor(Color.BLUE);     g2.draw(wheel1);
       g2.setColor(Color.RED);      g2.draw(uni1);

       
       
    }
    

}
