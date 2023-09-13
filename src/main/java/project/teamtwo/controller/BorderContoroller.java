package project.teamtwo.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project.teamtwo.component.BorderDTO;
import project.teamtwo.service.BorderService;

@Controller
@RequestMapping("/border/*")
public class BorderContoroller {

	@Autowired
	private BorderService service;
	
	@RequestMapping("bordermain")
	public String bordermain(BorderDTO dto, HttpSession session,HttpServletRequest request, Model model) {	
		
		int pageSize = 10;
		model.addAttribute("pageSize",pageSize);
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
			model.addAttribute("pageNum", pageNum);
		}
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize+1;					//(1-1) * 10+1
		int endRow = currentPage * pageSize;							//1 * 10 = 10
		int count = service.count();
		int number = 0;
		
		model.addAttribute("currentPage", currentPage);
		
		List<BorderDTO> list = service.borderall(startRow, endRow);
		model.addAttribute("list", list);
		
		String id = (String)session.getAttribute("memId");
		model.addAttribute("result", id);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd HH:mm:ss");
		
		number = list.size() - (currentPage - 1) * pageSize;
		model.addAttribute("number", number);
		
		if(count > 0) {
			int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);						//10 / 10 + (10%10) =2
			int startPage = (int)(currentPage / 10) * 10 + 1;										//1 / 10 * 10+1 = 1
			int pageBlock = 10;
			int endPage = startPage + pageBlock -1;													//1 + 10 -1 = 10
			if(endPage > pageCount) endPage = pageCount;											//10 > 2)
			
			model.addAttribute("pageCount", pageCount);
			model.addAttribute("startPage", startPage);
			model.addAttribute("pageBlock", pageBlock);
			model.addAttribute("endPage", endPage);
		}
		return "/border/bordermain";
	}
	
	@RequestMapping("main")
	public String main(HttpSession session, Model model) {
		String id = (String)session.getAttribute("memId");
		model.addAttribute("id", id);
		
		return "/border/main";
	}
	
	@RequestMapping("borderWrite")
	public String borderWrite(HttpSession session, Model model) {
		String id = (String)session.getAttribute("memId");
		model.addAttribute("result", id);
		
		return "/border/borderWrite";
	}
	
	@RequestMapping("borderWritePro")
	public String borderWritePro(HttpSession session, BorderDTO dto, Model model) {
		String id = (String)session.getAttribute("memId");
		dto.setId(id);
		service.insert(dto);
		return "/border/borderWritePro";
	}
	
	@RequestMapping("bordercon")
	public String bordercon(BorderDTO dto, Model model, int num, HttpSession session) {
		String id = (String)session.getAttribute("memId");
		model.addAttribute("id", id);
		
		model.addAttribute("result",service.borderselect(num));
		
		
		return "/border/bordercon";
	}
	
	@RequestMapping("updateborder")
	public String updateborder(BorderDTO dto, Model model, int num) {
		model.addAttribute("result",service.borderselect(num));
		return "/border/updateborder";
	}
	
	@RequestMapping("updateborderPro")
	public String updateborderPro(BorderDTO dto, Model model) {
		service.borderUpdate(dto);
		return "/border/updateborderPro";
	}
	
	@RequestMapping("deleteborder")
	public String deleteborder(int num, Model model) {
		model.addAttribute("num", num);
		return "/border/deleteborder";
	}
	
	@RequestMapping("deleteborderPro")
	public String deleteborderPro(int num, Model model) {
		service.borderdelete(num);
		return "/border/deleteborderPro";
	}
}
