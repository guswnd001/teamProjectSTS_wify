package service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.TeamBoardDataBean;
import mybatis.MyBatisConnector;

@Service
public class TeamBoardDBBeanMybatis {
   private final String namespace = "mybatis.mybatis_mapper";

   @Autowired
   public MyBatisConnector mybatisConnector;

   // 총 게시글 카운트
   public int sh_ReadCount() throws Exception {
      SqlSession sqlSession = mybatisConnector.sqlSession();
      System.out.println("--------------sh_ReadCount");
      try {
         return sqlSession.selectOne(namespace + ".sh_ReadCount");
      } finally {
         sqlSession.close();
      }
   }

   // 글 등록하면 카운트
   public List QnAList(int start, int end) throws Exception {
      SqlSession sqlSession = mybatisConnector.sqlSession();
      System.out.println("------------QnAList");
      HashMap listmap = new HashMap();
      listmap.put("start", start);
      listmap.put("end", end);
      try {
         return sqlSession.selectList(namespace + ".QnAList", listmap);
      } finally {
         sqlSession.close();
      }
   }

   // 글 등록
   public void insertQnA(TeamBoardDataBean qnaWrite) throws Exception {
      SqlSession sqlSession = mybatisConnector.sqlSession();
      System.out.println("---------insertQnA");

      int num = qnaWrite.getNum();
      int ref = qnaWrite.getRef();
      int re_step = qnaWrite.getRe_step();
      int re_level = qnaWrite.getRe_level();
      try {
         HashMap map = new HashMap();
         int number = sqlSession.selectOne(namespace + ".insertQnA_new");
         if (number != 0)
            number = number + 1;
         else
            number = 1;
         if (num != 0) {
            map.put("ref", ref);
            map.put("re_step", re_step);
            sqlSession.update(namespace + ".insertQnA_update", map);
            re_step = re_step + 1;
            re_level = re_level + 1;
         } else {
            ref = number;
            re_step = 0;
            re_level = 0;
         }
         qnaWrite.setNum(number);
         qnaWrite.setRef(ref);
         qnaWrite.setRe_step(re_step);
         qnaWrite.setRe_level(re_level);
         int result = sqlSession.insert(namespace + ".insertQnA_insert", qnaWrite);
         System.out.println("insert  0k:" + result);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         sqlSession.commit();
         sqlSession.close();
      }
   }


   // 글리스트 -> 글 내용 보기
   public TeamBoardDataBean getQnA(int num) throws Exception {
      SqlSession sqlSession = mybatisConnector.sqlSession();
      System.out.println("-------------getQnA");
      HashMap map = new HashMap();
      map.put("num", num);
      TeamBoardDataBean qna = new TeamBoardDataBean();
      try {
         int result = sqlSession.update(namespace + ".QnAupdate_readcount", map);
         qna = sqlSession.selectOne(namespace + ".getQnA", map);
      } finally {
         sqlSession.commit();
         sqlSession.close();
         return qna;
      }
   }

   // 글 수정 후 리스트로 감
   public TeamBoardDataBean getupdateQnA(int num) throws Exception {
      SqlSession sqlSession = mybatisConnector.sqlSession();
      System.out.println("----------getupdateQnA");
      HashMap map = new HashMap();
      map.put("num", num);
      TeamBoardDataBean qnaupdate = new TeamBoardDataBean();
      try {
         qnaupdate = (TeamBoardDataBean) sqlSession.selectOne(namespace + ".getQnA", map);
         System.out.println(":::" + qnaupdate);
      } finally {
         sqlSession.close();
         return qnaupdate;
      }
   }



   
   //글수정
   public int updateQnA(TeamBoardDataBean upQnAPro) throws Exception {
      SqlSession sqlSession = mybatisConnector.sqlSession();
      System.out.println("-------------updateQnA");
      HashMap map = new HashMap();
      map.put("num", upQnAPro.getNum());
      int x = -1;
      try {
         String dbpasswd = (String) sqlSession.selectOne(namespace + ".update_passwrod", map);
         if (dbpasswd.equals(upQnAPro.getPassword())) {
            x = sqlSession.update(namespace + ".QnAup_update", upQnAPro);
         }
      } finally {
         sqlSession.commit();
         sqlSession.close();
      }
      return x;
   }

   
   //글삭제
   public int deleteQnA(int num, String passwd) throws Exception {
      SqlSession sqlSession = mybatisConnector.sqlSession();
      System.out.println("----------------deleteQnA");
      HashMap map = new HashMap();
      map.put("num", num);
      int x = -1;
      try {
         String dbpasswd = (String) sqlSession.selectOne(namespace + ".update_passwrod", map);
         if (dbpasswd.equals(passwd)) {
            x = sqlSession.delete(namespace + ".QnAdelete", map);
         }
      } finally {
         sqlSession.commit();
         sqlSession.close();
      }
      return x;
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

}