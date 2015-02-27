package edu.ucsb.cs56.w15.drawings.mbahia.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Arc2D;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A drawing of an ice cream cone that extends GeneralPathWrapper
   and implements shape. It uses Lines and Arcs. 
      
   @author Manpreet Bahia
   @version for CS56, Winter 15, UCSB
   
*/
public class IceCreamCone extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coordinate for top corner of cone
       @param y y coordinate for lower corner of cone
       @param base base of the cone
       @param height height of cone 
     */
    public IceCreamCone(double x, double y, double base, double height)
    {
    
	// make the cone a triangular shape
	Line2D.Double leftCone = new Line2D.Double (x, y, x + base/2.0, y + height);

	Line2D.Double rightCone =  new Line2D.Double (x + base/2.0, y + height, x + base, y);

        Line2D.Double Cone =  new Line2D.Double (x + base, y, x, y);
       
	double radius = height/2.0;

	// make the ice cream
	Arc2D.Double iceCream = new Arc2D.Double (x, y/2.0, base, y, 0, 180, Arc2D.OPEN);

	// put the ice cream and cone together

        GeneralPath IceCC = this.get();
	IceCC.append(rightCone, false); 
	IceCC.append(leftCone, false);
        IceCC.append(Cone, false);
	IceCC.append(iceCream, false);
        
    }

}



