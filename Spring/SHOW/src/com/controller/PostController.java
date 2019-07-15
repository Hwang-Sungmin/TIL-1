package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Post;
import com.vo.Star;

@Controller
public class PostController {
	@Resource(name = "pbiz")
	Biz<Integer, Post> pbiz;

	@Resource(name = "sbiz")
	Biz<Integer, Star> sbiz;

	@RequestMapping("/postadd.sh")
	public ModelAndView postadd(String id) {
		ModelAndView mv = new ModelAndView();
		System.out.println(id);
		mv.addObject("center", "post/add");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping(value = "/postadd2.sh", method = RequestMethod.POST)
	public ModelAndView postaddmv(int id,String title,int category) {
		System.out.println(id);
		System.out.println(title);
		System.out.println(category);
		ModelAndView mv = new ModelAndView();
		mv.addObject("contentId", id);
		mv.addObject("contentTitle", title);
		mv.addObject("category", category);
		mv.addObject("center", "post/add");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping(value = "/postadd3.sh")
	public ModelAndView postaddmv2(HttpServletRequest req) {
		System.out.println(req.getAttribute("id"));
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "post/add");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/postaddimpl.sh")
	public String postaddimpl(ModelAndView mv, Post post, String nav) {
		try {
			post.setImg1("1");
			post.setImg2("1");
			post.setImg3("1");
			System.out.println(post);
			pbiz.insert(post);
			System.out.println(nav);
			mv.addObject("center", nav);

		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("center", "post/testfail");
		}		
		return "redirect:music.sh";
	}

//	// PostList 
//	@RequestMapping("/postlist.sh")
//	public ModelAndView ulist() {
//		ModelAndView mv = new ModelAndView();
//		ArrayList<Post> list = null;
//		try {
//			list = biz.select();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		mv.addObject("center", "post/list");
//		mv.addObject("ulist", list);
//		mv.setViewName("main");
//		return mv;
//	}

	// PostDetail : �Խñ� �ϳ� ����
	// �Խ��� �� �Խñ� ����Ʈ���� �� ���� Ŭ���ϸ� ����� �̵��ϵ��� �����ؾߵ�
	@RequestMapping("/postdetail.sh")
	public ModelAndView postdetail(ModelAndView mv, String id) {
		// DATA�� String ���·� �ְ� �����Ƿ�, String ���·� ���� �� int�� ��ȯ
		Post post = null;
		Star star = null;
		try {
			post = pbiz.select(Integer.parseInt(id));
			star = sbiz.select(Integer.parseInt(id)); // ��������������?
			mv.addObject("postdetail", post); // �ش��ϴ� id���� select�� ���� postdetail�� ���� �� view���� �ҷ��� �� ���
			mv.addObject("stardetail", star);
			mv.addObject("center", "post/detail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}

	// PostDelete
	@RequestMapping("/postdelete.sh")
	public String postdelete(ModelAndView mv, String id) {
		try {
			pbiz.delete(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:postlist.sh";
	}

	// PostUpdate
	@RequestMapping("/postupdate.sh")
	public ModelAndView postupdate(ModelAndView mv, String id) {
		Post post = null;
		Star star = null;
		try {
			post = pbiz.select(Integer.parseInt(id));
			star = sbiz.select(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("postupdate", post);
		mv.addObject("center", "post/update");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/postupdateimpl.mc")
	public String postupdateimp(ModelAndView mv, Post post) {
		try { // star�� ��� ����????
			pbiz.update(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:postdetail.sh?id=" + post.getId();
	}

}
