package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import model.Shop_conditionDataBean;
import service.BoardDBBeanMybatis;
import service.ShopDBBeanMybatis;

@Controller
@RequestMapping("/Dashio/")
public class ShoppingController {
	ModelAndView mv = new ModelAndView();
	String boardid;
	int pageNum;
	@Autowired
	public ShopDBBeanMybatis shopDBBeanMybatis;
	
	
	@RequestMapping("shopping")
	public ModelAndView index() {
		mv.setViewName("Dashio/shopping");
		return mv;
	}
	
	@RequestMapping("writeForm")
	public ModelAndView writeForm(Shop_conditionDataBean article) throws Exception {
		mv.addObject("id", article.getId());
		mv.addObject("com_code",article.getCom_code());
		mv.addObject("scon_no", article.getScon_no());
		mv.addObject("main_cat", article.getMain_cat());
		mv.addObject("sub_cat", article.getSub_cat());
		mv.addObject("soon_title", article.getSoon_title());
		mv.addObject("brand", article.getBrand());
		mv.addObject("price", article.getProduct_name());
		mv.addObject("wish_price", article.getWish_price());
		mv.addObject("reg_date", article.getReg_date());
		mv.setViewName("Dashio/writeForm");
		
		return mv;
	}
	
	
	@RequestMapping("list")
	public ModelAndView list() throws Exception {
		 int pageSize=6;
	     int currentPage =pageNum; 
	     int count = shopDBBeanMybatis.getArticleCount(boardid);
	     int startRow = (currentPage - 1) * pageSize;
	 	 int endRow = currentPage * pageSize;
	 	 if (count<endRow)  endRow=count;
	     List articleList = shopDBBeanMybatis.getArticles(startRow, pageSize, boardid);
	     int number=count-((currentPage - 1) * pageSize);
	     
	     if (shopDBBeanMybatis.myBatisConnector.getDbname().equals("Oracle")) {
			articleList = shopDBBeanMybatis.getArticles(startRow + 1, endRow, boardid);
		} else {
			articleList =shopDBBeanMybatis.getArticles(startRow, endRow, boardid);
		}
	     
		int bottomLine = 3;
			// 5 page 
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
		int endPage = startPage + bottomLine - 1;
		if (endPage > pageCount)	endPage = pageCount;
  		 mv.addObject("pageCount", pageCount);
	     mv.addObject("count", count);
	     mv.addObject("boardid", boardid);
	     mv.addObject("pageNum", pageNum);
	     mv.addObject("articleList", articleList);
	     mv.addObject("number", number);
	     mv.addObject("startPage", startPage);
	     mv.addObject("bottomLine", bottomLine);
	     mv.addObject("endPage", endPage);
	     mv.setViewName("board/list");
	     
	     return mv;
	}
	
	@RequestMapping("writePro")
	public String writePro(Shop_conditionDataBean article) throws Exception {
		article.setIp(ip);
		shopDBBeanMybatis.insertArticle(article, boardid);
		return "redirect:list?pageNum" + pageNum;
	}
}
