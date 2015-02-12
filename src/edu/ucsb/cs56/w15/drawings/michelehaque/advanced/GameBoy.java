package edu.ucsb.cs56.w15.drawings.michelehaque.advanced;
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
   A vector drawing of a GameBoy that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Michele Haque
   @version for CS56, Winter 15, UCSB
   
*/
public class GameBoy extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of upper left corner of GameBoy
       @param y y coord of upper left corner of GameBoy
       @param width width of the GameBoy
       @param height of GameBoy
     */
    public GameBoy(double x, double y, double width, double height)
    {
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        //Make main body of the GameBoy
	Rectangle2D.Double mainPart = new Rectangle2D.Double(x, y, width, height);

	double screen1Width = .9 * width;
	double screen1Height = .4 * height;
	double screen2Width = .7 * screen1Width;
	double screen2Height = screen2Width;

	
        // make the roof.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        /*Line2D.Double leftRoof = 
            new Line2D.Double (x, y + roofHeight,
                               x + width/2.0, y);
                               
        Line2D.Double rightRoof =
            new Line2D.Double (x + width/2.0, y,
	    x + width, y + roofHeight);*/

        // put the whole house together
       
        GeneralPath wholeGameBoy = this.get();
        wholeGameBoy.append(mainPart, false);
        wholeGameBoy.append(screen1, false);
	wholeGameBoy.append(screen2, false);
        wholeGameBoy.append(line1, false); 
	wholeGameBoy.append(line2, false);
	wholeGameBoy.append(line3, false);
	wholeGameBoy.append(line4, false);
	wholeGameBoy.append(line5, false);
	wholeGameBoy.append(line6, false);
        
    }

}
