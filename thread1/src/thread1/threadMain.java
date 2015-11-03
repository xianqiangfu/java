package thread1;

class NewThread implements Runnable {
	Thread t;
	NewThread()
	{
		t = new Thread(this, "Demo Thread");
		System.out.println("Child thread:" + t);
		t.start();
	}
	
	public void run()
	{
		try {
			for (int i = 5; i > 0; --i)
			{
				System.out.println("Child Thread:" + i);
				Thread.sleep(50);
			}
		} catch(InterruptedException e) {
			System.out.println("Child interrupted");
		}
		System.out.println("Exiting child thread.");
	}
}
public class threadMain {

	public static void main(String[] args) {
		new NewThread();
		
		try {
			for (int i = 5; i > 0; --i)
			{
				System.out.println("Main Thread " + i);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thred interrupt.");
		}
		System.out.println("Main thread exiiting.");
		// TODO Auto-generated method stub

	}

}