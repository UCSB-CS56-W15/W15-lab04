package edu.ucsb.cs56.w15.drawings.brandonwicka.advanced;
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
   A vector drawing of a spoon that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.

   @author Brandon Wicka
   @version for CS56, Winter 15, UCSB

*/
public class Spoon extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param length length of the entire spoon
       @param width  width of the spoon
       @param x x-coordinate of starting location
       @param y y-coordinate of starting location
    */
    public Spoon(double length, double width, double x, double y)
    {

        double handleLength = .70 * length;
        double circleLength = length - handleLength;

        double circleWidth = width;


	Rectangle2D.Double handle = 
	    new Rectangle2D.Double(x, y + handleLength , width * 0.3, handleLength);

	Ellipse2D.Double circlePart =
	    new Ellipse2D.Double(x - 0.35 * width, y + circleLength * 1.35, width, circleLength); 


        // put the utensil together

        GeneralPath wholeSpoon = this.get();
        wholeSpoon.append(handle, false);
        wholeSpoon.append(circlePart, false);

    }

}






