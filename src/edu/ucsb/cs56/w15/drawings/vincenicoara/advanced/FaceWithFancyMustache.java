package edu.ucsb.cs56.w15.drawings.vincenicoara.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes


// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D.Double; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Vince Nicoara
   @version for CS56, Winter 15, UCSB
   
*/
public class FaceWithFancyMustache extends Face implements Shape
{
	private int x;
	private int y;
	private int radius;
    /**
       Constructor
       @param xCoordinate the left-most x-coordinate of the head
       @param yCoordinate the highest y-coordinate of the head
       @param r The radius of the head.
     */   
         
    public FaceWithFancyMustache(int xCoordinate, int yCoordinate, int r){
    super(xCoordinate,yCoordinate,r);
    x = xCoordinate;
    y = yCoordinate;
    radius = r;
    GeneralPath wholeFace = this.get();
    double mouthYCoordinate = (y + radius/3);
    Double mustacheLine = new Double (x-(radius/2) - x/20, mouthYCoordinate - radius/15
				       , x+(radius/2) + x/20, mouthYCoordinate - radius/15);
    wholeFace.append(mustacheLine, false);
    }
    

}
