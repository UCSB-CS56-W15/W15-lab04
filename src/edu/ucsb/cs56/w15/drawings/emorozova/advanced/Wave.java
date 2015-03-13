package edu.ucsb.cs56.w15.drawings.emorozova.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.QuadCurve2D;

import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a wave that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Elena Morozova
   @version for CS56, Winter 15, UCSB
   
*/

public class Wave extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of wave
       @param y y coord of lower left corner of wave
       @param width width of wave
       @param height of wave
     */
    public Wave(double x, double y, double width, double height)
    {
	double xCoord = x;
	double yCoord = y + height;
	double xDiff = width/5;

	GeneralPath wholeWave = this.get();
	
	for (int i = 0; i<5; i++)
        {
	    QuadCurve2D q = new QuadCurve2D.Double();

	    q.setCurve(xCoord, yCoord, xCoord + (xDiff/2), yCoord+height, xCoord + xDiff, yCoord);

	    wholeWave.append(q, false);
	    xCoord += xDiff;
	}
    }

    
}
