package demo.logback.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class QuoteClient {
	public static void main(String[] args) throws IOException {

		// get a datagram socket
		DatagramSocket socket = new DatagramSocket();

		// send request
		byte[] buf;
		buf = new Integer(new Random().nextInt()).toString().getBytes();
		String msg = "{\"@timestamp\":\"2017-03-14T16:12:26.665+08:00\",\"@version\":1,\"message\":\"gen: 2097464084\",\"logger_name\":\"demo.logback.test.LoopLogger\",\"thread_name\":\"Timer-0\",\"level\":\"ERROR\",\"level_value\":40000,\"HOSTNAME\":\"lisong-PC\"}";
		buf = msg.getBytes();
		String host = "127.0.0.1";
		host = "192.168.1.139";
		InetAddress address = InetAddress.getByName(host);
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 9999);
		socket.send(packet);
		
		// get response
//		packet = new DatagramPacket(buf, buf.length);
//		socket.receive(packet);

		// display response
//		String received = new String(packet.getData(), 0, packet.getLength());
//		System.out.println("Quote of the Moment: " + received);

		socket.close();
	}
}
