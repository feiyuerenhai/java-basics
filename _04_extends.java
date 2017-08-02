public class _04_extends{
	public static void main(String[] args){
		Teacher jack = new Teacher("Jack", 22, "English");
		System.out.println(jack.greet());
		System.out.println(jack.work());
		System.out.println(jack.teach());
	};
};

class Human{
	private String name;
	private int age;
	public Human(String name, int age){
		this.name = name;
		this.age = age;
	};
	public String greet(){
		return "Hi there, My name is "+this.name+", and I am "+this.age+" years old.";
	};
	public String work(){
		return "everyone needs to work";
	}
}

class Teacher extends Human{
	private String subject;
	public Teacher(String name, int age, String subject){
		super(name, age);
		this.subject = subject;
	}
	public String work(){
		return "I am a teacher";
	}
	public String teach(){
		return "I teach "+this.subject;
	}
}