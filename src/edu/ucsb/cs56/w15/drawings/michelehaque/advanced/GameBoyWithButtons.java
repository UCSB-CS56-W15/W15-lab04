package edu.ucsb.cs56.w15.drawings.michelehaque.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a GameBoy that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Michele Haque
   @version for CS56, Winter 15, UCSB
   
*/
public class GameBoyWithButtons extends GameBoy implements Shape
{
    /**
       Constructor

       @param x x coord of upper left corner of GameBoy
       @param y y coord of upper left corner of GameBoy
       @param width width of the GameBoy
       @param height of GameBoy
     */
    public GameBoy(double x, double y, double width, double height)
    {
        // construct the basic GameBoy shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	// Need to add control pad, which can just be two filled in rectangles
	Rectangle2D.Double upDown = new Rectangle2D.Double(x,y,width,height);
	Rectangle2D.Double leftRight = new Rectangle2D.Double(x,y,width,height);
	
	// Need to add "A" and "B" buttons, which are filled in circles
	Ellipse2D.Double a = new Ellipse2D.Double(x, y, 3, 3);
	Ellipse2D.Double b = new Ellipse2D.Double(x, y, 3, 3);


    }

}
