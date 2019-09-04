package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import model.Crawling_product;
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
	@RequestMapping("search")
	public ModelAndView search(Shop_conditionDataBean article) throws Exception{
		
		HttpServletRequest request;

		//크롤링부분		
		String url = "http://category.gmarket.co.kr/listview/List.aspx?gdmc_cd=200001065&ecp_gdlc=&ecp_gdmc=";
        Document doc = null;
        Map<Object, Object> crawlingMap = new HashMap<Object, Object>();
        Crawling_product cp = new Crawling_product();
        List title = new ArrayList();
        List price = new ArrayList();
        List brand = new ArrayList();
        List<Crawling_product> product = new ArrayList<Crawling_product>();		        
        int index = 0;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }		        
        // 주요 뉴스로 나오는 태그를 찾아서 가져오도록 한다.;
        Elements element = doc.select("div.wrap li");
        // 1. 헤더 부분의 제목을 가져온다.
//        String title = element.select("div#powerClick.item_type").text().substring(0, 4);
        System.out.println("============================================================");
//        System.out.println(title);
           for(int i = 0 ; i < element.select("span.title").size() ; i++) {
              if(element.select("span.title").get(i).text().startsWith("[") == true) {
                product.add(new Crawling_product(element.select("span.title").get(i).text(),
                						element.select("div.price_info a").get(i).text().substring(0,element.select("div.price_info a").get(i).text().length()-1),
                						element.select("span.title").get(i).text().split("]")[0].substring(1)));              
              }else {
                 continue;
              }
           }		           		           
           for(int i = 0 ; i < product.size() ; i++) {
              System.out.println("/상품명: " + product.get(i).getTitle() + " /가격: " + product.get(i).getPrice() + " /상표: " + product.get(i).getBrand());
              
              cp.setTitle(product.get(i).getTitle());
              cp.setPrice(product.get(i).getPrice());
              cp.setBrand(product.get(i).getBrand());
              shopDBBeanMybatis.insertCrawling(cp, boardid);
           }   
           ////////////////////////////////////
           
           
		shopDBBeanMybatis.insertArticle(article, boardid);
		
		
		 mv.clear();
	     int pageSize=6;
	     int currentPage = pageNum;
	     int count = shopDBBeanMybatis.getCrawlingCount(boardid);
	     int startRow = (currentPage - 1) * pageSize;
	 	 int endRow = currentPage * pageSize;
	 	 if (count<endRow)  endRow=count;
	 	 Shop_conditionDataBean sc = shopDBBeanMybatis.getArticle(article.getScon_no(), boardid);
	     List crawlingList = shopDBBeanMybatis.getCrawlings(startRow, 100, boardid);
	     System.out.println("pro"+article);
	     System.out.println(crawlingList);
	     System.out.println(sc);
	     
	     
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
	     mv.addObject("sc", sc);
	     mv.addObject("crawlingList", crawlingList);
	     mv.addObject("number", number);
	     mv.addObject("startPage", startPage);
	     mv.addObject("bottomLine", bottomLine);
	     mv.addObject("endPage", endPage);
	     mv.addObject("pageCount", pageCount);
	     
	     mv.setViewName("Dashio/search");
			
		return mv;
		
	
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
	
//	@RequestMapping("search")
//	public ModelAndView searchList(Crawling_product cp) throws Exception{
//		 mv.clear();
//		 
//	     int pageSize=6;
//	     int currentPage = pageNum;
//	     int count = shopDBBeanMybatis.getCrawlingCount(boardid);
//	     int startRow = (currentPage - 1) * pageSize;
//	 	 int endRow = currentPage * pageSize;
//	 	 if (count<endRow)  endRow=count;
//	 	 System.out.println(shopDBBeanMybatis.getArticleCount(boardid));
//	 	 Shop_conditionDataBean sc = shopDBBeanMybatis.getArticle(shopDBBeanMybatis.getArticleCount(boardid), boardid);
//	//     List sconditionList = shopDBBeanMybatis.getArticles(startRow, pageSize, boardid);
//	     List crawlingList = shopDBBeanMybatis.getCrawlings(startRow, 100, boardid);
//	     System.out.println(crawlingList);
//	     System.out.println(sc);
//	     int number=count-((currentPage - 1) * pageSize);
//	     int bottomLine = 3;
//			// 5 page 
//		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
//		int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
//		int endPage = startPage + bottomLine - 1;
//		
//		if (endPage > pageCount)	endPage = pageCount;
//	     mv.addObject("count", count);
//	     mv.addObject("boardid", boardid);
//	     mv.addObject("pageNum", pageNum);
//	     mv.addObject("sc", sc);
//	     mv.addObject("crawlingList", crawlingList);
//	     mv.addObject("number", number);
//	     mv.addObject("startPage", startPage);
//	     mv.addObject("bottomLine", bottomLine);
//	     mv.addObject("endPage", endPage);
//	     mv.addObject("pageCount", pageCount);
//	     
//	     mv.setViewName("Dashio/search");
//			
//		return mv;
//	} 

	
}
