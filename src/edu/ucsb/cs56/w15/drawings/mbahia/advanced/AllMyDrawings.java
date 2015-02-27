package edu.ucsb.cs56.w15.drawings.mbahia.advanced;

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
 * @author Manpreet Bahia
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draws a few Ice Cream Cones and Ice Cream Cones With Toppings 
	with the colors of the rainbow
     */

    public static void drawPicture1(Graphics2D g2) {
	
	IceCreamConeWithToppings kidsize = new IceCreamConeWithToppings(50, 120, 50, 75);
	IceCreamCone mediumsize = new IceCreamCone(300, 130, 75, 150);
	IceCreamCone adultsize = new IceCreamCone(170, 200, 125, 175);

	g2.setColor(Color.RED);   
	g2.draw(kidsize);
	g2.setColor(Color.YELLOW);   
	g2.draw(mediumsize);
	g2.setColor(Color.ORANGE);
	g2.draw(adultsize);


	Shape IC = ShapeTransforms.scaledCopyOfLL(kidsize,1.5,1.5);
	IC = ShapeTransforms.translatedCopyOf(IC,25,300);
	g2.setColor(Color.GREEN);   
	g2.draw(IC);

	Shape IC2 = ShapeTransforms.scaledCopyOfLL(mediumsize,.5,.5);
	IC2 = ShapeTransforms.translatedCopyOf(IC2, 0, 150);
	g2.setColor(Color.BLUE);
	g2.draw(IC2);
	
	// make the purple line thick
	Shape IC3 = ShapeTransforms.scaledCopyOfLL(IC,1.25,1.25);
	IC3 = ShapeTransforms.translatedCopyOf(IC3, 300, 0);
	g2.setColor(new Color(0x9b30ff));
	Stroke thickLine = new BasicStroke (1.75f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);       
	g2.setStroke(thickLine);
	g2.draw(IC3);

	g2.setColor(Color.LIGHT_GRAY);
	g2.drawString("Ice Cream Cones with the Colors of the Rainbow by Manpreet Bahia", 20,20);
    }


    /** Draws a picture with 4 Ice Cream Cones and Ice Cream Cones with Toppings 
	of same size in a circle.
     */
    public static void drawPicture2(Graphics2D g2) {

	IceCreamConeWithToppings ICtemp = new IceCreamConeWithToppings(75, 75, 75, 75);
	Shape ICCT = ShapeTransforms.translatedCopyOf(ICtemp, 137, 180);
	g2.draw(ICCT);

	Stroke thickLine = new BasicStroke (1.75f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);       

	IceCreamCone IC = new IceCreamCone(200, 100, 100, 100);
	g2.setStroke(thickLine);
	g2.setColor(new Color(0x7a4b1c));
	g2.draw(IC);
		
	Shape IC2 = ShapeTransforms.rotatedCopyOf(IC, Math.PI/2.0);
	IC2 = ShapeTransforms.translatedCopyOf(IC2, 150, 150);
	g2.setColor(Color.MAGENTA);
	g2.setStroke(thickLine);
	g2.draw(IC2);

	Shape IC3 = ShapeTransforms.rotatedCopyOf(IC, Math.PI);
	IC3 = ShapeTransforms.translatedCopyOf(IC3, 0, 300);
	g2.setColor(Color.GREEN);
	g2.setStroke(thickLine);
	g2.draw(IC3);

	Shape IC4 = ShapeTransforms.rotatedCopyOf(IC, Math.PI/-2.0);
	IC4 = ShapeTransforms.translatedCopyOf(IC4, -150, 150);
	g2.setColor(Color.BLUE);
	g2.setStroke(thickLine);
	g2.draw(IC4);
	
	g2.setColor(Color.BLACK); 
	g2.drawString("Ice Cream Cones in a Circle by Manpreet Bahia", 20,20);
    }
  
    /** Draws a different picture with an ice cream cone
	and ice cream cone with toppings.
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Two Ice Cream Cones by Manpreet Bahia", 20, 20);

	// Drawing 2 ice cream cones

	IceCreamCone small = new IceCreamCone(50, 100, 50, 75);
	IceCreamConeWithToppings large = new IceCreamConeWithToppings(200, 200, 200, 200);

	// make a thick line
	Stroke thickLine = new BasicStroke (7.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);       

       
       g2.setColor(Color.PINK);   
       g2.draw(large);
       g2.setColor(Color.ORANGE);   
       g2.setStroke(thickLine);
       g2.draw(small);
  
       
       
    }
    

}
