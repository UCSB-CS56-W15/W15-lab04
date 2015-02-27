package edu.ucsb.cs56.w15.drawings.kelvinyang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a fan that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Kelvin Yang
   @version for CS56, Winter 15, UCSB, 02/05/2015
*/
public class Fan extends GeneralPathWrapper implements Shape
{
    /**
     * Constructor for Fan
     * @param x x coordinate of top left of fan
     * @param y y coordinate of top left of fan
     * @param height the height of the fan
     */
    public Fan(double x, double y, double height)
    {
        //Get the width as 2/3 of the height always
        double width = 2 * height / 3;
        
        //Create each segment of the fan
        Ellipse2D fanBody = new Ellipse2D.Double(x, y, width, width);
        Ellipse2D fanCenter = new Ellipse2D.Double(x + 0.375 * width, y + 0.375 * width, width * 0.25, width * 0.25);
        
        Rectangle2D fanStand = new Rectangle2D.Double(x + 0.4 * width, y + width * 0.98, width * 0.2, height * 0.2);
        Ellipse2D fanBase = new Ellipse2D.Double(x + width * 0.1, y + width + (height / 3 - height / 4), width * 0.8, height * 0.25);
        
        //Add all segments to the entire fan
        GeneralPath wholeFan = this.get();
        wholeFan.append(fanBody, false);
        wholeFan.append(fanCenter, false);
        wholeFan.append(fanStand, false);
        wholeFan.append(fanBase, false);
    }
}