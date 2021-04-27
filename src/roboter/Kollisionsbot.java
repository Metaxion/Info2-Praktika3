package roboter;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;

public class Kollisionsbot extends AdvancedRobot{

	boolean turn;
	
	public void run() {
		turn = true;
		while(true) {
			if(turn == true) {
				turnRight(10);
			}
		}
	}
	
	@Override
	public void onScannedRobot(ScannedRobotEvent e) {
		turn = false;
		ahead(10);
		fire(1);
		turn = true;
	}
}
