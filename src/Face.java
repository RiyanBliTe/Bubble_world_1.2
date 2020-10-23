import javax.swing.JFrame;
public class Face{
	public static void main(String[] args) {
		JFrame frame = new JFrame("Bubble World");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setContentPane(new GamePanel());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
}