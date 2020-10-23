import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class ListrenersMouse implements KeyListener, MouseListener, MouseMotionListener {
	@Override
	public void keyPressed(KeyEvent e){
		// TODO Auto-generated method stub
	}
	@Override
	public void keyReleased(KeyEvent e){
		// TODO Auto-generated method stub
	}
	@Override
	public void keyTyped(KeyEvent arg0){
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseClicked(MouseEvent arg0){
		// TODO Auto-generated method stub		
	}
	@Override
	public void mouseEntered(MouseEvent arg0){
		// TODO Auto-generated method stub		
	}
	@Override
	public void mouseExited(MouseEvent arg0){
		// TODO Auto-generated method stub		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getButton() == MouseEvent.BUTTON1)
		{
			GamePanel.leftMouse = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getButton() == MouseEvent.BUTTON1)
		{
			GamePanel.leftMouse = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		GamePanel.mouseX = arg0.getX();
		GamePanel.mouseY = arg0.getY();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		GamePanel.mouseX = arg0.getX();
		GamePanel.mouseY = arg0.getY();
	}

}
