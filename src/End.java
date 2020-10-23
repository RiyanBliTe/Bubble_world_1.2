import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class End {

	private int buttonW;
	private int buttonH;
	private static int transp;
	private static int transpB;
	private String ss;
	public String s;
	public End() {
		buttonW = 150;
		buttonH = 80;
		transp = 0;
		transpB = 0;
		ss = "Restart";
		s = "G A M E   O V E R";
	}
	public void setString(String g)
	{
		s = g;
	}
	public void update()
	{
		if (GamePanel.mouseX > GamePanel.WIDTH / 2 - buttonW / 2 + 2 && 
				 GamePanel.mouseX < GamePanel.WIDTH / 2 + buttonW / 2 && 
				 GamePanel.mouseY > GamePanel.HEIGHT - GamePanel.HEIGHT / 3  - buttonH / 2 + 5 && 
				 GamePanel.mouseY < GamePanel.HEIGHT - GamePanel.HEIGHT / 3  + buttonH / 2 + 3)
			{
				transp = 80;
				if (GamePanel.leftMouse)
				{
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
					GamePanel.player.setScore(0);
					GamePanel.player.setLocation(GamePanel.WIDTH / 2, GamePanel.HEIGHT / 1.2);
					for (int i = 0; i < GamePanel.powerups.size(); i++)
					{
						GamePanel.powerups.remove(i);
						i--;
					}
					for (int  i = 0; i < GamePanel.bullets.size(); i++){
						GamePanel.bullets.remove(i);
						i--;
					}
					for (int i = 0; i < GamePanel.explosions.size(); i++) {
						GamePanel.explosions.remove(i);
						i--;
					}
					GamePanel.state = GamePanel.STATES.PLAY;
				}
			}
			else
			{
				transp = 0;
			}
		if (GamePanel.mouseX > 11   && 
				 GamePanel.mouseX < 119 && 
				 GamePanel.mouseY > 10 && 
				 GamePanel.mouseY < 65)
			{
				transpB = 80;
				if (GamePanel.leftMouse)
				{
					GamePanel.state = GamePanel.STATES.MENUE;
				}
			}
			else
			{
				transpB = 0;
			}
	}
	public void draw(Graphics2D g)
	{
		g.setColor(Color.WHITE);
		String ser;
		int length = (int)g.getFontMetrics().getStringBounds(s,g).getWidth();
		g.drawString(s,(GamePanel.WIDTH - length)/2, GamePanel.HEIGHT/2);
			g.setColor(Color.BLUE);
		ser = "Final Score: " + GamePanel.player.getScore();
		length = (int)g.getFontMetrics().getStringBounds(ser,g).getWidth();
		g.drawString(ser,(GamePanel.WIDTH - length)/2, GamePanel.HEIGHT/2+30);
		g.setColor(Color.WHITE);
		
		g.setStroke(new BasicStroke(3));
		g.draw3DRect(GamePanel.WIDTH / 2 - buttonW / 2 + 1, 
				GamePanel.HEIGHT - GamePanel.HEIGHT / 4  - buttonH / 2 -50, buttonW, buttonH, true);
		g.setColor(new Color(255, 255, 255, transp));
		g.fillRect(GamePanel.WIDTH / 2 - buttonW / 2 + 1, 
				GamePanel.HEIGHT - GamePanel.HEIGHT / 4 - buttonH / 2 - 50, buttonW, buttonH);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana",Font.BOLD,30));
		length = (int)g.getFontMetrics().getStringBounds(ss,g).getWidth();
		g.drawString(ss, (int)GamePanel.WIDTH / 2 - length / 2, (int)GamePanel.HEIGHT - GamePanel.HEIGHT / 4 - buttonH / 2 + 3);
		
		g.setStroke(new BasicStroke(3));
		g.draw3DRect(10, 10, 110, 55, true);
		g.setColor(new Color(255, 255, 255, transpB));
		g.fillRect(10, 10, 110, 55);
		g.setColor(Color.WHITE);
		length = (int)g.getFontMetrics().getStringBounds("Back",g).getWidth();
		g.drawString("Back", 22, 47);
		
		g.setFont(new Font("Arial", Font.BOLD,15));
	}
}
