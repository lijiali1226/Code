package chat;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.*;

public class ChatServer {

	boolean started = false;
	ServerSocket ss = null;
	
	public static void main(String args[]) {
		new ChatServer().start();
	}

	public void start(){
		try {
			ss = new ServerSocket(8888);
			started = true;
		} catch (BindException e) {
			System.out.println("Port is being used");
			System.out
					.println("Please close related program and restart the server");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			
			while (started) {
				Socket s = ss.accept();
				Client c = new Client(s);
				System.out.println("A client connected");
				new Thread(c).start();
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	class Client implements Runnable {
		private Socket s;
		private DataInputStream dis = null;
		boolean bConnected = false;

		public Client(Socket s) {
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream());
				bConnected = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				while (bConnected) {
					String str = dis.readUTF();
					System.out.println(str);
				}
			} catch (EOFException e) {
				System.out.println("Client closed");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (dis != null)
						dis.close();
					if (s != null)
						s.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		}
	}
}
