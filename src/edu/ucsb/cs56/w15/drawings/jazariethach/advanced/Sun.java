package edu.ucsb.cs56.w15.drawings.jazariethach.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
// all imports below this line needed if you are implementing Shape
import java.awt.geom.Ellipse2D; // ellipses and circles
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A drawing of the Sun that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
   @author Jazarie Thach
   @version for CS56, Winter 15, UCSB
*/
public class Sun extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       @param x x coord of center of Sun
       @param y y coord of center of Sun
       @param r radius of the Sun
    */
    public Sun(double x, double y, double r, double r2)
    {

	Ellipse2D.Double sunFace =
	    new Ellipse2D.Double(x-r, y-r2, r*2, r2*2);
	// make the roof. Remember that y goes DOWN the page,
	// so we ADD to y to get a "lower" value on the screen
	Line2D.Double tl =
	    new Line2D.Double (x , y - 1.5*r2,
			       x - r*.50, y - r2*.85 );
	Line2D.Double bl =
	    new Line2D.Double (x - 1.5*r , y,
			       x - r*.85, y - r2*.50 );
	Line2D.Double tr =
	    new Line2D.Double (x + 1.5*r, y,
			       x + r*.85, y - r2*.50 );
	Line2D.Double br =
	    new Line2D.Double (x + r*.50 , y + r2*.85,
			       x , y +1.5*r2 );
	Line2D.Double tl2 =
	    new Line2D.Double (x , y - 1.5*r2 ,
			       x + r*.50 , y - r2*.85 );
	Line2D.Double bl2 =
	    new Line2D.Double (x - 1.5*r , y,
			       x - r*.85, y + r2*.50 );
	Line2D.Double tr2 =
	    new Line2D.Double (x + 1.5*r, y,
			       x + r*.85, y + r2*.50 );
	Line2D.Double br2 =
	    new Line2D.Double (x - r*.50 , y + r2*.85,
			       x , y +1.5*r2 );
	// put the sun together
	GeneralPath wholeSun = this.get();
	wholeSun.append(sunFace, false);
	wholeSun.append(tl, false);
	wholeSun.append(bl, false);
	wholeSun.append(tr, false);
	wholeSun.append(br, false);
	wholeSun.append(tl2, false);
	wholeSun.append(bl2, false);
	wholeSun.append(tr2, false);
	wholeSun.append(br2, false);
    }
}
