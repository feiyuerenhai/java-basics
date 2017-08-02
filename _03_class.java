// 所有的字段、语句、方法都在类中实现，类是java程序的基本单位
public class _03_class{
	public static void main(String[] args){
		Human jack = new Human("jack", 22, "bread");
		System.out.println(jack.greet("England"));
		System.out.println(Human.getIntro());
	}
}

class Human{
	// 类可以看作是 一些状态 + 操作这些状态的方法 所组成的
	// 状态和方法都由 修饰符 修饰
	// 修饰符很多，其中就包括 访问控制修饰符（ public > protected > private ）
	// 无论方法还是字段，除了 名称 之外，还由该字段的 数据类型 修饰
	// 使用逗号 , 可以连接 相同类型 的字段声明，不同类型的字段会报错
	// 字段还可以指定默认值
	private String name, food = "anything";
	// 通常来说，所有实例字段都应该限定为private
	// 将类比作一个容器，这样是为了保证密封性，密封性带来的好处就是安全
	// 试想，如果外部程序擅自改动实例的内部状态，相关方法将出现困惑
	private int age;

	// 通常的约定是使用 get/set + 字段名 表示对于字段的存取
	// 只暴露必要的接口
	public String getFood(){
		// 方法中可以 自由无限制地 取字段或者调用其他方法，如food，即为取笨类字段food
		return food;
	};
	public void setFood(String food){
		// 但是，为了避免混淆，最好取本类 字段或方法 的时候，前面加上 this
		this.food = food;
	};
	// 尽量多地利用private隐藏实现细节
	private String getName(){
		return name;
	};
	private int getAge(){
		return this.age;
	};
	// 一个方法，根据传参的签名不同，可以有多个实现，这叫做方法签名
	// 调用方法的时候，会根据传参的不同而调用签名方法中具体的某一个
	public String greet(){
		return "Hi there, I am " + this.getName()+", " + this.getAge() + " years old, and I like " + this.getFood()+'.';
	};
	public String greet(String nation){
		// 直接使用greet()或者this.greet()调用方法
		return greet() + "\nOh I am from "+nation+"!";
	};

	// 每个类都有构造方法，即便不显式指定，编译器也会隐式添加
	// 构造方法与普通方法最大的区别是构造方法没有返回值，因此不能指定其返回类型，void也不可以
	public Human(String name, int age){
		this.name = name;
		this.age = age;
	};
	// 构造方法也可以重载
	public Human(String name, int age, String food){
		// 有一点显得特殊，就是可以特别地使用this()调用构造方法
		this(name, age);
		this.food = food;
	};
	
	// 如果我们将字段和方法统称为属性
	// 那么，实例属性属于 实例本身
	// 静态属性则属于 类本身
	// 实例方法可以调用静态属性
	// 但静态方法不能调用实例属性
	public static String species = "Human";
	public static String intro = "is the most smart species in the world";
	public static String getIntro(){
		return species + " " + intro;
	};
}