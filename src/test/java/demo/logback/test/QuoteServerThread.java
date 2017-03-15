package demo.logback.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuoteServerThread extends Thread {

	protected DatagramSocket socket = null;
	protected boolean moreQuotes = true;

	public QuoteServerThread() throws IOException {
		this("QuoteServerThread");
	}

	public QuoteServerThread(String name) throws IOException {
		super(name);
		socket = new DatagramSocket(9999);
	}

	public void run() {

		while (moreQuotes) {
			try {
				byte[] buf = new byte[256];

				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);

				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				String data = new String(packet.getData());
//				log.debug("{}:{}: {}", address, port, data);
				System.out.println(String.format("%s:%s: %s", address, port, data));
			} catch (IOException e) {
				e.printStackTrace();
				moreQuotes = false;
			}
		}
		socket.close();
	}

}
