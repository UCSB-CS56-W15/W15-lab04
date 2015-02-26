package edu.ucsb.cs56.w15.drawings.stp.advanced;
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
   A Scooter with a basket

   @author Spencer Prescott
   @version for CS56, W15, UCSB, 02/04/2015

*/
public class ScooterWithBasket extends Scooter implements Shape
{
    /**
     * Constructor for objects of class ScooterWithBasket
     @param basketWidth the width of the rectangular basket
     @param basketHeight the height of the rectangular basket
     */
    public ScooterWithBasket(double x, double y, double width, double height, double wheelSize, double basketWidth, double basketHeight)
    {

        // construct the basic scooter
        super(x,y,width,height, wheelSize);

        // Add a basket to the stem of the scooter
        Rectangle2D.Double basket = new Rectangle2D.Double(x + width, y - height*0.75, basketWidth, basketHeight);

        GeneralPath wholeHouse = this.get();
        wholeHouse.append(basket, false);
    }

}
