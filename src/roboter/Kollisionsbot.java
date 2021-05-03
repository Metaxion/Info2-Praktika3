package roboter;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;

/**
 * Ein Bot fuer die RoboCode Anwendung
 * Vorgehensweise des Roboters:
 * Der Bot dreht sich links rum bis er einen Roboter scannt. 
 * Ist ein Roboter in Sichtweite bewegt er sich auf ihn zu und schiesst.
 * Er dreht sich dann in die Richtung, in die auch der erkannte Roboter sich dreht und behaelt ihn somit im Blick.
 * 
 * @author Marcel Thomas Krups
 */
public class Kollisionsbot extends AdvancedRobot {

	boolean turn;
	int richtung;

	/**
	 * Hauptmethode
	 * (Funktionalität siehe Klassenbeschreibung)
	 */
	public void run() {
		richtung = 1;
		while (true) {
			if (richtung > 0) {
				turnLeft(8);
			} else {
				turnRight(8);
			}
		}
	}

	/**
	 * Wenn ein Bot sich in Sichtweite befindet, schiesst der Roboter und faehrt gerade aus.
	 * Der Bot dreht sich in die Richtung, in die der erkannte Bot sich bewegt.
	 * @param e ScannedRobotEvent
	 */
	@Override
	public void onScannedRobot(ScannedRobotEvent e) {
		if (e.getBearing() < 0) {
			richtung = 1;
		} else {
			richtung = -1;
		}
		ahead(7);
		fire(2);
	}
}
