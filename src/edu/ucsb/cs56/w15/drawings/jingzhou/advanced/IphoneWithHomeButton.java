package edu.ucsb.cs56.w15.drawings.jingzhou.advanced;
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
   An Iphone
      
   @author Jingzhou Xue 
   @version for CS56, W15, UCSB, 02/15/2015
   
*/
public class IphoneWithHomeButton extends Iphone implements Shape
{
    /**
     * Constructor for objects of class Iphone
     */
    public IphoneWithHomeButton(double x, double y, double width, double length)
    {
	// construct the basic house shell
	super(x,y,width,length);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	
	double height = .1*length;
	double w = 0.10 * width;
	double winTop = y + 0.5 * height;
	double winHt =  0.25 * height;
	//double homebuttonX = x + width*2/5;
	double homebuttonY = y + 0.8*length + length * 1/30;
	double homebuttonD = (float)4/30 *length;
	double homebuttonR = 0.5*homebuttonD;
	double homebuttonX = x + 0.5*width - homebuttonR;
	//Rectangle2D.Double win1 =
	//    new Rectangle2D.Double(x + w, winTop, 2.0 * w, winHt);
	//Rectangle2D.Double win2 =
	//    new Rectangle2D.Double(x + 4.0*w, winTop, 2.0 * w, winHt);
	//Rectangle2D.Double win3 =
	//   new Rectangle2D.Double(x + 7.0*w, winTop, 2.0 * w, winHt);
	Ellipse2D.Double homebutton = 
		new Ellipse2D.Double(homebuttonX, homebuttonY, homebuttonD, homebuttonD);
	//Ellipse2D.Double homeButton = 
	//	new Ellipse2D.Double(x+width*0.4

	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath iphoneScreen = this.get();
        iphoneScreen.append(homebutton, false);
        //iphoneScreen.append(win3, false);
//wholeHouse.append(win2, false);
        //wholeHouse.append(win3, false); 
    }

}
