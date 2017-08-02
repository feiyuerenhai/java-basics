public class _12_annotation{
	public static void main(String[] args){
		Teacher jack = new Teacher("jack", "English");
		System.out.println(jack.great());
	}
}
class Person{
	private String name;
	
	public Person(String name){
		this.name = name;
	}
	public String greet(){
		return "hi, there";
	}
}
// 有时候我们想要覆写父类的方法，但是可能因为某些原因，没有写对要覆写的方法签名
// 比如，方法名拼错了，返回类型写错了
// 如下，我们原本是要覆盖greet方法，但是无意间写成了great
// 此时，编译器不会报错，调用也不会出错，但其实没有覆盖成功
// JDK5之后新增了注解功能，注解告诉编译器应该对当前注解目标作出什么样的指示
// 注解是给编译器看的
class Teacher extends Person{
	private String name, subject;
	public Teacher(String name, String subject){
		super(name);
		this.subject = subject;
	}
	@Override
	// wrong spell: public String great
	// Override告诉编译器，该方法必须要覆盖父类对象的某个方法，这就减少了方法签名写错的可能性
	public String greet(){
		return "hello world";
	}
	@Deprecated
	// Deprecated告诉编译器，该方法不再推荐使用，编译时会生成警告
	public String great(){
		return "great works done!";
	}
}
