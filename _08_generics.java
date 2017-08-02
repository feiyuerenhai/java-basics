// 定义一个空接口
interface Animal{}
// 一个Man类实现空接口
class Man implements Animal{
	private String name;
	public Man(String name){
		this.name = name;
	}
	public String greet(){
		return "hi there, nice to meet you, I am "+this.name;
	}
}
// 一个Dog类实现空接口
class Dog implements Animal{
	public String bark(){
		return "bough~bough~bough~";
	}
}
// 一个Box类
class Box1{
	// 用于操作Animal类型的对象
	// 所以，该Box可以操作Man和Dog类
	private Animal o;
	public void set(Animal a){
		this.o = a;
	}
	public Animal get(){
		return this.o;
	}
}

public class _08_generics{
	public static void main(String[] args){
		// 一个Man实例m
		Man m = new Man("jack");
		// 一个Dog实例d
		Dog d = new Dog();
		// 好戏开始
		Box1 box1 = new Box1();
		// Box存入m
		box1.set(m);
		// Box存入d
		box1.set(d);
		// ...
		// ...
		// ...
		// 过了很久之后，懵逼了
		// 我们现在并不知道box里面存储的到底是什么

		// 尝试取出来存储的内容
		// 因为box.get得到的是一个Animal对象
		// 所以，强转为Man，这是一个不安全的向下转型，然后调用greet方法
		// Man unknown = (Man) box1.get();
		// unknown.greet();
		// 直到此时，编译器并不会报错，因为一切看起来都是正确的
		// 然而，一运行，就报错，因为从上面看出来，box最后存入的是d
		// d没有greet方法

		// 为了摆正错误，我们先注释掉上面两行

		// instanceof能在运行时判断实例的类型
		if( box1.get() instanceof Man ){
			Man p1_ = (Man) box1.get();
			System.out.println(p1_.greet());
		}else if( box1.get() instanceof Dog ){
			Dog p1_ = (Dog) box1.get();
			System.out.println(p1_.bark());
		};

		// 但是这样实在太麻烦了
		// 我们是将异常检查遗留到了运行时

		// 现在，使用泛型
		// 如下，声明一个Box类型，并使用一对 尖括号<> 注明
		// 意味着，这个类要操作某个未知但确定的类型 T

		class U{}
		class Box2<T>{
			// T类型是通过参数传入
			private T o;
			// U类型是我们预先定义，所以，泛型，其实就是参数化的类型
			private U u;
			public void set(T a){
				this.o = a;
			}
			public T get(){
				return this.o;
			}
		}

		Box2<Man> box2 = new Box2<>();
		// 此时，在box中存入m，语法检查无误
		box2.set(m);
		// 而存入d，即，尝试在Man类型的box中存入dog，则编译器检查会报错
		// box2.set(d);

		// 其实，ArrayList<T> 等容器，实现也大致类似
		// 其实，泛型常常与 集合Collection 一起使用，因为，集合中存储的是Object
		// 因此，任意类型的对象都能存储其中
		// 这就给运行时带来了不确定性
		// 增加了错误的风险
		// 泛型的作用就是，将容器的类型检查，提前定位在编译阶段
		// 说白了，泛型就是为了改变 普通容器没有类型限定 的局面
		// 增强了类型检查，不使用过多的转型
	}
}