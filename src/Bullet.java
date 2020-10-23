import java.awt.Color;
import java.awt.Graphics2D;
public class Bullet
{
		private double x;
		private double y;
		private int r;
	
		private double dx;
		private double dy;
		private double rad;
		private double speed;
	
		private Color color;
	
		public Bullet (double angle, double x, double y, Color color) {
			this.x=x;
			this.y=y;
			this.color=color;
			r = 2;
			speed = 10;
			rad = Math.toRadians(angle);
			dx = Math.cos(rad) * speed;
			dy = Math.sin(rad) * speed;
		}

		public double getX() { return x; }
		public double getY() { return y; }
		public double getR() { return r; }

		public boolean update(){
			x += dx;
			y += dy;
			if (x < -r || x > GamePanel.WIDTH +r || y < -r || y > GamePanel.HEIGHT + r){ 
				return true; }
			  	return false; }
		
		public boolean remove(){
	        if (y < 0) { return true; }
	        				 return false; }

		public void draw(Graphics2D g){
			g.setColor(color);
			g.fillOval((int)(x-r),(int)( y-r), 2*r, 3*r);
		}
}