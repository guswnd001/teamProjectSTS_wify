package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import model.Shop_conditionDataBean;

import service.ShopDBBeanMybatis;

@Controller
@RequestMapping("/Dashio/")
public class ShoppingController {
	ModelAndView mv = new ModelAndView();
	String boardid;
	int pageNum;
	String ip;
	@Autowired
	public ShopDBBeanMybatis shopDBBeanMybatis;
	
	@ModelAttribute
	public void setAttr(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String reqboardid = request.getParameter("boardid");
		
		if(reqboardid != null)
			session.setAttribute("boardid", reqboardid);
		if(session.getAttribute("boardid") == null) {
			boardid = "1";
		}else {
			boardid = (String)session.getAttribute("boardid");
		}
		
		try {
		pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}catch(Exception e) {
			pageNum = 1;
		}
		
		ip = request.getRemoteAddr();
	}
	
	
	@RequestMapping("shopping")
	public ModelAndView shoppingCondition(Shop_conditionDataBean article) throws Exception{
		mv.addObject("id", article.getId());
		mv.addObject("com_code",article.getCom_code());
		mv.addObject("scon_no", article.getScon_no());
		mv.addObject("main_cat", article.getMain_cat());
		mv.addObject("sub_cat", article.getSub_cat());
		mv.addObject("scon_title", article.getScon_title());
		mv.addObject("brand", article.getBrand());
		mv.addObject("price", article.getProduct_name());
		mv.addObject("wish_price", article.getWish_price());
		mv.addObject("reg_date", article.getReg_date());
		mv.setViewName("Dashio/shopping");
		return mv;
	}
	@RequestMapping("shoppingPro")
	public String shoppingPro(Shop_conditionDataBean article) throws Exception{
		shopDBBeanMybatis.insertArticle(article, boardid);
		return "redirect:sconList?pageNum=" + pageNum;
	}
	

	@RequestMapping("sconList")
	public ModelAndView sconList(Shop_conditionDataBean article) throws Exception{
		
	     int pageSize=6;
	     int currentPage = pageNum;
	     int count = shopDBBeanMybatis.getArticleCount(boardid);
	     int startRow = (currentPage - 1) * pageSize;
	 	 int endRow = currentPage * pageSize;
	 	 if (count<endRow)  endRow=count;
	     List sconditionList = shopDBBeanMybatis.getArticles(startRow, pageSize, boardid);
	     int number=count-((currentPage - 1) * pageSize);
	     int bottomLine = 3;
			// 5 page 
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
		int endPage = startPage + bottomLine - 1;
		
		if (endPage > pageCount)	endPage = pageCount;
	     mv.addObject("count", count);
	     mv.addObject("boardid", boardid);
	     mv.addObject("pageNum", pageNum);
	     mv.addObject("sconditionList", sconditionList);
	     mv.addObject("number", number);
	     mv.addObject("startPage", startPage);
	     mv.addObject("bottomLine", bottomLine);
	     mv.addObject("endPage", endPage);
	     mv.addObject("pageCount", pageCount);
	     mv.setViewName("Dashio/sconList");
			
		return mv;
	}
	
	@RequestMapping("deleteCondition")
	public String delete(@RequestParam("scon_no") int scon_no) throws Exception{
//		mv.clear();
		shopDBBeanMybatis.deleteArticle(scon_no);
//	     mv.addObject("scon_no", scon_no);
//	     mv.addObject("pageNum", pageNum);
//	     mv.setViewName("board/deleteForm");
//		 return  mv;
		return "redirect:sconList?pageNum=" + pageNum;
	}
	
}
