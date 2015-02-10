package edu.ucsb.cs56.w15.drawings.connor00.advanced;

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
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    /** Draw a picture with a few stars 
     */

    public static void drawPicture1(Graphics2D g2) {

	ParabolicStar s1 = new ParabolicStar(200,200,400,400, 28);
	g2.setColor(Color.RED); g2.draw(s1);
	
	// Make a black star that's half the size, 
	// and moved over 250 pixels in x direction and up 250px

	Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
	s2 = ShapeTransforms.translatedCopyOf(s2,250,-250);
	g2.setColor(Color.BLACK); g2.draw(s2);
	
	// Here's a star that's 4x as big (2x the original)
	// and moved over 150 more pixels to right and a 465 pixels down.
	s2 = ShapeTransforms.scaledCopyOfLL(s2,4,4);
	s2 = ShapeTransforms.translatedCopyOf(s2,150,465);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(s2); 
	
	// Draw two houses with Windows
	
	ParabolicStarWithCenterLines sc1 = new ParabolicStarWithCenterLines(50,350,40,75, 2);
	ParabolicStarWithCenterLines sc2 = new ParabolicStarWithCenterLines(200,50,200,100, 2);
	
	g2.draw(sc1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(sc2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few parabolic stars created  by Connor Armbrust Mulcahey", 20,20);
    }


    /** Draw a picture with a special overlapping design using the stars
     */
    public static void drawPicture2(Graphics2D g2) {
	
	g2.drawString("A couple designs using parabolic stars by Connor Mulcahey", 20,20); 

	Stroke thick = new BasicStroke (1.6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	g2.setStroke(thick);

	Color goodGreen = new Color(0x009900);
	Color goodBlue = new Color(0x000099);
	Color goodYellow = new Color(0xEEDD00);

	ParabolicStar s1 = new ParabolicStar(100, 100, 600, 600, 18); 
	Shape s2 = ShapeTransforms.rotatedCopyOf(s1, Math.PI/8);
	Shape s3 = ShapeTransforms.rotatedCopyOf(s1, Math.PI/4);
	Shape s4 = ShapeTransforms.rotatedCopyOf(s1, 3*Math.PI/8);
	g2.setColor(Color.RED);     g2.draw(s1);
	g2.setColor(goodGreen);   g2.draw(s2);
	g2.setColor(goodYellow);    g2.draw(s3);
	g2.setColor(goodBlue); g2.draw(s4);


	ParabolicStarWithCenterLines sc1 = new ParabolicStarWithCenterLines(35, 35, 150, 150, 2); 
	Shape sc2 = ShapeTransforms.rotatedCopyOf(sc1, Math.PI/8);
	Shape sc3 = ShapeTransforms.rotatedCopyOf(sc1, Math.PI/4);
	Shape sc4 = ShapeTransforms.rotatedCopyOf(sc1, 3*Math.PI/8);
	g2.setColor(Color.RED);     g2.draw(sc1);
	g2.setColor(goodYellow);   g2.draw(sc2);
	g2.setColor(goodGreen);    g2.draw(sc3);
	g2.setColor(goodBlue);  g2.draw(sc4);

    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
        
	// Label the drawing
	g2.drawString("A design of parabolic stars with center lines by Connor Mulcahey", 20,20);       

	Color goodGreen = new Color(0x009900);
	Color goodBlue = new Color(0x000099);
	Color goodYellow = new Color(0xEEDD00);

       
	ParabolicStarWithCenterLines base = new ParabolicStarWithCenterLines(0, 0, 250, 250, 20);
	Shape baseRotated = ShapeTransforms.rotatedCopyOf(base, Math.PI/4.0);
	Shape s1 = ShapeTransforms.translatedCopyOf(baseRotated, 176, 9);
	Shape s2 = ShapeTransforms.translatedCopyOf(baseRotated, 0, 185);
	Shape s3 = ShapeTransforms.translatedCopyOf(baseRotated, 176, 360);
	Shape s4 = ShapeTransforms.translatedCopyOf(baseRotated, 352, 185);

	g2.setColor(Color.RED);     g2.draw(s1);
	g2.setColor(goodGreen);     g2.draw(s2);
	g2.setColor(goodYellow);    g2.draw(s3);
	g2.setColor(goodBlue);      g2.draw(s4);
	 

    }
    

}
