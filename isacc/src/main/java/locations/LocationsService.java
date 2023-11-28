package locations;

import java.util.List;

public class LocationsService {
	private LocationsDAO locationDAO;
	public LocationsService(LocationsDAO locationDAO) {
		this.locationDAO = locationDAO;
	}
	
	public List<LocationsDTO> getAllLocations(){
		return locationDAO.getAllLocations();
	}
}
