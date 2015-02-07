package edu.ucsb.cs56.w15.drawings.omeedrabani.advanced;
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
   A vector drawing of a clock that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Omeed Rabani 
   @version for CS56, W15, UCSB
   
*/
public class Clock extends GeneralPathWrapper implements Shape
{

    /** 
	Constructor
	@param x x coord of the center of the clock
	@param y y coord of the center of the clock
	@param r radius of the clock
     */

    public Clock(double x, double y, double r)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
  
	// Draw the outer circumference  of the Clock

	Ellipse2D.Double outerCircumference = new Ellipse2D.Double( x - r, y - r, r, r);
      
	// Draw minute and hour hand. The time will always say it is 12:15.
	Line2D.Double minuteHand = new Line2D.Double( x, y, x + .75*r, y );
	Line2D.Double hourHand = new Line2D.Double( x, y, x, y - .5 * r );
	
        // put the whole clock together
       
        GeneralPath wholeClock = this.get();
        wholeHouse.append(outerCircumference, false);
        wholeHouse.append(minuteHand, false);
        wholeHouse.append(hourHand, false); 
        
    }

}
