package edu.ucsb.cs56.w15.drawings.stp.advanced;

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
 * @author Spencer Prescott
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few Scooters
     */

    public static void drawPicture1(Graphics2D g2) {

    	Scooter s1 = new Scooter(10,200,50,70, 20);
    	g2.setColor(Color.CYAN);
      g2.draw(s1);

    	//Make a black Scooter that's half the size,
    	//and moved over 150 pixels in x direction

    	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
    	s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
    	g2.setColor(Color.BLACK);
      g2.draw(s2);

    	// Here's a Scooter that's 4x as big (2x the original)
    	// and moved over 100px to the right and 20px down.
    	s2 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
    	s2 = ShapeTransforms.translatedCopyOf(s2,100,20);

    	// We'll draw this with a thicker stroke
    	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);


    	Stroke orig=g2.getStroke();
    	g2.setStroke(thick);
    	g2.setColor(new Color(0x9999FF));
    	g2.draw(s2);



    	ScooterWithBasket sb1 = new ScooterWithBasket(50,350,40,50, 10, 10, 10);
      ScooterWithBasket sb2 = new ScooterWithBasket(200,350,200,300, 100, 40, 40);

    	g2.draw(sb1);
    	g2.setColor(new Color(0x8F00FF)); g2.draw(sb2);


    	g2.setStroke(orig);
    	g2.setColor(Color.BLACK);
    	g2.drawString("Some scooters by Spencer Prescott", 20,20);
    }


    /** Draw a picture with a Scooter variations
     */
    public static void drawPicture2(Graphics2D g2) {

    	// Draw some scooters.

    	Scooter large = new Scooter(200,180,130,150,60);
      Scooter small = new Scooter(20,230,40,50,10);

    	g2.setColor(Color.RED);     g2.draw(large);
    	g2.setColor(Color.GREEN);   g2.draw(small);

    	ScooterWithBasket sb1 = new ScooterWithBasket(100,250,50,75,20,20,20);
    	g2.setColor(Color.PINK); g2.draw(sb1);

    	Shape sb2 = ShapeTransforms.scaledCopyOfLL(sb1,0.5,0.5);
    	sb2 = ShapeTransforms.translatedCopyOf(sb2,150,0);
    	g2.setColor(Color.BLACK);
      g2.draw(sb2);

    	// Here's a Scooter with a basket that's 4x as big (2x the original)
    	// and moved over 150 more pixels to right.
    	sb2 = ShapeTransforms.scaledCopyOfLL(sb2,4,4);
    	sb2 = ShapeTransforms.translatedCopyOf(sb2,150,0);

    	// We'll draw this with a thicker stroke
    	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);


    	Stroke orig=g2.getStroke();
    	g2.setStroke(thick);
    	g2.setColor(new Color(0x00FF00));
    	g2.draw(sb2);

    	// Draw two Scooters with baskets

    	ScooterWithBasket sb3 = new ScooterWithBasket(50,350,40,75,10,10,10);
      ScooterWithBasket sb4 = new ScooterWithBasket(200,350,100,125,40,20,20);

    	g2.draw(sb3);
    	g2.setColor(new Color(0xFF9900));

    	// Rotate the second Scooter 45 degrees around its center.
    	Shape sb5 = ShapeTransforms.rotatedCopyOf(sb4, Math.PI/4.0);

    	g2.draw(sb5);


    	g2.setStroke(orig);
    	g2.setColor(Color.BLACK);
    	g2.drawString("A lot of scooter variations drawn by Spencer Prescott", 20,20);
    }

    /** Draw a different picture with a couple Scooters
     */

    public static void drawPicture3(Graphics2D g2) {

      // label the drawing

      g2.drawString("A bunch of Scooters by Spencer Prescott", 20,20);


      // Draw some scooters.

      Scooter large = new Scooter(100,50,225,275,130);
      Scooter small = new Scooter(20,50,20,40,5);

      g2.setColor(Color.PINK);     g2.draw(large);
      g2.setColor(Color.ORANGE);   g2.draw(small);

    }


}
