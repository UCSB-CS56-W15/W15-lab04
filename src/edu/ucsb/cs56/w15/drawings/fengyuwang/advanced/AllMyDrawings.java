package edu.ucsb.cs56.w15.drawings.fengyuwang.advanced;
import java.awt.Graphics2D;
import java.awt.geom.Line2D; // single lines
import java.awt.geom.Ellipse2D; // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle; // squares and rectangles
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
* @author Fengyu Wang
* @version for CS56, lab04, Winter 2015
*/
public class AllMyDrawings
{
/** Draw a picture with a few bear heads
*/
public static void drawPicture1(Graphics2D g2) {
BearHead h1 = new BearHead(100,250,50,50);
g2.setColor(Color.CYAN); g2.draw(h1);
// Make a black bearhead that's half the size,
// and moved over 150 pixels in x direction
Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
g2.setColor(Color.BLACK); g2.draw(h2);
// Here's a bear head that's 4x as big (2x the original)
// and moved over 150 more pixels to right.
h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
// We'll draw this with a thicker stroke
Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
// #002FA7 is "International Klein Blue" according to Wikipedia
// In HTML we use #, but in Java (and C/C++) its 0x
Stroke orig=g2.getStroke();
g2.setStroke(thick);
g2.setColor(new Color(0x002FA7));
g2.draw(h2);
// Draw two bear heads with bowties
BearHeadWithBowtie hw1 = new BearHeadWithBowtie(50,40,40,40);
BearHeadWithBowtie hw2 = new BearHeadWithBowtie(200,350,80,80);
g2.draw(hw1);
g2.setColor(new Color(0x8F00FF)); g2.draw(hw2);
// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
g2.setStroke(orig);
g2.setColor(Color.BLACK);
g2.drawString("A few bear heads by Fengyu Wang", 20,20);
}
/** Draw a picture with a few bear heads
*/
public static void drawPicture2(Graphics2D g2) {
// Draw some bear heads.
BearHead large = new BearHead(100,50,225,150);
BearHead smallCC = new BearHead(20,50,40,30);
BearHead tallSkinny = new BearHead(20,150,20,40);
BearHead shortFat = new BearHead(20,250,40,20);
g2.setColor(Color.RED); g2.draw(large);
g2.setColor(Color.GREEN); g2.draw(smallCC);
g2.setColor(Color.BLUE); g2.draw(tallSkinny);
g2.setColor(Color.MAGENTA); g2.draw(shortFat);

// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
// #002FA7 is "International Klein Blue" according to Wikipedia
// In HTML we use #, but in Java (and C/C++) its 0x

// Draw two bear with bowtie
BearHeadWithBowtie hw1 = new BearHeadWithBowtie(50,350,40,40);
BearHeadWithBowtie hw2 = new BearHeadWithBowtie(200,350,100,100);
g2.draw(hw1);
g2.setColor(new Color(0x8F00FF));
// Rotate the second bear 45 degrees around its center.
Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/4.0);
g2.draw(hw3);
// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING

g2.setColor(Color.BLACK);
g2.drawString("A bunch of bear heads by Fengyu Wang", 20,20);
}
/** Draw a different picture with a few houses and coffee cups
*/
public static void drawPicture3(Graphics2D g2) {
// label the drawing
g2.drawString("A bunch of bear heads by Fengyu Wang", 20,20);
// Draw some coffee cups.
BearHeadWithBowtie large = new BearHeadWithBowtie(100,50,150,150);
BearHeadWithBowtie smallCC = new BearHeadWithBowtie(20,50,30,30);
g2.setColor(Color.RED); g2.draw(large);
g2.setColor(Color.GREEN); g2.draw(smallCC);
}
}
