public class _05_casting{
	public static void main(String[] args){
		// *向上转型*
		// 新建new 一个Teacher实例 教英语的jack 出来
		// 将其 向上转型 缩小 为Human
		Human jack = new Teacher("jack", "English");
		// 因此，jack依然具有Teacher的功能，但是被封锁，无法访问
		System.out.println(jack.say("all is well"));
		// 试图访问被封锁的方法会报错
		// System.out.println(jack.teach());

		// *向下转型*
		// 将jack强转为Teacher类型，并存储新的引用为jack_
		Teacher jack_ = (Teacher)jack;
		// ( 尝试使用 Teacher jack = (Teacher)jack 会报错，这样就出现重复声明，Teacher jack 和 Human jack两个声明)
		// 此时，原本jack中被封锁的方法重新被解锁
		// 试图方法解锁后的方法，结果正常
		System.out.println(jack_.teach());

		// *向下转型（不安全）*
		// 如果试图将rose向下转型为子类
		Human rose = new Human("rose");
		// 假如子类并没有实际地扩展父类，运行时不会异常
		// 而假如子类拥有一些父类没有的方法，编译能通过，但是运行时会报错
		// Teacher rose_ = (Teacher)rose;
		// System.out.println(rose_.teach());
	};
};

// 定义一个父类
class Human{
	// 父类拥有自己的字段
	private String name;
	public Human(String name){
		this.name = name;
	}
	// 以及方法
	public String say(String words){
		return "Hi, I am "+this.name+", "+words;
	}
}

// 定义一个子类
class Teacher extends Human{
	// 子类继承了父类的 字段name以及方法say，并加入了自己的 字段subject
	private String subject;
	public Teacher(String name, String subject){
		super(name);
		this.subject = subject;
	}
	// 子类还加入了自己独有的 方法teach
	public String teach(){
		return "I teach "+this.subject;
	}
}
