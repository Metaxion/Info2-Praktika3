package roboter;

import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

public class Umrandungsbot extends AdvancedRobot{

	int turnDirection; // 1 = rechts rum, 2 = links rum
	int turnRight;
	int turnLeft;
	
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
	
	@Override
	public void onHitWall(HitWallEvent e) {
		if(turnDirection == 1) {
			turnRight = 1;
		} else {
			turnLeft = 1;
		}
	}
	
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
	
	@Override
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(1);
	}
	
}
