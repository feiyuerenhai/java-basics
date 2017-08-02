import java.util.*;
public class _15_collection{
	public static void main(String[] args) {

		// *数组*
		// 物质内部组成的特殊结构决定了其具有特殊的性质
		// 数组是内存中固定长度的一片连续区域
		// 读写时，只需要移动固定长度的指针，效率非常高
		// 插入时，需要顺延数据段，将新组合的各段复制到新数组，效率很低

		// *链表*
		// 很明显，数组的特点在于其索引是连续的，为了加快插入效率，人们想到了链表
		// 链表的本质是多个独立的Node对象，对象首尾分别存储了上一个和下一个节点的地址
		// 这样以来，插入速度明显增快，因为插入时，只需要修改插入位置节点的首尾指针即可
		// 但是读写速度将会明显降低，因为读写意味着需要逐个遍历节点直到找到目标节点的地址

		// *哈希*
		// 数组优点 -> 读写快 -> 本质: 键位偏移固定
		// 链表优点 -> 插入快 -> 本质: 内存地址不连续
		// 将 键位固定 与 内存地址不连续 结合起来看，人们创造了哈希表
		// hash语义: 计算一个对象的特征，得到一串不可逆的指纹摘要
		// hash算法的本质: 将可能是无限多的数据映射到有限的命名空间中。那么，一定会有碰撞，但尽量保证所有碰撞均匀分布
		// 这样以来，存一个对象，即是，计算hashCode，从容器中找到hashCode指向的地址，将对象放入其中
		// 比如，将0~9这10个数字，分别映射到A、B、C三个命名空间中，n%3=0到A，n%3=1到B，n%3=2到C
		// 即，A(0,3,6,9) B(1,4,7) C(2,5,8)
		// 那么，存10，得知10%3=1，应当存到B中，排在7后面，记作B3
		// 那么，取8，就得知要从8%3=2到C空间中寻找，遍历2、5、8，直到找到8为止
		// 哈希算法的关键在于，1，如何计算hash值，2，hash碰撞后如何尽量均匀分布
		// 这个问题尚没有理论上的完美解决方案
		// 但是现行的hash算法，底层是依赖数组(哈希桶)和链表(hash碰撞)实现的

		// java在数组、链表、哈希的基础上，封装了多种集合框架
		// Collection是接口，List和Set是继承了Collection的接口
		// ArrayList和LinkedList是对于List的充分且必要实现，前者底层是数组，后者底层是链表
		// Set也继承了Collection接口，但是与List序列不同的是，它不存储重复的元素
		// HashSet(基于hash)、LinkedHashSet(基于链表)和TreeSet(基于树)是对于Set的充分且必要实现
		// 总之，List和Set都是Collection接口的扩展接口，都是列表集合，Set不允许重复
		// 它们都有多种实现，在不同的场合下选择不同实现，能提高处理效率

		// 
		List<String> al = new ArrayList<>();
		al.add("hello");
		al.add("world");
		// 
		List<String> ll = new LinkedList<>();
		ll.add("a");
		ll.add("b");
		//
		System.out.println("-----List有序可重复-----");
		al.addAll(1, ll);
		System.out.println("-----ArrayList读写更高效-----");
		print(al);
		// 相比而言，LinkedList的插入效率更高
		ll.addAll(1, al);
		System.out.println("-----LinkedList插入更高效-----");
		print(ll);
		// 
		Set<String> hs = new HashSet<>();
		hs.add("你");
		hs.add("好");
		hs.add("你");
		hs.add("好");
		hs.add("test");
		// Set的addAll方法没有addAll(key, Collection签名)
		hs.addAll(al);
		System.out.println("-----Set无序不可重复-----");
		print(hs);
	}
	public static void print(Collection cl) {
		// for(int i=0; i<cl.size(); i++){
		// 	// get和set方法是List独有而Set没有的方法
		// 	// 所以，尝试使用cl.get(key)并不能遍历Set
		// 	System.out.println(cl.get(i));
		// }
		// 这里我们使用for增强语法
		// 此时cl中的每一个元素都是Object
		// 我们传入的都是String类型的Object，String.toString()即得到该对象的字符串表示
		for(Object obj : cl){
			System.out.println(obj.toString());
		}
	}
}