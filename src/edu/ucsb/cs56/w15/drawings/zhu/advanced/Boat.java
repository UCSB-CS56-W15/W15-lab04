package edu.ucsb.cs56.w15.drawings.zhu.advanced;
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
   A vector drawing of a boat that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Yuxiang Zhu 
   @version for CS56, Winter 15, UCSB
   
*/
public class Boat extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of Boat
       @param y y coord of lower left corner of Boat
       @param width width of the boat
       @param height of boat 
    */
    public Boat(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double topHeight = .4 * height;
	double topWidth = .4 *width;

        double bottomHeight = .6 * height;
	double bottomDownWidth = 0.7 * width;

        
        // Make the Top Rect
        
        Rectangle2D.Double topRect = 
            new Rectangle2D.Double(x + width/2, y - height, topWidth, topHeight);
                          
        // make the bottom part.   

        
        Line2D.Double leftPart = 
            new Line2D.Double (x, y - bottomHeight,
                               x + 0.2 * width, y);
                               
        Line2D.Double bottomLine =
            new Line2D.Double (x + 0.2 * width, y,
                               x + 0.2 * width + bottomDownWidth, y);

	Line2D.Double rightPart = 
	    new Line2D.Double (x + 0.2 * width + bottomDownWidth, y,
			       x + width, y - bottomHeight);
	
	Line2D.Double topLine = 
	    new Line2D.Double (x + width, y - bottomHeight,
			       x, y - bottomHeight);


        // put the whole boat together
       
        GeneralPath wholeBoat = this.get();
        wholeBoat.append(topRect, false);
        wholeBoat.append(leftPart, false);
        wholeBoat.append(bottomLine, false);
	wholeBoat.append(rightPart, false);
	wholeBoat.append(topLine, false);
        
    }

}
