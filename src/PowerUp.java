import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
public class PowerUp{
		private double x;
		private double y;
		private int r;
		private int type;
		private Color color;
		
		//1 -- +1 life
		//2 -- +1 power
		//3 -- slow down time
		public PowerUp(int type, double x, double y){
			this.x=x;
			this.y=y;
			this.type=type;
			
			if (type == 1) { r = 6; color = Color.RED;}
			if (type == 2) { r = 6; color = Color.YELLOW;}
			if (type == 3) { r = 6; color = Color.CYAN;}
		}
		
		public double getX() { return x; }
		public double getY() { return y; }
		public double getR() { return r; }
		public int getType() { return type; }
		
		public boolean update(){
			y += 2;
			if (y > GamePanel.HEIGHT+r){
				return true; }
				return false; }
		
		public void draw(Graphics2D g){
			GradientPaint gP = new GradientPaint((int)(x - r), (int)(y + r), color.darker(),
    				(int)(x + r), (int)(y - r), color, false);
    	g.setPaint(gP);
			g.fillOval((int)(x-r), (int)(y-r), 2*r, 2*r);	
		}
}