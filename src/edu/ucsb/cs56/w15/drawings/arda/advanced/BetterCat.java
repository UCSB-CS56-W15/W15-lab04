package edu.ucsb.cs56.w15.drawings.arda.advanced;
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
   A Cat face
    @author Phill Conrad
 *  @author Arda Ungun
 *  @version for UCSB CS56, W15, 02/20/2015
*/
public class BetterCat extends Cat implements Shape {
    /**
     * Constructor for objects of class CoffeeCup
     */
    public BetterCat(double x, double y, double radius)
    {
	// construct the basic house shell

	super(x,y,radius);




    // Assemble Nose

	Line2D.Double noseTop = 
		new Line2D.Double(x-(0.25)*radius, y, 
						x + (0.25)*radius, y);

	Line2D.Double noseLeft =
		new Line2D.Double(x-(0.25)*radius, y,
						x, y+(0.25)*radius);

	Line2D.Double noseRight =
		new Line2D.Double(x+(0.25)*radius, y,
						x, y+(0.25)*radius);





	// Right Whiskers (3 total)

	Line2D.Double rightWhisker_top = 
		new Line2D.Double(x+(0.75)*radius, y - (0.25)*radius,
						x+(5.0/4.0)*radius, y - (0.5)*radius);

	Line2D.Double rightWhisker_mid = 
		new Line2D.Double(x+(0.75)*radius, y,
						x+(1.5)*radius, y);

	Line2D.Double rightWhisker_bot = 
		new Line2D.Double(x+(0.75)*radius, y + (0.25)*radius,
						x+(5.0/4.0)*radius, y + (0.5)*radius);





	// Left Whiskers (3 total)

	Line2D.Double leftWhisker_top = 
		new Line2D.Double(x-(0.75)*radius, y - (0.25)*radius,
						x-(5.0/4.0)*radius, y - (0.5)*radius);

	Line2D.Double leftWhisker_mid = 
		new Line2D.Double(x-(0.75)*radius, y,
						x-(1.5)*radius, y);

	Line2D.Double leftWhisker_bot = 
		new Line2D.Double(x-(0.75)*radius, y + (0.25)*radius,
						x-(5.0/4.0)*radius, y + (0.5)*radius);






	// get the GeneralPath that we are going to append the new lines to
	GeneralPath gp = this.get();

	// add nose to drawing
	gp.append(noseTop, false);
	gp.append(noseLeft, false);
	gp.append(noseRight, false); 

	// add right whiskers to drawing
	gp.append(rightWhisker_bot, false);
	gp.append(rightWhisker_mid, false);
	gp.append(rightWhisker_top, false); 

	// add right whiskers to drawing
	gp.append(leftWhisker_bot, false);
	gp.append(leftWhisker_mid, false);
	gp.append(leftWhisker_top, false); 


    } // class BetterCat

}
