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
		ItemsDTO item = new ItemsDTO();
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
		
		if(kind_no == 2) {
			int num = StaticMethod.parameterNullCheckToInt0(req.getParameter("num"));
			int secondOrspaces = StaticMethod.parameterNullCheckToInt0(req.getParameter("scdOspc"));
			int infinityOroneoff = StaticMethod.parameterNullCheckToInt0(req.getParameter("iftOoo"));
			if(num == 0) {
				secondOrspaces = 0;
			}
			Item_CoolTimeDTO item_CoolTimeDTO = new Item_CoolTimeDTO(num, secondOrspaces, infinityOroneoff);
			int i_c_no = item_CoolTimeDAO.getItem_CoolTime_NO(item_CoolTimeDTO);
			System.out.println(i_c_no);
		}
		
		
		item.setKind_no(kind_no);
		item.setId(id);
		item.setKr_name(kr_name);
		item.setEn_name(en_name);
		item.setKr_line(kr_line);
		item.setEn_line(en_line);
		item.setUnlock(unlock);
		item.setEffect(effect);
		item.setQuality(quality);
		System.out.println(item.toString());
		return 0;
	}
}
