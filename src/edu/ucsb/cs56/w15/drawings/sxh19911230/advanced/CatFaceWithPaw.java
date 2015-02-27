package edu.ucsb.cs56.w15.drawings.sxh19911230.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A Pencil With Eraser
      
   @author Xianghong Sun
   @version for CS56, W15, UCSB
   
*/
public class CatFaceWithPaw extends CatFace implements Shape
{
    /**
     * Constructor for objects of class CatFaceWithPaw
     */
    public CatFaceWithPaw(double x, double y, double width, double height)
    {

		super(x,y,width, height);
		
		
		QuadCurve2D.Double leftPawUp = 
	            new QuadCurve2D.Double(.2 * width + x, 1.05 * height  + y, 
	            		0.33 * width + x, 0.99 * height + y, 0.45 * width + x , 1.05 * height + y);
		
		QuadCurve2D.Double leftPawDownLeft = 
	            new QuadCurve2D.Double(.2 * width + x, 1.05 * height  + y, 
	            		0.24 * width + x, 1.2 * height + y, 0.28 * width + x , 1.13 * height + y);
		QuadCurve2D.Double leftPawDownMid = 
	            new QuadCurve2D.Double(.28 * width + x, 1.13 * height  + y, 
	            		0.33 * width + x, 1.25 * height + y, 0.37 * width + x , 1.13 * height + y);
		QuadCurve2D.Double leftPawDownRight = 
	            new QuadCurve2D.Double(.37 * width + x, 1.13 * height  + y, 
	            		0.41 * width + x, 1.2 * height + y, 0.45 * width + x , 1.05 * height + y);
		
		QuadCurve2D.Double rightPawUp = 
            new QuadCurve2D.Double(.8 * width + x, 1.05 * height  + y, 
            		0.67 * width + x, 0.99 * height + y, 0.55 * width + x , 1.05 * height + y);
		
		QuadCurve2D.Double rightPawDownLeft = 
	            new QuadCurve2D.Double(.8 * width + x, 1.05 * height  + y, 
	            		0.76 * width + x, 1.2 * height + y, 0.72 * width + x , 1.13 * height + y);
		QuadCurve2D.Double rightPawDownMid = 
	            new QuadCurve2D.Double(.72 * width + x, 1.13 * height  + y, 
	            		0.67 * width + x, 1.25 * height + y, 0.63 * width + x , 1.13 * height + y);
		QuadCurve2D.Double rightPawDownRight = 
	            new QuadCurve2D.Double(.63 * width + x, 1.13 * height  + y, 
	            		0.59 * width + x, 1.2 * height + y, 0.55 * width + x , 1.05 * height + y);
		
		
	

        GeneralPath wholeHouse = this.get();
        wholeHouse.append(leftPawUp, false);
        wholeHouse.append(leftPawDownLeft, false);
        wholeHouse.append(leftPawDownMid, false);
        wholeHouse.append(leftPawDownRight, false);
        wholeHouse.append(rightPawUp, false);
        wholeHouse.append(rightPawDownLeft, false);
        wholeHouse.append(rightPawDownMid, false);
        wholeHouse.append(rightPawDownRight, false);
    }

}
