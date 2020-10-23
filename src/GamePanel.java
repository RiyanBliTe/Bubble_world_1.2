import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable
{
	public static int WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static int HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public static int mouseX;
	public static int mouseY;
	
	public static Color bColor;
	
	private BufferedImage image;
    private Graphics2D g;
    
    public static Thread thread;
    
    public static boolean running;
    
    private int FPS = 30;
	@SuppressWarnings("unused")
	private double averageFPS;
	
	public static Player player;
	
	public static ArrayList<Bullet> bullets; 
	public static ArrayList<Enemy> enemies;
	public static Wave wave;
	public static ArrayList<PowerUp> powerups;
	public static ArrayList<Explosion> explosions;
	
	private long slowDownTimer;
	private long slowDownTimerDiff;
	private int slowDownLength = 6000;
	
	public static boolean leftMouse;
	
	public enum STATES{
		MENUE,
		PLAY,
		HELP,
		END
	}
	public static STATES state = STATES.MENUE;
	public static Menue menue;
	public static Help help;
	public static End end;

	public GamePanel() 
	{
		super();
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);
        requestFocus();
        addKeyListener(new ListrenersWASD());
        addKeyListener(new ListrenersArrows());
        addKeyListener(new ListrenersKeys());
        addMouseMotionListener(new ListrenersMouse());
        addMouseListener(new ListrenersMouse());
     }
	public void addNotify()
	{
		super.addNotify();
		if (thread == null)
		{
        thread = new Thread(this);
        thread.start();
		}
    }
	@Override
	public void run() 
	{
		running = true;
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D)image.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		leftMouse = false;
		player = new Player();
		bullets = new ArrayList<Bullet>();
		enemies = new ArrayList<Enemy>();
		wave = new Wave();
		powerups = new ArrayList<PowerUp>();
		explosions = new ArrayList<Explosion>();
		menue = new Menue();
		help = new Help();
		end = new End();
		bColor = Color.BLUE;
		
		long startTime;
		long URDTimeMillis;
		long waitTime;
		long totalTime = 0;
		
		int frameCount = 0;
		int maxFrameCount = 30;
		
		long targetTime = 1000 / FPS;
							
		while(running)
		{
			startTime = System.nanoTime();			
			if (state.equals(STATES.MENUE))
			{
				g.setColor(Color.BLUE);
				g.fillRect(0, 0, WIDTH, HEIGHT);
				menue.update();
				menue.draw(g);
				gameDraw();
			}
			if (state.equals(STATES.HELP))
			{
				g.setColor(Color.BLUE);
				g.fillRect(0, 0, WIDTH, HEIGHT);
				help.update();
				help.draw(g);
				gameDraw();
			}
			if (state.equals(STATES.END))
			{
				g.setColor(new Color(0,100,255));
				g.fillRect(0, 0, WIDTH, HEIGHT);
				end.update();
				end.draw(g);
				gameDraw();
			}
			if (state.equals(STATES.PLAY))
			{	
				gameUpdate();
				gameRender();
				gameDraw();
			}
			URDTimeMillis = (System.nanoTime() - startTime)/1000000;
			
			waitTime = targetTime - URDTimeMillis;
			
			try
			{
				Thread.sleep(waitTime);
			}
			catch(Exception e)
			{}
			totalTime += System.nanoTime() - startTime;
			frameCount++;
			
			if (frameCount == maxFrameCount)
			{
				averageFPS = 1000.0 / ((totalTime / frameCount) / 1000000);
				frameCount = 0;
				totalTime = 0;
			}
		}
	}
		
	private void gameUpdate() 
	{
		 if (player.isDead())
		 {
			 state = STATES.END;
		 }
		 
		for (int i = 0; i < powerups.size(); i++)
		{
			boolean remove = powerups.get(i).update();
			if (remove)
			{
				powerups.remove(i);
				i--;
			}
		}
		player.update();
		 for (int i = 0; i<bullets.size(); i++)
	        {
	            bullets.get(i).update();
	            boolean remove = bullets.get(i).remove();
	            if (remove)
	            {
	                bullets.remove(i);
	                i--;
	            }
	        }
		 for (int i = 0; i < enemies.size(); i++)
		 {
				enemies.get(i).update();
		 }
		 for (int i = 0; i < enemies.size();i++)
	        {
	            Enemy e = enemies.get(i);
	            double ex = e.getX();
	            double ey = e.getY();
	            for (int j = 0; j < bullets.size(); j++)
	            {
	                Bullet b = bullets.get(j);
	                double bx = b.getX();
	                double by = b.getY();
	                double dx = ex - bx;
	                double dy = ey - by;
	                double dist = Math.sqrt(dx*dx+dy*dy);
	                if ((int)dist < e.getR()+b.getR())
	                {
	                    e.hit();
	                    bullets.remove(j);
	                    j--;
	                    boolean remove = e.isDead();
	                if(remove)
	                {
	                    	double rand = Math.random();
	                    		 if (rand < 0.020) { powerups.add(new PowerUp(1,ex,ey));}
	                    	else if (rand < 0.080) { powerups.add(new PowerUp(2,ex,ey));}
	                    	else if (rand < 0.130) { powerups.add(new PowerUp(3,ex,ey));}
	                       	player.addScore(e.getType()+e.getRank());
	                        enemies.remove(i);
	                        i--;
	                        e.explode();
	                        explosions.add(new Explosion(ex, ey, (int)e.getR(), (int)e.getR() + 20));
	                        break;
	                }
	                }
	            }
	        }
		 
		 if (!player.isRecovering())
		 {
				int px = (int)player.getX();
				int py = (int)player.getY();
				int pr = (int)player.getR();
				for (int i = 0; i<enemies.size(); i++)
				{
					Enemy e = enemies.get(i);
					double ex = e.getX();
					double ey = e.getY();
					double er = e.getR();
					double dx = px - ex;
					double dy = py - ey;
					double dist = Math.sqrt(dx * dx + dy * dy);
					if(dist < pr + er)
					{
						player.loseLife();
						player.addScore(-30);
						e.hit();
						if (e.isDead()) {
	                       	player.addScore(e.getType()+e.getRank());
							enemies.remove(i);
							e.explode();
	                        explosions.add(new Explosion(ex, ey, (int)e.getR(), (int)e.getR() + 20));
						}
					}
				}
			}
		 
		 double px = player.getX();
		 double py = player.getY();
		 double pr = player.getR();
		 for (int i = 0; i < powerups.size(); i++)
		 {
			 PowerUp p = powerups.get(i);
			 double x = p.getX();
			 double y = p.getY();
			 double r = p.getR();
			 double dx = px - x;
			 double dy = py - y;
			 double dist = Math.sqrt(dx * dx + dy * dy);
			 if (dist < pr + r) 
			 {
				 int type = p.getType();
				 if (type == 1) { player.gainLife(); player.addScore(30);}
				 if (type == 2) { player.increasePower(1); player.addScore(10);}
				 if (type == 3) 
				 { 
					 player.addScore(10);
					 slowDownTimer = System.nanoTime();
					 for (int j = 0; j < enemies.size(); j++)
					 {
						 enemies.get(j).setSlow(true);
					 }
				 }
				 powerups.remove(i);
				 i--; 
			 }
		 }
		 
		 for (int i = 0; i < explosions.size(); i++)
		 {
			 boolean remove = explosions.get(i).update();
			 if (remove)
			 {
				 explosions.remove(i);
				 i--;
			 }
		 }
		 
		 if (slowDownTimer != 0)
		 {
			 slowDownTimerDiff = (System.nanoTime() - slowDownTimer) / 1000000;
			 if (slowDownTimerDiff > slowDownLength) 
			 {
				 slowDownTimer = 0;
				 for (int j = 0; j < enemies.size(); j++)
				 {
					 enemies.get(j).setSlow(false);
				 }
			 }
		 }
		 
		 wave.updage();
	}
	
	private void gameRender() 
	{
		g.setColor(bColor);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setFont(new Font("Verdana",Font.ITALIC, WIDTH / 80));
		g.setColor(Color.WHITE);
		g.drawString("Lvl: "+ Wave.waveNumber, 0, WIDTH / 80);
		g.drawString("Weapon lvl: " +player.getPower()+" / "+player.getMaxPowerLevel(), 0, WIDTH / 80 + WIDTH / 80);
		
		if (slowDownTimer != 0)
		{
			g.setColor(new Color(255, 255, 255, 64));
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}
		
		g.setColor(Color.WHITE);
		g.drawString("Lives: "+ player.getLives(), 0, 3 * WIDTH / 80);
			
			g.setColor(Color.WHITE);
			g.drawString("Score: " + player.getScore(), WIDTH - 100, WIDTH / 80);
		
		if (slowDownTimer != 0)
		{
			g.setColor(Color.WHITE);
			g.drawRect(5, 70, 100, 8);
			g.fillRect(5, 70,(int)(100 - 100.0 * slowDownTimerDiff / slowDownLength), 8);
		}
		
		player.draw(g);
		for(int i = 0; i < bullets.size(); i++)
		{
			bullets.get(i).draw(g);
		}
		for (int i = 0; i < enemies.size(); i++)
		{
			enemies.get(i).draw(g);
		}
		if (wave.showWave())
		{
	        wave.draw(g);
		 }
		 for (int i = 0; i < powerups.size(); i++)
		 {
			powerups.get(i).draw(g);
		 }
		 for (int i = 0; i < explosions.size(); i++)
		 {
				explosions.get(i).draw(g);
		 }
	}
	
	private void gameDraw() 
	{
		Graphics g2 = this.getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}
}