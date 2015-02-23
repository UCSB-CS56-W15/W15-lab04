package edu.ucsb.cs56.w15.drawings.eshong.advanced;
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
   A DominoPiece
      
   @author Elliott S Hong
   @version for CS56, W15, UCSB, 02/19/2015
   
*/

public class DominoPiece extends Domino implements Shape
{


    /**
     * Circle class for use for making Domino Dots
     */

    public class Circle extends java.awt.geom.Ellipse2D.Double implements java.awt.Shape
    {
	/**
	 * Constructor for objects of class Circle
	 * @param x    x coordinate of center of circle
	 * @param y    y coordinate of center of circle
	 * @param r    radius of circle
	 */
	public Circle(double x, double y, double r)
	{
	    // invoke the super class constructor,
	    // i.e. the one for Ellipse2D.Double, which takes
	    // upper-left-x, upper-left,y (of the bounding box)
	    // width, and height

	    super( x - r, y - r,  /* upper left corner of bounding box */
		   r * 2, r * 2); /* width and height are double the radius */
	}
    }

    /**
     * Constructor for objects of class DominoPiece
     */
    public DominoPiece(double x, double y, double width, double height)
    {
	// construct the basic DominoPiece shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make circles
	// Top part (a)

	// one circle
	Circle one = new Circle(x+(width/2.0),y+(height/4.0),width/8);

	Circle twoA = new Circle(x+(width/3.0),y+((height/2)*0.66),width/8);
	Circle twoB = new Circle(x+2*(width/3.0),y+((height/2)*0.33),width/8);

	Circle threeA = new Circle(x+(width/2.0),y+(height/4.0),width/8);
	Circle threeB = new Circle(x+(width/3.0),y+((height/2)*0.66),width/8);
	Circle threeC = new Circle(x+2*(width/3.0),y+((height/2)*0.33),width/8);

	GeneralPath wholeDomino = this.get();
	


    }

}
