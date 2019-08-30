package controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/Dashio/")
public class DashioController {
	ModelAndView mv = new ModelAndView();
	@RequestMapping("index")
	public ModelAndView index() {
		mv.setViewName("Dashio/index");
		return mv;
	}
	
	
}
