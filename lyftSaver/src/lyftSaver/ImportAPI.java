package lyftSaver;

import java.net.*;
import java.io.*;

public class ImportAPI {

	public static void main(String[] args) throws Exception{
		URL u = new URL("https://api.lyft.com/oauth/authorize");
		URLConnection uc = u.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String inputLine;
		while((inputLine = in.readLine()) != null){
			System.out.println(inputLine);
		}
		in.close();
	}
	
}
