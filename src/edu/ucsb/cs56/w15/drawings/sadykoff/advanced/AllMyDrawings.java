package edu.ucsb.cs56.w15.drawings.sadykoff.advanced;

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
 * @author Boris Sadykoff 
 * @version for CS56, lab04, Winter 2015 */


public class AllMyDrawings
{
    /** Draw a picture with a few pizzas 
     */

    public static void drawPicture1(Graphics2D g2) {

	Pizza h1 = new Pizza(150,150,50);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black pizza that's half the size, 
	// and moved over 150 pixels in x direction

	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a pizza that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw pizzas with pepperoni
	
	PepperoniPizza hw1 = new PepperoniPizza(100,250,45);
	PepperoniPizza hw2 = new PepperoniPizza(350,350,75);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(hw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few pizzas by Boris Sadykoff", 20,20);
    }


    /** Draw a picture with a few pizzas and pepperoni pizzas
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some pizzas
	
	Pizza large = new Pizza(100,150,65);
	Pizza medium = new Pizza(250,150,45);
	Pizza small = new Pizza(350,150,25);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(medium);
	g2.setColor(Color.MAGENTA); g2.draw(small);
	
	PepperoniPizza largePep = new PepperoniPizza(150,300,65);
;
	g2.setColor(Color.CYAN); g2.draw(largePep);
	
	// Make a black pizza that's half the size, 
	// and moved over 150 pixels in x direction
	Shape p2 = ShapeTransforms.scaledCopyOfLL(largePep,0.5,0.5);
	p2 = ShapeTransforms.translatedCopyOf(largePep,150,0);
	g2.setColor(Color.BLACK); g2.draw(p2);
	
	// Here's a Pizza that's 2x as big (2x the original)
	// and moved over 250 more pixels to right.
	Shape p3 = ShapeTransforms.scaledCopyOfLL(p2,2,2);
	p3 = ShapeTransforms.translatedCopyOf(p2,250,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(largePep); 
	
	// Draw a pizzas with pepperoni
	
	PepperoniPizza pp1 = new PepperoniPizza(500,200,65);
      
	
	g2.draw(pp1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the pizza 45 degrees around its center.
	Shape pp3 = ShapeTransforms.rotatedCopyOf(pp1, Math.PI/4.0);

	g2.draw(pp3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of pizzas and pepperoni pizzas by Boris Sadykoff", 20,20);
    }
  
    /** Draw a different picture with two pizzas
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Pizzas by Boris Sadykoff", 20,20);

	
	// Draw some pizzas.
	
	Pizza first = new Pizza(200,200,50);
	PepperoniPizza second = new PepperoniPizza(400,100,75);
       
       g2.setColor(Color.RED);     g2.draw(first);
       g2.setColor(Color.GREEN);   g2.draw(second);

       Stroke orig=g2.getStroke();
       g2.setStroke(orig);
       g2.setColor(Color.BLACK); 
       g2.drawString("Two Pizzas by Boris Sadykoff", 20,20);
       
       
    }
    

}
