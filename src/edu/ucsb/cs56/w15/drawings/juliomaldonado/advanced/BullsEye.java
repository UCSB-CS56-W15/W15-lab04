package edu.ucsb.cs56.w15.drawings.juliomaldonado.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Line2D;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A BullsEye (wrapper around a General Path, implements Shape)   
      
   @author Julio Maldonado 
   @version for CS56, W15, UCSB, 02/20/2015
   
*/
public class BullsEye extends GeneralPathWrapper implements Shape
{

    
    /**
     * Constructor for objects of class BullsEye
     */
    public BullsEye(double x, double y, double width, double height)
    {
     
      
        
        Ellipse2D.Double FirstCircle = new Ellipse2D.Double(x + 2*width/5, x + 2*width/5, width/5, width/5);
	Ellipse2D.Double SecondCircle = new Ellipse2D.Double(x + 3*width/10, x + 3*width/10, width/2.5, width/2.5);
	Ellipse2D.Double ThirdCircle = new Ellipse2D.Double(x + width/10, x + width/10, width/1.25, width/1.25);
	Ellipse2D.Double OuterCircle = new Ellipse2D.Double(x, x, width, width);
	/*
	Line2D.Double MainLength = new Line2D.Double(x+(width/2),x+(width/2),y+width,y);

	Line2D.Double TopLength = new Line2D.Double(y+width,y,y+width,y-(width/5));	
	Line2D.Double BotLength = new Line2D.Double(y+(width),y,y+width+(width/5),y);

	Line2D.Double Mid1Length = new Line2D.Double(y+width-(width/10),y+(width/10),y+width,y-(width/5));	
	Line2D.Double Mid2Length = new Line2D.Double(y+(width)-(width/10),y+(width/10),y+width+(width/5),y);

	Line2D.Double PointTopLength = new Line2D.Double(x+(width/2),x+(width/2),x+(width/2)+(width/20),x+(width/2)-(width/8));
	Line2D.Double PointBotLength = new Line2D.Double(x+(width/2),x+(width/2),x+(width/2)+(width/8),x+(width/2)-(width/20));
	Line2D.Double PointBackLength = new Line2D.Double(x+(width/2)+(width/20),x+(width/2)-(width/8),x+(width/2)+(width/8),x+(width/2)-(width/20));	
	*/

	GeneralPath BullsEye = this.get();
        BullsEye.append(FirstCircle, false);
	BullsEye.append(ThirdCircle, false);
	BullsEye.append(SecondCircle, false);
	BullsEye.append(OuterCircle, false);
	
	/*BullsEye.append(MainLength, false);
	BullsEye.append(TopLength, false);
        BullsEye.append(BotLength, false);
	BullsEye.append(Mid1Length, false);
        BullsEye.append(Mid2Length, false);
        BullsEye.append(PointTopLength, false);
	BullsEye.append(PointBotLength, false);
	BullsEye.append(PointBackLength, false);
	*/
    }


}
