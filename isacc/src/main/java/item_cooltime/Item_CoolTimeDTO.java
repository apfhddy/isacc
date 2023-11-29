package item_cooltime;

public class Item_CoolTimeDTO {
	private int i_c_no;
	private int num;
	private int secondOrspaces;
	private int infinityOroneoff;
	
	public Item_CoolTimeDTO() {}

	public Item_CoolTimeDTO(int num, int secondOrspaces, int infinityOroneoff) {
		this.num = num;
		this.secondOrspaces = secondOrspaces;
		this.infinityOroneoff = infinityOroneoff;
	}

	public int getI_c_no() {
		return i_c_no;
	}

	public void setI_c_no(int i_c_no) {
		this.i_c_no = i_c_no;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getSecondOrspaces() {
		return secondOrspaces;
	}

	public void setSecondOrspaces(int secondOrspaces) {
		this.secondOrspaces = secondOrspaces;
	}

	public int getInfinityOroneoff() {
		return infinityOroneoff;
	}

	public void setInfinityOroneoff(int infinityOroneoff) {
		this.infinityOroneoff = infinityOroneoff;
	}
	
	
	
	
}
