import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
public class Enemy 
{
	private double x;
	private double y;
	private int r;
	
	private double dx;
	private double dy;
	private double rad;
	private double speed;
	
	private int health;
	private int type;
	private int rank;
	
	private Color color;
	
	private boolean ready;
	private boolean dead;
	
	private boolean hit;
	private long hitTimer;
	private boolean slow;
	
	public Enemy(int type, int rank)
	{
		this.type = type;
		this.rank = rank;
		
		if (type == 1)
		{	
			color = new Color(0,255,0,200);
			if (rank == 1) { speed = 3; r = 15; health = 3;}
			if (rank == 2) { speed = 2; r = 25; health = 5;}
			if (rank == 3) { speed = 1.5; r = 30; health = 7;}
			if (rank == 4) { speed = 1.5; r = 35; health = 8;}
		}
		
		if (type == 2)
		{
			color = new Color(255,255,0,200);
			if (rank == 1) { speed = 5; r = 20; health = 4;}
			if (rank == 2) { speed = 5; r = 25; health = 6;}
			if (rank == 3) { speed = 4; r = 30; health = 8;}
			if (rank == 4) { speed = 4; r = 35; health = 9;}
		}
		
		if (type == 3)
		{
			color = new Color(255,0,0,200);
			if (rank == 1) { speed = 8; r = 15; health = 3;}
			if (rank == 2) { speed = 7; r = 20; health = 5;}
			if (rank == 3) { speed = 6; r = 25; health = 7;}
			if (rank == 4) { speed = 5; r = 30; health = 9;}
		}
		
		if (type == 4)
		{
			color = new Color(0,0,255,200);
			if (rank == 1) { speed = 3; r = 15; health = 10;}
			if (rank == 2) { speed = 2.5; r = 20; health = 20;}
			if (rank == 3) { speed = 2; r = 25; health = 30;}
			if (rank == 4) { speed = 1.5; r = 30; health = 40;}
		}
		if (type == 5)
		{
			color = new Color(0,0,0,128);
			if (rank == 1) { speed = 7; r = 10; health = 20;}
			if (rank == 2) { speed = 6; r = 20; health = 30;}
			if (rank == 3) { speed = 5; r = 40; health = 40;}
			if (rank == 4) { speed = 4; r = 60; health = 50;}
		}
		int w = (int) Math.round(Math.random());
		if (w == 1) {
		x = Math.random() * GamePanel.WIDTH / 2 + GamePanel.HEIGHT / 2.5 + 150;
		} else {
			x = Math.random() * GamePanel.WIDTH / 2 + GamePanel.HEIGHT / 2.5 - 150;
		}
		y = -r;
		
		double angle = Math.random() * 140 + 20;
		rad = Math.toRadians(angle);
		
		dx = Math.cos(rad) * speed;
		dy = Math.sin(rad) * speed;
		
		ready = false;
		dead = false;
		
		hit = false;
		hitTimer = 0;
	}
	
	public double getX() { return x; }
	public double getY() { return y; }
	public double getR() { return r; }
	public int getType() { return type; }
	public int getRank() { return rank; }
	public void setSlow(boolean b) { slow = b; }
	public boolean isDead() { return dead; }
	
	public void hit()
	{
		health--;
		if (health <= 0)
		{
			dead = true;
		}
		hit = true;
		hitTimer = System.nanoTime();
	}
	
	public void explode()
	{
		if (rank > 1)
		{ 
			int amount = 0;
			if (type == 1) { amount = 3;}
			if (type == 2) { amount = 3;}
			if (type == 3) { amount = 3;}
			if (type == 4) { amount = 4;}
			if (type == 5) { amount = 4;} 
			
			for (int i = 0; i< amount; i++)
			{
				Enemy e = new Enemy(getType(),getRank() - 1);
				e.x = this.x;
				e.y = this.y;
				double angle = 0;
				if (!ready)
				{
					angle = Math.random() * 140 + 20;
				}
				else
				{
					angle = Math.random() * 360;
				}
				e.rad = Math.toRadians(angle);
				
				GamePanel.enemies.add(e);
			}
		}
	}
	
	public void update()
	{
		if (slow) 
		{
			x += dx * 0.3;
			y += dy * 0.3;
		}
		else
		{
			x += dx;
			y += dy;
		}
		if (!ready)
		{
			if ( x > r && x < GamePanel.WIDTH - r && y > r && y < GamePanel.HEIGHT - r)
			{
				ready = true;
			}
		}
		
		if (x < r && dx < 0) dx = -dx;
		if (y < r && dy < 0) dy = -dy;
		if (x >GamePanel.WIDTH - r && dx > 0) dx = -dx;
		if (y >GamePanel.HEIGHT - r && dy > 0) dy = -dy;
		
		if (hit) 
		{
			long elapsed = (System.nanoTime() - hitTimer) / 1000000;
			if (elapsed > 50)
			{
				hit = false;
				hitTimer = 0;
			}
		}
	}
	
	public void draw(Graphics2D g)
	{
		if (hit)
		{
			g.setColor(Color.WHITE);
			g.fillOval((int)(x-r), (int)(y - r), 2*r, 2*r);
			g.setStroke(new BasicStroke(3));
			g.setColor(Color.WHITE.darker());
			g.fillOval((int)(x-r), (int)(y - r), 2*r, 2*r);
		}
		else
		{
		GradientPaint gP = new GradientPaint((int)(x - r + r / 2), (int)(y + r + r / 2), color,
    				(int)(x + r), (int)(y - r), Color.WHITE, false);
    	g.setPaint(gP);
		g.fillOval((int)(x-r), (int)(y - r), 2*r, 2*r);
		}
	}
}