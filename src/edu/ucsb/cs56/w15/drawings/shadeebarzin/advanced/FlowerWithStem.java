package edu.ucsb.cs56.w15.drawings.shadeebarzin.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A flower with a stem and two leaves on the stem.
      
   @author Shadee Barzin
   @version for CS56, W15, UCSB, 02/13/2015
*/

public class FlowerWithStem extends Flower implements Shape {

    /**
     * Constructor for objects of class FlowerWithStem, an extension of Flower
     */
    public FlowerWithStem(double x, double y, double diameter) {
	// construct the basic flower
	super(x,y,diameter);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	double centerRadius = diameter/6;
	
	// make the stem
	Rectangle2D.Double stem = new Rectangle2D.Double(x+1.7*centerRadius, y+5*centerRadius, diameter/10, diameter);

	// make the leaf
	Ellipse2D.Double leaf = new Ellipse2D.Double(x-.25*centerRadius, y+1.25*diameter, .75*diameter, .2*diameter);

	// make the leaf vein
	Line2D.Double leafVein = new Line2D.Double(x-.25*centerRadius, y+1.35*diameter, x-.25*centerRadius+.75*diameter, y+1.35*diameter);

	// combine the flower w/stem and leaf
        GeneralPath wholeFlowerWithStem = this.get();
        wholeFlowerWithStem.append(stem, false);
	wholeFlowerWithStem.append(leaf, false);
        wholeFlowerWithStem.append(leafVein, false); 
    }

}
