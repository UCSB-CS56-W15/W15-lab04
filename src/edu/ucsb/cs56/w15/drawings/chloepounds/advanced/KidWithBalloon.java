
package edu.ucsb.cs56.w15.drawings.chloepounds.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A kid with a balloon
      
   @author Chloe Pounds
  */
public class KidWithBalloon extends Kid implements Shape{
    public KidWithBalloon(double x, double y, double width, double height)
    {
        // construct the basic kid shell
        super(x,y,width,height);

        // get the GeneralPath that we are going to append stuff to
        GeneralPath gp = this.get();

        // Make one balloon in the child's hand
        //
        // The string of the balloon will start at (x + width, y + .375* height)
        // the string will end at (x + width, y + height)

        double stringX = x + width;
        double stringY = y + 0.375 * height;
	double stringHeight = y + height;

        Line2D.Double balloonString =
            new Line2D.Double(stringX, stringY, stringX, stringHeight);
        Ellipse2D.Double balloon =
	    new Ellipse2D.Double(stringX, stringY, 
				 .25 * height, 
				  stringHeight); 

        // add the balloon to the child's hand 

        GeneralPath wholeKid = this.get();
        wholeKid.append(balloonString, false);
        wholeKid.append(balloon, false);
    }

}

