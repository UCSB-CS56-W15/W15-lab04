package edu.ucsb.cs56.w15.drawings.steventedsen.advanced;
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
   A Christmas Tree with Ornaments
      
   @author Steven Tedsen
   @version for CS56, W15, UCSB, 02/12/2015
   
*/
public class TreeWithOrnaments extends Tree implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public TreeWithOrnaments(double x, double y, double width, double height)
    {
	// construct the basic tree shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	


	double w = 0.05 * width;
	double winTop = y + 0.5 * height;
	double winHt =  0.10 * height;

	Rectangle2D.Double orn1 =
	    new Rectangle2D.Double(x - .1*width, winTop, 2.0 * w, winHt);
	Rectangle2D.Double orn2 =
	    new Rectangle2D.Double(x + .05*width, winTop - .25*height, 2.0 * w, winHt);
	Rectangle2D.Double orn3 =
	    new Rectangle2D.Double(x + .2*width, winTop, 2.0 * w, winHt);
       
	// add the ornaments to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeHouse = this.get();
        wholeHouse.append(orn1, false);
        wholeHouse.append(orn2, false);
        wholeHouse.append(orn3, false); 
    }

}
