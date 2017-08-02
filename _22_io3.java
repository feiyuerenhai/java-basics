import java.io.*;
class _22_io3{
	public static void main(String[] args) throws Exception {
		// 在前两个示例中，我们都做了同一件事情
		// 即，读取输入流到数组中，从数组中取数据，写入到输出流
		// 其中的数组就是缓存区，这样的缓存区通常设置为1024字节
		// 缓存区的优势在于避免了反反复复调用输入输出流
		// java io 中提供了已经包装好的流读写操作
		// BufferedInputStream 是对于 FileInputStream 的一种功能增强，采用了装饰者模式
		// BufferInputStream 内操作的就是 FileInputStream 对象
		// 如下，使用包装好的BufferedInputStream，我们不用再自己创建缓存数组
		String fileName1 = "_22_io_1.txt", fileName2 = "_22_io_2.txt";
		FileInputStream fis = new FileInputStream(fileName1);
		FileOutputStream fos = new FileOutputStream(fileName2);
		BufferedInputStream bufis = new BufferedInputStream(fis);
		BufferedOutputStream bufos = new BufferedOutputStream(fos);
		int bt;
		// 将输入流读取到的每一个字节写到输出流
		while( (bt=bufis.read()) != -1 ){
			bufos.write(bt);
		};
		// 关闭流
		bufis.close();
		bufos.close();
	}
}