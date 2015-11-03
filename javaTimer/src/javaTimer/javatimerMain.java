package javaTimer;

import java.util.Timer;
import java.util.TimerTask;

public class javatimerMain {
	Timer timer;
	public javatimerMain(int seconds) {
		timer = new Timer();
		timer.schedule(new RemindTask(),  0, seconds * 1000);
	}
	
	class RemindTask extends TimerTask {
		public void run() {
			System.out.println("Time is up!");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("About to schedule task.");
		new javatimerMain(5);
		System.out.println("Task scheduled!");
	}

}
