package edu.ucsb.cs56.w15.drawings.ecarnohan.advanced;
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
import java.awt.geom.Ellipse2D; //ellipses and circles

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A Turtle
      
   @author Erica Carnohan 
   @version for CS56, W15, UCSB, 02/09/2015
   
*/
public class TurtleWithDetails extends Turtle implements Shape
{
    /**
     * Constructor for objects of class TurtleWithDetails
     */
    public TurtleWithDetails(double x, double y, double length, double width)
    {
	// construct the basic turtle
	super(x,y,length,width);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make inner circle for shell

	double innerX = x + length/10;
	double innerY = y + width/10;
	double innerLength = length*0.8;
	double innerWidth = width*0.8;

	Ellipse2D.Double shell =
	    new Ellipse2D.Double(innerX, innerY, innerLength, innerWidth);
	
	// make tail
	Line2D.Double tail1 = 
	    new Line2D.Double(x, y + width/2.3,
			      x - length/12.0, y + width/2.0);
	
	Line2D.Double tail2 = 
	    new Line2D.Double(x - length/12.0, y + width/2.0,
			      x, y + width/1.7);
	

	// add the shell to the turtle
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeTurtle = this.get();
        wholeTurtle.append(shell, false); 
	wholeTurtle.append(tail1, false);
	wholeTurtle.append(tail2, false);
    }

}
