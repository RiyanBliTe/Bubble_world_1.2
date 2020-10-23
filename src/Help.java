import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
public class Help
{
	private Color color;
	private String s;
	private String title;
	private String first;
	private String second;
	private String t3;
	private String t4;
	private String t5;
	private String t6;
	private String t7;
	private String t8;
	private String t9;
	private String t10;
	private String t11;
	private String t12;
	private String t13;
	private String Who;
	
	private static int transp;
	
	
	public Help() {
		s = "Back";
		color = Color.WHITE;
		title = "Rules of the game";
		first = "1. 20 waves of enemies.";
		second = "2. 12 upgrades of weapons.";
		t3 = "3. 4 types of enemies and 1 boss.";
		t4 = "4. Standard control keys: ";
		t5 = "5. PowerUps:";
		t6 = "6. Enemiess have 4 types & boss and each in 4 ranks.";
		t7 = "7. When a big enemy dies others get out of it, but they are of lesser rank.";
		t8 = "8. You only have 5 lives at the beginning of the game.";
		t9 = "9. Score = type + rank.";
		t10 = "Be careful";
		t11 = "And";
		t12 = "GOOD LUCK!";
		t13 = "10. If you lose one life then lose one power.";
		Who = "Made by Bogdan Marchak with tiny help by Volodynyr Lagush :)";
	}
	
	public void update()
	{
		if (GamePanel.mouseX > 10 && 
				 GamePanel.mouseX < 110 && 
				 GamePanel.mouseY > 10 && 
				 GamePanel.mouseY < 60)
			{
				transp = 80;
				if (GamePanel.leftMouse)
				{
					GamePanel.state = GamePanel.STATES.MENUE;
				}
			}
			else
			{
				transp = 0;
			}
	}
	public void draw(Graphics2D g){
		g.setColor(new Color(255,255,255,88));
		g.fillOval(GamePanel.WIDTH / 3, GamePanel.HEIGHT / 3, GamePanel.WIDTH / 3, GamePanel.HEIGHT / 4);
		g.setColor(new Color(0,0,255));
		g.setFont(new Font("Jokerman",Font.BOLD,50));
		long length = (int)g.getFontMetrics().getStringBounds("BUBBLE",g).getWidth();
		g.drawString("BUBBLE", (int)GamePanel.WIDTH / 3 + length / 2, GamePanel.HEIGHT / 3 + GamePanel.HEIGHT / 8 );
		g.setFont(new Font("Verdana",Font.BOLD,30));
		length = (int)g.getFontMetrics().getStringBounds("WORLD",g).getWidth();
		g.drawString("WORLD", (int)GamePanel.WIDTH / 2 - length / 2, GamePanel.HEIGHT / 3 + GamePanel.HEIGHT / 5);
		
		g.setFont(new Font("Verdana", Font.BOLD,30));
		g.setColor(color);
		g.setStroke(new BasicStroke(3));
		g.draw3DRect(10, 10, 100, 50, true);
		g.setColor(new Color(255, 255, 255, transp));
		g.fillRect(10, 10, 100, 50);
		g.setColor(color);
		g.drawString(s, 20, 45);
		g.setFont(new Font("Verdana", Font.BOLD,18));
		length = (int)g.getFontMetrics().getStringBounds(title,g).getWidth();
		g.drawString(title, GamePanel.WIDTH / 2 - length / 2, 45);
		g.setFont(new Font("Verdana", Font.BOLD,14));
		g.drawString(first, 2, 80);
		g.drawString(second, 2, 96);
		g.drawString(t3, 2, 111);
		g.drawString(t4, 2, 130);
		g.setStroke(new BasicStroke(1));
		g.drawRect(54, 134, 50, 50);
		g.drawRect(2, 186, 50, 50);
		g.drawRect(54, 186, 50, 50);
		g.drawRect(106, 186, 50, 50);
		g.drawString("UP", 70, 165);
		g.drawString("Down", 57, 218);
		g.drawString("Left", 13, 218);
		g.drawString("Right", 110, 218);
		g.drawRect(29, 250, 100, 40);
		g.drawString("Space", 57, 275);
		g.drawRect(55, 300, 50, 40);
		g.drawString("Esc", 66, 325);
		g.drawString("-    Moving", 180, 190);
		g.drawString("-    Firing", 180, 276);
		g.drawString("-    Pause and dack to menu", 180, 329);
		g.drawString(t5, 2, 360);
		g.setColor(Color.YELLOW);
		g.fillOval(5, 370, 10, 10);
		g.setColor(Color.CYAN);
		g.fillOval(5, 414, 10, 10);
		g.setColor(Color.RED);
		g.fillOval(5, 435, 10, 10);
		g.setColor(Color.WHITE);
		g.drawString("-  +1 power", 20, 380);
		g.drawString("-  time slower", 20, 424);
		g.drawString("-  +1 life", 20, 445);
		g.setFont(new Font("Verdana", Font.BOLD,14));
		g.drawString(t6, 2, 465);
		g.drawString(t7, 2, 480);
		g.drawString(t8, 2, 495);
		g.drawString(t9, 2, 510);
		g.drawString(t13, 2, 525);
		g.setFont(new Font("Verdana",Font.BOLD,20));
		length = (int)g.getFontMetrics().getStringBounds(t10,g).getWidth();
		g.drawString(t10, GamePanel.WIDTH / 2 - length / 2, GamePanel.HEIGHT - GamePanel.HEIGHT/8);
		length = (int)g.getFontMetrics().getStringBounds(t11,g).getWidth();
		g.drawString(t11, GamePanel.WIDTH / 2 - length / 2, GamePanel.HEIGHT - GamePanel.HEIGHT/12);
		length = (int)g.getFontMetrics().getStringBounds(t12,g).getWidth();
		g.drawString(t12, GamePanel.WIDTH / 2 - length / 2, GamePanel.HEIGHT - GamePanel.HEIGHT/22);
		g.setFont(new Font("Arial", Font.BOLD,15));
		g.drawString(Who, GamePanel.WIDTH - 500, GamePanel.HEIGHT - 10);
	}
}