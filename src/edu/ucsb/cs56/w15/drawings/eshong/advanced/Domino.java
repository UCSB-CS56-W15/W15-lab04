package edu.ucsb.cs56.w15.drawings.eshong.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a domino that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Elliott S Hong
   @version for CS56, Winter 15, UCSB
   
*/
public class Domino extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of domino
       @param y y coord of lower left corner of domino
       @param width width of the domino
       @param height of domino (including first story and second story)
     */
    public Domino(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.        

	// Make a blank (0:0) domino
	Rectangle2D.Double domino = new Rectangle2D.Double(x, y, width, height);

	// Make the dividing line
	Line2D.Double divide = new Line2D.Double(x + 0.15 * width, y + (height / 2.0), x + 0.85 * width, y + (height / 2.0));

        // Remember that y goes DOWN the page, so we ADD
        // to y to get a "lower" value on the screen

        // put the whole domino together
       
        GeneralPath wholedomino = this.get();
        wholedomino.append(domino, false);
        wholedomino.append(divide, false);
    }
}
