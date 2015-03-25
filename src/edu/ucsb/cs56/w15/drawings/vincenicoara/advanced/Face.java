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
public class Face extends GeneralPathWrapper implements Shape
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
    public Face(int xCoordinate, int yCoordinate, int r){

    x = xCoordinate;
    y = yCoordinate;
    radius = r;

	Circle head = new Circle(x, y, radius);
	Circle leftEye = new Circle(x-(radius/2), y, radius/5);
	Circle rightEye = new Circle(x+(radius/2), y, radius/5);
	Circle leftEyePupil = new Circle(x-(radius/2), y, radius/10);
	Circle rightEyePupil = new Circle(x+(radius/2), y, radius/10);
	double mouthYCoordinate = (y + radius/3);

	java.awt.geom.Arc2D.Double mouthCurve = new java.awt.geom.Arc2D.Double (
										 x - (radius/2)
										, mouthYCoordinate - radius/2
										, radius
										, radius
										, 180
										, 180
										, java.awt.geom.Arc2D.CHORD					
					      );
	

	GeneralPath wholeFace = this.get();
	wholeFace.append(head,false);
	wholeFace.append(leftEye,false);
	wholeFace.append(rightEye,false);
	wholeFace.append(leftEyePupil,false);
	wholeFace.append(rightEyePupil,false);
	wholeFace.append(mouthCurve, false);
    }

}
