import java.util.concurrent.Semaphore;

public class NewThread {
	/*
	 * Semaphore Implementation in Java
	 */
	static Semaphore semaphore = new Semaphore(5);

	static class myClass implements Runnable {
		String name = "";

		myClass(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			System.out.println("Available locks: -----> " + semaphore.availablePermits());
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				System.out.println("acquired lock -----> " + name);
				System.out.println("Available locks: -----> " + semaphore.availablePermits());
				semaphore.release();
				System.out.println("Lock Released -----> " + name);
			}

			System.out.println("Available locks: -----> " + semaphore.availablePermits());
		}
	}

	public static void main(String[] args) {

		new Thread(new myClass("A")).start();
		new Thread(new myClass("B")).start();
		new Thread(new myClass("C")).start();
		new Thread(new myClass("D")).start();
		new Thread(new myClass("E")).start();
		new Thread(new myClass("F")).start();
		new Thread(new myClass("G")).start();
		new Thread(new myClass("H")).start();
		new Thread(new myClass("I")).start();
		new Thread(new myClass("J")).start();

	}

}
