import java.net.*;
import java.io.*;

public class _23_HttpServer{
	public static void main(String[] args) throws Exception {
		new HTTPServer();
	}
}

class HTTPServer implements Runnable{
	public static int PORT = 8899;
	ServerSocket serverSocket;
	public HTTPServer() throws Exception{
		serverSocket = new ServerSocket(PORT);
		new Thread(this).start();
	}
	public void run(){
		// 不断地接受新连接
		while(true){
			try{
				// ServerSocket一旦接受连接，将获取到一个客户端socket的连接引用
				// 该引用用于读取客户端的输入和输出流
				Socket clientSocket = serverSocket.accept();
				// 客户端
				if(clientSocket != null){

					// **********输入**********
					System.out.println("-> " + clientSocket);
					InputStream is = clientSocket.getInputStream();

					// 如下方法无法读取到输入流的终点，因为浏览器往往会发送connection: keep-alive
					// 导致socket连接一直都不会关闭，服务端认为浏览器时刻都有可能接着发数据来
					// 浏览器和服务端一直pending，相互阻塞在read方法
					/*
					StringBuilder sb = new StringBuilder();
					int c;
					while( (c=is.read())!=-1 ){
						// sb.append( (char)c );
					};
					System.out.print( (char)c );
					*/

					// 标准的解析http协议的方法参见content-length以及transfer-encoding: chunked

					byte[] buf = new byte[1024];
					int len = is.read(buf);
					System.out.println(new String(buf, 0, len));

					// **********输出**********
					System.out.println("<- [RESPONSE]");
					PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
					// 输出流

					out.print("HTTP/1.0 200 ok\r\n");
					// 结束一行头信息
					out.print("msg: aha~\r\n");
					// 结束一行头信息
					out.print("\r\n");
					// 结束全部头信息
					
					out.print("<html><head><title>hello</title></head><body><span style='color: blue'>Hello</span> from the other side!</body></html>");
					// 输出实体信息
					
					out.flush();
					// Flushes the output stream and forces any buffered output bytes to be written out.
					
					out.close();
					// 关闭输出流
					
					try{
						clientSocket.close();
						// 关闭客户端连接
						// 一次请求到此结束
					}catch(Exception e){}
				}
			}catch(Exception e){}
		}
	}
}