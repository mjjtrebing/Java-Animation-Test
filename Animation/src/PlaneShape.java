/*
 * Matt Trebing
 * 3/28/16
 * PlaneShape.java
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;


public class PlaneShape implements MoveableShape
{
	   private int x;
	   private int y;
	   private int width;
	   /**
	      Constructs a car item.
	      @param x the left of the bounding rectangle
	      @param y the top of the bounding rectangle
	      @param width the width of the bounding rectangle
	   */
	   public PlaneShape(int x, int y, int width)
	   {
	      this.x = x;
	      this.y = y;
	      this.width = width;
	      
	   }

	   /**
	    * this method shifts the x and y values across the shows frame
	    */
	   public void translate(int dx, int dy)
	   {
		   x += dx;
		   y += dy;
		   if(x>=500)
		   {
			   x=0;
		   }
		   if(y>=500)
		   {
		  	  y=0;
		   }
		   if(y<=-1)
			  {
			  	  y=499;
			  }
			  if(x<=-1)
			  {
				  x=499;
			  }
	      
	   }

	   /**
	    * this method actually creates and draws the plane
	    */
	   public void draw(Graphics2D g2)
	   {
		   Random rando = new Random();
			  int varColor = rando.nextInt(7);
			  if(varColor==1)
				  g2.setColor(Color.RED);
			  if(varColor==2)
				  g2.setColor(Color.BLUE);
			  if(varColor==0)
				  g2.setColor(Color.GREEN);
			  if(varColor ==3)
				  g2.setColor(Color.ORANGE);
			  if(varColor ==4)
				  g2.setColor(Color.BLACK);
			  if(varColor ==6)
				  g2.setColor(Color.PINK);
		   
		   
	      Ellipse2D.Double chassy = new Ellipse2D.Double(x + width, y + width, width+25, width-20);
	      Ellipse2D.Double rearTire = new Ellipse2D.Double(x + width * 2 / 3, y + width / 3,width / 6, width / 6);
	      Point2D.Double p1= new Point2D.Double(x + width / 2 +33, y + width /2+15);//in the wing
	      Point2D.Double p2= new Point2D.Double(x + width / 2 +33, y + width +20);
	      Point2D.Double p3= new Point2D.Double(x + width / 2 +36, y + width +20);//tip
	      Point2D.Double p4= new Point2D.Double(x + width / 2 +40, y + width/2 +15);
	      Point2D.Double p5= new Point2D.Double(x + width / 2 +25, y + width /2+12);
	      Point2D.Double p6= new Point2D.Double(x + width / 2 +25, y + width /2+5);
	      Point2D.Double p7= new Point2D.Double(x + width / 2 +29, y + width /2+12);
	      Line2D.Double wing1 = new Line2D.Double(p1, p2);
	      Line2D.Double wingTip = new Line2D.Double(p2, p3);
	      Line2D.Double wing2 = new Line2D.Double(p3, p4);
	      Line2D.Double fin = new Line2D.Double(p5, p6);
	      Line2D.Double fin2 = new Line2D.Double(p6, p7);
	      
	      g2.draw(wingTip);
	      g2.draw(chassy);
	      g2.draw(wing1);
	      g2.draw(wing2);
	      g2.draw(fin);
	      g2.draw(fin2);
	   }
	   

	}
