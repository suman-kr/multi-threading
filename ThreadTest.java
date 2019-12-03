import java.util.concurrent.CyclicBarrier;


class Product extends Thread implements Runnable{
	static int product = 1;
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getId());
		// TODO Auto-generated method stub
		for (int i = 1 ; i <= 10 ; ++i) {
			product *= i;
		}
		try {
		ThreadTest.cyclic.await();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

class Sum extends Thread implements Runnable{
	static int sum ;
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getId());
		// TODO Auto-generated method stub
		 for (int i = 0 ; i <= 10 ; ++i) {
			 sum += i;
		 }
		try {
		ThreadTest.cyclic.await();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 
public class ThreadTest extends Thread implements Runnable {

	static CyclicBarrier cyclic = new CyclicBarrier(3);

	public static void main(String[] args) {
		Thread parent = new Thread(new ThreadTest());
		parent.start();
		System.out.println(Thread.currentThread().getId());
	}

	@Override
	public void run() {
		System.out.println("Multi Threading in Java with dependency");
		System.out.print("Before creating a thread --- >");
		System.out.println("sum: "+ Sum.sum + " Product: "+ Product.product + " SUM AND PRODUCT: "+ (Sum.sum + Product.product) );
		Thread t1 = new Thread(new Sum());
		Thread t2 = new Thread(new Product());
		t1.start();
		t2.start();
		System.out.print("Before calling a cyclic barrier --- >");
		System.out.println("sum: "+ Sum.sum + " Product: "+ Product.product + " SUM AND PRODUCT: "+ (Sum.sum + Product.product) );
		try {
			ThreadTest.cyclic.await();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("sum: "+ Sum.sum + " Product: "+ Product.product + " SUM AND PRODUCT: "+ (Sum.sum + Product.product) );
	}

}
