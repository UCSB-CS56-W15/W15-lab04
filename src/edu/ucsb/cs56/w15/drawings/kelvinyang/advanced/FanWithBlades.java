package edu.ucsb.cs56.w15.drawings.kelvinyang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.CubicCurve2D;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A Fan, with blades
      
   @author Kelvin Yang 
   @version for CS56, W15, UCSB, 02/05/2015
   
*/
public class FanWithBlades extends Fan implements Shape
{
    /**
     * Constructor for FanWithBlades
     * @param x x coordinate of top left of fan
     * @param y y coordinate of top left of fan
     * @param height the height of the fan
     */
    public FanWithBlades(double x, double y, double height)
    {
        //Draw the rest of the fan using super
        super(x, y, height);
        
        // "fan blade x" & "fan blade y"
        double fbx, fby;
        double width = 2 * height / 3;
        
        // Create each blade of the fan (Total 4)
        fbx = x + width * 0.5;
        fby = y + width * 0.375;
        CubicCurve2D fanBlade1 = new CubicCurve2D.Double(fbx, fby, fbx - width * 0.75, fby - width * 0.125, fbx + width * 0.75, fby - width * 0.625, fbx, fby);
        fbx = x + width * 0.625;
        fby = y + width * 0.5;
        CubicCurve2D fanBlade2 = new CubicCurve2D.Double(fbx, fby, fbx + width * 0.125, fby - width * 0.75, fbx + width * 0.625, fby + width * 0.75, fbx, fby);
        fbx = x + width * 0.5;
        fby = y + width * 0.625;
        CubicCurve2D fanBlade3 = new CubicCurve2D.Double(fbx, fby, fbx + width * 0.75, fby + width * 0.125, fbx - width * 0.75, fby + width * 0.625, fbx, fby);
        fbx = x + width * 0.375;
        fby = y + width * 0.5;
        CubicCurve2D fanBlade4 = new CubicCurve2D.Double(fbx, fby, fbx - width * 0.125, fby + width * 0.75, fbx - width * 0.625, fby - width * 0.75, fbx, fby);
        
        //Get the rest of the fan
        GeneralPath wholeFan = this.get();
        
        //Add each blade to the fan
        wholeFan.append(fanBlade1, false);
        wholeFan.append(fanBlade2, false);
        wholeFan.append(fanBlade3, false);
        wholeFan.append(fanBlade4, false);
    }
}