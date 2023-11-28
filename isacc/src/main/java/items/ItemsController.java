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
		ItemsDTO item = new ItemsDTO();
		int kind = Integer.parseInt(req.getParameter("kind"));
		String image = null;
		int id = Integer.parseInt(req.getParameter("id"));
		String kr_name = req.getParameter("kr_name");
		String en_name = req.getParameter("en_name");
		String kr_line = req.getParameter("kr_line");
		String en_line = req.getParameter("en_line");
		String unlock = req.getParameter("unlock");
		
		item.setKind(kind);
		item.setId(id);
		item.setKr_name(kr_name);
		item.setEn_name(en_name);
		item.setKr_line(kr_line);
		item.setEn_line(en_line);
		item.setUnlock(unlock);
		System.out.println(item.toString());
		
		return null;
	}
}
