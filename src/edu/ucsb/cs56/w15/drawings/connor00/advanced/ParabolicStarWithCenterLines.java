package edu.ucsb.cs56.w15.drawings.connor00.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D; 
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A Paroblic Star With Center Lines (subclass of ParabolicStar, implements Shape)   
      
   @author Connor Armbrust Mulcahey 
   @version for CS56, W15, UCSB, 2/6/14
   
*/
public class ParabolicStarWithCenterLines extends ParabolicStar implements Shape {
    
    /**
       Constructor

       @param x x coord of upper left corner of star
       @param y y coord of upper left corner of house
       @param width width of the star
       @param height height of star
       @param linesPerQuadrant the number of lines perquadrant of the star
     */

    public ParabolicStarWithCenterLines(double x, double y, double width, double height, int linesPerQuadrant) {
	
	super(x, y, width, height, linesPerQuadrant);

	GeneralPath wholeStar = this.get();

	// Vertical center line
	Line2D.Double vLine = new Line2D.Double(x + (width/2), y, x + (width/2), y + height);
	wholeStar.append(vLine, false);

	// Horizontal center line
	Line2D.Double hLine = new Line2D.Double(x, y + (height/2), x + width, y + (height/2));
	wholeStar.append(hLine, false);
    }

}
