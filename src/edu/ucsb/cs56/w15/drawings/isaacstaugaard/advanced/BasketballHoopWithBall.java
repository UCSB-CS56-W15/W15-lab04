package edu.ucsb.cs56.w15.drawings.isaacstaugaard.advanced;
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
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A Basketball Hoop
      
   @author Phill Conrad, Isaac Staugaard 
   @version for CS56, W15, UCSB, 02/10/2015
   
*/
public class BasketballHoopWithBall extends BasketballHoop implements Shape
{
    /**
     * Constructor for objects of class BasketballHoop
     */
    public BasketballHoopWithBall(double x, double y, double width, double height)
    {
	// construct the basic BasketballHoop shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	double ballWidth = 0.3 * width;
	double ballHeight = 0.3 * height;
	double ballXLocation = x + .5 * width;
	double ballYLocation = y + .5 * height;

	Ellipse2D.Double basketball = new Ellipse2D.Double(ballXLocation,ballYLocation,ballWidth,ballHeight);
	
	// add the basketballs 
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeBackboardPlusBall = this.get();
        wholeBackboardPlusBall.append(basketball, false);
    }

}
