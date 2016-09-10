package lyftSaver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TripObject {

	private double startingLong, startingLat, endingLong, endingLat;
	private double cost;
	
	public TripObject(double startLong, double startLat, double endLong, double endLat) {
		startingLong = startLong;
		startingLat = startLat;
		endingLong = endLong;
		endingLat = endLat;
	}

	public String getUrl() throws IOException{
		String url = "https://api.lyft.com/v1/cost?start_lat=" + String.valueOf(startingLat) +
				"&start_lng=" + String.valueOf(startingLong) + "&end_lat=" + String.valueOf(endingLat) + "&end_lng=" + String.valueOf(endingLong);
		//String url2 = "https://api.lyft.com/v1/cost?start_lat=37.7772&start_lng=-122.4233&end_lat=37.7972&end_lng=-122.4533";
		
		URL u = new URL(url);
		URLConnection uc = u.openConnection();
		uc.setRequestProperty("Authorization", "bearer gAAAAABX1FRvPPg4DfPHML8fdc0g7Lg3sVlg0f2HmVVVTQnqKqfz5xAt-M2D6ucBjdl3uQDBAXwoecyOK1lFKZIks9L5IVma_cFngIMFrRUz2XsAustTopkwj-s3N_dOoq2sSWfw2fvK1uFhYl69Q5QptrhBzCMhMq-ia1U-sQF0_hkb74oaknFRvs7qM55RZOQi55TSfdv0O_iJhRIIt1maUGHIVJw4ug==");
		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String inputLine;
		String ret = "";
		while((inputLine = in.readLine()) != null){
			ret = inputLine;
		}
		in.close();
		
		return ret;
	}
	
	public double getMaxCost() throws IOException{
		String url = this.getUrl();
		String line = url;
		System.out.println(url);
	      String pattern = "(\"estimated_cost_cents_max\": )(\\d+)";
	      Pattern r = Pattern.compile(pattern);
	      Matcher m = r.matcher(line);
	      
	      if (m.find( )) {
	         return Double.valueOf(m.group(0).substring(28)) / 100;
	      }
		return 0;
	}
	
	public double getStartLong() {
		return startingLong;
	}
	
	public double getStartLat() {
		return startingLat;
	}

}
