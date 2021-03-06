package edu.ucsb.cs56.w15.drawings.hanna.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;  // ellipses and circles
import edu.ucsb.cs56.w15.drawings.hanna.simple.Circle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A dice that shows one two and three on the visible faces
      
   @author Hanna Vigil
   @version for CS56, W15, UCSB, 02/12/2015
   
*/
public class Dice extends Cube implements Shape
{
    /**
     * Constructor for objects of class Dice
     */
    public Dice(double x, double y, double length)
    {
	// construct the basic cube shape of the die
	super(x,y,length);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	//Make dot arrangement for die
	double x1 = x;
	double x2 = x + 0.375*length;
	double x3 = x + length;
	double x4 = x + 1.375*length;

	double y1 = y;
	double y2 = y - 0.375*length;
	double y3 = y - length;
	double y4 = y - 1.375*length;

	Circle one1 = new Circle(x+0.5*length, (y+y3)/2.0, .1*length);

	Circle two1 = new Circle(x2+0.085*length, (y3+y4)/2.0-.03*length, 0.08*length);
	Circle two2 = new Circle(x3-0.085*length, (y3+y4)/2.0+.03*length, 0.08*length);

	Circle three1 = new Circle((x3+x4)/2.0+.05*length, y3, .05*length);
	Circle three2 = new Circle((x3+x4)/2.0, (y+y4)/2.0, .05*length);
	Circle three3 = new Circle((x3+x4)/2.0-.05*length, y2, .05*length);	

	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeCube = this.get();
        wholeCube.append(one1, false);
        wholeCube.append(two1, false);
	wholeCube.append(two2, false);
        wholeCube.append(three1, false);
	wholeCube.append(three2, false);
	wholeCube.append(three3, false); 
    }

}
