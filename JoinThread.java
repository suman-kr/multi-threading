class ThreadClass implements Runnable{

	@Override
	public void run() {
		for (int i = 0 ; i <= 5 ; ++i) {
			
			System.out.println("Thread id: ----> " + Thread.currentThread().getId() + "   "+i);
		}
	}
}
public class JoinThread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new ThreadClass());
		Thread t2 = new Thread(new ThreadClass());
		Thread t3 = new Thread(new ThreadClass());
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
	}
}
