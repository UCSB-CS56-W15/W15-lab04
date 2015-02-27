package edu.ucsb.cs56.w15.drawings.neidler.advanced;

import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by nick on 2/1/15.
 * Draws a simple credit card
 */
public class BlankCreditCard extends GeneralPathWrapper implements Shape {
    /**
     Constructor

     @param x x coord of lower left corner of card
     @param y y coord of lower left corner of card
     @param width width of the card
     @param height of card
     */
    public BlankCreditCard(double x, double y, double width, double height)
    {
        Rectangle2D.Double cardBody = new Rectangle2D.Double(x, y, width, height);
        Rectangle2D.Double magneticStrip = new Rectangle2D.Double(x, y + (3*height) / 5, width, height / 5);

        GeneralPath wholeCard = this.get();
        wholeCard.append(cardBody, false);
        wholeCard.append(magneticStrip, false);
    }
}
