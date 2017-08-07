public class _24_jar{
	public static void main(String[] args) {
		Animal cat = new Animal("kitty");
		System.out.println(cat.eat("fish"));
	}
}
class Animal{
	private String name;
	public Animal(String name){
		this.name = name;
	}
	public String eat(String food){
		return this.name+" is eating "+food;
	}
}
// 源代码都是先被编译成中间码，然后交给虚拟机运行
// 中间码是以.class文件的形式存在的，注意，中间码并非最终执行的机器码
// 使用jar命令，可以将多个.class文件打包成.jar文件，即java archive，java归档文件
// M个.class文件可以任意打包成N个.jar文件，这之间没有必然关系
// 但是通常，都会将某个.class文件及其依赖类打成一个包
// 打包的时候要指定manifest.mf文件，该文件要指定 Main-class，即程序的执行入口
// 另外该文件的末尾必须是空行
// 命令如下：jar cfm _24_jar.jar _24_jar.mf _24_jar.class Animal.class
// 即：jar | cfm | 目标jar文件 | manifest文件 | ...class文件
// cfm 即 create filename manifest
// jar包的执行命令：java -jar _24_jar.jar