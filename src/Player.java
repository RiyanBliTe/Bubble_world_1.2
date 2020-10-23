import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
public class Player 
{
	private double x;
    private double y;
    private int r;

    private int speed;
    public static int lives;

    private double dx;
    private double dy;

    private long firingTimer;
	private static long firingDelay;

    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;
    public static boolean firing;
    
    private boolean recovering;
	private long recoveryTimer;
	
	private int score;
	
	private int maxPowerLevel;
	private int power;

	public void setLife(int i)
	{
		lives = i;
	}
	public void setPower(int i)
	{
		power = i;
	}
	public void setScore(int i)
	{
		score = i;
	}
	public void setLocation(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
    public double getX() { return x; }
    public double getY() { return y; }
    public int getR() { return r; }

    public Player()
    {
    x = GamePanel.WIDTH / 2;
    y = GamePanel.HEIGHT / 1.2;
    r = 15;

    speed = 6;
    lives = 5;

    dx = 0;
    dy = 0;

    firingTimer = System.nanoTime();
	firingDelay = 500;
	
    firing = false;
    up = false;
    down = false;
    left = false;
    right = false;
    recovering = false;
	recoveryTimer = 0;
	score = 0;
	power = 1;
	maxPowerLevel = 12;
    }
    
    public int getLives() { return lives; }
	public boolean isRecovering() { return recovering; }
	public int getScore() { return score; }
	public void addScore (int i) { 
		score+=i;
		if (score < 0) {
			score = 0;
		}
	}
	public void gainLife() { lives++; }
	
	public void  increasePower(int i)
	{
		power += i;
		if (power > maxPowerLevel)
		{
			power = maxPowerLevel;
		}
	}
	public int getMaxPowerLevel() { return maxPowerLevel; }
	public int getPower() { return power; }
	public boolean isDead() { return lives <= 0; }
	public void loseLife() 
	{
		lives--;
		power -= 1;
		if (power <= 0) { power = 1;}
		recovering = true;
		recoveryTimer = System.nanoTime();
	}
    public boolean remove()
    {
        if (lives<=0)
        {
            return true;
        }
        	return false;
    }
    public void update()
    {
        if(up == true && y > r)
        {
            dy-=speed;
        }
        if (down == true && y < GamePanel.HEIGHT - r)
        {
            dy+=speed;
        }
        if (left == true && x > r)
        {
            dx -= speed;
        }
        if(right == true && x < GamePanel.WIDTH - r)
        {
            dx += speed;
        }
        if (up && left && firing)
        {
            dy = dy * Math.sin(Math.toRadians(45));
            dx = dx * Math.cos(Math.toRadians(45));
        }
        if (up && right && firing)
        {
            dy = dy * Math.sin(Math.toRadians(45));
            dx = dx * Math.cos(Math.toRadians(45));
        }
        if (down && right && firing)
        {
            dy = dy * Math.sin(Math.toRadians(45));
            dx = dx * Math.cos(Math.toRadians(45));
        }
        if (down && left && firing)
        {
            dy = dy * Math.sin(Math.toRadians(45));
            dx = dx * Math.cos(Math.toRadians(45));
        }
        if (up && left && firing == false)
        {
            dy = dy * Math.sin(Math.toRadians(45));
            dx = dx * Math.cos(Math.toRadians(45));
        }
        if (up && right && firing == false)
        {
            dy = dy * Math.sin(Math.toRadians(45));
            dx = dx * Math.cos(Math.toRadians(45));
        }
        if (down && right && firing == false)
        {
            dy = dy * Math.sin(Math.toRadians(45));
            dx = dx * Math.cos(Math.toRadians(45));
        }
        if (down && left && firing == false)
        {
            dy = dy * Math.sin(Math.toRadians(45));
            dx = dx * Math.cos(Math.toRadians(45));
        }
        
        y+=dy;
        x+=dx;

        dx = 0;
        dy = 0;
        
        if (firing)
        {
        	long elapsed = (System.nanoTime() - firingTimer) / 1000000;
			if (elapsed > firingDelay)
			{
				firingTimer = System.nanoTime();
				if (power == 1)
				{
					GamePanel.bullets.add(new Bullet(270, x, y - r, Color.YELLOW));
				}
				else if (power == 2)
				{
					GamePanel.bullets.add(new Bullet(270, x + 5, y - r, Color.YELLOW));
					GamePanel.bullets.add(new Bullet(270, x - 5, y - r, Color.YELLOW));
				}
				else if (power == 3)
				{
					GamePanel.bullets.add(new Bullet(270, x, y - r, Color.YELLOW));
					GamePanel.bullets.add(new Bullet(275, x, y - r, Color.YELLOW));
					GamePanel.bullets.add(new Bullet(265, x, y - r, Color.YELLOW));
				}
				else if (power == 4)
				{
					firingDelay = 450;
					GamePanel.bullets.add(new Bullet(270, x, y - r, Color.GREEN));
					GamePanel.bullets.add(new Bullet(275, x, y - r, Color.YELLOW));
					GamePanel.bullets.add(new Bullet(265, x, y - r, Color.YELLOW));
				}
				else if (power == 5)
				{
					firingDelay = 400;
					GamePanel.bullets.add(new Bullet(270, x, y - r, Color.GREEN));
					GamePanel.bullets.add(new Bullet(275, x, y - r, Color.GREEN));
					GamePanel.bullets.add(new Bullet(265, x, y - r, Color.YELLOW));
				}
				else if (power == 6)
				{
					firingDelay = 350;
					GamePanel.bullets.add(new Bullet(270, x, y - r, Color.GREEN));
					GamePanel.bullets.add(new Bullet(275, x, y - r, Color.GREEN));
					GamePanel.bullets.add(new Bullet(265, x, y - r, Color.GREEN));
				}
				else if (power == 7)
				{
					firingDelay = 300;
					GamePanel.bullets.add(new Bullet(270, x, y - r, Color.RED));
					GamePanel.bullets.add(new Bullet(275, x, y - r, Color.GREEN));
					GamePanel.bullets.add(new Bullet(265, x, y - r, Color.GREEN));
				}
				else if (power == 8)
				{
					firingDelay = 250;
					GamePanel.bullets.add(new Bullet(270, x, y - r, Color.RED));
					GamePanel.bullets.add(new Bullet(275, x, y - r, Color.RED));
					GamePanel.bullets.add(new Bullet(265, x, y - r, Color.GREEN));
				}
				else if (power == 9)
				{
					firingDelay = 200;
					GamePanel.bullets.add(new Bullet(270, x, y - r, Color.RED));
					GamePanel.bullets.add(new Bullet(275, x, y - r, Color.RED));
					GamePanel.bullets.add(new Bullet(265, x, y - r, Color.RED));
				}
				else if (power == 10)
				{
					firingDelay = 150;
					GamePanel.bullets.add(new Bullet(270, x, y - r, Color.MAGENTA));
					GamePanel.bullets.add(new Bullet(275, x, y - r, Color.RED));
					GamePanel.bullets.add(new Bullet(265, x, y - r, Color.RED));
				}
				else if (power == 11)
				{
					firingDelay = 100;
					GamePanel.bullets.add(new Bullet(270, x, y - r, Color.MAGENTA));
					GamePanel.bullets.add(new Bullet(275, x, y - r, Color.MAGENTA));
					GamePanel.bullets.add(new Bullet(265, x, y - r, Color.RED));
					GamePanel.bullets.add(new Bullet(270, x, y - r, Color.MAGENTA));
					GamePanel.bullets.add(new Bullet(275, x, y - r, Color.MAGENTA));
					GamePanel.bullets.add(new Bullet(265, x, y - r, Color.RED));
				}
				else if (power == 12)
				{
					firingDelay = 100;
					GamePanel.bullets.add(new Bullet(270, x, y - r, Color.MAGENTA));
					GamePanel.bullets.add(new Bullet(275, x, y - r, Color.MAGENTA));
					GamePanel.bullets.add(new Bullet(265, x, y - r, Color.MAGENTA));
					GamePanel.bullets.add(new Bullet(270, x, y - r, Color.MAGENTA));
					GamePanel.bullets.add(new Bullet(275, x, y - r, Color.MAGENTA));
					GamePanel.bullets.add(new Bullet(265, x, y - r, Color.MAGENTA));
				}
			}
        }
        if (recovering)
        {
        	long elapsed = (System.nanoTime() - recoveryTimer) / 1000000;
        	if (elapsed > 500)
        	{
        		recovering = false;
        		recoveryTimer = 0;
        	}
        }
    }
    
    public void draw(Graphics2D g)
    {
    	if (recovering)
    	{
    		GradientPaint gP = new GradientPaint((int)(x - r), (int)(y + r), Color.RED.darker(),
    				(int)(x + r), (int)(y - r), Color.RED, false);
    		g.setPaint(gP);
    		g.fillOval((int)(x - r), (int)(y - r), r*2, r*2);
    		g.setStroke(new BasicStroke(3));
    	}
    	else
    	{
    		GradientPaint gP = new GradientPaint((int)(x - r), (int)(y + r), Color.ORANGE,
    				(int)(x + r), (int)(y - r), Color.MAGENTA, false);
    		g.setPaint(gP);
    		g.fillOval((int)(x - r), (int)(y - r), r*2, r*2);
    		g.setStroke(new BasicStroke(3));
    	}
    }
}