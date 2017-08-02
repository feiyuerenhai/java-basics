interface Human{
	public String work();
}
public class _09_anonymousclass{
	public static void main(String[] args){
		// 实现接口的匿名内部类
		Human jack = new Human(){
			public String work(){
				return "I work 12 hour a day";
			};
		};
		System.out.println(jack.work());
		// 匿名内部类
		String sleep = (new Animal(){
			public String sleep(){
				return "I sleep all day";
			}
		}).sleep();
		System.out.println(sleep);
		// lambda表达式
		Dog d = voice -> voice+"~"+voice+"~"+voice+"~";
		System.out.println(d.bark("bough"));
	}
};
interface Dog {
	String bark(String voice);
};