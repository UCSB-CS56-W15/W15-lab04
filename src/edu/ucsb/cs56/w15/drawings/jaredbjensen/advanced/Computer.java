package edu.ucsb.cs56.w15.drawings.jaredbjensen.advanced;
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
   A vector drawing of a computer that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Jared Jensen 
   @version for CS56, Winter 15, UCSB
   
*/
public class Computer extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of screen
       @param y y coord of lower left corner of screen
       @param width width of the screen
       @param height of screen
     */
    public Computer(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        
        Rectangle2D.Double screen = 
            new Rectangle2D.Double(x, y - height,
                          width, height);
                          

        
        Rectangle2D.Double innerScreen = 
            new Rectangle2D.Double (x + width/14, y - height + height/14,
                               width*.85, height*.85);
                               

       
        GeneralPath wholeComputer = this.get();
        wholeComputer.append(screen, false);
        wholeComputer.append(innerScreen, false);
        
        
    }

}
