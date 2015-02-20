package edu.ucsb.cs56.w15.drawings.kevinlau.advanced;
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
   Tv on a table
      
   @author Kevin Lau
   @version for CS56, W15, UCSB, 02/7/2015
   
*/
public class tvWithTable extends tv implements Shape
{
    /**
     * Constructor for objects of class Car
     */
    public tvWithTable(double x, double y, double width, double height)
    {
	// construct the tv
	super(x,y,width,height);

	// get the GeneralPath so we can append the table.
	GeneralPath gp = this.get(); 
	
	double tableTopY = y + height;
	double tableTopHeight = .2 * height;
	
	double leftLegY = y + height + tableTopHeight;
	double leftLegHeight = .75 * height;
	double leftLegWidth = .1 * width;
	
	double rightLegX = x + (.9 * width);
	double rightLegY = leftLegY;
	double rightLegHeight = leftLegHeight;
	double rightLegWidth = leftLegWidth;
	
	Rectangle2D.Double tableTop = 
            new Rectangle2D.Double(x, tableTopY ,
                          width, tableTopHeight);
	
	Rectangle2D.Double leftLeg = 
            new Rectangle2D.Double(x, leftLegY ,
                          leftLegWidth, leftLegHeight);
	
	Rectangle2D.Double rightLeg = 
            new Rectangle2D.Double(rightLegX, rightLegY ,
                          rightLegWidth, rightLegHeight);
	
	GeneralPath wholeTv = this.get();
        wholeTv.append(tableTop, false);
        wholeTv.append(leftLeg, false);
		wholeTv.append(rightLeg, false);
	}
}
