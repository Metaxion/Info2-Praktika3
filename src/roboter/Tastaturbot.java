package roboter;

import java.awt.event.KeyEvent;

import robocode.AdvancedRobot;

public class Tastaturbot extends AdvancedRobot {

	int moveDirection;
	int turnDirection;
	
	@Override
	public void run() {
		moveDirection = 0;
		while(true) {
			setAhead(10 * moveDirection);
			
			setTurnRight(45 * turnDirection);
			
			execute();
		}
	}
	
	@Override
	public void onKeyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_A:
				turnDirection = -1;
				break;
			case KeyEvent.VK_D:
				turnDirection = 1;
				break;
			case KeyEvent.VK_W:
				moveDirection = 1;
				break;
			case KeyEvent.VK_S:
				moveDirection = -1;
				break;
			case KeyEvent.VK_SPACE:
				fire(1);
				break;
		}
	}
	
	@Override
	public void onKeyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
		case KeyEvent.VK_D:
			turnDirection = 0;
			break;
		case KeyEvent.VK_W:
		case KeyEvent.VK_S:
			moveDirection = 0;
			break;
		case KeyEvent.VK_SPACE:
			fire(1);
			break;
		}
	}
	
}
