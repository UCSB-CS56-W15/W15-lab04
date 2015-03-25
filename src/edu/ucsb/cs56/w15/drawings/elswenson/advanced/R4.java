package edu.ucsb.cs56.w15.drawings.elswenson.advanced;

import java.awt.geom.GeneralPath; 
import java.awt.geom.AffineTransform; 
import java.awt.Shape; 


import java.awt.geom.Point2D; 
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.Ellipse2D;


import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
  A R4 Droid is a specific type of droid with a trapezoidal top.
  @author Eric Swenson
  @version CS56W15 
  */

public class R4 extends Droid implements Shape
{
	/**
 	 Constructor for the R4 class, creates a R4 Droid.
	 @param x = top left x coordinate of the droid
	 @param y = top left y coordinate of the droid
	 @param width = width of the droid
	 @param height = height of the droid
	*/
	public R4(double x, double y, double width, double height)
	{
		super(x + 0.05*width, y + 0.2 * height, 0.9*width, 0.8*height); //gives space above and on both left and right sides.
		
		double domeHeight = 0.2*height;
		double domeTopWidth = .3*width;
		double domeBottomLeftX = x + (width - 0.7*0.9*width)/2;
		double domeTopLeftX = x + 0.35*width;
		
		double footHeight = 0.1*height;
		double footWidth = 0.1*width + 0.9*0.15*width;
		
		double eyeHeight = 0.05*height;
		double eyeWidth = eyeHeight;
		double eyeX = x + 0.5*width;
		double eyeY = y + 0.5*domeHeight;

		Rectangle2D.Double leftFoot = new Rectangle2D.Double(x, y + height, footWidth, footHeight);
		Rectangle2D.Double rightFoot = new Rectangle2D.Double(x + width - footWidth, y + height, footWidth, footHeight);
		Ellipse2D.Double eye = new Ellipse2D.Double(eyeX, eyeY, eyeWidth, eyeHeight);		
	
		Line2D.Double leftDome = new Line2D.Double(domeBottomLeftX, y + domeHeight, domeTopLeftX, y);
		Line2D.Double rightDome = new Line2D.Double(domeBottomLeftX + (0.7*0.9*width), y + domeHeight, domeTopLeftX + domeTopWidth, y);
		Line2D.Double topDome = new Line2D.Double(domeTopLeftX, y, domeTopLeftX + domeTopWidth, y);


		GeneralPath thisDroid = this.get();
		thisDroid.append(leftFoot, false);
		thisDroid.append(rightFoot, false);
		thisDroid.append(leftDome, false);
		thisDroid.append(rightDome, false);
		thisDroid.append(topDome, false);
		thisDroid.append(eye, false);
		
	}
}
