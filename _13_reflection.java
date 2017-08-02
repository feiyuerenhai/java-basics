import java.lang.reflect.*;

public class _13_reflection{
	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {
		// 我们通常都是通过import关键字将类引入当前程序，但有一些特殊情况
		// 比如，需要策略性引入不同的类，或者，为已经开发完成的程序开发扩展插件
		// 这就要求我们的程序能动态地引入未经声明的类
		// 类本身也是对象，其类型为Class（而非class）
		// 要引入类，本质是就是获取 类的类型
		// 通过ins.getClass()与Cls.class都能获取到类型，如下
		if( Engineer.class == (new Engineer("rose", "math")).getClass() ){
			System.out.println( "eg.getClass() and Engineer.class are exactly the same thing" );
		};
		// 但我们的需求是，并不事先引入类

		// 根据字符串xyz读取xyz.class类文件
		Class cls1;
		// 向forName方法传入类的路径
		// 此时，cls1得到的类型也就是上述的.class
		cls1 = Class.forName("Engineer");
		// JVM读取该cls对象的 字段列表、方法列表(包括构造方法)
		// getXXX与getDeclaredXXX的区别是: 前者获取的只有public，后者获取的是all
		// getYYYs获取的是一个列表比如 Method[]

		// 获取指定签名的构造方法
		Constructor constructor1 = cls1.getConstructor(String.class, String.class);
		
		// 尝试调用某个构造器初始化对象
		// 返回对象类型是Object
		Object obj1 = constructor1.newInstance("jack", "logistics");

		// 获取任何字段(declared包括私有字段)
		Field field1 = cls1.getDeclaredField("CODE");
		// 使得私有字段可存取
		field1.setAccessible(true);
		// 存
		field1.set(obj1, 13);
		// 取
		System.out.println( field1.get(obj1) );

		// 获取指定签名的public方法
		Method method1 = cls1.getMethod("intro", int.class);
		// 调用方法并传参
		System.out.println( method1.invoke( obj1, 3 ) );

		// 获取任何方法(包括私有方法)
		Method method2 = cls1.getDeclaredMethod("work");
		// 调用私有方法
		method2.setAccessible(true);
		System.out.println( method2.invoke( obj1    ) );
	}
}

class Engineer{
	private int CODE = 11;
	private String name, domain;
	public Engineer(String name, String domain){
		this.name = name;
		this.domain = domain;
	}
	public String intro(int years){
		return "I have been working on " + this.domain + " for " + years + " years";
	}
	private String work(){
		return "i am working privately i donna wanna be seen";
	}
}