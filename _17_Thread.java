public class _17_Thread {
	public static void main(String[] args) {
		MyThread mt1 = new MyThread();
		MyThread mt2 = new MyThread();
		MyThread mt3 = new MyThread();
		MyThread mt4 = new MyThread();
		mt1.start();
		mt2.start();
		mt3.start();
		mt4.start();
	}
}
// Thread类拥有Native实现，本质就会新建一个线程
// 实现多线程最简单的方法就是继承Thread类并覆写run方法，可以同时开启多个线程
// 但是，上文中，虽然字面上看来，mt1.start()比mt2.start()要早
// 实际执行中，java虚拟机只是依次将mt1和mt2先后交给CPU处理
// 而CPU到底会先执行哪一个线程，这是不确定的，依据 线程争夺CPU时间片 来定
// 因此，上文中执行结果是乱序的
// 通常，并不建议通过继承Thread类的方式
// 因为，java是单继承的，继承了Thread便无法继承其他父类
// 建议的做法是实现Runnable接口
class MyThread extends Thread{
	private int num = 5;
	@Override
	public void run(){
		while(num>0){
			System.out.println( Thread.currentThread().getName() + " => " + num-- );
		}
	}
}