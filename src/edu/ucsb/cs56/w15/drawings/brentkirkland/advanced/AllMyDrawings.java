package edu.ucsb.cs56.w15.drawings.brentkirkland.advanced;

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
 * @author Brent Kirkland 
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {

	Pizza p1 = new Pizza(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(p1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction

	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.5,0.5);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	g2.setColor(Color.BLACK); g2.draw(p2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	p2 = ShapeTransforms.scaledCopyOfLL(p2,4,4);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(p2); 
	
	// Draw two houses with Windows
	
	PizzaWithPepperoni pp1 = new PizzaWithPepperoni(50,350,40,75);
	PizzaWithPepperoni pp2 = new PizzaWithPepperoni(200,350,200,100);
	
	g2.draw(pp1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(pp2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few Pizzas by Brent Kirkland", 20,20);
    }


    /** Draw a picture with a Pizzas
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some Pizzas.
	
	Pizza large = new Pizza(100,50,225,150);
	Pizza small = new Pizza(20,50,40,30);
	Pizza tallSkinny = new Pizza(20,150,20,40);
	Pizza shortFat = new Pizza(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Pizza p1 = new Pizza(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(p1);
	
	// Make a black pizza that's half the size, 
	// and moved over 150 pixels in x direction
	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.5,0.5);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	g2.setColor(Color.BLACK); g2.draw(p2);
	
	// Here's a pizza that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	p2 = ShapeTransforms.scaledCopyOfLL(p2,4,4);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(p2); 
	
	// Draw two pizza with pepperonis
	
	PizzaWithPepperoni pp1 = new PizzaWithPepperoni(50,350,40,75);
	PizzaWithPepperoni pp2 = new PizzaWithPepperoni(200,350,200,100);
	
	g2.draw(pp1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second pizza 45 degrees around its center.
	Shape pp3 = ShapeTransforms.rotatedCopyOf(pp2, Math.PI/4.0);

	g2.draw(pp3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Pizzas by Brent Kirkland", 20,20);
    }
  
    /** Draw a different picture with a few different pizzas
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Pizzas by Brent Kirkland", 20,20);

	
	// Draw some Pizzas.
	
       Pizza large = new Pizza(100,50,225,150);
       Pizza small = new Pizza(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(small);
       
       
    }
    

}
