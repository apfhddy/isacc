package item_kinds;

import java.util.List;

public class Item_KindsService {
	private Item_KindsDAO item_KindsDAO;
	public Item_KindsService(Item_KindsDAO item_KindsDAO) {
		this.item_KindsDAO = item_KindsDAO;
	}
	
	public List<Item_KindsDTO> getAllKind() {
		return item_KindsDAO.getAllKind();
	}
}
