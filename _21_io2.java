import java.io.*;
public class _21_io2{
	public static void main(String[] args) throws Exception {
		
		// 文件名
		String fileName = "_21_io_1.txt";
		
		// 输出文件流，写一个文件
		FileOutputStream fos = new FileOutputStream(fileName);
		// 输出内容
		String str = "Hello World!\r\nHello Java!\r\nHello Guys!";
		// 注意，stream写入的是字节
		fos.write( str.getBytes() );
		// 因为直接写入的字节，不是字符，不会出现多个字节才能凑成一个字符的情况，所以没有缓存区，不用flush
		fos.close();

		// 输出文件流
		// 因为文件流往往很大，无法将读取到的字节放入内存byte数组中，虽然可以通过FileInputStream.available()获取到字节总长度
		// 但是非常建议不这么做，因为字节可能会塞满内存
		// 通常的做法是：构造一个输出流，将输入流的内容及时输出，流入到其他介质上，如硬盘等等
		FileOutputStream file = new FileOutputStream("_21_io_2.txt");

		// 文件内容输出
		FileInputStream fis = new FileInputStream(fileName);
		byte[] buf = new byte[1024];
		int len = 0;
		while( (len=fis.read(buf))!=-1 ){
			file.write(buf, 0, len);
		};
		file.close();

	}
}