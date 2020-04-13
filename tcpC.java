import java.io.*;
import java.net.*;

public class tcpC{
	public static void main(String[] args) {
		//creating  a socket 'sock'

		Socket sock = null;
		try{
			byte []m = new byte [1000];
			InetAddress ahost = InetAddress.getByName("localhost"); //Host address
			int port = 7896;
			sock = new Socket(ahost, port);
			DataInputStream in = new DataInputStream(sock.getInputStream());
			DataOutputStream out = new DataOutputStream(sock.getOutputStream());
			out.write(m);
			String data = in.readUTF();
			System.out.println("Received:" + data);


		}
		catch(EOFException e){System.out.println("EOF:" + e.getMessage());}
		catch(IOException e){System.out.println("IO:" + e.getMessage());}
		finally{if (sock != null) try{ sock.close();} catch(IOException e){System.out.println("IO:" + e.getMessage());}}
	}
}