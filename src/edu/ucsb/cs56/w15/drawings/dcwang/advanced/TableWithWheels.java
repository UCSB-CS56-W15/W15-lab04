package edu.ucsb.cs56.w15.drawings.dcwang.advanced;
import java.awt.geom.*;
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
   A Table with wheels
      
   @author Derek Wang 
   @version for CS56, W15, UCSB, 02/23/2011
   
*/
public class TableWithWheels extends Table implements Shape
{
    /**
     * Constructor for objects of class TableWithWheels
     */
    public TableWithWheels(double x, double y, double width, double length)
    {
	// construct the basic table shell
	super(x,y,width,length);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make wheels
	double wheelRadius = (width+length)/20;
	double legLength = (width+length)/2;

	Ellipse2D.Double wheel1 =
	    new Ellipse2D.Double(x-wheelRadius/2,y+legLength, wheelRadius, wheelRadius);
       	Ellipse2D.Double wheel2 =
	    new Ellipse2D.Double(x+width-wheelRadius/2,y-width+legLength, wheelRadius, wheelRadius);
	Ellipse2D.Double wheel3 =
	    new Ellipse2D.Double(x+length-wheelRadius/2,y+legLength, wheelRadius, wheelRadius);
	Ellipse2D.Double wheel4 =
	    new Ellipse2D.Double(x+width+length-wheelRadius/2,y-width+legLength, wheelRadius, wheelRadius);
	
	// add the wheels to the table
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeTable = this.get();
        wholeTable.append(wheel1, false);
	wholeTable.append(wheel2, false);
	wholeTable.append(wheel3, false);
	wholeTable.append(wheel4, false);
    }

}
