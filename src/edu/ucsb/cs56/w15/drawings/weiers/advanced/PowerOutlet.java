package edu.ucsb.cs56.w15.drawings.weiers.advanced;
import java.awt.geom.GeneralPath;
import java.awt.geom.AffineTransform;
import java.awt.Shape;

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
   A basic AC power outlet that implements
   the Shape interface, and so can be drawn,
   rotated, etc...

   @author William Eiers
   @version for CS56 Winter 15, UCSB

*/

public class PowerOutlet extends GeneralPathWrapper implements Shape {

    /**
       Constructor
       @param x x coord of lower left corner of power outlet
       @param y y coord of lower left corner of power outlet
       @param width width of outlet
       @param height height of outlet
    */

    public PowerOutlet(double x, double y, double width, double height) {
        // rectangular base for the outlet
        Rectangle2D.Double base = new Rectangle2D.Double(
            x,
            y + height,
            width,
            height);

        double plugRadius = width / 2;
        double socketX = x+width/4;
        double socketY = y+height;
        // topmost socket of the outlet
        Ellipse2D.Double topSocket = new Ellipse2D.Double(
            socketX, socketY+height/8, plugRadius, plugRadius);

        // bottommost socket of the outlet
        Ellipse2D.Double bottomSocket = new Ellipse2D.Double(
            socketX, socketY+height/2, plugRadius, plugRadius);
        
        // for the leftmost prong on top
        Line2D.Double topLeftHole = new Line2D.Double(
            socketX+plugRadius*2/6, // begin x
            socketY+plugRadius*7/8, // begin y
            socketX+plugRadius*2/6, // end x 
            socketY+plugRadius*1/2); // end y

        // for the rightmost prong on top
        Line2D.Double topRightHole = new Line2D.Double(
            socketX+plugRadius*4/6, // begin x
            socketY+plugRadius*7/8, // begin y
            socketX+plugRadius*4/6, // end ex
            socketY+plugRadius*1/2); // end y
        
        // for the leftmost prong on bottom
        Line2D.Double bottomLeftHole = new Line2D.Double(
            socketX+plugRadius*2/6, // begin x
            socketY+height/2+plugRadius*1/2, // begin y
            socketX+plugRadius*2/6, // end x
            socketY+height/2+plugRadius*1/8); // end y

        // for the rightmost prong on bottom
        Line2D.Double bottomRightHole = new Line2D.Double(
            socketX+plugRadius*4/6, // begin x
            socketY+height/2+plugRadius*1/2, // begin y
            socketX+plugRadius*4/6, // end x
            socketY+height/2+plugRadius*1/8); // end y
 
        GeneralPath outlet = this.get();
        outlet.append(base, false);
        outlet.append(topSocket, false);
        outlet.append(bottomSocket, false);
        outlet.append(topLeftHole, false);
        outlet.append(topRightHole, false);
        outlet.append(bottomLeftHole, false);
        outlet.append(bottomRightHole, false);
    }



}
