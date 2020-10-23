import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class ListrenersKeys implements KeyListener, MouseListener, MouseMotionListener {

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE)
        {
            Player.firing = true;
        }
		if ((key == KeyEvent.VK_ESCAPE )||(key==KeyEvent.VK_BACK_SPACE))
        {
        	if (GamePanel.state == GamePanel.STATES.MENUE) {
        		ExitQ q = new ExitQ();
        		q.main();
        	}else {
        	GamePanel.state = GamePanel.STATES.MENUE;
        	}
        }
        if (key == KeyEvent.VK_ENTER)
        {
        	if (GamePanel.state == GamePanel.STATES.MENUE)
        	{
        		GamePanel.state = GamePanel.STATES.PLAY;
        	}
        }
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE)
        {
            Player.firing = false;
        }
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
	public void mousePressed(MouseEvent arg0){
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent arg0){
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseDragged(MouseEvent arg0){
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseMoved(MouseEvent arg0){
		// TODO Auto-generated method stub
	}
}
