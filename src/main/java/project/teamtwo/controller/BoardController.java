package project.teamtwo.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import project.teamtwo.component.PictureDTO;
import project.teamtwo.service.BoardService;

@Controller
@RequestMapping("/picture/*")
public class BoardController {
	
	@Autowired
	private BoardService service;

	@RequestMapping("list")
	public String info(Model model) {
		List<PictureDTO> list = service.list();
		model.addAttribute("list", list);
		return "/picture/list";
	}
	
	@RequestMapping("main")
	public String main() {	
		
		return "/picture/main";
	}
	
	@RequestMapping("board")
	public String board(PictureDTO dto) {
		return "/picture/board";
	}
	
	@RequestMapping("insert")
	public String insert(PictureDTO dto,HttpServletRequest request,MultipartFile save) {
		String uploadPath = request.getRealPath("/resources/img");
		String filename = save.getOriginalFilename();
		dto.setPic(filename);
		service.insert(dto);
		String contentType = save.getContentType();
		File copy = new File(uploadPath + "//" + save.getOriginalFilename());;
			try {
				save.transferTo(copy);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return "redirect:/picture/list";
	}
	
	@RequestMapping("view")
	public String read(int num, Model model,PictureDTO dto) {
		model.addAttribute("dto", service.read2(num));
		return "/picture/view";
	}
	
	@RequestMapping("modify")
	public String modify(int num, Model model) {
		PictureDTO info = service.read2(num);
		model.addAttribute("dto", info );
		return "/picture/modify";
	}
	
	@RequestMapping("modifyPro")
	public String modifyPro(PictureDTO dto,HttpServletRequest request,MultipartFile save) {
		String uploadPath = request.getRealPath("/resources/img");
		String filename = save.getOriginalFilename();
		dto.setPic(filename);
		service.modify(dto);
		String contentType = save.getContentType();
		File copy = new File(uploadPath + "//" + save.getOriginalFilename());
		
			try {
					save.transferTo(copy);
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		return "redirect:/picture/list";
	}
	
	
	@RequestMapping("delete")
	public String delete(int num) {
		service.delete(num);
		return "redirect:/picture/list";
	}
	
}