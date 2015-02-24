package edu.ucsb.cs56.w15.drawings.shadeebarzin.advanced;

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
 * @author Shadee Barzin
 * @version for CS56, lab04, W15, UCSB
 */


public class AllMyDrawings {
    /** Draw a picture with flowers
     */
    public static void drawPicture1(Graphics2D g2) {
	// Make an orange flower centered at (500,500) w/diameter 300
	Flower f1 = new Flower(500,500,300);
	g2.setColor(Color.ORANGE);
	g2.draw(f1);
	
	// Make a black flower that's half the size,
	// and moved over 200 pixels left and 20 pixels up
	Shape f2 = ShapeTransforms.scaledCopyOfLL(f1,0.5,0.5);
	f2 = ShapeTransforms.translatedCopyOf(f2,-200,-20);
	g2.setColor(Color.BLACK);
	g2.draw(f2);
	
	// Make a flower that's 4x as big (2x the original)
	// and moved over 250 more pixels to left and 80 pixels up
	f2 = ShapeTransforms.scaledCopyOfLL(f2,4,4);
	f2 = ShapeTransforms.translatedCopyOf(f2,-250,-80);
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	Stroke orig = g2.getStroke();
	g2.setStroke(thick);
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// In HTML we use #, but in Java (and C/C++) its 0x
	// set the color to light pink
	g2.setColor(new Color(0xFFCCCC));
	g2.draw(f2); 
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Flowers by Shadee Barzin", 20,20);
    }


    /** Draw a picture with a few flowers with stems
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw two flowers with stems
	FlowerWithStem fs1 = new FlowerWithStem(600,200,200);
	g2.setColor(new Color(0x9CDEFF));
	g2.draw(fs1);

	FlowerWithStem fs2 = new FlowerWithStem(100,100,300);
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	g2.setStroke(thick);
	Stroke orig = g2.getStroke();
	g2.setColor(new Color(0xA3A3FF));
	g2.draw(fs2);

	// Make a flower that's half as big as the 2nd one
	// and moved over 300 pixels right and 100 pixels up
	Shape fs3 = ShapeTransforms.scaledCopyOfLL(fs2,.5,.5);
	fs3 = ShapeTransforms.translatedCopyOf(fs3,300,100);
	g2.setColor(new Color(0xFFA347));
	g2.draw(fs3);

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Flowers by Shadee Barzin", 20,20);
    }
  

    /** Draw a picture with a few flowers and flowers with stems
     */
    public static void drawPicture3(Graphics2D g2) {

	Stroke orig = g2.getStroke();
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

	// Make a cyan flower centered at (400,400) w/diameter 400
	Flower f1 = new Flower(400,400,400);
	g2.setColor(Color.CYAN);
	g2.draw(f1);

	// Make a flower that's half as big as the 2nd one
	// and moved over 300 pixels left and 500 pixels up
	Shape f2 = ShapeTransforms.scaledCopyOfLL(f1,.5,.5);
	f2 = ShapeTransforms.translatedCopyOf(f2,-300,-500);
	g2.setStroke(thick);
	g2.setColor(new Color(0xFFA347));
	g2.draw(f2);

	// Make a pink flower with stem centered at (600,200) w/diameter 200
	FlowerWithStem fs1 = new FlowerWithStem(600,50,200);
	g2.setColor(new Color(0xFF0066));
	g2.draw(fs1);

	// Make a flower with stem that's 1.5 times as big the 2nd one
	// and moved over 450 pixels left and 350 pixels down
	Shape fs2 = ShapeTransforms.scaledCopyOfLL(fs1,1.5,1.5);
	fs2 = ShapeTransforms.translatedCopyOf(fs2,-450,350);
	g2.setStroke(orig);
	g2.setColor(new Color(0xFFCC00));
	g2.draw(fs2);

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Flowers by Shadee Barzin", 20,20);
    }
    
}
