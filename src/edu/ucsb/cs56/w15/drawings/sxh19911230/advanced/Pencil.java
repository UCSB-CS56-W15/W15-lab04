package edu.ucsb.cs56.w15.drawings.sxh19911230.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes


// all imports below this line needed if you are implementing Shape
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a Pencil that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Xianghong Sun
   @version for CS56, Winter 15, UCSB
   
*/
public class Pencil extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of Pencil
       @param y y coord of lower left corner of Pencil
       @param size size of the Pencil
     */
    public Pencil(double x, double y, double size)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
    	
    	double width = 0.05 * size;
    	
        double nibLength = 2.5 * width;
        double height = size - nibLength;
        
        double pencilBodyLenght = y + nibLength;
        
        // Make the first story
        
        Rectangle2D.Double pencilBody = 
            new Rectangle2D.Double(x, pencilBodyLenght ,
                          width, height);
                          
        // make the roof.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        Line2D.Double leftNib = 
            new Line2D.Double (x, y + nibLength,
                               x + width/2.0, y);
                               
        Line2D.Double rightNib =
            new Line2D.Double (x + width/2.0, y,
                               x + width, y + nibLength);
        
        Line2D.Double NibTop = 
        		new Line2D.Double (x + width * 2.0 / 5.0, y + nibLength / 5.0,
        				x + width * 3.0 / 5.0, y + nibLength / 5.0);

        // put the whole house together
       
        GeneralPath wholePencil = this.get();
        wholePencil.append(pencilBody, false);
        wholePencil.append(leftNib, false);
        wholePencil.append(rightNib, false);
        wholePencil.append(NibTop, false);
        
    }

}

