package lyftSaver;

import java.net.*;
import java.io.*;

public class ImportAPI {

	public static void main(String[] args) throws Exception{
		URL u = new URL("https://api.lyft.com/v1/cost?start_lat=37.7772&start_lng=-122.4233&end_lat=37.7972&end_lng=-122.4533");
		URLConnection uc = u.openConnection();
		uc.setRequestProperty("Authorization", "bearer gAAAAABX1FRvPPg4DfPHML8fdc0g7Lg3sVlg0f2HmVVVTQnqKqfz5xAt-M2D6ucBjdl3uQDBAXwoecyOK1lFKZIks9L5IVma_cFngIMFrRUz2XsAustTopkwj-s3N_dOoq2sSWfw2fvK1uFhYl69Q5QptrhBzCMhMq-ia1U-sQF0_hkb74oaknFRvs7qM55RZOQi55TSfdv0O_iJhRIIt1maUGHIVJw4ug==");
		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String inputLine;
		while((inputLine = in.readLine()) != null){
			System.out.println(inputLine);
		}
		in.close();
	}
	
	//public static 
	
}
