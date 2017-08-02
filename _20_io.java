import java.io.*;
public class _20_io{
	public static void main(String[] args) throws IOException{
		// io就是设备之间的数据传输，数据是以字节 byte[] 的形式存在的
		// 字节流有两个基本的抽象类，InputStream和OutputStream
		// 图片、视频、文本，等等等等数据，都可以以基本的字节流来处理
		// 但是文本类型IO流又比较常见，因此JDK在高级层次封装得到了字符流
		// Reader和Writer
		// 本节先讨论字符文件的处理，接着讨论底层字节流的处理

		// 文件名
		String fileName = "_20_io.txt";

		// new FileWriter，如果文件不存在，会自动创建新的空白文件
		// 如果传入参数true，则不会清空原有文件
		FileWriter fw = new FileWriter(fileName, true);
		// 写入字符串
		fw.write("abc\r\n");
		// 推入输出流
		fw.flush();
		// 写入字符串
		fw.append("def...\r\n");
		// 推入输出流
		fw.flush();
		// 关闭输出流，且会隐式调用flush
		fw.close();
		// 无法继续写入

		// 一个StringBuilder用来存放字符串
		StringBuilder str = new StringBuilder();

		// 输入流
		FileReader fr = new FileReader(fileName);

		// 请注意理解这里的缓冲区概念
		// 一个缓冲区，通常设置为1024个字节，即1KB
		char[] buf = new char[1024];

		// 每次读取到的字符数量，如果读到结尾，则num值为-1
		int num;

		// 将读到的内容读入到缓冲区中
		while( (num=fr.read(buf))!=-1 ){
			// 在缓存区buf中从0开始，取本次读取到的字符数，存入str
			String buf_str = new String(buf, 0, num);
			// 将缓存区存入str
			str.append(buf_str);
		};
		System.out.print(str);
	}
}