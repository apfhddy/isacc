package item_locations;

public class Item_LocationsDTO {
	private int i_l_no;
	private int item_no;
	private int location_no;
	
	public Item_LocationsDTO() {}

	public Item_LocationsDTO(int item_no, int location_no) {
		this.item_no = item_no;
		this.location_no = location_no;
	}

	public int getI_l_no() {
		return i_l_no;
	}

	public void setI_l_no(int i_l_no) {
		this.i_l_no = i_l_no;
	}

	public int getItem_no() {
		return item_no;
	}

	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}

	public int getLocation_no() {
		return location_no;
	}

	public void setLocation_no(int location_no) {
		this.location_no = location_no;
	}
	
	
}
