package edu.ucsb.cs56.w15.drawings.salolivares.advanced;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

// all imports below this line needed if you are implementing Shape

/**
   A Desktop computer with a monitor
      
   @author Sal Olivares
   @version for CS56, W15, UCSB, 02/07/2015
   
*/
public class DesktopComputerWithMonitor extends DesktopComputer implements Shape
{
    public DesktopComputerWithMonitor(double x, double y, double width, double height)
    {
	    // construct the basic Desktop Computer shell
	    super(x,y,width,height);

	    // get the GeneralPath that we are going to append stuff to
	    GeneralPath gp = this.get();

        // monitor constraints
        double monitorScreenWidth = width * 2;
        double monitorScreenHeight = height * .80;
        double monitorBaseWidth = width;
        double monitorBaseHeight = height * .08;
        double monitorStandStemHeight = height * .08;
        double monitorStandStemWidth = monitorScreenWidth * .25;
        double monitorInnerScreenWidth = monitorScreenWidth * .8;
        double monitorInnerScreenHeight = monitorScreenHeight * .8;

        //monitor position
        double monitorScreenBottomLeftX = x + width*1.5;
        double monitorScreenBottomLeftY = y;
        double monitorInnerScreenBottomLeftX = monitorScreenBottomLeftX + monitorScreenWidth*.1;
        double monitorInnerScreenBottomLeftY = monitorScreenBottomLeftY + monitorScreenHeight*.1;

        //monitor base positon
        double monitorBaseBottomLeftX = monitorScreenBottomLeftX + .25*monitorScreenWidth;
        double monitorBaseBottomLeftY = y + monitorScreenHeight + monitorBaseHeight;
        double monitorStandStemBottomLeftX = monitorBaseBottomLeftX + monitorBaseWidth*.26;
        double monitorStandStemBottomLeftY = y + monitorScreenHeight;


        // make monitor parts
        Rectangle2D.Double monitorScreen = new Rectangle2D.Double(monitorScreenBottomLeftX,monitorScreenBottomLeftY,
                monitorScreenWidth, monitorScreenHeight);
        Rectangle2D.Double monitorBase = new Rectangle2D.Double(monitorBaseBottomLeftX,monitorBaseBottomLeftY,
                monitorBaseWidth, monitorBaseHeight);
        Rectangle2D.Double monitorStem = new Rectangle2D.Double(monitorStandStemBottomLeftX, monitorStandStemBottomLeftY,
                monitorStandStemWidth, monitorStandStemHeight);
        Rectangle2D.Double monitorInnerScreen = new Rectangle2D.Double(monitorInnerScreenBottomLeftX,monitorInnerScreenBottomLeftY,
                monitorInnerScreenWidth, monitorInnerScreenHeight);

        //assemble monitor parts
        GeneralPath wholeSetup = this.get();
        wholeSetup.append(monitorScreen,false);
        wholeSetup.append(monitorBase,false);
        wholeSetup.append(monitorStem,false);
        wholeSetup.append(monitorInnerScreen,false);
    }

}
