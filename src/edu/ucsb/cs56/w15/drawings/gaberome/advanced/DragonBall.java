package edu.ucsb.cs56.w15.drawings.gaberome.advanced;
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
   
      
   @author Gabriel Romero 
   @version for CS56, W15, UCSB, 02/20/2015
   
*/
public class DragonBall extends Ball implements Shape
{
    public DragonBall(double x, double y, double r)
    {
	super(x,y,r);
	

	y -= .3*r;
        Line2D.Double s1 = 
            new Line2D.Double (x,y,
                               x + .18*r, y+ r/2);
	
        Line2D.Double s2 = 
            new Line2D.Double (x + .18*r, y + r/2,
                               x - r/4, y+ .19*r);
	
        Line2D.Double s3 = 
            new Line2D.Double (x-r/4, y+ .19*r,
                               x + r/4, y+.19*r);
	
        Line2D.Double s4 = 
            new Line2D.Double (x + r/4,y+ .19*r,
                               x - .18*r, y+ r/2);
	
        Line2D.Double s5 = 
            new Line2D.Double (x -.18*r,y+r/2,
                               x, y);
      
        GeneralPath DragonBall = this.get();
        DragonBall.append(s1, false);
	DragonBall.append(s2, false);
        DragonBall.append(s3, false);
        DragonBall.append(s4, false);
        DragonBall.append(s5, false);

	

    }

}
