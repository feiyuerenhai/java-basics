public class _06_interface{
	public static void main(String[] args){
		MarriedTeacher rose = new MarriedTeacher("rose", "Art");
		System.out.println(rose.greet());
		System.out.println(rose.eat("bread"));
		System.out.println(rose.sleep(10));
		System.out.println(rose.work());
		System.out.println(rose.marry("jack"));
		System.out.println(rose.mum(3));
	};
};
// 接口本质上是特殊的、完全抽象的类
interface Animal{
	String eat(String food);
	String sleep(int hours);
}
// 接口也可以继承 interface x extends y
interface Married{
	String marry(String spouster);
}

interface Mother{
	String mum(int kids);
}
// 类实现了接口
// 如果，类中包含抽象方法，则类必须标注为抽象类
abstract class Human implements Animal{
	
	public String eat(String food){
		return "I eat "+food;
	}
	public String sleep(int hour){
		return "I sleep "+hour+" hours";
	}

	private String name;
	public Human(String name){
		this.name = name;
	}
	public String greet(){
		return "Hi, I am "+this.name;
	}

	abstract String work();
}
// 类只能继承自另外 一个 类
class Teacher extends Human{
	private String career = "Teacher";
	private String subject;
	public Teacher(String name, String subject){
		super(name);
		this.subject = subject;
	}
	public String work(){
		return "I work as a "+career+", and I teach "+this.subject;
	}
}
// 但是，类可以实现 多个接口
class MarriedTeacher extends Teacher implements Married, Mother{
	public MarriedTeacher(String name, String subject){
		super(name, subject);
	}
	public String marry(String spouster){
		return "I got married to "+spouster;
	}
	public String mum(int kids){
		return "I have "+kids+" kids";
	}
}