package items;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import a.controllerPath.AllPath;

@Controller
public class ItemsController implements AllPath{
	private ItemsService itemsService;
	public ItemsController(ItemsService itemsService) {
		this.itemsService = itemsService;
	}
	
	@RequestMapping("insertItem")
	public String insertItem(HttpServletRequest req)  {
		itemsService.insertItem(req);
		
		
		return null;
	}
}
