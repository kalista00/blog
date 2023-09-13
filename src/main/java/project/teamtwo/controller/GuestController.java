package project.teamtwo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.teamtwo.component.GuestDTO;
import project.teamtwo.service.GuestService;

@Controller
@RequestMapping("/guest/*")
public class GuestController {
	
	@Autowired
	private GuestService service;

	@RequestMapping("guestboard")
	public String main(GuestDTO dto, Model model) {
		List<GuestDTO> list = service.all();
		model.addAttribute("list", list);
		
		return "/guest/guestForm";
	}
	
	@RequestMapping("write")
	public String write(GuestDTO dto, Model model) {
		service.insert(dto);
		List<GuestDTO> list = service.all();
		System.out.println(list);
		model.addAttribute("list", list);
		return "redirect:/guest/guestboard";
	}
	
	@RequestMapping("deleteguest")
	public String delete(HttpServletRequest request) {
		int num= Integer.parseInt(request.getParameter("num"));
		service.delete(num);
		
		return "redirect:/guest/guestboard";
	}
	
	@RequestMapping("updateguest")
	public String updateguestPOST(@ModelAttribute("GuestDTO") GuestDTO dto, Model model) {
		System.out.println(dto);
		service.updateguest(dto);
				
		return "redirect:/guest/guestboard";
	}
	
}
