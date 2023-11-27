package location;

public class LocationService {
	private LocationDAO locationDAO;
	public LocationService(LocationDAO locationDAO) {
		this.locationDAO = locationDAO;
	}
}
