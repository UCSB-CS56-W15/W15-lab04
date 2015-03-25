package edu.ucsb.cs56.w15.drawings.ralvarez.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   Creates a drawing of a Person with a cape
      
   @author Richard Alvarez 
   @version for CS56 02/12/15
   
*/
public class Superman extends Person implements Shape
{
    /**
     * Constructor for Superman

       @param x x coord of upper left corner of the drawing
       @param y y coord of upper left corner of the drawing
       @param width Widths of the box to draw in
       @param height Height of the box to draw in
     */
    public Superman(double x, double y, double width, double height)
    {
	// construct the person
	super(x,y,width,height, 1);


	double Jx =(x + width/2 ); //x coordinate of the neck joint
	double Jy =(y+width/3);      //y coordinate of the neck joint



	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
        Line2D.Double Lcape = 
            new Line2D.Double (Jx, Jy, x, y+.70*height);     


	Line2D.Double Rcape = 
            new Line2D.Double (Jx, Jy, x+width, y+.70*height);
    
	Line2D.Double Bcape = 
	    new Line2D.Double ( x, y+.70*height, x+width, y+.70*height);
	
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")


        gp.append(Lcape, false);
        gp.append(Rcape, false);
        gp.append(Bcape, false); 
    }

}
