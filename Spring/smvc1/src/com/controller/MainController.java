package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class MainController {
	@RequestMapping("/main.mc")// main.mc�� ��û�Ǹ� ����ȴ�
	public ModelAndView main() {
		//�����Ϳ� ȭ��
		//�� �ص� �� 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");		
		return mv;
		//modelandview �� return �ϸ�  �ڵ����� forward �� �ȴ�
	}
}
