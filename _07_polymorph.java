public class _07_polymorph{
	public static void main(String[] args){
		// Teacher实例
		Teacher jack = new Teacher("jack", "English");
		// Doctor实例
		Doctor rose = new Doctor("rose");
		// 调用方法
		System.out.println( show(jack) );
		System.out.println( show(rose) );
	}
	public static String show(Human hm){
		// 分别将Teacher实例与Doctor实例传入，转型为父类类型Human的实例
		// 此时，双方都进行了向上转型
		// 发生向上转型的时候，如果子类拥有与父类相同的方法签名，则转型后的实例将使用被覆盖的方法
		// 因此Human.work调用的是子类实例原有的方法
		return hm.work();
	}
}

class Human{
	protected String name;
	public Human(String name){
		this.name = name;
	}
	// 父类拥有一个自己的work方法
	public String work(){
		return "work...work...work...";
	}
}

class Teacher extends Human{
	private String subject;
	public Teacher(String name, String subject){
		super(name);
		this.subject = subject;
	}
	// 子类重写了父类的work方法
	public String work(){
		return "I am "+this.name+", I teach students "+this.subject;
	}
}

class Doctor extends Human{
	public Doctor(String name){
		super(name);
	}
	// 子类重写了父类的work方法
	public String work(){
		return "I am "+this.name+", I am happy to cure the patients, and I would work till mid-nights";
	}
}