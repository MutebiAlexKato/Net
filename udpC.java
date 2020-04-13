import java.io.*;
import java.net.*;
import java.lang.*;

public class udpC{
	public static void main(String[] args) {
		DatagramSocket aSocket = null;
		try{
			aSocket = new DatagramSocket();
			byte []m = new byte[1000];
			//String aHost = "127.0.0.1";

			InetAddress aHost = InetAddress.getByName("localhost");
			//Getting the local host ip
			int sPort = 6789;
			DatagramPacket request = new DatagramPacket(m, m.length, aHost, sPort);
			aSocket.send(request);

			byte []buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply);
			System.out.println("Reply:" + new String(reply.getData()));
		}
		catch(SocketException e) {System.out.println("Socket:" + e.getMessage());}
		catch(IOException e) {System.out.println("IO:" + e.getMessage());}
		finally{if(aSocket != null) aSocket.close();}
	}
}