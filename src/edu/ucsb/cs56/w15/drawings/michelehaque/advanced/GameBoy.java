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

	double widDiff1 = width - screen1Width;
	double widDiff2 = width - screen2Width;
	double heiDiff1 = height - screen1Height;
	double heiDiff2 = height - screen2Height;

	Rectangle2D.Double screen1 = new Rectangle2D.Double(x+(widDiff1/2), y+(widDiff1/2), screen1Width, screen1Height); 
	Rectangle2D.Double screen2 = new Rectangle2D.Double(x+(widDiff2/2), y+(widDiff2/2), screen2Width, screen2Height);
	
        // Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
	
	Line2D.Double line1 = new Line2D.Double(x+width-16, y+height-12, x+width-12, y+height-4);
	Line2D.Double line2 = new Line2D.Double(x+width-14, y+height-14, x+width-10, y+height-6);
	Line2D.Double line3 = new Line2D.Double(x+width-12, y+height-16, x+width-8, y+height-8);
	Line2D.Double line4 = new Line2D.Double(x+width-10, y+height-18, x+width-6, y+height-10);
	Line2D.Double line5 = new Line2D.Double(x+width-8, y+height-20, x+width-4, y+height-12);
	Line2D.Double line6 = new Line2D.Double(x+width-6, y+height-22, x+width-2, y+height-14);

        // put the whole GameBoy together
       
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
