package edu.ucsb.cs56.w15.drawings.salolivares.advanced;
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

import edu.ucsb.cs56.w15.drawings.salolivares.simple.Circle;
import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a desktop computer that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Sal Olivares
   @version for CS56, Winter 2015, UCSB
   
*/
public class DesktopComputer extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of Desktop
       @param y y coord of lower left corner of Desktop
       @param width width of the Desktop
       @param height of Desktop
     */
    public DesktopComputer(double x, double y, double width, double height)
    {
        // Component Positions
        double firstCdDiskLowerLeftX = x + (width*.10);
        double secondCdDiskLowerLeftX = firstCdDiskLowerLeftX;
        double powerButtonCenterX = x + (width*.5);

        double firstCdDiskLowerLeftY = y + (height * .10);
        double secondCdDiskLowerLeftY = firstCdDiskLowerLeftY + 2*(height * .10);
        double powerButtonCenterY = secondCdDiskLowerLeftY + (height*.30);
        
        // Component Heights
        double firstCdDiskHeight = .10 * height;
        double secondCdDiskHeight = firstCdDiskHeight;

        // Component Widths
        // | +------------+ |
        // | |            | |
        // | +------------+ |
        // |.10w  .80w  .10w|
        double firstCdDiskWidth = .80 * width;
        double secondCdDiskWidth = firstCdDiskWidth;

        //Circle Radius
        double powerButtonRadius = (.10 * width)/2;
        
        // Make computer tower, cd trays and power button
        
        Rectangle2D.Double DesktopTower = new Rectangle2D.Double(x, y, width, height);
        Rectangle2D.Double CDTrayOne = new Rectangle2D.Double(firstCdDiskLowerLeftX,firstCdDiskLowerLeftY,firstCdDiskWidth,firstCdDiskHeight);
        Rectangle2D.Double CDTrayTwo = new Rectangle2D.Double(secondCdDiskLowerLeftX,secondCdDiskLowerLeftY,secondCdDiskWidth,secondCdDiskHeight);
        Circle powerButton = new Circle(powerButtonCenterX,powerButtonCenterY,powerButtonRadius);

        // put the computer together
       
        GeneralPath wholeComputer = this.get();
        wholeComputer.append(DesktopTower,false);
        wholeComputer.append(CDTrayOne,false);
        wholeComputer.append(CDTrayTwo,false);
        wholeComputer.append(powerButton,false);
    }

}
