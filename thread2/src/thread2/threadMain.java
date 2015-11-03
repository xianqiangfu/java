package thread2;

class NewThread extends Thread
{
	NewThread()
	{
		super("Demo Thread");
		System.out.println("Child thread:"+ this);;
		start();
	}
	
	public void run() {
		try {
			for (int i = 5; i > 0; --i)
			{
				System.out.println("Child thread " + i);
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Child interrupted.");
		}
	}
}


public class threadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method
		new NewThread();
		try{
			for (int i = 5; i > 0; --i) {
				System.out.println("Main Thread:" + i);
				Thread.sleep(100);
			}
		}catch (InterruptedException e) {
			System.out.println("Main interrupted.");
		}
		System.out.println("Main thread exiting.");
	}

}
