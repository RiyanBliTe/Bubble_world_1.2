import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
public class Explosion 
{
		private double x;
		private double y;
		private int r;
		private int maxRadius;
		
	public Explosion(double x, double y, int r, int max) 
	{
		this.x = x;
		this.y = y;
		this.r = r;
		maxRadius = max;
	}
	
	public boolean update()
	{
		r++;
		if (r >= maxRadius)
		{
			return true;
		}
			return false;
	}
	
	public void draw(Graphics2D g)
	{
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(new Color(255,255,255,128));
		g.setStroke(new BasicStroke(2));
		g.drawOval((int)(x-r),(int)(y-r), 2*r, 2*r);
		g.setStroke(new BasicStroke(2));
	}
}