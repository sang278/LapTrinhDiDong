package ntu.edu;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CTchinh {

	public static void main(String[] args) throws IOException {
		// mở cổng bắt đầu nghe
		ServerSocket socketServer = new ServerSocket(9999);
		System.out.print("Tôi lắng nghe trong cổng 9999  ...");
		int id =0;
		while(true) {
			Socket s = socketServer.accept();
			//new LuongLamViec(s, id++).start();
			LuonglamViec luongTask = new LuonglamViec(s, id);
			luongTask.start();
		}
	}


}
