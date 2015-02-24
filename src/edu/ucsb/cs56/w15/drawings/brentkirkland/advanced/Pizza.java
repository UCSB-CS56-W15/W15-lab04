package edu.ucsb.cs56.w15.drawings.brentkirkland.advanced;
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
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

import static java.lang.Math.*;

/**
   A vector drawing of a pizza that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad
   @author Brent Kirkland 
   @version for CS56, Winter 15, UCSB
   
*/
public class Pizza extends GeneralPathWrapper implements Shape
{

    /**
       Constructor

       @param x x coordinate that is center of circle
       @param y y coord that is center of circle
       @param width width of the pizza
       @param height of pizza
     */
    public Pizza(double x, double y, double width, double height)
    {
 	
	//center coordinate is calculated by taking x - width / 2 for x coordinate at cennter
	//for y coordinate, it's y - height / 2

	Ellipse2D.Double crust =
                        new Ellipse2D.Double(x - width /2 ,y - height/2, width, height);
	

	// width of sauce is 90% of original pizza size
	Ellipse2D.Double sauce =
                        new Ellipse2D.Double(x - width * 0.9 / 2, y - height * 0.9 / 2, width*0.9, height*0.9);
	// width of cheese is 85% of original pizza size
	Ellipse2D.Double cheese = new Ellipse2D.Double(x - width * 0.85 / 2, y - height * 0.85 / 2, width*0.85, height*0.85);

	//slice the pizza horizontally
	Line2D.Double horizontal = new Line2D.Double(x - width / 2, y, x + width / 2, y);

	//slice it vertically
	Line2D.Double vertical = new Line2D.Double(x, y - height/2, x, y + height/2);

	//slice it \
	Line2D.Double forwardSlash = new Line2D.Double(x - (width/4) * sqrt(2), y - (height/4) * sqrt(2), x + width/4 * sqrt(2), y + height/4 * sqrt(2));

	//slice it /
	Line2D.Double backwardSlash = new Line2D.Double(x + (width/4) * sqrt(2), y - (height/4) * sqrt(2), x - width/4 * sqrt(2), y + height/4 * sqrt(2));


	GeneralPath wholePizza = this.get();
        wholePizza.append(crust, false);
        wholePizza.append(sauce, false);
        wholePizza.append(cheese, false);
	wholePizza.append(horizontal, false);
	wholePizza.append(vertical, false);
	wholePizza.append(forwardSlash, false);
	wholePizza.append(backwardSlash, false);
    }

}
