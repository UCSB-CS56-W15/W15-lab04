package edu.ucsb.cs56.w15.drawings.zakary94.advanced;
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
	Draws a shovel given height x,y,height
                
    	 @author Zak Blake
  	 @version for CS56, Winter 15, UCSB
                         
 */
public class Shovel extends GeneralPathWrapper implements Shape
{
 /**
   Constructor

	@param x x coord of top of shovel shaft
	@param y y coord of top of shovel shaft
	@param height of the shovel extending downward from coordinates
  */
    public Shovel(double x, double y, double height)
    {
// Draw the Shaft
	double shaftLength = (.8)*height;
	double shaftWidth = shaftLength/12.0;
	Rectangle2D.Double shaft =
		 new Rectangle2D.Double(x-.5*shaftWidth,y,shaftWidth,shaftLength);	

// Draw the Head
	double headLength = (.2)*height; 
	double headWidth = shaftWidth*7.0;
	double gap = (headWidth - shaftWidth)/2.0;
	Rectangle2D.Double head =
		 new Rectangle2D.Double(x-.5*shaftWidth-gap,y+shaftLength,headWidth,headLength);

// create
	GeneralPath myShovel = this.get();
	myShovel.append(shaft,false);
	myShovel.append(head,false);

	} // end constructor



}// end class
