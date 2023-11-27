package items;

public class ItmesDTO {
	private int item_no;
	private int kind;
	private String image;
	private int id;
	private String kr_name;
	private String en_name;
	private String kr_line;
	private String en_line;
	private String unlock;
	private String effect;
	private int quality;
	private int cooltime;
	private String goldaccessories;
	
	public ItmesDTO(int kind, String image, int id, String kr_name, String en_name, String kr_line,
			String en_line, String unlock, String effect, int quality, int cooltime, String goldaccessories) {
		this.kind = kind;
		this.image = image;
		this.id = id;
		this.kr_name = kr_name;
		this.en_name = en_name;
		this.kr_line = kr_line;
		this.en_line = en_line;
		this.unlock = unlock;
		this.effect = effect;
		this.quality = quality;
		this.cooltime = cooltime;
		this.goldaccessories = goldaccessories;
	}

	public int getItem_no() {
		return item_no;
	}

	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
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

	public int getCooltime() {
		return cooltime;
	}

	public void setCooltime(int cooltime) {
		this.cooltime = cooltime;
	}

	public String getGoldaccessories() {
		return goldaccessories;
	}

	public void setGoldaccessories(String goldaccessories) {
		this.goldaccessories = goldaccessories;
	}
	
	
	
}
