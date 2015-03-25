package edu.ucsb.cs56.w15.drawings.emorozova.advanced;
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
   A Striped Lighthouse
      
   @author Phill Conrad 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class StripedLighthouse extends Lighthouse implements Shape
{
    /**
     * Constructor for objects of class StripedLighthouse
     */
    public StripedLighthouse(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);
	
	// We want to draw 7 lines, so we need 7 equally spaced X-coords, 
	// and 7 equally spaced Y-coords

	 GeneralPath wholeHouse = this.get();

	double yCoordDiff = (.8 * height) / 7;
	double xCoordDiff = (.25 * width) / 14;

	double leftX = x;
	double leftY = y;
	double rightX = x + width;
	double rightY = y - yCoordDiff;

	for (int i = 0; i < 7; i++){
	    Line2D.Double newLine = 
		new Line2D.Double(leftX, leftY, rightX, rightY);
	    
	    wholeHouse.append(newLine, false);

	    leftX += xCoordDiff;
	    leftY -= yCoordDiff;
	    rightX -= xCoordDiff;
	    rightY -= yCoordDiff;
	}

    }

}
