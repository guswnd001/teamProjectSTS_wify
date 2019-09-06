package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.TeamMemberDataBean;
import service.TeamMemberDBBeanMybatis;

@Controller
@RequestMapping("/member/")
public class TeamMemberController {
	ModelAndView mv = new ModelAndView();

	@Autowired
	public TeamMemberDBBeanMybatis teamMemberDBBeanMybatis;

	// 테스트
	@RequestMapping("test")
	public ModelAndView test() {
		mv.setViewName("member/test");
		return mv;
	}


	// 로그인
	@RequestMapping("login")
	public ModelAndView login(String id, String passwd) throws Exception {
		mv.clear();
		mv.setViewName("member/loginForm");
		return mv;
	}

	@RequestMapping("loginPro") 
	public ModelAndView loginPro(String id, String passwd, HttpServletRequest req) throws Exception {
		System.out.println(id + ":" + passwd);
		HashMap error = teamMemberDBBeanMybatis.login_check(id, passwd);
		if(error.isEmpty()) {
			mv.setViewName("redirect:/index");
			req.getSession().setAttribute("id", id);
		} else {
			mv.addObject("error", error);
			mv.setViewName("member/loginForm");
			mv.addObject("idValue",id);
		}
		return mv;
	}

	// 로그아웃
	@RequestMapping("logout")
	public String logout(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/index";
	}

	// 회원가입
	@RequestMapping("join")
	public ModelAndView join() throws Exception {
		mv.setViewName("member/joinForm");
		return mv;
	}

	@RequestMapping("joinPro")
	public ModelAndView joinPro(TeamMemberDataBean joinmember) throws Exception {
		mv.clear();
		String id = joinmember.getId();
		if(teamMemberDBBeanMybatis.idCheck(joinmember.getId())) {
			teamMemberDBBeanMybatis.sh_insert(joinmember);
			mv.addObject("idValue", id);
			mv.setViewName("member/joinend");
		} else {
			mv.setViewName("member/joinForm");
			mv.addObject("error", Boolean.TRUE);
		}
		return mv;
	}
		
	
}
