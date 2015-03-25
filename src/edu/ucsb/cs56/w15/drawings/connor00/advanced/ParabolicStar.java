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
   A Paroblic Star (wrapper around a General Path, implements Shape)   
      
   @author Connor Armbrust Mulcahey 
   @version for CS56, W15, UCSB, 2/6/14
   
*/
public class ParabolicStar extends GeneralPathWrapper implements Shape {
    
    /**
       Constructor

       @param x x coord of upper left corner of star
       @param y y coord of upper left corner of house
       @param width width of the star
       @param height height of star
       @param linesPerQuadrant the number of lines to draw per quadrant
     */

    public ParabolicStar(double x, double y, double width, double height, int linesPerQuadrant) {

	double yinc = height / (2*(linesPerQuadrant + 1));
	double xinc = width / (2*(linesPerQuadrant + 1));	

	GeneralPath wholeStar = this.get();

	// Top left quadrant
	for (double xs = x + (width/2), ys = y, xe = x + (width/2) - xinc, ye = (height/2) + y; ys < y + height/2 - (yinc/2);  ys += yinc, xe -= xinc) {
	    Line2D.Double newLine = new Line2D.Double(xs, ys, xe, ye);
	    wholeStar.append(newLine, false);
	}

	// Top right quadrant
	for (double xs = x + (width/2), ys = y, xe = x + (width/2) + xinc, ye = (height/2) + y; ys < y + height/2 - (yinc/2);  ys += yinc, xe += xinc) {
	    Line2D.Double newLine = new Line2D.Double(xs, ys, xe, ye);
	    wholeStar.append(newLine, false);
	}

	// Bottom right quadrant
	for (double xs = x + width, ys = y + (height/2), xe = x + (width/2), ye = y + (height/2) + yinc; ye < y + height + (yinc/2);  ye += yinc, xs -= xinc) {
	    Line2D.Double newLine = new Line2D.Double(xs, ys, xe, ye);
	    wholeStar.append(newLine, false);
	}

	// Bottom left quadrant
	for (double xs = x, ys = y + (height/2), xe = x + (width/2), ye = y + (height/2) + yinc; xs < x + (width/2) - xinc + (xinc/2);  xs += xinc, ye += yinc) {
	    Line2D.Double newLine = new Line2D.Double(xs, ys, xe, ye);
	    wholeStar.append(newLine, false);
	}
    }

}
