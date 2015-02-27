package edu.ucsb.cs56.w15.drawings.shadeebarzin.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a flower that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Shadee Barzin 
   @version for CS56, W15, UCSB, 02/13/2015 
*/

public class Flower extends GeneralPathWrapper implements Shape {

    /**
       Constructor

       @param x x coord of middle of flower
       @param y y coord of middle of flower
       @param diameter diameter of flower (including petals)
     */
    public Flower(double x, double y, double diameter) {
	double centerRadius =  diameter/6;

	// make the center circle
	Ellipse2D.Double flowerCenter = new Ellipse2D.Double(x+1.5*centerRadius, y+1.5*centerRadius, centerRadius, centerRadius);

	double petalRadius = 2*centerRadius;

	// make petalOne (the top petal)
	Ellipse2D.Double petalOne = new Ellipse2D.Double(x+centerRadius, y-centerRadius, petalRadius, petalRadius);
	// make petalTwo (the top right petal)
	Ellipse2D.Double petalTwo = new Ellipse2D.Double(x+3*centerRadius, y, petalRadius, petalRadius);
	// make petalThree (the bottom right petal)
	Ellipse2D.Double petalThree = new Ellipse2D.Double(x+3*centerRadius, y+2*centerRadius, petalRadius, petalRadius);
	// make petalFour (the bottom petal)
	Ellipse2D.Double petalFour = new Ellipse2D.Double(x+centerRadius, y+3*centerRadius, petalRadius, petalRadius);
	// make petalFive (the bottom left petal)
	Ellipse2D.Double petalFive = new Ellipse2D.Double(x-centerRadius, y+2*centerRadius, petalRadius, petalRadius);
	// make petalSix (the top left petal)
	Ellipse2D.Double petalSix = new Ellipse2D.Double(x-centerRadius, y, petalRadius, petalRadius);

        // put the whole flower together
        GeneralPath wholeFlower = this.get();
        wholeFlower.append(flowerCenter, false);
        wholeFlower.append(petalOne, false);
        wholeFlower.append(petalTwo, false);
        wholeFlower.append(petalThree, false);
        wholeFlower.append(petalFour, false);
        wholeFlower.append(petalFive, false);
        wholeFlower.append(petalSix, false); 
    }

}
