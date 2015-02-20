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
   A House
      
   @author Phill Conrad 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class BetterCat extends Cat implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public BetterCat(double x, double y, double radius)
    {
	// construct the basic house shell

	super(x,y,radius);




    // Assemble Nose

	Line2D.Double noseTop = 
		new Line2D.Double(x-(1/8)*radius, y, 
						x + (1/8)*radius, y);

	Line2D.Double noseLeft =
		new Line2D.Double(x-(1/8)*radius, y,
						x, y+(1/8)*radius);

	Line2D.Double noseRight =
		new Line2D.Double(x-(1/8)*radius, y,
						x, y+(1/8)*radius);





	// Right Whiskers (3 total)

	Line2D.Double rightWhisker_top = 
		new Line2D.Double(x+(3/8)*radius, y - (1/8)*radius,
						x+(5/8)*radius, y - (2/8)*radius);

	Line2D.Double rightWhisker_mid = 
		new Line2D.Double(x+(3/8)*radius, y,
						x+(5/8)*radius, y);

	Line2D.Double rightWhisker_bot = 
		new Line2D.Double(x+(3/8)*radius, y + (1/8)*radius,
						x+(5/8)*radius, y + (2/8)*radius);





	// Left Whiskers (3 total)

	Line2D.Double leftWhisker_top = 
		new Line2D.Double(x-(3/8)*radius, y - (1/8)*radius,
						x-(5/8)*radius, y - (2/8)*radius);

	Line2D.Double leftWhisker_mid = 
		new Line2D.Double(x-(3/8)*radius, y,
						x-(5/8)*radius, y);

	Line2D.Double leftWhisker_bot = 
		new Line2D.Double(x-(3/8)*radius, y + (1/8)*radius,
						x-(5/8)*radius, y + (2/8)*radius);






	// get the GeneralPath that we are going to append the new lines to
	GeneralPath gp = this.get();




	// add nose to drawing

        GeneralPath wholeHouse = this.get();
        wholeHouse.append(win1, false);
        wholeHouse.append(win2, false);
        wholeHouse.append(win3, false); 
    } // class BetterCat

}
