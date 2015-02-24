package edu.ucsb.cs56.w15.drawings.shayan.advanced;
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
   A DDR Pad with Arrows
      
   @author Shayan Sadigh
   @version for CS56, W14
*/

public class DDRPad extends DDRPadBlank implements Shape
{
    /**
     * Constructor for objects of class DDRPad
     */
    public DDRPad(double x)
    {
	// construct a blank DDR Pad
	super(x);

	DDRArrow ddra1 = new DDRArrow(x/3);
	Shape ddrA1 = ShapeTransforms.translatedCopyOf(ddra1, x/3, x/3);
	DDRArrow ddra2 = new DDRArrow(x/3);
	Shape ddrA2 = ShapeTransforms.translatedCopyOf(ddra2, 0, 2*x/3);	
	ddrA2 = ShapeTransforms.rotatedCopyOf(ddrA2, 3*Math.PI/2);
	DDRArrow ddra3 = new DDRArrow(x/3);
	Shape ddrA3 = ShapeTransforms.translatedCopyOf(ddra3, x/3, x);	
	ddrA3 = ShapeTransforms.rotatedCopyOf(ddrA3, Math.PI);
	DDRArrow ddra4 = new DDRArrow(x/3);
	Shape ddrA4 = ShapeTransforms.translatedCopyOf(ddra4, 2*x/3, 2*x/3);
	ddrA4 = ShapeTransforms.rotatedCopyOf(ddrA4, Math.PI/2);
	
	//add the arrows to the blank DDR Pad.

    GeneralPath gp = this.get();
    gp.append(ddrA1, false);
    gp.append(ddrA2, false);
    gp.append(ddrA3, false); 
	gp.append(ddrA4, false);
    }

}
