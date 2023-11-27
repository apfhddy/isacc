package item_kinds;

public class Item_KindsDTO {
	private int kind_no;
	private String name;
	public Item_KindsDTO(int kind_no, String name) {
		super();
		this.kind_no = kind_no;
		this.name = name;
	}
	public int getKind_no() {
		return kind_no;
	}
	public void setKind_no(int kind_no) {
		this.kind_no = kind_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
