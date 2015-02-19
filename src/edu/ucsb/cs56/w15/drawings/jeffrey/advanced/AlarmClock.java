package edu.ucsb.cs56.w15.drawings.jeffrey.advanced;
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
import java.awt.geom.Arc2D;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   An Alarm Clock
      
   @author Jeffrey Chen
   @version for CS56, W15, UCSB, 02/18/2015
   
*/
public class AlarmClock extends Clock implements Shape
{
    /**
     * Constructor for objects of class AlarmClock
     @param x x coordinate of top-left rectangular corner.
     @param y y coordinate of top-left rectangular corner.
     @param radius radius of clock frame.
     */
    public AlarmClock(double x, double y, double radius) {
		// construct the basic Clock shell
		super(x,y,radius);

		// x,y coordinates for center of clock
		double xOrigin = x+radius;
		double yOrigin = y+radius;

		// Add alarm bells to the clock
		Arc2D.Double leftBell = new 
			Arc2D.Double(x, y-radius*0.2, radius*0.8, radius*0.8,
				30, 195, Arc2D.OPEN);
		Arc2D.Double rightBell = new 
			Arc2D.Double(x+(radius*1.2), y-radius*0.2,
				radius*0.8, radius*0.8, 315, 195, Arc2D.OPEN);

		// Add alarm hammer
		Line2D.Double hammerStem = new
			Line2D.Double(xOrigin, y, xOrigin, y-radius/5);

		Line2D.Double hammerHead = new
			Line2D.Double(xOrigin-(radius/10), y-radius/5,
				xOrigin+(radius/10), y-radius/5);

		// Add alarm clock legs
		Line2D.Double leftLeg = new
			Line2D.Double(x, y+radius*2.1, x+(radius*.3), y+radius*1.75);

		Line2D.Double rightLeg = new
			Line2D.Double(x+radius*2, y+radius*2.1,
				(x+radius*1.7), y+radius*1.75);
	
		// Put together the alarm clock
		GeneralPath wholeClock = this.get();
		wholeClock.append(leftBell, false);
		wholeClock.append(rightBell, false);
		wholeClock.append(hammerStem, false);
		wholeClock.append(hammerHead, false);
		wholeClock.append(leftLeg, false); 
		wholeClock.append(rightLeg, false);
    }

}
