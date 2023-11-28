package location;

public class LocationsService {
	private LocationsDAO locationDAO;
	public LocationsService(LocationsDAO locationDAO) {
		this.locationDAO = locationDAO;
	}
}
