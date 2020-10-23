import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExitQ {

	public void main() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Are you sure?");
		JButton buttonYes = new JButton("Yes");
		JButton buttonNo = new JButton("No");
		frame.setSize(400, 200);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.BLUE.darker());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Verdana", Font.BOLD, 35));
		panel.add(label);
		buttonYes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
		buttonNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		panel.add(buttonYes);
		panel.add(buttonNo);
		frame.add(panel);
		frame.setVisible(true);
	}
}