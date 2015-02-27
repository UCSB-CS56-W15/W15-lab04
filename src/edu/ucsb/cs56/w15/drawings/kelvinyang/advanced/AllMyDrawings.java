package edu.ucsb.cs56.w15.drawings.kelvinyang.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;


import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Kelvin Yang 
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a fan with blades of a different color
     */

    public static void drawPicture1(Graphics2D g2)
    {
        g2.drawString("Quite the fan by Kelvin Yang", 20,20);
        
        FanWithBlades f1 = new FanWithBlades(175, 50, 400);
        Fan f2 = new Fan(175, 50, 400);
        
        Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
        Stroke orig = g2.getStroke();
        g2.setStroke(thick);
        g2.setColor(Color.RED); 
        g2.draw(f1);
        g2.setColor(Color.BLACK);
        g2.draw(f2);
        g2.setStroke(orig);
    }


    /** Draw a picture with many fans, some rotated, some thicker
     */
    public static void drawPicture2(Graphics2D g2)
    {
        g2.drawString("A bunch of Fans with rotation by Kelvin Yang", 20,20);
        
        FanWithBlades f1 = new FanWithBlades(100, 125, 50);
        
        Fan f2 = new Fan(150, 175, 100);
        Shape f2s = ShapeTransforms.rotatedCopyOf(f2, Math.PI/4.0);
        
        FanWithBlades f3 = new FanWithBlades(50, 250, 125);
        
        FanWithBlades f4 = new FanWithBlades(250, 200, 200);
        Fan f5 = new Fan(425, 200, 250);
        FanWithBlades f6 = new FanWithBlades(350, 50, 175);
        Shape f6s = ShapeTransforms.rotatedCopyOf(f6, 3.0 * Math.PI / 4.0);
        
        g2.setColor(new Color(0x7CB9E8));
        g2.draw(f1);
        g2.setColor(new Color(0xEFDECD));
        g2.draw(f2);
        g2.setColor(Color.BLACK);
        g2.draw(f2s);
        g2.setColor(new Color(0xE52B50));
        g2.draw(f3);
        
        // We'll draw this with a thicker stroke
        Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
        
        Stroke orig = g2.getStroke();
        g2.setStroke(thick);
        g2.setColor(new Color(0x002FA7)); 
        g2.draw(f4); 
        g2.setStroke(orig);
        g2.setColor(new Color(0x568203));
        g2.draw(f5);
        g2.setColor(new Color(0x00FFFF));
        g2.draw(f6s);
        g2.setStroke(orig);
    }
  
    /** Draw a different picture with three fans.  Two with blades, one without
     */

    public static void drawPicture3(Graphics2D g2)
    {
        // label the drawing
        g2.drawString("A few fans by Kelvin Yang", 20,20);
        
        // Draw some coffee cups.
        FanWithBlades f1 = new FanWithBlades(100, 125, 300);
        Fan f2 = new Fan(325, 100, 100);
        FanWithBlades f3 = new FanWithBlades(400, 175, 220);
        
        g2.setColor(Color.GREEN);
        g2.draw(f1);
        
        g2.setColor(Color.RED);
        g2.draw(f2);
        
        g2.setColor(Color.BLUE);
        g2.draw(f3);
    }
}
