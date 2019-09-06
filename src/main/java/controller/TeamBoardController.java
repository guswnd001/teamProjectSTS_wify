package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.TeamBoardDBBeanMybatis;

@Controller
@RequestMapping("/board/")
public class TeamBoardController {
	ModelAndView mv = new ModelAndView();

	int pageNum;
	String password;

	@Autowired
	public TeamBoardDBBeanMybatis teamBoardDBBeanMybatis;

	// board/test 테스트
	@RequestMapping("test")
	public ModelAndView test() {
		mv.setViewName("board/test");
		return mv;
	}

	// 게시글 페이지를 넘기는거
	@ModelAttribute
	public void setAttPageNum(HttpServletRequest pageNumreq) {
		HttpSession session = pageNumreq.getSession();
		
		
		try {
			pageNum = Integer.parseInt(pageNumreq.getParameter("pageNum"));
		} catch (Exception e) {
			pageNum = 1;
		}
		password = pageNumreq.getParameter("passwd");//deleteForm에 있는 name="passwd" / 아래 deletePro에서 필요함.
	}

	// 총 게시글 카운트

	
	
	@RequestMapping("list")
	public ModelAndView QnAlist() throws Exception {
		int pageSize = 6;
		int currentPage = pageNum;

		// int currentPage =Integer.parseInt(pageNum);	
		int count = teamBoardDBBeanMybatis.sh_ReadCount();
		int startRow = (currentPage - 1) * pageSize;
		int endRow = currentPage * pageSize;
		List qnaList = teamBoardDBBeanMybatis.QnAList(startRow, pageSize);		
		int number = count - ((currentPage - 1) * pageSize);
		  
		  int bottomLine = 3; // 5 page
		  int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		  int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
		  int endPage = startPage + bottomLine - 1;
		  if (endPage > pageCount) endPage = pageCount;
		  mv.addObject("count", count);
		  mv.addObject("pageNum", pageNum);
		  mv.addObject("qnaList", qnaList);
		  mv.addObject("number", number);
		  mv.addObject("startPage", startPage);
		  mv.addObject("bottomLine", bottomLine);
		  mv.addObject("endPage", endPage);
		  mv.addObject("pageCount", pageCount);
		  mv.setViewName("board/list");
		  return mv;
		 
	}
	
	
	
	

}
