public class _10_enum{
	public static void main(String[] args){
		System.out.println(Season.SPRING.getDesc());
		System.out.println(Season.summer.getDesc() + Season.summer.isMild());
		// name()方法 返回实例名称
		System.out.println(Season.AUTUMN.name());
		// 遍历values()方法得到的枚举实例集合
		System.out.println("------");
		for(Season s : Season.values()){
			System.out.println(s.name());
		};
	}
}
// 枚举类使用enum修饰符
// 本质上是一个特殊的class
enum Season{
	// 枚举概念：如果一个类只可能有固定的几个实例
	// enum本质上是class，除了实例声明之外，其他和class几乎一样
	// enum类不可被继承，所以构造方法不能声明为public
	// enum类第一行必须是实例声明，这相当于
	// public static final Season SPRING = new Season("spring")
	// 而且要 一口气 全部声明完
	// 请记住枚举类的实例声明：必须为第一行代码，必须一次性全部声明
	// 枚举实例名称大小写都可以，但按照规范最好是大写
	SPRING("spring", true), summer("summer"), AUTUMN("autumn", true), WINTER("winter");
	// - - - - - -
	//以下内容与class别无二致 
	private String s;
	private boolean isMild;
	Season(String s){
		this.s = s;
	};
	Season(String s, boolean isMild){
		this(s);
		this.isMild = isMild;
	};
	public String getDesc(){
		return this.s;
	};
	public String isMild(){
		if(isMild){
			return " is a mild season";
		}else{
			return " is a wild season";
		}
	}
}