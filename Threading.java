class abc {
	synchronized void print(int n) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i * n);
			
		}
	}
	
	void printMessage(String msg) {
		synchronized (this) {
			for(int i = 0 ; i < 5 ; ++i) {
				System.out.println(Thread.currentThread().getId() + "-----> " + msg);
			}
		}
	}
}

public class Threading {

	public static void main(String[] args) {
		// same object should be passed
		abc obj = new abc();
//		Synchronized method
		Thread t1 = new Thread() {
			public void run() {
				obj.print(10);
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				obj.print(13);
			}
		};

		t1.start();
		t2.start();
//		Synchronized block
		Thread t3 = new Thread() {
			public void run() {
				obj.printMessage("hello");
			}
		};
		
		Thread t4 = new Thread() {
			public void run() {
				obj.printMessage("hello");
			}
		};
		
		t3.start();
		t4.start();
	}
	
}
