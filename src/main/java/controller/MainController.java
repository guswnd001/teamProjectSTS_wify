package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main/")
public class MainController {
	ModelAndView mv = new ModelAndView();
	
	
	@RequestMapping("index")
	public ModelAndView index() {
		mv.setViewName("global-master/index");
		return mv;
	}
}
