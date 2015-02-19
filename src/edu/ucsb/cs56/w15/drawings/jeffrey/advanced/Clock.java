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
import java.awt.geom.Ellipse2D;
import java.lang.Math;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a clock that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Jeffrey Chen 
   @version for CS56, Winter 15, UCSB
   
*/
public class Clock extends GeneralPathWrapper implements Shape {
    /**
     * Constructor for objects of class Clock
     * Parameters:
     *      Coordinates for upper-left rectangular corner.
     *      Radius of clock frame.
     */
    public Clock(double x, double y, double radius)
    {
        // x,y coordinates for center of clock
        double xOrigin = x+radius;
        double yOrigin = y+radius;

        // Make frame
        Ellipse2D clockFrame = new Ellipse2D.Double(x,y,radius*2,radius*2);  

        // Make minute and hour hands.
        Line2D.Double hrHand = new
            Line2D.Double(xOrigin, yOrigin,
                (xOrigin)-Math.cos(.585)*radius/2,
                (yOrigin)-Math.sin(.585)*radius/2);

        Line2D.Double minHand = new
            Line2D.Double(xOrigin, yOrigin,
                (xOrigin)+Math.cos(.838)*radius*0.8,
                (yOrigin)-Math.sin(.838)*radius*0.8);

        // Make time indices
        Line2D.Double twelve = new
            Line2D.Double(xOrigin, y+(radius*0.1),
                xOrigin, y+(radius*0.25));

        Line2D.Double three = new
            Line2D.Double(x+(radius*0.1), yOrigin,
                x+(radius*0.25), yOrigin);

        Line2D.Double six = new
            Line2D.Double(xOrigin, (y+radius*2)-(radius*0.1),
                xOrigin, (y+radius*2)-(radius*0.25));

        Line2D.Double nine = new
            Line2D.Double((x+radius*2)-(radius*0.1), yOrigin,
                (x+radius*2)-(radius*0.25), yOrigin);

        // put the whole clock together
        GeneralPath wholeClock = this.get();
        wholeClock.append(clockFrame, false);
        wholeClock.append(hrHand, false);
        wholeClock.append(minHand, false);
        wholeClock.append(twelve, false);
        wholeClock.append(three, false);
        wholeClock.append(six, false);
        wholeClock.append(nine, false);
    }

}
