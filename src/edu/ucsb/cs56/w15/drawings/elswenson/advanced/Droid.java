package edu.ucsb.cs56.w15.drawings.elswenson.advanced;

import java.awt.geom.GeneralPath;
import java.awt.geom.AffineTransform;
import java.awt.Shape;

import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
 A vector drawing of a basic droid using the Shape interface.
 @author Eric Swenson
 @version CS56W15
 */

public class Droid extends GeneralPathWrapper implements Shape
{
	/**
 	 Constructor for the Droid class, creates a droid.
	@param x = lower left x coordinate of the droid
	@param y = lower left y coordinate of the droid
	@param width = width of the droid
	@param height = height of the droid
	 
	*/
	public Droid(double x, double y, double width, double height)
	{
		double legHeight = 0.8 * height;
		double legWidth = 0.15 * width;
		double bodyWidth = width - 2 * legWidth;
		double bodyHeight = 0.7 * height;
		
		Rectangle2D.Double body = new Rectangle2D.Double(x + legWidth, y, bodyWidth, bodyHeight);
		Rectangle2D.Double leftLeg = new Rectangle2D.Double(x, y + height - legHeight, legWidth, legHeight);
		Rectangle2D.Double rightLet = new Rectangle2D.Double(x + bodyWidth + legWidth, y + height - legHeight, legWidth, legHeight);
		Rectangle2D.Double port = new Rectangle2D.Double(x + 1.5 * legWidth, y + 0.2*height, width - 3 * legWidth, height * 0.05);
		
		GeneralPath wholeDroid = this.get();
		wholeDroid.append(body, false);
		wholeDroid.append(leftLeg, false);
		wholeDroid.append(rightLet, false);
		wholeDroid.append(port, false);
		
	}
	



}
