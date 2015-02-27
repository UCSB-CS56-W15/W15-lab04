package edu.ucsb.cs56.w15.drawings.weiers.advanced;
import java.awt.geom.GeneralPath;
import java.awt.geom.AffineTransform;
import java.awt.Shape;

import java.awt.geom.Ellipse2D;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
  A power outlet with ground

  @author William Eiers
  @version for CS56, W15, UCSB, 02/18/2015
*/
public class PowerOutletWithGround extends PowerOutlet implements Shape {
    /**
       Constructor for objects of type PowerOutlet

       @param x x coordinate of lower left corner of power outlet
       @param y y coord of lower left corner of power outlet
       @param width width of outlet
       @param height height of outlet
    */
    public PowerOutletWithGround(double x, double y, double width, double height) {
        super(x,y,width,height);
        
        // locations of the outlet
        double plugRadius = width/2;
        double topSocketX = x+width/4;
        double topSocketY = y+height+height/8;
        double bottomSocketX = x+width/4;
        double bottomSocketY = y+height+height/2;
        double groundRadius = plugRadius/4;
        // ground hole for top socket
        Ellipse2D.Double topGround = new Ellipse2D.Double (
            topSocketX + plugRadius/2.65,
            topSocketY + plugRadius/1.5,
            groundRadius,
            groundRadius
        );

        // ground hole for bottom socket
        Ellipse2D.Double bottomGround = new Ellipse2D.Double (
            bottomSocketX + plugRadius/2.65,
            bottomSocketY + plugRadius/1.5,
            groundRadius,
            groundRadius
        );
        
        GeneralPath outlet = this.get();
        outlet.append(topGround, false);
        outlet.append(bottomGround, false);

    }
}
