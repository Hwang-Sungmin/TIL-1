package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Content;
import com.vo.Post;
import com.vo.User;

@Controller
public class MainController {
	@Resource(name = "ubiz")
	Biz<String, User> biz;
	
	@Resource(name = "pbiz")
	Biz<Integer, Post> pbiz;
	
	@Resource(name = "cbiz")
	Biz<Integer, Content> cbiz;
	@RequestMapping("/main.sh")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/login.sh")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "login");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/loginimpl.sh")
	public ModelAndView loginimpl(ModelAndView mv, HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");		
		try {
			User dbuser = biz.select(id);
			if(pwd.equals(dbuser.getPwd())) {
			session.setAttribute("loginuser", dbuser);
				mv.setViewName("main");
			}else {
				mv.setViewName("loginfail");
			}
		} catch (Exception e) {
			mv.setViewName("loginfail");
			
			mv.addObject("center","loginfail");
			e.printStackTrace();
		}
		
		return mv;
	}

	@RequestMapping(value = "logout.sh", method = RequestMethod.GET)
    //�޼ҵ� �̸��� LOGOUT �Ű� ������ SESSION
    public String logout(HttpSession session) {
        //m���� ����� ������ ������Ų��.
        session.removeAttribute("loginuser");
        // /�������� �����̷�Ʈ ��Ų��.
        return "redirect:main.sh";
    }
	@RequestMapping("/movie.sh")
	public ModelAndView movie() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Post> list = null;
		ArrayList<Content> clist = new ArrayList<>();
		try {
			list = pbiz.select();
			for(int i=0;i<list.size();i++) {
				clist.add(cbiz.select(list.get(i).getContents()));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("clist",clist);
		mv.addObject("plist", list);
		mv.addObject("center", "movie");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/pe.sh")
	public ModelAndView pe() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Post> list = null;
		ArrayList<Content> clist = new ArrayList<>();
		try {
			list = pbiz.select();
			for(int i=0;i<list.size();i++) {
				clist.add(cbiz.select(list.get(i).getContents()));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("clist", clist);
		mv.addObject("plist", list);
		mv.addObject("center", "pe");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/music.sh")
	public ModelAndView music() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Post> list = null;
		try {
			list = pbiz.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("plist", list);
		mv.addObject("center", "music");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/drama.sh")
	public ModelAndView drama() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Post> list = null;
		try {
			list = pbiz.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("plist", list);
		mv.addObject("center", "drama");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/write.sh")
	public ModelAndView write() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "addreview");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/mypost.sh")
	public ModelAndView mp() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Post> list = null;
		try {
			list = pbiz.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("mplist", list);
		mv.addObject("center", "mypost");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/mypage.sh")
	public ModelAndView mypage(String id) {
		ModelAndView mv = new ModelAndView();
		User user = null;
		System.out.println(id);
		try {
			user = biz.select(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("u", user);	//mypage.jsp���� ������ u�� �޴´�.????
		mv.addObject("center", "mypage");
		mv.addObject("navi", Navi.login);
		mv.setViewName("main");
		return mv;
	}

}