package edu.ucsb.cs56.w15.drawings.jazariethach.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;  // ellipses and circles 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A Sun with glasses
      
   @author Phill Conrad 
   @author Jazarie Thach
   @version for CS56, W15, UCSB, 02/12/2015
   
*/
public class SunWithGlasses extends Sun implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public SunWithGlasses(double x, double y, double r, double r2)
    {
	// construct the basic sun shell
	super(x,y,r,r2);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// make rectangles to draw glasses on the sun
	
	double w = 0.30 * r;
	double winTop = y - .25*r;
	double winHt =   .45 * r;


	Rectangle2D.Double win1 =
	    new Rectangle2D.Double(x + .55*w, winTop, 2.5 * w, winHt);
	Rectangle2D.Double win2 =
	    new Rectangle2D.Double(x - 3.0*w, winTop, 2.5 * w, winHt);
	Rectangle2D.Double win3 =
	    new Rectangle2D.Double(x- .75*w, winTop, 2.0 * w, 0);
	
	// add the glasses to the sun

	  GeneralPath wholeSun = this.get();
	   wholeSun.append(win1, false);
	   wholeSun.append(win2, false);
	   wholeSun.append(win3, false); 
    }

}
