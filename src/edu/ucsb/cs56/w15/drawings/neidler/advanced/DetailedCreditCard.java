package edu.ucsb.cs56.w15.drawings.neidler.advanced;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

/**
 * Created by nick on 2/1/15.
 * Draws a more detailed credit card.
 */
public class DetailedCreditCard extends BlankCreditCard implements Shape {

    public DetailedCreditCard(double x, double y, double width, double height) {
        super(x, y, width, height);
        GeneralPath gp = this.get();

        Rectangle2D.Double photoSquare = new Rectangle2D.Double(x + width / 10, y + height / 10, width / 4, height / 4);
        Rectangle2D.Double nameInfo = new Rectangle2D.Double(x + photoSquare.getWidth() + width / 5,
                y + height / 5, width - photoSquare.getWidth() - 2*width / 5, height / 10);

        gp.append(photoSquare, false);
        gp.append(nameInfo, false);
    }
}
