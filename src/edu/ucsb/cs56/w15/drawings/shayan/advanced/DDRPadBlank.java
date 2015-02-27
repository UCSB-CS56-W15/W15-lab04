package edu.ucsb.cs56.w15.drawings.shayan.advanced;
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
   A vector drawing of a blank DDR Pad that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Shayan Sadigh
   @version for CS56, Winter 14, UCSB
   
*/
public class DDRPadBlank extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x the length and width of our square DDR Pad)
     */
    public DDRPadBlank(double x)
    {
    
        
        double innerSquareSize = x/3;
        
        // Make the outer border
        
        Rectangle2D.Double ddrBorder = 
            new Rectangle2D.Double(0, x ,
                          x, x);
                          
        // make all 9 panels.
        
        Rectangle2D.Double lowerLeft = 
            new Rectangle2D.Double (0, innerSquareSize,
                               innerSquareSize,innerSquareSize);
                               
        Rectangle2D.Double lowerMid = 
            new Rectangle2D.Double (innerSquareSize, innerSquareSize,
                               innerSquareSize,innerSquareSize);

        Rectangle2D.Double lowerRight = 
            new Rectangle2D.Double (2*innerSquareSize, innerSquareSize,
                               innerSquareSize,innerSquareSize);

        Rectangle2D.Double middleLeft = 
            new Rectangle2D.Double (0, 2*innerSquareSize,
                               innerSquareSize,innerSquareSize);

        Rectangle2D.Double middleMid = 
            new Rectangle2D.Double (innerSquareSize, 2*innerSquareSize,
                               innerSquareSize,innerSquareSize);

        Rectangle2D.Double middleRight = 
            new Rectangle2D.Double (2*innerSquareSize, 2*innerSquareSize,
                               innerSquareSize,innerSquareSize);

        Rectangle2D.Double topLeft = 
            new Rectangle2D.Double (0, 3*innerSquareSize,
                               innerSquareSize,innerSquareSize);

        Rectangle2D.Double topMid = 
            new Rectangle2D.Double (innerSquareSize, 3*innerSquareSize,
                               innerSquareSize,innerSquareSize);

        Rectangle2D.Double topRight = 
            new Rectangle2D.Double (innerSquareSize*2, 3*innerSquareSize,
                               innerSquareSize,innerSquareSize);

        // put the blank DDR Pad together
       
        GeneralPath wholePad = this.get();
        wholePad.append(lowerRight, false);
        wholePad.append(lowerMid, false);
        wholePad.append(lowerLeft, false); 
        wholePad.append(middleRight, false);
        wholePad.append(middleMid, false);
        wholePad.append(middleLeft, false);
        wholePad.append(topRight, false);
        wholePad.append(topMid, false);
        wholePad.append(topLeft, false);
        
    }

}
