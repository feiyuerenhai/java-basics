import java.util.HashSet;
import java.util.Set;

public class _11_Object{
	public static void main(String[] args){
		Person jack = new Person("jack", 26);
		System.out.println( jack + "" );
		// 默认的hashCode方法得到该对象的哈希码
		// 哈希码是在hash集合中存放对象的索引
		System.out.println( jack.hashCode() );
		// - - - - - -
		Employee timmy = new Employee(122, "timmy", 26);
		Employee tim = new Employee(122, "tim", 26);
		// 
		System.out.println( tim.equals(timmy) );
		Set<Employee> employees = new HashSet<Employee>();
		// 此时，set集合认为timmy和tim因为hashCode相同，即放入同一个位置
		employees.add(timmy);
		// 后来者tim会被直接忽略
		employees.add(tim);
		System.out.println( employees );
		// 但无论何时，== 判断的都是指针是否相等
		System.out.println( tim == timmy );
	}
}
class Person{
	private String name;
	private int age;
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	// Object的默认toString方法输出为 类名:hashcode
	public String toString(){
		return String.format("hi, I am %s, and I'm %s years old", this.name, this.age);
	}
	// 但是默认没有valueOf方法，即便有 public Integer valueOf方法 输出什么呢？
}
class Employee extends Person{
	public int id;
	public Employee(int id, String name, int age){
		super(name, age);
		this.id = id;
	}
	// 对象默认的equals方法用于比较两个对象是否“语义上相等”
	// 如下为equals的通常实现
	public boolean equals(Object o){
		// 就是该对象索引则相等
		if( o == this) return true;
		// 如果不属于同一个类则不相等
		if( o.getClass() != this.getClass() ) return false;
		// 属于同一个类，声明 彼对象
		Employee that = (Employee) o;
		// 彼对象与此对象 的重要属性是否相等
		if(that.id==this.id) return true;
		// 否则都不相等
		return false;
	}
	// hashCode方法用于获得对象的哈希码
	// 虽然，语义上来说，两个对象可以相等，但是在哈希表中，字面相等的两个对象
	// 索引未必相等，也就是说，我们从业务上可以认为这两个对象相等
	// 实际上，在系统内部依然认为两个对象不相等
	// 重写hashCode方法，使他们返回同样的哈希值，这样之后：
	// hash集合就认为，字面相等的两个对象，在hash散列中也是同一个索引
	public int hashCode(){
		return 37 * this.id + this.id;
	}
}