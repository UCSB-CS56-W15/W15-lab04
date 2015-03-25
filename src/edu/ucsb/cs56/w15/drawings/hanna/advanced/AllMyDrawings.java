package edu.ucsb.cs56.w15.drawings.hanna.advanced;

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
 * @author Hanna Vigil
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    //Dice and cubes
    public static void drawPicture1(Graphics2D g2) {

	Cube c1 = new Cube(150, 250, 100);
        g2.setColor(Color.BLUE); g2.draw(c1);

        // Make a blue cubee that's half the size,
        // and moved over 150 pixels in x direction

        Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
        c2 = ShapeTransforms.translatedCopyOf(c2,50,100);
        g2.setColor(Color.GRAY); g2.draw(c2);
	// Here's a cube that's 4x as big (2x the original)
        // and moved over 150 more pixels to right.
        c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
        c2 = ShapeTransforms.translatedCopyOf(c2,100,0);

        // We'll draw this with a thicker stroke
        Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

        // for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
        // #002FA7 is "International Klein Blue" according to Wikipedia
        // In HTML we use #, but in Java (and C/C++) its 0x

	Stroke orig=g2.getStroke();
        g2.setStroke(thick);
        g2.setColor(new Color(0x002FA7));
	g2.draw(c2);

        // Draw two dice
	Dice d1 = new Dice(5, 350, 40);
	Dice d2 = new Dice(2, 250, 100);

	g2.draw(d1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(d2);

        // @@@ FINALLY, SIGN AND LABEL YOUR DRAWING

        g2.setStroke(orig);
	g2.setColor(Color.BLACK);
        g2.drawString("Some dice - By Hanna Vigil", 20,20);
		
    }

    /** Draw a few dice
     */
        public static void drawPicture2(Graphics2D g2) {

	    Dice smallest = new Dice(50, 50, 25);
	    Dice small = new Dice(100, 150, 50);
	    Dice justRight = new Dice(200, 300, 100);
	    Dice large = new Dice(350, 400, 200);

        g2.setColor(Color.LIGHT_GRAY);     g2.draw(smallest);
        g2.setColor(Color.GRAY);   g2.draw(small);
        g2.setColor(Color.GREEN);    g2.draw(justRight);
        g2.setColor(Color.DARK_GRAY); g2.draw(large);

	Dice d1 = new Dice(2,350,50);
	g2.setColor(Color.BLACK); g2.draw(d1);

        Shape d2 = ShapeTransforms.scaledCopyOfLL(d1,0.75,0.75);
        d2 = ShapeTransforms.translatedCopyOf(d2,300,400);
        g2.setColor(Color.MAGENTA); g2.draw(d2);
	
        // Here's one that's 2x the original
        // and moved over 150 more pixels to the right.
        d2 = ShapeTransforms.scaledCopyOfLL(d1,2,2);
        d2 = ShapeTransforms.translatedCopyOf(d2,150,50);

        // We'll draw this with a thicker stroke
        Stroke thick = new BasicStroke (6.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

        // for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
        // #002FA7 is "International Klein Blue" according to Wikipedia
        // In HTML we use #, but in Java (and C/C++) its 0x
	
       	Stroke orig=g2.getStroke();
	/*	g2.setStroke(thick);
        g2.setColor(new Color(0x002FA7));
	g2.draw(d2);
	*/
        // A couple of cubes

        Cube cube1 = new Cube(400,50,25);
	Cube cube2 = new Cube(450, 75, 50);

	g2.draw(cube1);
	g2.setColor(new Color(0x8F00FF));
	// Rotate the cube 45 degrees
	Shape c3 = ShapeTransforms.rotatedCopyOf(cube2, 3.0*Math.PI/4.0);

        g2.draw(c3);
	
        // @@@ FINALLY, SIGN AND LABEL YOUR DRAWING

        g2.setStroke(orig);
        g2.setColor(Color.BLACK);
	g2.drawString("More dice, by Hanna Vigil", 20,15);
	    
    }

    /** Draws a picture of two dice with twos up
     */
    
    public static void drawPicture3(Graphics2D g2) {

        // label the drawing

        g2.drawString("Dice Love, by Hanna Vigil", 20,20);
	//Two twos are called love in dice

	//Draw a couple of dice
	Dice smaller = new Dice(50, 400, 100);
	Dice larger = new Dice(200,400,250);

	g2.setColor(Color.MAGENTA);     g2.draw(smaller);
	g2.setColor(Color.BLUE);   g2.draw(larger);


    }


}
