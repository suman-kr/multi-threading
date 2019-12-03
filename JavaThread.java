
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class JavaThread{
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Runnable  r1 = () -> {
			System.out.println(Thread.currentThread().getName());
			int a = 0;
			for (int i = 1 ; i <= 100; ++i) {
				System.out.println(i);
			}
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Runnable  r2 = () -> {
			System.out.println(Thread.currentThread().getName());
			int p = 1;
			for (int i = 1 ; i <= 100; ++i) {
			
				System.out.println(i);
			}

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		executor.submit(r1);
		executor.submit(r2);
		executor.shutdown();
		
		
		
	}

}
