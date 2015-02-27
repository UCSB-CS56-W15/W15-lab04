package edu.ucsb.cs56.w15.drawings.dcwang.advanced;
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
   A vector drawing of a table that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Derek Wang 
   @version for CS56, Winter 15, UCSB
   
*/
public class Table extends GeneralPathWrapper implements Shape
{
    /**
       Constructor for Table object

       @param x x coord of lower left corner of table
       @param y y coord of lower left corner of table
       @param width width of the house
       @param length length of the table 
     */
    public Table(double x, double y, double width, double length)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and length.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
	double legLength = (width+length)/2;

	Line2D.Double left  = new Line2D.Double(x,y,x+width,y-width);
	Line2D.Double top = new Line2D.Double(x+width,y-width, x+width+length, y-width);
	Line2D.Double right = new Line2D.Double(x+width+length, y-width, x+length, y);
	Line2D.Double bottom = new Line2D.Double(x+length, y, x, y);
	Line2D.Double leg1 = new Line2D.Double (x,y,x,y+legLength);
	Line2D.Double leg2 = new Line2D.Double(x+width, y, x+width, y-width+legLength);
	Line2D.Double leg3 = new Line2D.Double(x+length,y,x+length,y+legLength);
	Line2D.Double leg4 = new Line2D.Double(x+width+length,y-width,x+width+length,y-width+legLength);

        // put the whole table together
       
        GeneralPath wholeTable = this.get();
        wholeTable.append(left, false);
        wholeTable.append(top, false);
        wholeTable.append(right, false); 
	wholeTable.append(bottom, false);
	wholeTable.append(leg1, false);
	wholeTable.append(leg2, false);
	wholeTable.append(leg3, false);
	wholeTable.append(leg4, false);
    }

}
