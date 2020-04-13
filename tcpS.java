import java.io.*;
import java.net.*;

public class tcpS{
	public static void main(String[] args) {
		try{
			byte [] buffer = new byte [100];
			int serverPort = 7896;
			ServerSocket ls = new ServerSocket(serverPort);
			while(true){
				Socket cli = ls.accept();
				Connection c = new Connection(cli);
			}
		} catch(IOException e){System.out.println("Listen:" + e.getMessage());}
	}
}

class Connection extends Thread{
	DataInputStream in;
	DataOutputStream out;
	Socket cli;
	public Connection(Socket aSock){
		try {
			cli = aSock;
			in= new DataInputStream(cli.getInputStream());
			out = new DataOutputStream(cli.getOutputStream());
			this.start();
		}
		catch(IOException e){System.out.println("Connection:" + e.getMessage());}

	}
	public void run(){
		try{
			String data = in.readUTF();
			out.writeBytes(data);
		}
		catch(EOFException e){System.out.println("EOF:" + e.getMessage());}
		catch(IOException e){System.out.println("EOF:" + e.getMessage());}
	finally{try{cli.close();} catch(IOException e){System.out.println("IO:" + e.getMessage());}}

	}
}