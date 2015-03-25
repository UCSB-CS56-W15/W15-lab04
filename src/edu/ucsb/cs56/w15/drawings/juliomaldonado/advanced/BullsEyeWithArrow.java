package edu.ucsb.cs56.w15.drawings.juliomaldonado.advanced;
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
   An Arrow
      
   @author Julio Maldonado
   @version for CS56, W15, UCSB, 02/21/2015
   
*/
public class BullsEyeWithArrow extends BullsEye implements Shape
{
    /**
     * Constructor for objects of class BullsEyeWithArrow
     */
    public BullsEyeWithArrow(double x, double y, double width, double height)
    {
      
	super(x,y,width,height);

	Line2D.Double MainLength = new Line2D.Double(y+(height/2),y+(height/2),y+height,y);

	Line2D.Double TopLength = new Line2D.Double(y+height,y,y+height,y-(height/5));	
	Line2D.Double BotLength = new Line2D.Double(y+height,y,y+height+(height/5),y);

	Line2D.Double Mid1Length = new Line2D.Double(y+height-(height/10),y+(height/10),y+height,y-(height/5));	
	Line2D.Double Mid2Length = new Line2D.Double(y+(height)-(height/10),y+(height/10),y+height+(height/5),y);

	Line2D.Double PointTopLength = new Line2D.Double(y+(height/2),y+(height/2),y+(height/2)+(height/20),y+(height/2)-(height/8));
	Line2D.Double PointBotLength = new Line2D.Double(y+(height/2),y+(height/2),y+(height/2)+(height/8),y+(height/2)-(height/20));
	Line2D.Double PointBackLength = new Line2D.Double(y+(height/2)+(height/20),y+(height/2)-(height/8),y+(height/2)+(height/8),y+(height/2)-(height/20));	

	
	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath BEWArrow = this.get();
	BEWArrow.append(MainLength, false);
	BEWArrow.append(TopLength, false);
        BEWArrow.append(BotLength, false);
	BEWArrow.append(Mid1Length, false);
        BEWArrow.append(Mid2Length, false);
        BEWArrow.append(PointTopLength, false);
	BEWArrow.append(PointBotLength, false);
	BEWArrow.append(PointBackLength, false);
    }

}
