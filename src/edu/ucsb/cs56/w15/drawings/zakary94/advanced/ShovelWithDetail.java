package edu.ucsb.cs56.w15.drawings.zakary94.advanced;
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
    A Shovel with Added Detail
          
 	@author Phill Conrad 
  	@version for CS56, W15, UCSB                   
 */
public class ShovelWithDetail extends Shovel implements Shape{
	
 /**
     Constructor
 
       	@param x x coord of top of shovel shaft
        @param y y coord of top of shovel shaft
 	@param height of the shovel extending downward from coordinates
*/
	public ShovelWithDetail(double x, double y,double height){

	super(x,y,height);
	GeneralPath gp = this.get();

	double shaftWidth =(height/12.0)*(0.95);
	double handleWidth = shaftWidth*3.0;
	double handleHeight = handleWidth*2.0/3.0;
// create outer handle
        Rectangle2D.Double myHandleOut = 
		new Rectangle2D.Double(
			x-0.5*shaftWidth-(1.0/3.0)*handleWidth,
			y-handleHeight,	
			handleWidth,
			handleHeight);	
// create inner handle
	double iSW = handleWidth*(0.8);
	double iSH = handleHeight*(0.6);

Rectangle2D.Double myHandleIn =
                new Rectangle2D.Double(
                        x-0.5*shaftWidth-(1.0/3.0)*handleWidth+(0.1*handleWidth),
                        y-handleHeight+(0.2*handleHeight), 
                        iSW,
                        iSH);
// add shaft detail
	Line2D.Double L1 = new Line2D.Double();
	L1.setLine(x-0.5*shaftWidth,y+(0.1*height),x+.5*shaftWidth,y+(0.1*height));

        Line2D.Double L2 = new Line2D.Double();
        L2.setLine(x-0.5*shaftWidth,y+(0.1*height)*7,x+.5*shaftWidth,y+(0.1*height)*7);
// add head detail
	Line2D.Double L3 = new Line2D.Double();
	L3.setLine(x-2.5*shaftWidth,y+height*(.85),x+2.5*shaftWidth,y+height*(.85));

        Line2D.Double L4 = new Line2D.Double();
        L4.setLine(x-2.5*shaftWidth,y+height*(.85),x-2.8*shaftWidth,y+height);

        Line2D.Double L5 = new Line2D.Double();
        L5.setLine(x+2.5*shaftWidth,y+height*(.85),x+2.8*shaftWidth,y+height);

	GeneralPath fShovel = this.get();
	fShovel.append(myHandleOut,false);
	fShovel.append(myHandleIn,false);
	fShovel.append(L1, false);
	fShovel.append(L2, false);	
	fShovel.append(L3, false);
        fShovel.append(L4, false);
        fShovel.append(L5, false);




}//end constructor
} // end class
