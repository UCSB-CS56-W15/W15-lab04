package edu.ucsb.cs56.w15.drawings.d_luo.advanced;
import java.awt.geom.GeneralPath; //lines and curves
import java.awt.geom.AffineTransform; //moving stuff/translation
import java.awt.Shape; //general class for shapes

import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
 * 	A drawing of a sword, remember to add to this description later.
 *
 * 	@author Dan Luo
 *	@version for CS56, Winter 2015, UCSB
 */
public class Sword extends GeneralPathWrapper implements Shape
{
	/**
 * 		Constructor
 * 		@param xCenterLine x coordinate of the center line
 * 		@param y y coordinate of the top of the handle of the sword
 * 		@param length length of the sword
 * 		@param width width of the sword 
 * 	*/ 
	public Sword(double xCenterLine, double y, double length, double width)
{
	while(width> length*0.1)
	{
		width = width * 0.5;
		length = length * 2;
	}
	double swordRadius = 0.5 * width; 
	double handleLength = 0.2 * length; 
	
	// Make the handle
	
	Rectangle2D.Double handle = 
		new Rectangle2D.Double(xCenterLine - swordRadius, y, width, handleLength);  
	// Make the long part of the sword
	double swordLength = 0.7*length; 
	//Rectangle2D.Double swordBase = new Rectangle2D.Double(xCenterLine - swordRadius, y-swordLength, width, swordLength); 
	Line2D.Double swordBaseLeft = new Line2D.Double(xCenterLine - swordRadius, y, xCenterLine - swordRadius, y - swordLength); 
	Line2D.Double swordBaseRight = new Line2D.Double(xCenterLine + swordRadius, y, xCenterLine + swordRadius, y - swordLength); 
	// Make the edge of the sword
	Line2D.Double leftTip = new Line2D.Double(xCenterLine - swordRadius, y-swordLength, xCenterLine, y-length); 
	Line2D.Double rightTip = new Line2D.Double(xCenterLine + swordRadius, y-swordLength, xCenterLine, y-length); 

	// Make the sword now
	GeneralPath wholeSword = this.get();
	wholeSword.append(handle, false);
	wholeSword.append(swordBaseLeft, false);
	wholeSword.append(swordBaseRight, false); 
	wholeSword.append(leftTip, false);
	wholeSword.append(rightTip, false);
	}
}
	 
