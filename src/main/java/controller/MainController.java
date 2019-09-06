package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.javafx.sg.prism.NGShape.Mode;

@Controller

public class MainController {
	ModelAndView mv = new ModelAndView();
	
	
	@RequestMapping("/index")
	public ModelAndView index() {
		
		
		mv.setViewName("/index");
		return mv;
	}
	

}
