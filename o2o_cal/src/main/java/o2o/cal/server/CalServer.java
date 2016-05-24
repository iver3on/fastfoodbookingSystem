package o2o.cal.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import net.sf.json.JSONObject;

public class CalServer {
	
	public static void main(String[] args) throws Exception{
		ServerSocket serv=new ServerSocket(4567);
		while(true){
			Socket sk=serv.accept();
			BufferedReader reader=new BufferedReader(new InputStreamReader(sk.getInputStream()));
			OutputStream out=sk.getOutputStream();
			
			String line=reader.readLine();
			System.out.println(line);
			JSONObject jso1=JSONObject.fromObject(line);
			String ip=jso1.getString("ip");
			int id=jso1.getInt("id");
			int sfx=Integer.parseInt(ip.split("\\.")[3]);
			if(sfx%2==0){
				out.write("[1,3]\n".getBytes());
			}
			else{
				out.write("[2,4]\n".getBytes());
			}
			
			sk.close();
		}
	}
}
