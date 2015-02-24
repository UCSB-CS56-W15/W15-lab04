package edu.ucsb.cs56.w15.drawings.parsahadidi.advanced;

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
 * @author Phill Conrad
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    public static void drawPicture1(Graphics2D g2) {

	Shield large = new Shield(150,50,115,150);
	g2.setColor(Color.BLUE);
	g2.draw(large);

	Shield medium = new Shield(300,100,85,125);
	Stroke orig=g2.getStroke();
	Stroke middle = new BasicStroke (2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	g2.setStroke(middle);
	g2.setColor(Color.RED);
	g2.draw(medium);

	ShieldWithLogo small = new ShieldWithLogo(225,225,40,75);
	Shape smallR = ShapeTransforms.rotatedCopyOf(small, Math.PI);
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	g2.setStroke(thick);
	g2.setColor(Color.GREEN);
	g2.draw(smallR);

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A trio of shields by Parsa Hadidi", 20,20);
    }

    public static void drawPicture2(Graphics2D g2) {
	
	Shield green = new Shield(75,100,60,30);
	ShieldWithLogo blue = new ShieldWithLogo(150,300,90,50);
	ShieldWithLogo magenta = new ShieldWithLogo(100,200,150,90);
	
	g2.setColor(Color.GREEN);   g2.draw(green);
	g2.setColor(Color.BLUE);    g2.draw(blue);
	g2.setColor(Color.MAGENTA); g2.draw(magenta);
	Stroke orig=g2.getStroke();
	
	Shape greenST = ShapeTransforms.scaledCopyOfLL(green,4,4);
	greenST = ShapeTransforms.translatedCopyOf(greenST,200,50);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	g2.setStroke(thick);
	g2.setColor(new Color(0x00563F));
	g2.draw(greenST);

	Shape blueSTR = ShapeTransforms.scaledCopyOfLL(blue,0.85,1.15);
	blueSTR = ShapeTransforms.translatedCopyOf(blueSTR,-100,25);
	blueSTR = ShapeTransforms.rotatedCopyOf(blueSTR, Math.PI * 1.5);

	Stroke middle = new BasicStroke (2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	
	g2.setStroke(middle);
	g2.setColor(new Color(0x002E63));
	g2.draw(blueSTR);

	Shape magentaTR = ShapeTransforms.translatedCopyOf(magenta,250,-40);
	magentaTR = ShapeTransforms.rotatedCopyOf(magentaTR, Math.PI * 0.75);

	g2.setStroke(orig);
	g2.setColor(new Color(0x8B008B));
	g2.draw(magentaTR);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
		
	g2.setColor(Color.BLACK); 
	g2.drawString("Three shields and their transformations by Parsa Hadidi", 20,20);
    }

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Two shields and transformations of ShieldWithLogo instances sharing the same parameters by Parsa Hadidi", 20,20);

	Shield large = new Shield(200,250,150,200);
	Shield small = new Shield(50,75,50,75);
       
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	Stroke orig=g2.getStroke();
	
	ShieldWithLogo largeWL = new ShieldWithLogo(200,250,150,200);
	Shape largeWLSTR = ShapeTransforms.scaledCopyOfLL(largeWL,2,2);
	largeWLSTR = ShapeTransforms.translatedCopyOf(largeWLSTR,200,75);
	largeWLSTR = ShapeTransforms.rotatedCopyOf(largeWLSTR, Math.PI * 1.75);

	Stroke thick = new BasicStroke (5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	
	g2.setStroke(thick);
	g2.setColor(new Color(0x003366));
	g2.draw(largeWLSTR);

	ShieldWithLogo smallWL = new ShieldWithLogo(50,75,50,75);
	Shape smallWLSTR = ShapeTransforms.scaledCopyOfLL(smallWL,1.25,1.15);
	smallWLSTR = ShapeTransforms.translatedCopyOf(smallWLSTR,50,80);
	smallWLSTR = ShapeTransforms.rotatedCopyOf(smallWLSTR, Math.PI * 0.50);

	Stroke middle = new BasicStroke (1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	
	g2.setStroke(middle);
	g2.setColor(new Color(0xCC397B));
	g2.draw(smallWLSTR);
    }
    

}
