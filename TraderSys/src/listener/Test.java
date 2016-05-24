package listener;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import util.FileUtil;

public class Test {

	public static void main(String[] args) throws Exception {
		String url = "d:";
		String fileName = "obj.data";
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("");
//		
		ObjectOutputStream oStream = FileUtil.createOutStream(url, fileName);
		for(String string : list){
			oStream.writeObject(string);
		}

		
		oStream.close();
		String str;
		ObjectInputStream oin = FileUtil.createInStream(url, fileName);
		while (( str = (String)oin.readObject())!=null) {
			
			System.out.println(str);
		}
		oin.close();
//		for (int i = 0; i < 10; i++) {
//			chenge chenge = (chenge) oin.readObject();
//			System.out.println(chenge.getName());
//		}
	}
}
