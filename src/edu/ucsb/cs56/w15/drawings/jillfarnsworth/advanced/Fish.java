package edu.ucsb.cs56.w15.drawings.jillfarnsworth.advanced;
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
   A vector drawing of a fish that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Jill Farnsworth 
   @version for CS56, Winter 15, UCSB
   
*/
public class Fish extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of upper left corner of framing rectangle of fish body
       @param y y coord of upper left corner of framing rectangle of fish body
       @param w width of fish
       @param h height of fish
     */
    public Fish(double x, double y, double w, double h)
    {
    
	Ellipse2D.Double body = new Ellipse2D.Double(x, y, w*0.75, h);
        
	double bodyEndX = x + (w*0.75);
	double bodyEndY = y + (h*0.5);
	Line2D.Double topTail = new Line2D.Double(bodyEndX, bodyEndY, x+w, y);
	Line2D.Double endTail = new Line2D.Double(x+w, y, x+w, y+h);
	Line2D.Double bottomTail = new Line2D.Double(x+w, y+h, bodyEndX, bodyEndY);
        
          
        GeneralPath wholeFish = this.get();
        wholeFish.append(body, false);
        wholeFish.append(topTail, false);
        wholeFish.append(endTail, false);
	wholeFish.append(bottomTail, false);
 
        
    }

}
