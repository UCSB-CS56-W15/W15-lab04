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
   A Grandfather Clock
      
   @author Omeed Rabani
   @version for CS56, W15, UCSB
   
*/
public class GrandfatherClock extends Clock implements Shape
{
    /**
       Constructor
       @param x x cord for the top left corner of the drawing
       @param y y cord for the top left corner of the drawing
       @param h height of the GrandfatherClock (width is equal to 1/4 of the height)
     */
    public GrandfatherClock(double x, double y, double h)
    {
	// Construct the basic clock
	super(x + 0.5*(0.25*h), y + 0.2*h, 0.5 * (0.5 * (0.25*h)));
	// Width will be equal to 1/4 of the height.
	double w = 0.25 * h;

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	Line2D.Double topLeftOfPediment = new Line2D.Double( x, y + 0.1*h, x + 0.5*w, y);
	Line2D.Double topRightOfPediment = new Line2D.Double( x + w, y + 0.1*h, x + 0.5*w, y);
	Rectangle2D.Double topRectangle =
	    new Rectangle2D.Double( x, y + 0.1*h, w, 0.2 * h);
	Rectangle2D.Double middleRectangle =
	    new Rectangle2D.Double( x + 0.2*w, y + 0.3*h, 0.6*w, 0.5 * h);
	Rectangle2D.Double bottomRectangle =
	    new Rectangle2D.Double( x, y + 0.8*h, w, 0.2 * h);
	
	// Add the rest of the shapes to the GrandfatherClock
	gp.append(topLeftOfPediment, false);
	gp.append(topRightOfPediment, false);
	gp.append(topRectangle, false);
	gp.append(middleRectangle, false);
	gp.append(bottomRectangle, false);

    }

}
