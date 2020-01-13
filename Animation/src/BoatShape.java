/*
 * Matt Trebing
 * 3/28/16
 * BoatShape.java
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;


public class BoatShape implements MoveableShape
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
	   public BoatShape(int x, int y, int width)
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
	    * this method actually creates and draws the boat
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
		  
	      Point2D.Double r1
	            = new Point2D.Double(x + width / 6-17, y + width / 6-50);
	      Point2D.Double r2
	            = new Point2D.Double(x + width / 3, y);
	      Point2D.Double r3
	            = new Point2D.Double(x + width * 2 / 3, y);
	      Point2D.Double r4
	            = new Point2D.Double(x + width * 5 / 6+20, y + width / 6 -50);
	      Point2D.Double p1= new Point2D.Double(x + width/2 - 15, y+ width / 6 -50);
	      Point2D.Double p2= new Point2D.Double(x + width/2 -15, y-70);
	      Point2D.Double p3= new Point2D.Double(x + width/2+10, y+ width / 6 -90);
	      Point2D.Double p4= new Point2D.Double(x + width/2 -15, y-55);
	      
	      Line2D.Double flag1= new Line2D.Double(p2, p3);
	      Line2D.Double flag2= new Line2D.Double(p4, p3);
	      Line2D.Double mast= new Line2D.Double(p1, p2);
	      Line2D.Double frontWindshield
	            = new Line2D.Double(r1, r2);
	      Line2D.Double roofTop
	            = new Line2D.Double(r2, r3);
	      Line2D.Double rearWindshield
	            = new Line2D.Double(r3, r4);
	      Line2D.Double poopDeck= new Line2D.Double(r1, r4);

	      
	      g2.draw(flag2);
	      g2.draw(flag1);
	      g2.draw(frontWindshield);
	      g2.draw(roofTop);
	      g2.draw(rearWindshield);
	      g2.draw(poopDeck);
	      g2.draw(mast);
	   }
	   

	}
