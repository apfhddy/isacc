package items;

import javax.servlet.http.HttpServletRequest;

import a.controllerPath.StaticMethod;
import item_cooltime.Item_CoolTimeDAO;
import item_cooltime.Item_CoolTimeDTO;

public class ItemsService {
	private ItemsDAO itemsDAO;
	private Item_CoolTimeDAO item_CoolTimeDAO;
	
	public ItemsService(ItemsDAO itemsDAO, Item_CoolTimeDAO item_CoolTimeDAO) {
		this.itemsDAO = itemsDAO;
		this.item_CoolTimeDAO = item_CoolTimeDAO;
	}
	
	public int insertItem(HttpServletRequest req) {
		int kind_no = Integer.parseInt(req.getParameter("kind"));
		String image = null;
		int id = Integer.parseInt(req.getParameter("id"));
		String kr_name = req.getParameter("kr_name");
		String en_name = req.getParameter("en_name");
		String kr_line = req.getParameter("kr_line");
		String en_line = req.getParameter("en_line");
		String unlock = req.getParameter("unlock");
		String effect = req.getParameter("effect");
		int quality = Integer.parseInt(req.getParameter("quality"));
		int i_c_no = 0;
		String goldaccessories = req.getParameter("goldaccessories");
		
		if(kind_no == 2) {
			int num = StaticMethod.parameterNullCheckToInt0(req.getParameter("num"));
			int secondOrspaces = StaticMethod.parameterNullCheckToInt0(req.getParameter("scdOspc"));
			int infinityOroneoff = StaticMethod.parameterNullCheckToInt0(req.getParameter("iftOoo"));
			if(num == 0) {
				secondOrspaces = 0;
			}
			Item_CoolTimeDTO item_CoolTimeDTO = new Item_CoolTimeDTO(num, secondOrspaces, infinityOroneoff);
			i_c_no = item_CoolTimeDAO.getItem_CoolTime_NO(item_CoolTimeDTO);
			
			if(i_c_no == 0) {
				i_c_no = item_CoolTimeDAO.getNextNo();
				item_CoolTimeDTO.setI_c_no(i_c_no);
				item_CoolTimeDAO.insertCoolTime(item_CoolTimeDTO);
			}
		}
		
		ItemsDTO item = new ItemsDTO(kind_no, image, id, kr_name, en_name, kr_line, en_line, unlock, effect, quality, i_c_no, goldaccessories);
		return itemsDAO.insertItems(item);
	}
}
