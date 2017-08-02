import java.lang.reflect.*;
import java.lang.annotation.*;

public class _14_annotation2 {
	public static void main(String[] args) throws Exception {
		Class cls = (new Person("jack")).getClass();
		// 反射读取方法
		Method method = cls.getDeclaredMethod("setAge", int.class);
		// 检查该方法上是否存在注解
		if( method.isAnnotationPresent(NaturalAge.class) ){
			// 获取该方法注解
			NaturalAge na = method.getAnnotation(NaturalAge.class);
			// 获取该方法注解值
			int from = na.from();
			int to = na.to();
			/* 注解使用场景 */
			// 注解的作用不在业务上，而是在程序代码本身
			// 换句话说，注解和最终用户没有关系，而是和程序员紧密相关
			// 注解在一些框架中使用频率最多，比如，程序员开发程序的过程中使用了注解
			// 这些框架就能根据程序员的注解，恰当地处理相关代码
			// 代码前标识@Controller注解，框架就将该代码加载到controller处理而非serivce
			// - - - - - -
			// 如下，某个程序员自定义了Person类
			// 在setAge方法上使用了我们提供的注解@NaturalAge
			// 而我们使用反射编写了 “Person类的解析程序”，拿到age的取值范围
			// 这样以来，我们的解析程序就能使用注解里的信息对Person类进行恰当的处理了
			System.out.println(to);
		}
	}
}

/* 自定义注解 */

// 使用元注解@Target标明该注解可以作用于哪些目标元素，ElementType枚举值包括：
// PACKAGE 包、TYPE 类、FIELD 域、CONSTRUCTOR 构造器、
// METHOD 方法、PARAMETER 参数、LOCAL_VARIABLE 局部变量
// 如果不标注@Target则可以作用于所有目标元素
@Target(ElementType.METHOD)

// 使用元注解@Retention标明该注解可以存留在程序的那个阶段
// RetentionPolicy枚举值包括：
// SOURCE 只保留在源代码中，编译时被丢弃
// CLASS（默认） 保留在编译生成的java字节码中，很难被读取
// RUNTIME 一直被留存到编译完成，可以通过反射读取，也是注解最常用的方式
@Retention(RetentionPolicy.RUNTIME)

// 注解是特殊的类，其属性都会经过特殊处理
@interface NaturalAge{
	// 定义字段以及默认值
	public int from() default 0;
	public int to() default 100;
}

class Person{
	private String name;
	private int age;
	public Person(String name){
		this.name = name;
	}
	@NaturalAge(to=120)
	public int setAge(int age){
		return this.age = age;
	}
}