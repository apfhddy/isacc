package items;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import a.controllerPath.AllPath;

@Controller
public class ItemsController implements AllPath{
	@Autowired
	private ServletContext application;
	
	private ItemsService itemsService;
	public ItemsController(ItemsService itemsService) {
		this.itemsService = itemsService;
	}
	
	@RequestMapping("insertItem")
	public String insertItem(HttpServletRequest req,@RequestParam("image")MultipartFile file)  {
		//파일 업로드 처리
		String savePath = application.getRealPath("/resources/itemImg");
		String fileName = file.getOriginalFilename();
		
		File saveFile = new File(savePath, fileName);
		
		if(!saveFile.exists()) {
			saveFile.mkdir();
		}else {//이름변경 작업
			long time = System.currentTimeMillis();
			
			fileName = String.format("%s%d%s", fileName.substring(0, fileName.lastIndexOf(".")),time,fileName.substring(fileName.lastIndexOf(".")));//중간에 시간을 넣기 위한 작업
		
			saveFile = new File(savePath,fileName);
		}
		
		try {
			file.transferTo(saveFile);//이름 바꾸기?
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		
		itemsService.insertItem(req,fileName);
		
		
		return "/?key=admin";
	}
	
	@RequestMapping("updateItem")
	public String updateItem(Model m) {
		List<Map<String,Object>> itemList = itemsService.getAllItems();
		String json = JSONArray.toJSONString(itemList);
		m.addAttribute("itemList", json);
		return updateHome;
	}

	@RequestMapping("updateForm")
	public String updateForm(HttpServletRequest req) {
		int item_no = Integer.parseInt(req.getParameter("key"));
		Map<String,Object> itemMap = itemsService.getOneItem(item_no);
		req.setAttribute("itemMap", itemMap);
		return hidden;
	}
	
}
