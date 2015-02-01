package edu.ucsb.cs56.w15.drawings.tngo.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.RectangularShape;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a fish that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Tamky Ngo 
   @version for CS56, Winter 15, UCSB
   
*/
public class Fish extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of upper left corner for Ellipse constructor
       @param y y coord of lower left corner for Ellipse constructor
       @param width width of the body of the fish
       @param height height of the body of the fish
     */
    public Fish(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
	Ellipse2D.Double fishBody = new Ellipse2D.Double(x,y,width,height);
        
        double startOfTailx = x + width;
        double startOfTaily = y + height/2;
                          
        // make the tail.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        Line2D.Double topOfTail = 
            new Line2D.Double (startOfTailx, startOfTaily,
                               startOfTailx + width/2.0, startOfTaily-height/2.0);
                               
        Line2D.Double sideOfTail =
            new Line2D.Double (startOfTailx + width/2.0, startOfTaily-height/2.0,
                               startOfTailx + width/2.0, startOfTaily + height/2.0);

	Line2D.Double bottomOfTail =
	    new Line2D.Double (startOfTailx + width/2.0, startOfTaily + height/2.0,
			       startOfTailx, startOfTaily);

        // put the whole fish together
       
        GeneralPath wholeFish = this.get();
        wholeFish.append(fishBody, false);
        wholeFish.append(topOfTail, false);
        wholeFish.append(sideOfTail, false); 
        wholeFish.append(bottomOfTail, false);
    }

}
