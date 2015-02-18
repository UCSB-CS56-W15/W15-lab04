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
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @version for CS56, Winter 11, UCSB
   
*/
public class Clock extends GeneralPathWrapper implements Shape {
    public Clock(double radius)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double faceRadius = radius;
        double minHandLength = radius * 0.8;
	double hrHandLength = radius * 0.5;        

        Ellipse2D clockFrame = new Ellipse2D.Double(0,0,radius,radius);                          
        // Make minute and hour hands.

        // put the whole clock together
        GeneralPath wholeClock = this.get();
        wholeClock.append(clockFrame, false);
    }

}
