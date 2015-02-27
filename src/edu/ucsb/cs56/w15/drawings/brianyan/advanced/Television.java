package edu.ucsb.cs56.w15.drawings.brianyan.advanced;
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
   A vector drawing of a Television that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @author Brian Yan
   @version for CS56, Winter 15, UCSB
   
*/
public class Television extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of top left corner of TV
       @param y y coord of top left corner of TV
       @param side side length of the TV
    */
    public Television(double x, double y, double side)
    {
	//draw the box first
	Rectangle2D.Double box = new Rectangle2D.Double(x,y,side,side);
	
	//draw the Antennas 
		Line2D.Double leftAn =
		    new Line2D.Double(x + side/2.0, y, x + side/4.0 , y - side/4.0); 

		Line2D.Double rightAn =
		    new Line2D.Double(x + side/2.0, y, x + 3*(side/4.0), y - side/4.0);
	//put the TV together
	GeneralPath wholeTV = this.get();
	wholeTV.append(box, false);
	wholeTV.append(leftAn,false);
	wholeTV.append(rightAn,false);
   





 }
}

	
  
