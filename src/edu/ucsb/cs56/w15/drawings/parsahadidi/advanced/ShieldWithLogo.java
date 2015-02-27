package edu.ucsb.cs56.w15.drawings.parsahadidi.advanced;
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
   A Shield
      
   @author Parsa Hadidi
   @version for CS56, W15, UCSB, 02/3/2015
   
*/
public class ShieldWithLogo extends Shield implements Shape
{

    public ShieldWithLogo(double x, double y, double width, double height)
    {
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	double center = 0.1 * width;
	double logoTop = y + 0.1 * height;
	double logoHt =  0.1 * height;

	Rectangle2D.Double logo = new Rectangle2D.Double(x + 1.5 * center, logoTop, 2.0 * center, logoHt);

        GeneralPath wholeShield = this.get();
        wholeShield.append(logo, false); 
    }

}
