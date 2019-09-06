package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.TeamBoardDataBean;
import model.TeamMemberDataBean;
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
      password = pageNumreq.getParameter("passwd");// deleteForm에 있는 name="passwd" / 아래 deletePro에서 필요함.
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
      if (endPage > pageCount)
         endPage = pageCount;
      mv.addObject("count", count);
      mv.addObject("pageNum", pageNum);
      mv.addObject("qnaList", qnaList);
      mv.addObject("number", number);
      mv.addObject("startPage", startPage);
      mv.addObject("bottomLine", bottomLine);
      mv.addObject("endPage", endPage);
      mv.addObject("pageCount", pageCount);
      mv.setViewName("board/list");// 웹에서 보여지는 jsp파일로 감.

      return mv;
   }

   @RequestMapping("write")
   public ModelAndView write(TeamBoardDataBean write) throws Exception {
      mv.clear();

      mv.addObject("num", write.getNum());
      mv.addObject("PageNum", pageNum);
      mv.addObject("ref", write.getRef());
      mv.addObject("re_step", write.getRe_step());
      mv.addObject("re_level", write.getRe_level());
      mv.setViewName("board/writeForm");

      return mv;
   }

   @RequestMapping("writePro")
   public String writePro(TeamBoardDataBean write) throws Exception {
      System.out.println(write);
      teamBoardDBBeanMybatis.insertQnA(write);
      return "redirect:list?pageNum=" + pageNum;
   }

   @RequestMapping("content")
   public ModelAndView content(int num) throws Exception {

      mv.clear();

      TeamBoardDataBean QnAcontent = teamBoardDBBeanMybatis.getQnA(num);
      mv.addObject("QnAcontent", QnAcontent);
      mv.addObject("pageNum", pageNum);
      mv.setViewName("board/content");

      return mv;
   }

   @RequestMapping("update") // url에 프로젝트명/팩키지명/@RequestMapping(명)
   public ModelAndView update(int num) throws Exception {

      mv.clear();

      TeamBoardDataBean upQnA = teamBoardDBBeanMybatis.getupdateQnA(num);
      mv.addObject("upQnA", upQnA);
      mv.addObject("pageNum", pageNum);
      mv.setViewName("board/updateForm");

      return mv;
   }

   @RequestMapping("updatePro") // url에 프로젝트명/팩키지명/@RequestMapping(명) public
   ModelAndView updatePro(TeamBoardDataBean upQnAPro) throws Exception {

      mv.clear();

      int check = teamBoardDBBeanMybatis.updateQnA(upQnAPro);
      mv.addObject("check", check);
      mv.addObject("pageNum", pageNum);
      mv.setViewName("board/updatePro");// 웹에서 보여지는 jsp파일로 감.

      return mv;

   }


   @RequestMapping("delete") // url-> 프로젝트명/팩키지명/@RequestMapping(명)
   public ModelAndView delete(int num) throws Exception {

      mv.clear();

      mv.addObject("num", num);
      mv.addObject("pageNum", pageNum);
      mv.setViewName("board/deleteForm");

      return mv;
   }

   @RequestMapping("deletePro") // url-> 프로젝트명/팩키지명/@RequestMapping("명") public
   ModelAndView deletePro(int num) throws Exception {

      mv.clear();

      int check = teamBoardDBBeanMybatis.deleteQnA(num, password);
      mv.addObject("check", check);
      mv.addObject("pageNum", pageNum);
      mv.setViewName("board/deletePro");

      return mv;
   }

}