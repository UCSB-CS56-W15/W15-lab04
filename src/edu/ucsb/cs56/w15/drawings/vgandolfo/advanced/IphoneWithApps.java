package edu.ucsb.cs56.w15.drawings.vgandolfo.advanced;
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
   An Iphone with Apps on the screen
      
   @author Vincent Gandolfo
   @version for CS56, W15, UCSB, 
   
*/
public class IphoneWithApps extends Iphone implements Shape
{
    /**
     * Constructor for objects of class IphoneWithApps

       @param x x coord of lower left corner of iPhone
       @param y y coord of lower left corner of iPhone
       @param width width of the iPhone
       @param height of the iPhone

     */
    public IphoneWithApps(double x, double y, double width, double height)
    {
	
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	


	//Make 7 apps on the screen

	Rectangle2D.Double app1 =
	    new Rectangle2D.Double(x + width * .2, y + height * .094 , width * .15, width * .15);
	Rectangle2D.Double app2 =
	    new Rectangle2D.Double(x + (width * .4), y + height * .094, width * .15 ,width * .15);
	Rectangle2D.Double app3 =
	    new Rectangle2D.Double(x + (width * .6), y + height * .094, width * .15 ,width * .15);
	Rectangle2D.Double app4 =
	    new Rectangle2D.Double(x + width * .2, y + height * .3, width * .15 ,width * .15);
	Rectangle2D.Double app5 =
	    new Rectangle2D.Double(x + (width * .4), y + height * .3, width * .15 ,width * .15);
	Rectangle2D.Double app6 =
	    new Rectangle2D.Double(x + (width * .6), y + height * .3, width * .15 ,width * .15);
	Rectangle2D.Double app7 =
	    new Rectangle2D.Double(x + width * .2, y + height *.6, width * .15,width * .15);	
	




	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeIphone = this.get();
        wholeIphone.append(app1, false);
        wholeIphone.append(app2, false);
        wholeIphone.append(app3, false); 
	wholeIphone.append(app4, false); 
	wholeIphone.append(app5, false); 
	wholeIphone.append(app6, false); 
	wholeIphone.append(app7, false); 
    }

}
