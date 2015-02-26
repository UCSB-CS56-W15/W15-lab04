package edu.ucsb.cs56.w15.drawings.d_luo.advanced;
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
 * 	A sword with a Hilt so it actually looks like a sword
 * 	
 * 	@author Dan Luo
 * 	@version for CS56 W15, UCSB, 2/22/2014
 */

public class SwordAndHilt extends Sword implements Shape
{
	/**
 		Constructor for the Sword with a Hilt
		@param xCenterLine x coordinate of the center line
		@param y y coordinate of the top of the handle of the sword
		@param length length of the sword
		@param width width of the sword
	*/
	
	
	public SwordAndHilt(double xCenterLine, double y, double length, double width)
{
	// construct a basic sword
	super(xCenterLine, y, length, width);
	// get the general path to append to
	GeneralPath gp = this.get(); 	
	while(width > length*0.1)
	{
		width = width * 0.5;
		length = length * 2;
	}
	double handleLength = 0.1*length;
	double swordRadius = 0.5 * width; 
	// remake the handle this time with a hilt
	Line2D.Double leftRightTop = new Line2D.Double(xCenterLine - width, y, xCenterLine + width, y);
	Line2D.Double leftRightBot1 = new Line2D.Double(xCenterLine - width, y + handleLength/2, xCenterLine - swordRadius, y + handleLength/2);
	Line2D.Double leftRightBot2 = new Line2D.Double(xCenterLine + swordRadius, y + handleLength/2, xCenterLine + width, y + handleLength/2);
	Line2D.Double TopDownLeft = new Line2D.Double(xCenterLine - width, y, xCenterLine - width, y + handleLength/2);
	Line2D.Double TopDownRight = new Line2D.Double(xCenterLine + width, y, xCenterLine + width, y + handleLength/2);
	Line2D.Double TopDownBottomLeft = new Line2D.Double(xCenterLine - swordRadius, y + handleLength/2, xCenterLine - swordRadius, y + handleLength);
	Line2D.Double TopDownBottomRight = new Line2D.Double(xCenterLine + swordRadius, y + handleLength/2, xCenterLine + swordRadius, y + handleLength); 
	Line2D.Double veryBottom = new Line2D.Double(xCenterLine - swordRadius, y+handleLength, xCenterLine + swordRadius, y + handleLength); 
	// now add these pieces to overlap with the original handle and replace it 
	gp.append(leftRightTop, false);
	gp.append(leftRightBot1, false);
	gp.append(leftRightBot2, false);
	gp.append(TopDownLeft, false);
	gp.append(TopDownRight, false);
	gp.append(TopDownBottomLeft, false);
	gp.append(TopDownBottomRight, false); 
	gp.append(veryBottom, false);
	}
}
	
