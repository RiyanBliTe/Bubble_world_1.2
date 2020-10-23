import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
public class Wave 
{
    public static int waveNumber;
    private long waveTimer;
    private long waveDelay;
    private long waveTimerDiff;

    public Wave()
    {
        waveNumber = 0; 
        waveTimer = 0;
        waveDelay = 5000;
        waveTimerDiff = 0;
    }
    
    public void setWaveNumber(int i)
    {
    	waveNumber = i;
    }
    public void setWaveTimer(int i)
    {
    	waveTimer = i;
    }
    public void setWaveTimerDiff(int i)
    {
    	waveTimerDiff = i;
    }
    public void createEnemies()
    {
      if (waveNumber == 1)
      {
    	  for (int i = 0; i < 8; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(1,1));
    	  }
      }
      
      if (waveNumber == 2)
      {
    	  for (int i = 0; i < 6; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(1,1));
    	  }
    	  GamePanel.enemies.add(new Enemy(1,2));
    	  GamePanel.enemies.add(new Enemy(1,2));
    	  GamePanel.enemies.add(new Enemy(1,2));
    	  GamePanel.enemies.add(new Enemy(1,2));
      }
      
      if (waveNumber == 3)
      {
    	  for (int i = 0; i < 5; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(1,2));
    	  }
    	  for (int i = 0; i < 4; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(1,3));
    	  }
      }
      
      if (waveNumber == 4)
      {
    	  for (int i = 0; i < 5; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(1,3));
    	  }
    	  for (int i = 0; i < 3; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(1,4));
    	  }
      }
      
      if (waveNumber == 5)
      {
    	  for (int i = 0; i < 7; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(1,4));
    	  }
      }
      
      if (waveNumber == 6)
      {
    	  for (int i = 0; i < 10; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(2,1));
    	  }
      }
      
      if (waveNumber == 7)
      {
    	  for (int i = 0; i < 6; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(2,1));
    	  }
    	  for (int i = 0; i < 4; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(2,2));
    	  }
      }
      
      if (waveNumber == 8)
      {
    	  for (int i = 0; i < 6; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(2,2));
    	  }
    	  for (int i = 0; i < 3; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(2,3));
    	  }
      }
      
      if (waveNumber == 9)
      {
    	  for (int i = 0; i < 6; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(2,3));
    	  }
    	  for (int i = 0; i < 3; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(2,4));
    	  }
      }
      
      if (waveNumber == 10)
      {
    	  for (int i = 0; i < 8; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(2,4));
    	  }
      }
      if (waveNumber == 11)
      {
    	  for (int i = 0; i < 8; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(3,1));
    	  }
      }
      if (waveNumber == 12)
      {
    	  for (int i = 0; i < 6; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(3,1));
    	  }
    	  for (int i = 0; i < 4; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(3,2));
    	  }
      }
      if (waveNumber == 13)
      {
    	  for (int i = 0; i < 6; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(3,2));
    	  }
    	  for (int i = 0; i < 4; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(3,3));
    	  }
      }
      if (waveNumber == 14)
      {
    	  for (int i = 0; i < 4; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(3,3));
    	  }
    	  for (int i = 0; i < 3; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(3,4));
    	  }
      }
      if (waveNumber == 15)
      {
    	  for (int i = 0; i < 5; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(3,4));
    	  }
      }
      if (waveNumber == 16)
      {
    	  for (int i = 0; i < 8; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(4,1));
    	  }
      }
      if (waveNumber == 17)
      {
    	  for (int i = 0; i < 4; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(4,1));
    	  }
    	  for (int i = 0; i < 6; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(4,2));
    	  }
      }
      if (waveNumber == 18)
      {
    	  for (int i = 0; i < 4; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(4,2));
    	  }
    	  for (int i = 0; i < 2; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(4,3));
    	  }
      }
      if (waveNumber == 19)
      {
    	  for (int i = 0; i < 4; i ++)
    	  {
    		  GamePanel.enemies.add(new Enemy(4,4));
    	  }
      }
      if (waveNumber == 20)
      {
    		  GamePanel.enemies.add(new Enemy(5,4));
      }
      if (waveNumber == 21)
      {
    	  GamePanel.state = GamePanel.STATES.END;
    	  GamePanel.end.setString("YOU WON");
    	  GamePanel.wave.setWaveNumber(0);
			GamePanel.wave.setWaveTimer(0);;
			GamePanel.wave.setWaveTimerDiff(0);
			for(int i = 0; i < GamePanel.enemies.size(); i++)
			{
				GamePanel.enemies.remove(i);
				i--;
			}
			GamePanel.player.setLife(5);	
			GamePanel.player.setPower(1);
			GamePanel.player.setLocation(GamePanel.WIDTH / 2, GamePanel.HEIGHT / 1.2);
			for (int i = 0; i < GamePanel.bullets.size(); i++)
			{
				GamePanel.bullets.remove(i);
				i--;
			}
      }
    }
    
    public void updage()
    {	
        if (GamePanel.enemies.size() == 0 && waveTimer == 0)
        {
        	waveNumber++;
            waveTimer = System.nanoTime();
        }
        
        if (waveTimer > 0)
        {	
            waveTimerDiff += (System.nanoTime()-waveTimer)/1000000;
            waveTimer = System.nanoTime();
        }
        
        if (waveTimerDiff > waveDelay)
        {
            createEnemies();
            waveTimer = 0;
            waveTimerDiff = 0;
        }
    }
    
    public boolean showWave()
    {
        if (waveTimer != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void draw(Graphics2D g)
    {
    	if (waveNumber != 21)
    		{
    		g.setFont(new Font("Arial", Font.BOLD, GamePanel.WIDTH / 50));
    		String s = "- W A V E "+" - "+waveNumber+" -";
    		int length = (int)g.getFontMetrics().getStringBounds(s,g).getWidth();
    		int alpha = (int) (255 * Math.sin(3.14 * waveTimerDiff/waveDelay));
    		if(alpha> 255) alpha = 255;
    		g.setColor(new Color(255,255,255,alpha));
    		g.drawString(s, GamePanel.WIDTH/2 - length/2, GamePanel.HEIGHT/2);
    		}
    	if (waveNumber == 21)
    	{
    		g.setFont(new Font("Arial", Font.BOLD,GamePanel.WIDTH / 60));
    		 String ss = "End";
    		int length = (int)g.getFontMetrics().getStringBounds(ss,g).getWidth();
    		int alpha = (int) (255 * Math.sin(3.14 * waveTimerDiff/waveDelay));
    		if(alpha> 255) alpha = 255;
    		g.setColor(new Color(255,255,255,alpha));
    		g.drawString(ss, GamePanel.WIDTH/2 - length/2, GamePanel.HEIGHT/2);
    	}
    		}
}