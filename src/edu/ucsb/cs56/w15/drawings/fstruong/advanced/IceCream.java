package edu.ucsb.cs56.w15.drawings.fstruong.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Arc2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a ice cream cone that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Felicia Truong
   @version for CS56, Winter 15, UCSB
   
*/
public class IceCream extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left of ice cream
       @param y y coord of lower left of ice cream
       @param width width of ice cream
       @param height of ice cream
     */
    public IceCream(double x, double y, double width, double height)
    {
         // Make the scoop
        Arc2D.Double scoop
                    = new Arc2D.Double(x, y, width, height, 0, 180, Arc2D.OPEN);
                          
        Line2D.Double leftCone = 
            new Line2D.Double (x, y+height/2,
                               x + width/2, y+height*2);
                               
        Line2D.Double rightCone =
            new Line2D.Double (x + width/2, y+height*2,
                               x + width, y+height/2);

		 Line2D.Double topCone =
            new Line2D.Double (x, y+height/2,
                               x + width, y+height/2);
        // put the whole cone together
       
        GeneralPath wholeCone = this.get();
        wholeCone.append(scoop, false);
        wholeCone.append(leftCone, false);
        wholeCone.append(rightCone, false); 
        wholeCone.append(topCone, false); 
    }

}
