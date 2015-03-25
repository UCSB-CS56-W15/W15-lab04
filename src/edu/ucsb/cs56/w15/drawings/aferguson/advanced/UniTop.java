package edu.ucsb.cs56.w15.drawings.aferguson.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   Top of the Unicycle (for animation purposes)
      
   @author Andrew Ferguson
   @version for CS56, W15, UCSB, 02/19/2015
   
*/
public class UniTop extends GeneralPathWrapper implements Shape
{
    /**
     * Constructor for objects of class Unicycle
     */
    public UniTop(double x, double y, double r)
    {
	
	Rectangle2D.Double post =
	    new Rectangle2D.Double(x+r-r/12, y-r*2, r/6, r*3);

	Ellipse2D.Double seat = 
	    new Ellipse2D.Double(x+r-r/2, y-r*2-r/6, r, r/6);


	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeUniTop = this.get();
        wholeUniTop.append(post, false);
	wholeUniTop.append(seat, false);
    }

}
