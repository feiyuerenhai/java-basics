public class _19_lambda{
	public static void main(String[] args) {
		// Lambda表达式也称为闭包，是匿名类的简短形式
		// Lambda表达式简化了单一抽象方法声明接口的使用
		// 因此lambda表达式也称为功能接口
		// 可以使用lambda表达式实现功能接口，而无需创建类或匿名类
		// Lambda 表达式只能用于单一方法声明接口
		// 即功能性接口 functional interface，一个接口只包含有一个抽象方法
		// 如下：
		Worker w = career -> "I work as a " + career;
		System.out.println(w.work("teacher"));
		// 对于多方法接口，还是应该使用经典的匿名内部类
		// 匿名类的实现接口不能有参数
		Teacher t = new Teacher(){
			public String teach(String subject){
				return "I teach " + subject;
			}
			public String sleep(int hrs){
				return "I sleep " + hrs + " hours";
			}
		};
		System.out.println(t.teach("English"));
		// 用lambda实现Runnable
		// Java 8之前（已经定义了Thread、Runnable）
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		    System.out.println("Before Java8, too much code for too little to do");
		    }
		}).start();
		// Java 8方式：
		// 注意，lambda会被自动转成该方法需要的参数类型
		new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
	}
}
interface Worker{
	public String work(String career);
}
interface Teacher{
	public String teach(String subject);
	public String sleep(int hours);
}