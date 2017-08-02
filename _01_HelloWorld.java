// 包名必须与文件名相同
public class _01_HelloWorld{
	// 默认的入口方法为main，一般不能指定为其他方法
	// 先使用javac编译: javac _01_HelloWorld.java 得到 _01_HelloWorld.class
	// 然后使用java -cp . _01_HelloWorld 'main' tony
	// 意即：使用java命令行，设定当前目录为class path，执行 _01_HellowWorld.class文件的main方法，并传入参数tony
	public static void main(String[] args){
		// java句法要求非常严格，每行语句结尾必须输入分号;
		// java中使用双引号 "" 标注字符串，单引号 '' 标注字符
		System.out.println("Hello World!");
		// args参数的第一个数值为入口方法main
		for (int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}
	}
}