public class _18_Runnable {
	public static void main(String[] args) {
		Ticket ticket = new Ticket(200);
		Thread t1 = new Thread(ticket);
		Thread t2 = new Thread(ticket);
		Thread t3 = new Thread(ticket);
		t1.start();
		t2.start();
		t3.start();
	}
}
// 任何类实现Runnable接口，并将该类作为Thread构造参数传入即可实现多线程
// 所以，本质上，Thread类就是会接受一个实现了Runnable接口的对象，如果没有，默认构造一个空的
// synchronized关键字标识了某个语句块为同步语句
// 即：当一个线程进入synchronized语句，将 o 设为on，标明该代码块内已有线程在运行，其他线程不能进入
// 运行完毕，将 o 设为off，其他线程才有权利进入该代码块
class Ticket implements Runnable{
	private boolean flag = true;
	private int num;
	private Object o = new Object(); // o could be anything
	public Ticket(int num){
		this.num = num;
	}
	public void run(){
		while(true){
			synchronized(o){
				if(num>0 && flag){
					try{
						Thread.sleep(1);
					}catch(Exception e){};
					System.out.println( Thread.currentThread().getName() + " => " + num-- );
					if(num<5){
						// 终止线程的方式不是stop不是interrupt而是预存标识位
						flag = false;
						System.out.println( "all thread stop here" );
					}
				}else{
					break;
				}
			}
		}
	}
}