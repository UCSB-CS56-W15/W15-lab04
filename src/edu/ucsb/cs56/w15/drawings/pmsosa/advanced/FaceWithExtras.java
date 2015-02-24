package edu.ucsb.cs56.w15.drawings.pmsosa.advanced;
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
   A Face
      
   @author Pedro M. Sosa
   @version for CS56, W15, UCSB, 02/11/2015
   
*/
public class FaceWithExtras extends Face implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public FaceWithExtras(double x, double y, double width, double height)
    {
	// construct the basic face shell
	super(x,y,width,height);

    //EyeLids
    Line2D.Double lf_eyelid = new Line2D.Double((x+(0.125)*width),(y+0.2*height),(x+(0.375)*width),(y+0.2*height));
    Line2D.Double rt_eyelid = new Line2D.Double((x+(0.625)*width),(y+0.2*height),(x+(0.875)*width),(y+0.2*height));

    //Tooth
    Rectangle2D.Double tooth = new Rectangle2D.Double((x+(0.33)*width),(y+(0.725)*height),((0.33)*width),((0.1)*height));

    //Pupils
    Rectangle2D.Double lf_pupil = new Rectangle2D.Double((x+(0.20)*width),(y+0.45*height),(0.1*width),(0.1*height));
    Rectangle2D.Double rt_pupil = new Rectangle2D.Double((x+(0.70)*width),(y+0.45*height),(0.1*width),(0.1*height));

    //Adding to Path
    GeneralPath face = this.get();
    face.append(lf_eyelid,false);
    face.append(rt_eyelid,false);
    face.append(tooth,false);
    face.append(lf_pupil,false);
    face.append(rt_pupil,false);

    }

}
