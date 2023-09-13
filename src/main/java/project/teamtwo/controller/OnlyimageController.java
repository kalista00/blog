package project.teamtwo.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import project.teamtwo.component.OnlyimageDTO;
import project.teamtwo.service.OnlyimageService;


@Controller
@RequestMapping("/image/*")
public class OnlyimageController {
	
	@Autowired
	private OnlyimageService service;
	
	@RequestMapping("list")
	public String list(Model model,String pageNum) {
		
		
		int pageSize = 2;
		
	    if (pageNum == null) {
	        pageNum = "1";
	    }

	    int currentPage = Integer.parseInt(pageNum);
	    int startRow = (currentPage - 1) * pageSize + 1;
	    int endRow = currentPage * pageSize;
	    
	    List list = service.select(startRow,endRow);
	    
	    int count = service.count();
	    int number=0;
	    

		//number=count-(currentPage-1)*pageSize;
		
		
		 if (count > 0) {
		        int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);  //2.5+1
		        int startPage = (int)(currentPage/10)*10+1; //2
				int pageBlock = 10;
		        int endPage = startPage + (pageBlock-1); // 2+ 9 = 11
		        if (endPage > pageCount) {endPage = pageCount; }
		        		
		        model.addAttribute("pageBlock",pageBlock);
		        model.addAttribute("startPage",startPage);
		        model.addAttribute("endPage",endPage);
		        model.addAttribute("pageCount",pageCount); 
		 }
		model.addAttribute("list", list);
		
		return "/onlyimage/list";
	}
	
	@RequestMapping("insertForm")
	public String insertForm(Model model) {
		
		return "/onlyimage/write";
	}
	
	@RequestMapping("insertPro")
	public String insertPro(OnlyimageDTO dto,HttpServletRequest request,MultipartFile save, Model model) {
		String uploadPath = request.getRealPath("/resources/img");
		String filename = save.getOriginalFilename();
		dto.setPicture(filename);
		service.insert(dto);
		String contentType = save.getContentType();
		File copy = new File(uploadPath + "//" + save.getOriginalFilename());;
			try {
				save.transferTo(copy);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return "redirect:list";
	}
	
	@RequestMapping("content")
	public String content(int num,Model model) {
		OnlyimageDTO condata = service.content(num);
		model.addAttribute("condata", condata);
		model.addAttribute("writer", condata.getWriter());
		return "/onlyimage/content";
	}
	@RequestMapping("updateForm")
	public String updateForm(int num,Model model) {
		OnlyimageDTO condata = service.content(num);
		model.addAttribute("condata", condata);
		return "/onlyimage/update";
	}
	
	@RequestMapping("updatePro")
	public String updatePro(OnlyimageDTO dto,HttpServletRequest request,MultipartFile save, Model model) {
		String uploadPath = request.getRealPath("/resources/img");
		String filename = save.getOriginalFilename();
		dto.setPicture(filename);
		service.update(dto);
		String contentType = save.getContentType();
		File copy = new File(uploadPath + "//" + save.getOriginalFilename());;
		
			try {
					save.transferTo(copy);
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return "redirect:list";
	}
	
	
	@RequestMapping("delete")
	public String delete(int num) {
		
		service.delete(num);
		return "redirect:list";
	}
	
}
