package edu.ucsb.cs56.w15.drawings.sadykoff.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.lang.Math;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a pizza that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Boris Sadykoff 
   @version for CS56, Winter 15, UCSB
   
*/
public class Pizza extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of center of the pizza
       @param y y coord of center of the pizza
       @param radius radius of the pizza
     */
    public Pizza(double x, double y, double radius)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, radius  
        
        // Draw the pizza without slices yet
        
        Ellipse2D.Double thePizza = new Ellipse2D.Double(x-radius,y-radius,2.0*radius,2.0*radius);
                          
        //slic // so we ADD to y to get a "lower" value on the screen
        
        Line2D.Double firstSlice = 
            new Line2D.Double (x - radius, y,
                               x + radius, y);
                               
        Line2D.Double secondSlice =
            new Line2D.Double (x, y + radius,
                               x, y - radius);

	Line2D.Double thirdSlice =
            new Line2D.Double (x + radius * Math.cos(Math.toRadians(45)),
			       y + radius * Math.sin(Math.toRadians(45)),
                               x + radius * Math.cos(Math.toRadians(225)),
			       y + radius * Math.sin(Math.toRadians(225)));

	Line2D.Double fourthSlice =
            new Line2D.Double (x + radius * Math.cos(Math.toRadians(135)),
			       y + radius * Math.sin(Math.toRadians(135)),
                               x + radius * Math.cos(Math.toRadians(315)),
			       y + radius * Math.sin(Math.toRadians(315)));

		

        // put the whole pizza together
       
        GeneralPath wholePizza = this.get();
        wholePizza.append(thePizza, false);
        wholePizza.append(firstSlice, false);
        wholePizza.append(secondSlice, false);
        wholePizza.append(thirdSlice, false);
        wholePizza.append(fourthSlice, false);
    }

}
