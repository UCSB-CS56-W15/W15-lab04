package edu.ucsb.cs56.w15.drawings.sxh19911230.advanced;
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
import java.awt.geom.RoundRectangle2D;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A Pencil With Eraser
      
   @author Xianghong Sun
   @version for CS56, W15, UCSB
   
*/
public class PencilWithEraser extends Pencil implements Shape
{
    /**
     * Constructor for objects of class PencilWithEraser
     */
    public PencilWithEraser(double x, double y, double size)
    {
	// construct the basic Pencil
	super(x,y,size);
	
	
	double width = 0.05 * size;
	double height = size - 2.5 * width;
	double topEraser = size;

	RoundRectangle2D.Double eraiser =
	    new RoundRectangle2D.Double(x , y + topEraser, width, 0.1 * height, 0.1* width, 0.025* height);
	
	

        GeneralPath wholeHouse = this.get();
        wholeHouse.append(eraiser, false);

    }

}
