package items;

public class ItemsDTO {
	private int item_no;
	private int kind_no;
	private String image;
	private int id;
	private String kr_name;
	private String en_name;
	private String kr_line;
	private String en_line;
	private String unlock;
	private String effect;
	private int quality;
	private int i_c_no;
	private String goldaccessories;
	public ItemsDTO() {}
	public ItemsDTO(int kind_no, String image, int id, String kr_name, String en_name, String kr_line,
			String en_line, String unlock, String effect, int quality, int i_c_no, String goldaccessories) {
		this.kind_no = kind_no;
		this.image = image;
		this.id = id;
		this.kr_name = kr_name;
		this.en_name = en_name;
		this.kr_line = kr_line;
		this.en_line = en_line;
		this.unlock = unlock;
		this.effect = effect;
		this.quality = quality;
		this.i_c_no = i_c_no;
		this.goldaccessories = goldaccessories;
	}
	
	
	
	@Override
	public String toString() {
		return "ItemsDTO [item_no=" + item_no + ", kind_no=" + kind_no + ", image=" + image + ", id=" + id
				+ ", kr_name=" + kr_name + ", en_name=" + en_name + ", kr_line=" + kr_line + ", en_line=" + en_line
				+ ", unlock=" + unlock + ", effect=" + effect + ", quality=" + quality + ", i_c_no=" + i_c_no
				+ ", goldaccessories=" + goldaccessories + "]";
	}
	public int getItem_no() {
		return item_no;
	}
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	
	public int getKind_no() {
		return kind_no;
	}
	public void setKind_no(int kind_no) {
		this.kind_no = kind_no;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKr_name() {
		return kr_name;
	}
	public void setKr_name(String kr_name) {
		this.kr_name = kr_name;
	}
	public String getEn_name() {
		return en_name;
	}
	public void setEn_name(String en_name) {
		this.en_name = en_name;
	}
	public String getKr_line() {
		return kr_line;
	}
	public void setKr_line(String kr_line) {
		this.kr_line = kr_line;
	}
	public String getEn_line() {
		return en_line;
	}
	public void setEn_line(String en_line) {
		this.en_line = en_line;
	}
	public String getUnlock() {
		return unlock;
	}
	public void setUnlock(String unlock) {
		this.unlock = unlock;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public int getI_c_no() {
		return i_c_no;
	}
	public void setI_c_no(int i_c_no) {
		this.i_c_no = i_c_no;
	}
	public String getGoldaccessories() {
		return goldaccessories;
	}
	public void setGoldaccessories(String goldaccessories) {
		this.goldaccessories = goldaccessories;
	}
	
	
	
	

	
	
}
