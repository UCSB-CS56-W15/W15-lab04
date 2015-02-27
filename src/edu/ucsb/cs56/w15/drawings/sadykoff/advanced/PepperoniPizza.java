package edu.ucsb.cs56.w15.drawings.sadykoff.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.lang.Math;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A Pizza with Pepperoni
      
   @author Boris Sadykoff
   @version for CS56, W15, UCSB, 02/12/2015
   
*/
public class PepperoniPizza extends Pizza implements Shape
{
    /**
     * Constructor for objects of class Pizza
     */
    public PepperoniPizza(double x, double y, double radius)
    {
	// construct the basic house shell
	super(x,y,radius);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Add a pepperoni per slice
	//
	// radius of the pepperonis will be 1/5 of the radius

	Ellipse2D.Double pepOne = new Ellipse2D.Double(x + .6*radius*Math.cos(Math.toRadians(22.5)),
				   y + .6*radius*Math.sin(Math.toRadians(22.5)),
						       radius/4,radius/4);
	
	Ellipse2D.Double pepTwo = new Ellipse2D.Double(x + .6*radius*Math.cos(Math.toRadians(67.5)),
				   y + .6*radius*Math.sin(Math.toRadians(67.5)),
						       radius/4,radius/4);

	Ellipse2D.Double pepThree = new Ellipse2D.Double(x + .9*radius*Math.cos(Math.toRadians(112.5)),
				     y + .6*radius*Math.sin(Math.toRadians(112.5)),
							 radius/4,radius/4);

	Ellipse2D.Double pepFour = new Ellipse2D.Double(x + .8*radius*Math.cos(Math.toRadians(157.5)),
				    y + .6*radius*Math.sin(Math.toRadians(157.5)),
							radius/4,radius/4);

	Ellipse2D.Double pepFive = new Ellipse2D.Double(x + .75*radius*Math.cos(Math.toRadians(202.5)),
				    y + .8*radius*Math.sin(Math.toRadians(202.5)),
							radius/4,radius/4);

	Ellipse2D.Double pepSix = new Ellipse2D.Double(x + .9*radius*Math.cos(Math.toRadians(247.5)),
				   y + .75*radius*Math.sin(Math.toRadians(247.5)),
						       radius/4,radius/4);

	Ellipse2D.Double pepSeven = new Ellipse2D.Double(x + .5*radius*Math.cos(Math.toRadians(292.5)),
				     y + .75*radius*Math.sin(Math.toRadians(292.5)),
							 radius/4,radius/4);

	Ellipse2D.Double pepEight = new Ellipse2D.Double(x + .6*radius*Math.cos(Math.toRadians(337.5)),
				     y + .8*radius*Math.sin(Math.toRadians(337.5)),
							 radius/4,radius/4);

	// add the pepperonis to the pizza
	
        GeneralPath wholePizza = this.get();
        wholePizza.append(pepOne, false);
	wholePizza.append(pepTwo, false);
	wholePizza.append(pepThree, false);
	wholePizza.append(pepFour, false);
	wholePizza.append(pepFive, false);
	wholePizza.append(pepSix, false);
	wholePizza.append(pepSeven, false);
	wholePizza.append(pepEight, false);		        
    }

}
