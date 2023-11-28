package location;

public class LocationsDTO {
	private int location_no;
	private String name;
	private String image;
	
	public LocationsDTO() {}
	
	public LocationsDTO(int location_no, String name,String image) {
		this.location_no = location_no;
		this.name = name;
		this.image = image;
	}
	
	public int getLocation_no() {
		return location_no;
	}
	public void setLocation_no(int location_no) {
		this.location_no = location_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
