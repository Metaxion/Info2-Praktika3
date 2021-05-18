package roboter;

import java.awt.event.KeyEvent;

import robocode.AdvancedRobot;

/**
 * Ein Bot fuer die RoboCode Anwendung
 * Vorgehensweise des Roboters:
 * 
 * Der Bot ist steuerbar, Eingaben:
 * - W, faehrt gerade aus
 * - S, faehrt rueckwaerts
 * - A, dreht sich nach links
 * - D, dreht sich nach rechts
 * - SPACE, schiesst
 * 
 * @author Marcel Thomas Krups
 */
public class Tastaturbot extends AdvancedRobot {

	int moveDirection;
	int turnDirection;
	
	/**
	 * Hauptmethode
	 * (Funktionalität siehe Klassenbeschreibung)
	 */
	@Override
	public void run() {
		moveDirection = 0;
		while(true) {
			setAhead(10 * moveDirection);
			
			setTurnRight(45 * turnDirection);
			
			execute();
		}
	}
	
	/**
	 * Erwartet die Eingaben des Nutzers (siehe Klassenbeschreibung)
	 * Erkennt den Beginn des Befehls, durch das Druecken einer Taste.
	 * @param e KeyEvent
	 */
	@Override
	public void onKeyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_H: //h
			case KeyEvent.VK_A:
				turnDirection = -1;
				break;
			case KeyEvent.VK_J: //j
			case KeyEvent.VK_D:
				turnDirection = 1;
				break;
			case KeyEvent.VK_K: //k
			case KeyEvent.VK_W:
				moveDirection = 1;
				break;
			case KeyEvent.VK_L: //l
			case KeyEvent.VK_S:
				moveDirection = -1;
				break;
			case KeyEvent.VK_SPACE:
				fire(1);
				break;
		}
	}
	
	/**
	 * Erkennt die Beendigung des Befehls, durch das Loslassen der Taste.
	 * @param e KeyEvent
	 */
	@Override
	public void onKeyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_H:
		case KeyEvent.VK_J:
		case KeyEvent.VK_A:
		case KeyEvent.VK_D:
			turnDirection = 0;
			break;
		case KeyEvent.VK_K:
		case KeyEvent.VK_L:
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
