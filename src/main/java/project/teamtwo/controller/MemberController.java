package project.teamtwo.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import project.teamtwo.component.MemberDTO;
import project.teamtwo.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService service;			//SampleServiceImpl 의 객체를 의존성주입받음
	
	@RequestMapping("main")
	public String main() {
		return "/member/main";
	}
	@RequestMapping("loginForm")
	public String loginForm() {
		return "/member/loginForm";
	}
	@RequestMapping("main1")
	public String main1() {
		return "/member/main";
	}
	@RequestMapping("inputForm")
	public String inputForm() {
		return "/member/inputForm";
	}
	@RequestMapping("confirmId")
	public String confirmId(String id, Model model) {
		model.addAttribute("check", service.check(id));
		model.addAttribute("id", id);
		return "/member/confirmId";
	}
	@RequestMapping("regist")
	public String regist(MemberDTO dto) {
		service.regist(dto);
		return "/member/loginForm";
	}
	@RequestMapping("loginCheck")
	public String loginCheck(MemberDTO dto, Model model) {
		model.addAttribute("dto", dto);
		model.addAttribute("check", service.loginCheck(dto));
		return "/member/loginPro";
	}
	@RequestMapping("session")
	public void session(String id, String passwd, HttpSession session, HttpServletResponse response) {
		session.setAttribute("memId", id);
	    session.setAttribute("memPasswd", passwd);
	    try {
	        response.sendRedirect("/blog02/member/main");
	    } catch (IOException e) {
	        // 예외 처리
	    }
	}
	@RequestMapping("modify")
	public String modify() {
		return "/member/modify";
	}
	@RequestMapping("modifyForm")
	public String modifyForm(HttpSession session, Model model) {
		String id = (String) session.getAttribute("memId");
		model.addAttribute("id", id);
		model.addAttribute("d", service.getMember(id));
		return "/member/modifyForm";
	}
	@RequestMapping("deleteForm")
	public String deleteForm() {
		return "/member/deleteForm";
	}
	@RequestMapping("delete")
	public String delete(MemberDTO dto, HttpServletRequest request, Model model, HttpSession session) {
		String id = (String) session.getAttribute("memId");
		int check = 0;
		dto.setId(id);
		if(service.loginCheck(dto) == 1)
		{	service.deleteMember(dto);
			check = 1;}
		session.invalidate();
		model.addAttribute("check", check);
		return "/member/deletePro";
	}
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/member/main";
	}
	@RequestMapping("modifyPro")
	public String modifyPro(HttpSession session, MemberDTO dto) {
		String id = (String) session.getAttribute("memId");
		dto.setId(id);
		service.updateMember(dto);
		return "/member/modifyPro";
	}
	@RequestMapping("loginForm1")
	public String loginForm1() {
		return "/bootstrap/login1";
	}
}

