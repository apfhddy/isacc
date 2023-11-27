package a.firstController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import a.controllerPath.AllPath;
import item_kinds.Item_KindsDTO;
import item_kinds.Item_KindsService;
import items.ItemsService;


@Controller
public class FirstController implements AllPath{
	private ItemsService itemsService;
	private Item_KindsService item_KindsService;
	
	public FirstController(ItemsService itemsService,Item_KindsService item_KindsService) {
		this.itemsService = itemsService; 
		this.item_KindsService = item_KindsService;
	}
	

	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		String key = request.getParameter("key");
		boolean hiddenPath = key != null && key.equals("admin");
		if(hiddenPath) {
			List<Item_KindsDTO> kindList = item_KindsService.getAllKind();
			request.setAttribute("kindList", kindList);
			return hidden;
		}
		else return home; 
	}
	
}
