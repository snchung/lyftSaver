package lyftSaver;

import java.io.IOException;
import java.util.ArrayList;

//http://gis.stackexchange.com/questions/2951/algorithm-for-offsetting-a-latitude-longitude-by-some-amount-of-meters

public class Functions {
	public static TripObject getCheapest(double startLat, double startLong, double endLat, double endLong) throws IOException {
		TripObject initalLoc = new TripObject(startLat, startLong, endLat, endLong);
		int earthRad = 6378137;
		double dlat1 = 480 / earthRad;
		double dlon1 = 0;
		double dlat2 = -480 / earthRad;
		double dlon2 = 0;
		double dlat3 = 0;
		double dlon3 = 480 / (earthRad * Math.cos(3.14 * startLat/ 180));
		double dlat4 = 0;
		double dlon4 = -480 / (earthRad * Math.cos(3.14 * startLat/ 180));
		
		TripObject northLoc = new TripObject(startLat + dlat1 * 180 / 3.14, startLong + dlon1 * 180 / 3.14, endLat, endLong);
		TripObject southLoc = new TripObject(startLat + dlat2 * 180 / 3.14, startLong + dlon2 * 180 / 3.14, endLat, endLong);
		TripObject eastLoc = new TripObject(startLat + dlat3 * 180 / 3.14, startLong + dlon3 * 180 / 3.14, endLat, endLong);
		TripObject westLoc = new TripObject(startLat + dlat4 * 180 / 3.14, startLong + dlon4 * 180 / 3.14, endLat, endLong);
		
		ArrayList<TripObject> list = new ArrayList<TripObject>();
		list.add(northLoc);
		list.add(southLoc);
		list.add(eastLoc);
		list.add(westLoc);
		
		TripObject cheapest = initalLoc;
		for (TripObject t : list) {
			if (t.getMaxCost() < cheapest.getMaxCost()) {
				cheapest = t;
			}
		}
		
		return cheapest;
	}
}
