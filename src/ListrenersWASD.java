import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class ListrenersWASD implements KeyListener, MouseListener, MouseMotionListener {

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
        if(key==KeyEvent.VK_W)
        {
            Player.up = true;
        }
        if(key==KeyEvent.VK_S)
        {
            Player.down = true;
        }
        if(key==KeyEvent.VK_A)
        {
            Player.left = true;
        }
        if(key==KeyEvent.VK_D)
        {
            Player.right = true;
        }
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
        if(key==KeyEvent.VK_W)
        {
            Player.up = false;
        }
        if(key==KeyEvent.VK_S)
        {
            Player.down = false;
        }
        if(key==KeyEvent.VK_A)
        {
            Player.left = false;
        }
        if(key==KeyEvent.VK_D)
        {
            Player.right = false;
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
