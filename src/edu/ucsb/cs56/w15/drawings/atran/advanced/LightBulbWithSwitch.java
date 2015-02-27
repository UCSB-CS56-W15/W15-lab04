package edu.ucsb.cs56.w15.drawings.atran.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.geom.Arc2D; // abstract class Arc2D allows for arc
import java.awt.geom.Arc2D.Double; // arc in double precision
import java.awt.geom.Ellipse2D; // class for ellipses/circles

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
   A vector drawing that extends LightBulb, adding a switch

   @author Andrew Tran
   @version for CS56, Winter 15, UCSB
*/
public class LightBulbWithSwitch extends LightBulb implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of lightbulb
       @param y y coord of lower left corner of lightbulb
       @param width width of the lightbulb
       @param height height of the lightbulb
    */
    public LightBulbWithSwitch(double x, double y, double width, double height)
    {
	// call super constructor to construct original lightbulb first
	super(0.0,0.0,100.0,200.0);

	// start with dimensions of original LightBulb
	final double ORIG_ULX = 0.0;
	final double ORIG_ULY = 0.0;
	final double ORIG_HEIGHT = 200.0;
	final double ORIG_WIDTH = 100.0;
	final double ORIG_RADIUS = ORIG_WIDTH/2;
	final double ORIG_CHORD = Math.sqrt(2)*ORIG_RADIUS;
	final double ORIG_VERTICAL = Math.sqrt(0.5)*ORIG_RADIUS;

	// specify dimensions of switch
	final double CHAIN_RADIUS = 5;

	

	// create opening rectangle for switch
	Rectangle2D.Double opening =
	    new Rectangle2D.Double(ORIG_WIDTH/4 - ORIG_WIDTH/20,
				   ORIG_HEIGHT*3/4 + ORIG_HEIGHT/20,
				   ORIG_WIDTH/20,
				   ORIG_HEIGHT*30/200);

	// make switch
	Ellipse2D.Double ballOne =
	    new Ellipse2D.Double(ORIG_WIDTH/10,
				 ORIG_HEIGHT*3/4 + CHAIN_RADIUS*4,
				 CHAIN_RADIUS*2,
				 CHAIN_RADIUS*2);

	// add switch to original lightbulb
	GeneralPath gp = this.get();
	gp.append(opening, false);
	for(int i=0; i<7; i++)
	    gp.append(ShapeTransforms.translatedCopyOf(
						       ballOne,
						       0,
						       0 + i*10
						       ),
		      false);

	// move to (x,y)
	Shape s = ShapeTransforms.translatedCopyOf(gp, x, y);

	// scale to correct height and width
	s = ShapeTransforms.scaledCopyOf(s,
					 width/ORIG_WIDTH,
					 height/ORIG_HEIGHT) ;
	// Use GeneralPath constructor that takes shape and returns
	// general path to set our instance variable
	this.set(new GeneralPath(s));
    }

}
