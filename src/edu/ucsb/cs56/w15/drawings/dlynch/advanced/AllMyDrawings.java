package edu.ucsb.cs56.w15.drawings.dlynch.advanced;

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
 * A class with static methods for Kanye West's face
 * 
 * @author Phill Conrad 
 * @author Dylan Lynch (Kanye Westified the 3 methods)
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    /** 2 Normal Kanyes and 1 Angry Kanye of differing sizes
     */

    public static void drawPicture1(Graphics2D g2) {
	Shape kw1ANGRY = new KanyeWest(150,150,50,75);
	g2.setColor(Color.BLACK); g2.draw(kw1ANGRY);

	Shape kw2 = new KanyeWestAngry(150,250,100,125);
	g2.setColor(Color.BLUE); g2.draw(kw2);

	Shape kw2ANGRY = new KanyeWest(150,175,200,90);
	g2.setColor(Color.RED); g2.draw(kw2ANGRY);
	

	
	g2.setColor(Color.BLACK);
	g2.drawString("Kanye West made by Dylan Lynch", 20, 20);	
    }


    /** Multiple Kanye Wests of varying Size/Color (with and without aspect ratio)
     */
    public static void drawPicture2(Graphics2D g2) {

      	KanyeWest large = new KanyeWest(150,150,225,150);
	KanyeWest small = new KanyeWest(250,150,40,30);
	KanyeWest tallSkinny = new KanyeWest(350,150,20,40);
	KanyeWest shortFat = new KanyeWest(450,150,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	KanyeWest kw1 = new KanyeWest(100,300,50,75);
	g2.setColor(Color.CYAN); g2.draw(kw1);
	
	// Make a Kanye West that's half the size, 
	// and moved over 150 pixels in x direction
	Shape kw2 = ShapeTransforms.scaledCopyOfLL(kw1,0.5,0.5);
	kw2 = ShapeTransforms.translatedCopyOf(kw2,150,0);
	g2.setColor(Color.BLACK); g2.draw(kw2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	kw2 = ShapeTransforms.scaledCopyOfLL(kw2,4,4);
	kw2 = ShapeTransforms.translatedCopyOf(kw2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(kw2); 
	
	
	
	KanyeWestAngry kw1ANGRY = new KanyeWestAngry(50,100,40,75);
	KanyeWestAngry kw2ANGRY = new KanyeWestAngry(100,150,100,200);
	
	g2.draw(kw1ANGRY);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape kw3ANGRY = ShapeTransforms.rotatedCopyOf(kw2ANGRY, Math.PI/4.0);
	g2.draw(kw3ANGRY);
		
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Kanyes of different sizes by Dylan Lynch", 20,20);
    }
  
    /** Two Kanye Wests with changed aspect ratio
     */

    public static void drawPicture3(Graphics2D g2) {
	
       g2.drawString("Kanye West drawings by Dylan Lynch", 20,20);

       KanyeWest large = new KanyeWest(100,200,225,150);
       KanyeWest small = new KanyeWest(20,50,50,100);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(small);
       
       
    }
    

}
