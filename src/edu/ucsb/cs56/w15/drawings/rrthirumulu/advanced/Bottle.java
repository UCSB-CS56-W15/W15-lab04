package edu.ucsb.cs56.w15.drawings.rrthirumulu.advanced;
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
   A vector drawing of a bottle that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Raghav Raju 
   @version for CS56, W15, UCSB
   
*/
public class Bottle extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of bottle
       @param y y coord of lower left corner of bottle
       @param width width of the bottle
       @param height of bottle (including base and neck)
     */
    public Bottle(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double baseHeight = .67 * height;
        double neckHeight = height - baseHeight;
	double neckWidth = .5 * width;
        
        double baseUpperLeftY = y + baseHeight;
	double neckBottomLeftX = x + (0.25 * width);
	
        
       	Line2D.Double leftSide = 
            new Line2D.Double (x, y,
                               x, y - baseHeight);
                               
        Line2D.Double leftSideToNeck =
            new Line2D.Double (x, y - baseHeight,
                               x - (0.25 * width), y - baseHeight);

	Line2D.Double leftNeckToTop =
	    new Line2D.Double (x - (0.25 * width), y - baseHeight,
			       x - (0.25 * width), y - height);

	Line2D.Double leftTopToRightTop =
	    new Line2D.Double (x - (0.25 * width), y - height,
			       x - (0.75 * width), y - height);

	Line2D.Double rightTopToNeck =
	    new Line2D.Double (x - (0.75 * width), y - height,
			       x - (0.75 * width), y - baseHeight);

	Line2D.Double rightNeckToSide =
	    new Line2D.Double (x - (0.75 * width), y - baseHeight,
			       x - width, y - baseHeight);

	Line2D.Double rightSide =
	    new Line2D.Double (x - width, y - baseHeight,
			       x - width, y);

	Line2D.Double base =
	    new Line2D.Double (x - width, y,
		               x, y);


        // put the whole bottle together
       
        GeneralPath wholeBottle = this.get();
        wholeBottle.append(leftSide, false);
        wholeBottle.append(leftSideToNeck, false);
        wholeBottle.append(leftNeckToTop, false);
	wholeBottle.append(leftTopToRightTop, false);
        wholeBottle.append(rightTopToNeck, false);
        wholeBottle.append(rightNeckToSide, false);
        wholeBottle.append(rightSide, false);
        wholeBottle.append(base, false); 
        
    }

}
