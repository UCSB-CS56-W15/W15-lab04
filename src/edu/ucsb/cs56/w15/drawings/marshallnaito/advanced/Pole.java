package edu.ucsb.cs56.w15.drawings.marshallnaito.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a pole that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Marshall Naito
   @version for CS56, Winter 15, UCSB
   
*/
public class Pole extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x-coordinate of pole bottom
       @param y y-coordinate of pole bottom
       @param width of base
       @param height of pole
     */
    public Pole(double x, double y, double width, double height)
    {
    

        double baseWidth = .5 * width;
        double baseHeight = .25 * height;

        double straightBottom = y-height;

        double bendWidth = x + height/2;
        double bendHeight = straightBottom - height/10;

        Rectangle.Double base = new Rectangle.Double(x-baseWidth,y,width,baseHeight);

        Ellipse2D.Double poleLight = new Ellipse2D.Double(bendWidth , bendHeight-0.03125*height, 0.1*height , .05*height);

        Line2D.Double straight = new Line2D.Double(x , y , x , straightBottom);

        Line2D.Double bend = new Line2D.Double( x , straightBottom , bendWidth , bendHeight);
        

        // put poles and base together
       
        GeneralPath wholePole = this.get();
        wholePole.append(straight, false);
        wholePole.append(bend, false); 
        wholePole.append(base, false);
        wholePole.append(poleLight, false);
        
    }

}
