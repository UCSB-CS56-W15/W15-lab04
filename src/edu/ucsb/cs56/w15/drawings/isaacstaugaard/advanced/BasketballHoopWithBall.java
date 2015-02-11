package edu.ucsb.cs56.w15.drawings.isaacstaugaard.advanced;
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
/**
   A Basketball Hoop
      
   @author Phill Conrad, Isaac Staugaard 
   @version for CS56, W15, UCSB, 02/10/2015
   
*/
public class BasketballHoopWithBall extends BasketballHoop implements Shape
{
    /**
     * Constructor for objects of class BasketballHoop
     */
    public BasketballHoopWithBall(double x, double y, double width, double height)
    {
	// construct the basic BasketballHoop shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	double ballWidth = 0.3 * width;
	double ballHeight = 0.3 * height;
	double ballXLocation = x + .75 * width;
	double ballYLocation = y + .45 * height;
	double ballXPlusBallWidth = ballXLocation + ballWidth;
	double ballYPlusBallHeight = ballYLocation + ballHeight;
	
	Ellipse2D.Double basketball = new Ellipse2D.Double(ballXLocation,ballYLocation,ballWidth,ballHeight);
	
	GeneralPath ballLines = new GeneralPath ();
	ballLines.moveTo(ballXLocation, ballYLocation + (ballHeight / 2));
	ballLines.lineTo(ballXLocation + ballWidth, ballYLocation + (ballHeight / 2));

	ballLines.moveTo(ballXLocation + (ballWidth / 2), ballYLocation);
	ballLines.lineTo(ballXLocation + (ballWidth / 2), ballYLocation + ballHeight);

	ballLines.moveTo(ballXLocation + (ballWidth * 2 / 9), ballYLocation + (ballHeight * .1 ));
	ballLines.curveTo(ballXLocation + (ballWidth / 3), ballYLocation + (ballHeight / 4),
			  ballXLocation + (ballWidth / 3), ballYLocation + (ballHeight * 3 / 4),
			  ballXLocation + (ballWidth * 2 / 9), ballYLocation + (ballHeight * .9));

	ballLines.moveTo(ballXPlusBallWidth - (ballWidth * 2 / 9), ballYLocation + (ballHeight * .1));
	ballLines.curveTo(ballXPlusBallWidth - (ballWidth / 3), ballYLocation + (ballHeight / 4),
			  ballXPlusBallWidth - (ballWidth / 3), ballYLocation + (ballHeight * 3 / 4),
			  ballXPlusBallWidth - (ballWidth * 2 / 9), ballYLocation + (ballHeight * .9));
	
	GeneralPath entireBall = new GeneralPath ();
	entireBall.append(basketball, false);
	entireBall.append(ballLines,false);

	Ellipse2D.Double head = new Ellipse2D.Double(ballXLocation + (ballWidth * 5 / 4), ballYLocation + (ballHeight * 5 / 4), ballWidth * 3 / 4, ballHeight * 3 / 4);
	
	GeneralPath body = new GeneralPath (); 
	body.moveTo(ballXLocation + (ballWidth * 5 / 4) + (ballWidth * 3 / 8), ballYLocation + (ballHeight * 2 * 1.041667));     //Torso
	body.lineTo(ballXLocation + (ballWidth * 5 / 4) + (ballWidth * 3 / 8), ballYLocation + (ballHeight * 4.75));

	body.moveTo(ballXLocation + (ballWidth * 5 / 4) + (ballWidth * 3 / 8), ballYLocation + (ballHeight * 2 * 1.041667) + ballHeight);  //dunking arm
	body.lineTo(ballXLocation + (ballWidth * 3 / 4 ), ballYLocation + (ballHeight * .9));
		    
	body.moveTo(ballXLocation + (ballWidth * 1.25) + (ballWidth * 3 / 8), ballYLocation + (ballHeight * 2 * 1.041667) + ballHeight);  //other arm
	body.lineTo(ballXLocation + (ballWidth * 2.45), ballYLocation + (ballHeight * 2 * 1.041667) + (ballHeight * 2.25));
	
	body.moveTo(ballXLocation + (ballWidth * 1.25) + (ballWidth * 3 / 8), ballYLocation + (ballHeight * 4.75));    //left leg
	body.lineTo(ballXLocation + (ballWidth * .75), ballYLocation + (ballHeight * 6));
	
	body.moveTo(ballXLocation + (ballWidth * 1.25) + (ballWidth * 3 / 8), ballYLocation + (ballHeight * 4.75));    //right leg
	body.lineTo(ballXLocation + (ballWidth * 1.25) + (ballWidth * 5 / 4), ballYLocation + (ballHeight * 6.1));

	GeneralPath personWithBall = new GeneralPath ();
	personWithBall.append(entireBall, false);
	personWithBall.append(head, false);
	personWithBall.append(body, false);
	
	
	// add the basketballs 
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeBackboardPlusBall = this.get();
        wholeBackboardPlusBall.append(personWithBall, false);
    }

}
