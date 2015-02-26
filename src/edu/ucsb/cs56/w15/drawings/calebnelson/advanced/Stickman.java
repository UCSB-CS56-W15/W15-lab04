package edu.ucsb.cs56.w15.drawings.calebnelson.advanced;
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
   A House
      
   @author Phill Conrad 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class Stickman extends Face implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public Stickman(double x, double y, double width, double height)
    {	

	// construct the face
	super(x + (width * .125), y, width * .75, height / 3);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	double faceHeight = height / 3;
	double faceWidth = width * .75;
	double bodyLength = height * 2 / 3;
	double armHeight = height / 2;

	Line2D.Double body =
	    new Line2D.Double(x + (width * .5), y + (height - bodyLength),
			      x + (width * .5), y + (height - faceHeight));

	Line2D.Double arms = 
	    new Line2D.Double(x, y + armHeight,
			      x + width, y + armHeight);

	Line2D.Double leftLeg =
	    new Line2D.Double(x, y + height,
			      x + (width * .5), y + bodyLength);
	Line2D.Double rightLeg =
	    new Line2D.Double(x + width, y + height,
			      x + (width * .5), y + bodyLength);
	
	// add the body to the stickman
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeStickman = this.get();
        wholeStickman.append(body, false);
        wholeStickman.append(arms, false);
        wholeStickman.append(leftLeg, false); 
        wholeStickman.append(rightLeg, false);
    }

}
