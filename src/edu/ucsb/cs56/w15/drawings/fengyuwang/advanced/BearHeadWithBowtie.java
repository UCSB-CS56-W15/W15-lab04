package edu.ucsb.cs56.w15.drawings.fengyuwang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
A Bear with bowtie
@author Fengyu Wang
@version for CS56, W15, UCSB, 02/19/2015
*/
public class BearHeadWithBowtie extends BearHead implements Shape
{
/**
* Constructor for objects of class BearHeadWithBowtie
*/
public BearHeadWithBowtie(double x, double y, double width, double height)
{
// construct the basic bear face
super(x,y,width,height);
// get the GeneralPath that we are going to append stuff to
GeneralPath gp = this.get();


double midBowtieWidth = width/5;
double midBowtieHeight = height/5;
double midBowtieX = x + width/2 - midBowtieWidth/2;
double midBowtieY = y + height;


Ellipse2D.Double midBowtie =
new Ellipse2D.Double(midBowtieX,midBowtieY,midBowtieWidth,midBowtieHeight);

Rectangle2D.Double leftBowtie =
new Rectangle2D.Double(x + width/2 - 3*midBowtieWidth/2, midBowtieY, midBowtieWidth, midBowtieHeight);
Rectangle2D.Double rightBowtie =
new Rectangle2D.Double( x + width/2 + midBowtieWidth/2, midBowtieY, midBowtieWidth, midBowtieHeight);

GeneralPath BearHead = this.get();
BearHead.append(midBowtie, false);
BearHead.append(leftBowtie, false);
BearHead.append(rightBowtie, false);

}
}
