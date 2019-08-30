package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Dashio/")
public class ShoppingController {
	ModelAndView mv = new ModelAndView();
	@RequestMapping("shopping")
	public ModelAndView index() {
		mv.setViewName("Dashio/shopping");
		return mv;
	}
}
