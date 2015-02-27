package edu.ucsb.cs56.w15.drawings.shayan.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A DDR Arrow (wrapper around a General Path, implements Shape)

   @author Shayan Sadigh
   @version for CS56, W14, UCSB, W15
   
*/
public class DDRArrow extends GeneralPathWrapper implements Shape
{

    
    /**
     * Constructor for objects of class DDRArrow
	 * @param x the total horizontal and vertical length of the arrow
     */
    public DDRArrow(double x)
    {
                
        GeneralPath arrow = new GeneralPath();

		double halfLength = x/2;
       
        arrow.moveTo(halfLength,0);
        arrow.lineTo(0,halfLength);
        arrow.lineTo(x, halfLength);
        arrow.lineTo(halfLength, 0);
        arrow.moveTo(halfLength/2,halfLength);
		arrow.lineTo(halfLength/2, x);
		arrow.lineTo(3*halfLength/2,x);
		arrow.lineTo(3*halfLength/2,halfLength);
        

	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cup
        
	this.set(new GeneralPath(arrow));
        
    }

}
