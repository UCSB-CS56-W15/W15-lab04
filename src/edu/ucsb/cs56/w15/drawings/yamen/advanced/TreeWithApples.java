package edu.ucsb.cs56.w15.drawings.yamen.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   An extension of the Tree.java class that adds apples to the tree drawing
   @author Yamen Alghrer
   @version for CS56, W15, UCSB, 02/19/2015
   
*/
public class TreeWithApples extends Tree  implements Shape
{
    /**
     * Constructor
     */
    public TreeWithApples(double x, double y, double width, double height)
    {
	// construct the basic Tree shell
	super(x,y,width,height);

	// get the GeneralPath to append stuff to
	GeneralPath gp = this.get();
	GeneralPath appleStem = this.get();
	// Make five apples that have a radius the 1/10 the size of the width of
	// the top of the tree
	
	double barkH = height *.30;
	double barkW = width *.25;
	double topH = height - barkH;
	double topW = width - barkW;

	double r = 0.10 * topH;
	
	Ellipse2D.Double app1 =
	    new Ellipse2D.Double(x + topW/5, y - topH/5, r, r);
	Ellipse2D.Double app2 =
	    new Ellipse2D.Double(x + topW/2.7, y - topH/2.7, r, r);
	Ellipse2D.Double app3 =
	    new Ellipse2D.Double(x + topW/5, y - topH/1.2, r, r);
	Ellipse2D.Double app4 =
	    new Ellipse2D.Double(x + topW/1.4, y - topH/1.25, r, r);
	Ellipse2D.Double app5 =
	    new Ellipse2D.Double(x + topW/1.25, y - topH/3, r, r);
	Ellipse2D.Double app6 =
	    new Ellipse2D.Double(x + topW/3.5, y - topH/2, r, r);
	// add the apples to the tree

        gp.append(app1, false);
	gp.append(app2, false);
	gp.append(app3, false);
	gp.append(app4, false);
	gp.append(app5, false);
    }

}
