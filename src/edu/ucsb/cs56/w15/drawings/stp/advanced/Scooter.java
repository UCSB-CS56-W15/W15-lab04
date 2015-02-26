package edu.ucsb.cs56.w15.drawings.stp.advanced;
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
   A vector drawing of a scooter that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.

   @author Spencer Prescott
   @version for CS56, Winter 15, UCSB

*/
public class Scooter extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of center of rear wheel
       @param y y coord of center of rear wheel
       @param width width of the base of the scooter
       @param height of scooter (from bottom of wheels to handle bars)
       @param wheelSize diameter of the wheels
     */
    public Scooter(double x, double y, double width, double height, double wheelSize)
    {

        // Create the base of the scooter
        Line2D.Double base = new Line2D.Double(x, y, x + width, y);

        // Create the stem for the handle bars
        Line2D.Double stem = new Line2D.Double(base.getX2(), y, base.getX2(), y - height);

        // Create handle bars
        Line2D.Double bars = new Line2D.Double(base.getX2() - width/4.0, stem.getY2(), base.getX2() + width/4.0, stem.getY2());

        // Create the wheels of the scooter
        Ellipse2D.Double leftWheel = new Ellipse2D.Double(x - wheelSize/2.0, y - wheelSize/2.0, wheelSize, wheelSize);

        Ellipse2D.Double rightWheel = new Ellipse2D.Double(base.getX2() - wheelSize/2.0, y - wheelSize/2.0, wheelSize, wheelSize);




        GeneralPath wholeScooter = this.get();
        wholeScooter.append(leftWheel, false);
        wholeScooter.append(rightWheel, false);
        wholeScooter.append(base, false);
        wholeScooter.append(stem, false);
        wholeScooter.append(bars, false);

    }

}
