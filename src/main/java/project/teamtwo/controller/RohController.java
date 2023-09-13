package project.teamtwo.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import project.teamtwo.component.RohDTO;
import project.teamtwo.service.RohService;

@Controller
@RequestMapping("/roh/*")
public class RohController {
	
	@Autowired
	private RohService service;
	
	// http://localhost:8080/blog02/roh/main
	@RequestMapping("main")
	public String main() {
		return "/main";
	}
	
	@RequestMapping("write")
	public String aopSessionWrite() {
		return "/imgboard/writeForm";
	}
	
	@RequestMapping("writePro")
	public String wirtePro(RohDTO dto, HttpServletRequest req, MultipartFile save) {
		int count = 1;
		String path = req.getRealPath("/resources/img");
		String fileName = save.getOriginalFilename();
		String type = save.getContentType();
		dto.setImg("default.jpg");
		
		if(type.contains("image")) {
			File copy = new File(path+File.separator+count+"_"+save.getOriginalFilename());
			dto.setImg(fileName);
			while(copy.exists()) {
				count++;
				copy = new File(path+File.separator+count+"_"+save.getOriginalFilename());
				dto.setImg(count+"_"+save.getOriginalFilename());
			}
			try {
				save.transferTo(copy);
			} catch(Exception e) {e.printStackTrace();}
		}
		service.insertContent(dto);
		return "redirect:/roh/list";
	}
	
	// http://localhost:8080/controller/roh/list
	@RequestMapping("list")
	public String list(Model model, String pageNum) {
		int pageSize = 10;
		if(pageNum == null) {pageNum = "1";}
		int currentPage = Integer.parseInt(pageNum);
		
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		List<RohDTO> list = service.getList(startRow, endRow);
		
		int count = service.countContent();
		
		if(count > 0) {
			int pageCount = count / pageSize + (count % pageSize == 0? 0:1);
			int startPage = (int)(currentPage / 10) * 10 + 1;
			int pageBlock = 10;
			int endPage = startPage + pageBlock -1;
			
			if(endPage > pageCount) {endPage = pageCount;}
			model.addAttribute("pageCount", pageCount);
			model.addAttribute("startPage", startPage);
			model.addAttribute("pageBlock", pageBlock);
			model.addAttribute("endPage", endPage);
		}
		
		model.addAttribute("list", list);
		return "/imgboard/list";
	}
	
	@RequestMapping("content")
	public String content(RohDTO dto, Model model) {
		dto = service.getContent(dto);
		service.updateReadCount(dto);
		model.addAttribute("dto", dto);
		return "/imgboard/content";
	}
	
	@RequestMapping("delete")
	public String delete(RohDTO dto) {
		service.deleteContent(dto);
		return "redirect:/roh/list";
	}
	
	@RequestMapping("update")
	public String updateForm(RohDTO dto, Model model) {
		dto = service.getContent(dto);
		
		model.addAttribute("dto", dto);
		return "/imgboard/updateForm";
	}
	
	@RequestMapping("updatePro")
	public String updatePro(RohDTO dto, HttpServletRequest req, MultipartFile save) {
		int count = 1;
		String path = req.getRealPath("/resources/img");
		String fileName = save.getOriginalFilename();
		String type = save.getContentType();
		dto.setImg("default.jpg");
		
		if(type.contains("image")) {
			File copy = new File(path+File.separator+count+"_"+save.getOriginalFilename());
			dto.setImg(fileName);
			while(copy.exists()) {
				count++;
				copy = new File(path+File.separator+count+"_"+save.getOriginalFilename());
				dto.setImg(count+"_"+save.getOriginalFilename());
			}
			try {
				save.transferTo(copy);
			} catch(Exception e) {e.printStackTrace();}
		}
		
		service.updateContent(dto);
		return "redirect:/roh/content?num="+dto.getNum();
	}
	
}
