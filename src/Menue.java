import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
public class Menue {
	
	private int buttonPlayWidth;
	private int buttonPlayHeight;
	private int buttonHelpWidth;
	private int buttonHelpHeight;
	private int buttonExitWidth;
	private int buttonExitHeight;
	private int emblemRadius;
	private Color color;
	private String s;
	private String help;
	private String exit;
	private String title1;
	private String title2;
	private static int transp = 0;
	private static int transpHelp = 0;
	private static int transpExit = 0;
	public static ArrayList<Enemy> enemies;
	public static ExitQ quit=new ExitQ();
	public static int debug=0;
	
	public Menue()
	{
		buttonPlayWidth = 140;
		buttonPlayHeight = 70;
		buttonHelpWidth = 120;
		buttonHelpHeight = 60;
		buttonExitWidth = 100;
		buttonExitHeight = 60;
		emblemRadius = 125;
		color = Color.white;
		s = "Play";
		help = "Help";
		exit = "Exit";
		title1 = "BUBBLE";
		title2 = "WORLD";
		enemies = new ArrayList<Enemy>();
		for (int k = 0; k < 5; k++) {
			for (int i = 1; i <= 4; i++) {
				for(int j = 1; j <= 4; j++) {
					enemies.add(new Enemy(i,j));
				}
			}
		}
	}
	
	public void update()
	{
		for (int i = 0; i < enemies.size(); i++)
		 {
				enemies.get(i).update();
		 }
		if (GamePanel.mouseX > GamePanel.WIDTH / 2 - buttonPlayWidth / 2 && 
			 GamePanel.mouseX < GamePanel.WIDTH / 2 + buttonPlayWidth / 2 && 
			 GamePanel.mouseY > GamePanel.HEIGHT / 2 - buttonPlayHeight / 2 && 
			 GamePanel.mouseY < GamePanel.HEIGHT / 2 + buttonPlayHeight / 2)
		{
			transp = 80;
			if (GamePanel.leftMouse)
			{
				GamePanel.state = GamePanel.STATES.PLAY;
				if (GamePanel.player.getScore() > 0 && GamePanel.player.getX() == GamePanel.WIDTH / 2 && GamePanel.player.getY() == GamePanel.HEIGHT / 1.2
						&& GamePanel.enemies.size() == 0 && GamePanel.bullets.size() == 0)
				{
					GamePanel.player.setScore(0);
				}
			}
		}
		else
		{
			transp = 0;
		}
		
		if (GamePanel.mouseX > GamePanel.WIDTH / 2 - buttonHelpWidth / 2 && 
				 GamePanel.mouseX < GamePanel.WIDTH / 2 + buttonHelpWidth / 2 && 
				 GamePanel.mouseY > GamePanel.HEIGHT - GamePanel.HEIGHT / 3  - buttonHelpHeight / 2 && 
				 GamePanel.mouseY < GamePanel.HEIGHT - GamePanel.HEIGHT / 3  + buttonHelpHeight / 2)
			{
				transpHelp = 80;
				if (GamePanel.leftMouse)
				{
					GamePanel.state = GamePanel.STATES.HELP;
				}
			}
			else
			{
				transpHelp = 0;
			}
			
		if (GamePanel.mouseX > GamePanel.WIDTH / 2 - buttonExitWidth / 2  && 
				 GamePanel.mouseX < GamePanel.WIDTH / 2 + buttonExitWidth / 2 + 2 && 
				 GamePanel.mouseY > GamePanel.HEIGHT - GamePanel.HEIGHT / 6 - buttonExitHeight / 2 && 
				 GamePanel.mouseY < GamePanel.HEIGHT - GamePanel.HEIGHT / 6 + buttonExitHeight / 2)
			{
				transpExit = 80;
				if (GamePanel.leftMouse)
				{
					debug++;
					if(debug==1)
						quit.main();
				}
			}
			else
			{
				transpExit = 0;
				debug=0;
			}
	}
	
	public void draw(Graphics2D g)
	{
		for (int i = 0; i < enemies.size(); i++)
		{
			enemies.get(i).draw(g);
		}
		
		g.setColor(Color.WHITE);
		g.setStroke(new BasicStroke(10));
		g.drawOval(GamePanel.WIDTH / 2 - emblemRadius, GamePanel.HEIGHT / 18, emblemRadius*2, emblemRadius*2);
		g.setColor(new Color(0,0,0,128));
		g.fillOval(GamePanel.WIDTH / 2 - emblemRadius + 4, GamePanel.HEIGHT / 18 + 4, emblemRadius*2, emblemRadius*2);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Jokerman",Font.BOLD,50));
		g.drawString(title1, GamePanel.WIDTH / 2 - emblemRadius + emblemRadius / 7, GamePanel.HEIGHT / 18 + emblemRadius + emblemRadius / 20);
		g.setFont(new Font("Verdana",Font.BOLD,30));
		g.drawString(title2, GamePanel.WIDTH / 2 - emblemRadius + emblemRadius / 2, GamePanel.HEIGHT / 18 + emblemRadius + emblemRadius / 2);
		g.setFont(new Font("Verdana",Font.BOLD,14));
		g.drawString("Ver 1.1.1", GamePanel.WIDTH / 2 - emblemRadius + emblemRadius / 2 + emblemRadius / 4, GamePanel.HEIGHT / 18 + emblemRadius + emblemRadius / 2 + emblemRadius / 4);
		g.setFont(new Font("Verdana",Font.BOLD,30));
		
		g.setColor(color);
		g.setStroke(new BasicStroke(3));
		g.draw3DRect(GamePanel.WIDTH / 2 - buttonPlayWidth / 2, 
				GamePanel.HEIGHT / 2 - buttonPlayHeight / 2, buttonPlayWidth, buttonPlayHeight, true);
		g.setColor(new Color(255, 255, 255, transp));
		g.fillRect(GamePanel.WIDTH / 2 - buttonPlayWidth / 2, 
				GamePanel.HEIGHT / 2 - buttonPlayHeight / 2, buttonPlayWidth, buttonPlayHeight);
		
		g.setColor(color);
		g.setStroke(new BasicStroke(3));
		g.draw3DRect(GamePanel.WIDTH / 2 - buttonHelpWidth / 2, 
				GamePanel.HEIGHT - GamePanel.HEIGHT / 3 - buttonHelpHeight / 2, buttonHelpWidth, buttonHelpHeight, true);
		g.setColor(new Color(255, 255, 255, transpHelp));
		g.fillRect(GamePanel.WIDTH / 2 - buttonHelpWidth / 2, 
				GamePanel.HEIGHT - GamePanel.HEIGHT / 3 - buttonHelpHeight / 2, buttonHelpWidth, buttonHelpHeight);
		
		g.setColor(color);
		g.setStroke(new BasicStroke(3));
		g.draw3DRect(GamePanel.WIDTH / 2 - buttonExitWidth / 2, 
				GamePanel.HEIGHT - GamePanel.HEIGHT / 6 - buttonExitHeight / 2, buttonExitWidth, buttonExitHeight, true);
		g.setColor(new Color(255, 255, 255, transpExit));
		g.fillRect(GamePanel.WIDTH / 2 - buttonExitWidth / 2, 
				GamePanel.HEIGHT - GamePanel.HEIGHT / 6 - buttonExitHeight / 2, buttonExitWidth, buttonExitHeight);
		
		g.setFont(new Font("Verdana",Font.BOLD,40));
		g.setStroke(new BasicStroke(1));
		g.setColor(color);
		long length = (int)g.getFontMetrics().getStringBounds(s,g).getWidth();
		g.drawString(s, (int)GamePanel.WIDTH / 2 - length / 2, (int)GamePanel.HEIGHT / 2 + buttonPlayHeight / 4);
		g.setFont(new Font("Verdana",Font.BOLD,30));
		length = (int)g.getFontMetrics().getStringBounds(help,g).getWidth();
		g.drawString(help, GamePanel.WIDTH / 2 - length / 2, GamePanel.HEIGHT - GamePanel.HEIGHT / 3 + buttonHelpHeight / 4);
		length = (int)g.getFontMetrics().getStringBounds(exit,g).getWidth();
		g.drawString(exit, GamePanel.WIDTH / 2 - length / 2, GamePanel.HEIGHT - GamePanel.HEIGHT / 6 + buttonExitHeight / 4);
		
		g.setFont(new Font("Arial", Font.BOLD,15));
		
	}
}