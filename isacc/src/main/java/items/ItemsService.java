package items;

public class ItemsService {
	private ItemsDAO itemsDAO;
	
	public ItemsService(ItemsDAO itemsDAO) {
		this.itemsDAO = itemsDAO;
	}
}
