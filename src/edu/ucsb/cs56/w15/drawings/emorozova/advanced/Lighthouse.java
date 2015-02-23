package edu.ucsb.cs56.w15.drawings.emorozova.advanced;
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
   A vector drawing of a lighthouse that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Elena Morozova
   @version for CS56, Winter 15, UCSB
   
*/
public class Lighthouse extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of lighthouse
       @param y y coord of lower left corner of lighthouse
       @param width width of the house
       @param height of house (including tower and lantern)
     */
    public Lighthouse(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
	// Trapezoidal tower
        double towerHeight = .8 * height;
	double towerWidthBottom = width;
	double towerWidthTop = .75 * width;

	// Rectangular base
	double lanternBaseHeight = .02 * height;
	double lanternBaseWidth = .85 * width;
	double baseX = x + (width - lanternBaseWidth)/2;
	double baseY = y - towerHeight - lanternBaseHeight;
	
	// Rectangular lantern
        double lanternHeight = .1 * height;
	double lanternWidth = .65 * width;
	double lanternX = x + (width - lanternWidth)/2;
	double lanternY = y - towerHeight-lanternBaseHeight - lanternHeight;

	// Triangular top
	double topHeight = .08 * height;
        double topWidth = lanternBaseWidth;
	double topX = baseX;
	double topY = y - towerHeight - lanternBaseHeight - lanternHeight;
	double tippyTopX = baseX + (topWidth/2);
	double tippyTopY = topY - topHeight;

        // Make the tower base
	Line2D.Double towerBase = 
	    new Line2D.Double (x, y, x + towerWidthBottom, y);

	Line2D.Double towerLeftSide = 
	    new Line2D.Double (x, y, x + (towerWidthBottom - towerWidthTop)/2 ,
			       y - towerHeight);
	
	Line2D.Double towerRightSide = 
	    new Line2D.Double (x + towerWidthBottom, y,
			       x + towerWidthTop + (towerWidthBottom-towerWidthTop)/2, 
			       y - towerHeight);

	Line2D.Double towerTop = 
	    new Line2D.Double (x + (towerWidthBottom - towerWidthTop)/2,
			       y - towerHeight, 
			       x + towerWidthTop + (towerWidthBottom - towerWidthTop)/2,
			       y - towerHeight);

	
        // Make the lantern's base
        
        Rectangle2D.Double lanternBase = 
            new Rectangle2D.Double(baseX, baseY ,
                          lanternBaseWidth, lanternBaseHeight);

	// Make the lantern
	Rectangle2D.Double lantern = 
	    new Rectangle2D.Double(lanternX, lanternY, lanternWidth, lanternHeight);
                          
	
	// Make the roof

	Line2D.Double roofBottom = 
	    new Line2D.Double (topX, topY, topX + topWidth, topY);

        Line2D.Double leftRoof = 
            new Line2D.Double (topX, topY,
                               tippyTopX, tippyTopY);
                               
        Line2D.Double rightRoof =
            new Line2D.Double (topX + topWidth, topY,
                               tippyTopX, tippyTopY);

	

        // put the whole house together
       
        GeneralPath wholeLightHouse = this.get();
        wholeLightHouse.append(towerBase, false);
        wholeLightHouse.append(towerLeftSide, false);
        wholeLightHouse.append(towerRightSide, false); 
	wholeLightHouse.append(towerTop, false);
	wholeLightHouse.append(lanternBase, false);
	wholeLightHouse.append(lantern, false);
	wholeLightHouse.append(roofBottom, false);
        wholeLightHouse.append(leftRoof, false);
	wholeLightHouse.append(rightRoof, false);
    }

}
