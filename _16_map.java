import java.util.*;
public class _16_map{
	public static void main(String[] args) {
		// Collection的两个扩展接口List和Set，都是序列容器，存储的内容都是单个对象
		// 而Map表示的是一种映射关系，所谓HashMap，即是键值对的映射
		// HashSet的实现也是基于HashMap
		// 只不过，在HashSet中是以value本身的hashcode值作为键值存放value
		// 而HashMap中则是计算key的hashcode值，找到hash桶以及链表存放value
		// 所以: hash中一定是以hashcode作为索引来存放值的，只不过
		// HashSet是计算value得到hashcode来存放value
		// HashMap是计算key得到hashcode
		// HashSet的内部原理是基于HashMap，用key.hashcode替代了value.hashcode
		HashMap<Person, String> hm = new HashMap<>();
		Person p1 = new Person("Jack");
		Person p2 = new Person("Xiaoming");
		// 同样的键值会被覆盖
		hm.put(p1, "England");
		hm.put(p2, "China");
		hm.put(p1, "England");
		hm.put(p2, "China");
		// 得到一个键值对，键值对中能获取key与value
		System.out.println("----------");
		for(Map.Entry<Person, String> entry : hm.entrySet()) {
            System.out.println( entry.getKey()+" => "+entry.getValue() );
        };
        // 得到所有key组合
        System.out.println("----------");
		for(Person k : hm.keySet()) {
            System.out.println( k+" => "+hm.get(k) );
        };
        // 得到所有value组合
        System.out.println("----------");
        for(String v : hm.values()) {
            System.out.println( v );
        };
        // containsKey和containsValue
        System.out.println("----------");
        System.out.println( hm.containsKey(p1) );
        System.out.println( hm.containsValue("Chinese") );
	}
}

class Person{
	private String name;
	public Person(String name){
		this.name = name;
	}
	public String toString(){
		return this.name;
	}
}