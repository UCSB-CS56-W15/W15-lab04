package edu.ucsb.cs56.w15.drawings.mbahia.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A drawing of an ice cream cone with toppings that extends 
   IceCreamCone and implements shape. It uses Lines and Arcs. 
      
   @author Manpreet Bahia
   @version for CS56, W15, UCSB, 02/05/2015
   
*/
public class IceCreamConeWithToppings extends IceCreamCone implements Shape
{
    /**
     * Constructor for making ice cream cone with toppings
     @param x used to determine placement of ice cream cone, cherry, and sprinkles
     @param y used to determine placement of ice cream cone, cherry, and sprinkles
     @param base used to determine placed of ice cream cone, cherry, and sprinkles
     @param height used to determine length of ice cream cone 
     */
    public IceCreamConeWithToppings(double x, double y, double base, double height)
    {
	// construct the ice cream cone with ice cream
	super(x,y,base,height);


	Arc2D.Double cherry = new Arc2D.Double ((x + base/2.0) - x/30.0, y/2.0 - y/10.0, base/10.0, y/10.0, 0, 360, Arc2D.OPEN);

	
	// have 10 sprinkles on the ice cream cone
	// row 1
	Line2D.Double sprinkle1 = new Line2D.Double (x + x*0.3 + base/5.0, y*0.525, x + x*0.3 + base/10.0, y*0.525 + y*0.05);
	// row 2
        Line2D.Double sprinkle2 = new Line2D.Double (x + x*0.15 + base/5.0, y*0.625, x + x*0.15 +  base/10.0, y*0.625 + y*.05);
        Line2D.Double sprinkle3 = new Line2D.Double (x + x*0.45 + base/5.0, y*0.625, x + x*0.45 +  base/10.0, y*0.625 + y*.05);
	// row 3
	Line2D.Double sprinkle4 = new Line2D.Double (x + base/5.0, y*0.75, x + base/10.0, y*0.75 + y*0.05);
	Line2D.Double sprinkle5 = new Line2D.Double (x + x*0.3 + base/5.0, y*0.75, x + x*0.3 + base/10.0, y*0.75 + y*0.05);
	Line2D.Double sprinkle6 = new Line2D.Double (x + x*0.6 + base/5.0, y*0.75, x + x*0.6 + base/10.0, y*0.75 + y*0.05);
	// row 4
	Line2D.Double sprinkle7 = new Line2D.Double (x - x*0.09 + base/5.0, y*0.875, x - x*0.09 + base/10.0, y*0.875 + y*0.05);
	Line2D.Double sprinkle8 = new Line2D.Double (x + x*0.15 + base/5.0, y*0.875, x + x*0.15 + base/10.0, y*0.875 + y*0.05);
        Line2D.Double sprinkle9 = new Line2D.Double (x + x*0.45 + base/5.0, y*0.875, x + x*0.45 + base/10.0, y*0.875 + y*0.05);
	Line2D.Double sprinkle10 = new Line2D.Double (x + x*0.75 + base/5.0, y*0.875, x + x*0.75 + base/10.0, y*0.875 + y*0.05);

	// add the cherry and sprinkles

        GeneralPath IceCCToppings = this.get();
	IceCCToppings.append(cherry, false);
	IceCCToppings.append(sprinkle1, false);
	IceCCToppings.append(sprinkle2, false);
	IceCCToppings.append(sprinkle3, false);
	IceCCToppings.append(sprinkle4, false);
	IceCCToppings.append(sprinkle5, false);
	IceCCToppings.append(sprinkle6, false);
	IceCCToppings.append(sprinkle7, false);
	IceCCToppings.append(sprinkle8, false);
	IceCCToppings.append(sprinkle9, false);
	IceCCToppings.append(sprinkle10, false);
    }
}
