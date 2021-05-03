package roboter;

import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

/**
 * Ein Bot fuer die RoboCode Anwendung
 * Vorgehensweise des Roboters:
 * Der Roboter dreht sich links rum bis er zur rechten Wand schaut, bewegt sich darauf an den Rand.
 * Ab da fährt der Bot am Rand entlang im Kreis, mit der Kanone in Richtung Spielfeld gerichtet.
 * Bei Sichtkontakt schiesst der Bot. Wird er getroffen, dreht er sich und faehrt in die andere Richtung im Kreis.
 * 
 * @author Marcel Thomas Krups
 */
public class Umrandungsbot extends AdvancedRobot{

	int turnDirection; // 1 = rechts rum, 2 = links rum
	int turnRight;
	int turnLeft;
	
	/**
	 * Hauptmethode
	 * (Funktionalität siehe Klassenbeschreibung)
	 */
	@Override
	public void run() {
		turnDirection = 1;
		turnRight = 0;
		turnLeft = 0;
		double change = getHeading() - 90;
		turnLeft(change);
		turnGunRight(90);
		
		while(true) {
			if(turnRight == 1) {
				turnRight(90);
				turnRight = 0;
			} else if (turnLeft == 1) {
				turnLeft(90);
				turnLeft = 0;
			}
			setAhead(10);
			execute();
		}
	}
	
	/**
	 * Bei Wandkontakt dreht er sich um 90 Grad.
	 * @param e HitWallEvent
	 */
	@Override
	public void onHitWall(HitWallEvent e) {
		if(turnDirection == 1) {
			turnRight = 1;
		} else {
			turnLeft = 1;
		}
	}
	
	/**
	 * Wenn er von einer Kugel getroffen wird, dreht er sich um 180 Grad und faehrt in die andere Richtung
	 * @param e HitByBulletEvent
	 */
	@Override
	public void onHitByBullet(HitByBulletEvent e) {
		if(turnDirection == 1) {
			turnDirection = 2;
			turnRight(180);
			turnGunRight(180);
		} else {
			turnDirection = 1;
			turnLeft(180);
			turnGunLeft(180);
		}
	}
	
	/**
	 * Wenn ein Bot sich in Sichtweite befindet, schiesst der Roboter
	 * @param e ScannedRobotEvent
	 */
	@Override
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(1);
	}
	
}
