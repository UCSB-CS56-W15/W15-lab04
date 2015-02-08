package edu.ucsb.cs56.w15.drawings.nikolas_chaconas.advanced;

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
 * @author Nikolas Chaconas 
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {
	
	//Create a Cyan balloon House
	BalloonsTiedToHouse b1 = new BalloonsTiedToHouse(200,100,2,200,250);
	g2.setColor(Color.BLUE); 
	g2.draw(b1);
	g2.setColor(Color.RED);
	g2.draw(new Balloons(500,100,2,200,250));
	g2.setColor(Color.GREEN);
	g2.draw(new Balloons(500,250,1,500,400));
	g2.setColor(Color.ORANGE);
	g2.drawString("A balloon house and a few extra bundles of balloons by Nick Chaconas",20,20);

    }


    /** Draw a picture with a few balloons and balloon houses scaled
     */
    public static void drawPicture2(Graphics2D g2) {

	//Draw some Balloons and Balloon Houses
	
	BalloonsTiedToHouse b1 = new BalloonsTiedToHouse(200,100,2,200,250);
	//draw a magenta houseballoon that is upside down.
	g2.setColor(Color.MAGENTA);
	Shape h = ShapeTransforms.rotatedCopyOf(b1,Math.PI);
	g2.draw(h);

	//draw two bunches of balloons that are tied to each other, one is upside down
	//first balloon
	g2.setColor(Color.GREEN);
	Balloons b2 = new Balloons(450,100,1,450,200);
	g2.draw(b2);
	
	//second balloon
	g2.setColor(Color.RED);
	Balloons b3 = new Balloons(450,200,1,450,300);
	h = ShapeTransforms.rotatedCopyOf(b3,Math.PI);
	g2.draw(h);

	//make small BalloonsTiedToHouse and rotate it and translate it
	g2.setColor(Color.BLACK);
	
	BalloonsTiedToHouse b4 = new BalloonsTiedToHouse(200,100,5,200,250);
	h = ShapeTransforms.rotatedCopyOf(b4,Math.PI/4.0);
	h = ShapeTransforms.translatedCopyOf(h,450,300);
	h = ShapeTransforms.scaledCopyOf(h,.1,.1);	
	g2.draw(h);

	//@@@ SIGN AND LABEL YOUR DRAWING
	
	g2.setColor(Color.BLACK);
	g2.drawString("Two balloon houses and two balloon bunches by Nikolas Chaconas", 20,20);


	//make fat balloons which are black
	Balloons b5 = new Balloons(440,340,1,440,420);
	h = ShapeTransforms.rotatedCopyOf(b5,Math.PI/2.0);
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 
	g2.setStroke(thick);
	g2.draw(h);


    }
  
    /** Draw a different picture that has balloon houses rotating 45degrees each time and 
	cycling through the colors of the rainbow.
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A rotating rainbow array of balloon houses by Nick Chaconas", 20,20);
	BalloonsTiedToHouse b2 = new BalloonsTiedToHouse(100,100,1,100,200);


	g2.setColor(Color.RED);
	g2.draw(b2);


	g2.setColor(Color.ORANGE);
	Shape h = ShapeTransforms.rotatedCopyOf(b2,Math.PI/2.0);
	h = ShapeTransforms.translatedCopyOf(h,200,0);
	g2.draw(h);

	g2.setColor(Color.YELLOW);
	h = ShapeTransforms.rotatedCopyOf(h,Math.PI/2.0);
	h = ShapeTransforms.translatedCopyOf(h,200,0);
	g2.draw(h);

	g2.setColor(Color.GREEN);
	h = ShapeTransforms.rotatedCopyOf(h,Math.PI/2.0);
	h = ShapeTransforms.translatedCopyOf(h,-400,200);
	g2.draw(h);

	g2.setColor(Color.BLUE);
	h = ShapeTransforms.rotatedCopyOf(h,Math.PI/2.0);
	h = ShapeTransforms.translatedCopyOf(h, 200,0);
	g2.draw(h);

	g2.setColor(Color.MAGENTA);
	h = ShapeTransforms.rotatedCopyOf(h,Math.PI/2.0);
	h = ShapeTransforms.translatedCopyOf(h,200,0);
	g2.draw(h);
       
    }
    

}
