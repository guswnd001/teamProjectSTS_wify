package service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Crawling_product;
import model.Shop_conditionDataBean;
import mybatis.MyBatisConnector;

@Service
public class ShopDBBeanMybatis {
	
	private final String namespace = "mybatis.mybatis_mapper";
	
	
	@Autowired
	public MyBatisConnector mybatisConnector;
	
	public Shop_conditionDataBean getArticle(int num, String boardid) throws Exception {
		SqlSession sqlSession = mybatisConnector.sqlSession();
		HashMap map = new HashMap();
		map.put("scon_no", num);
		map.put("boardid", boardid);
		Shop_conditionDataBean article = new Shop_conditionDataBean();
		try {
//			int result = sqlSession.update(namespace + ".update_readcount", map);
			article = (Shop_conditionDataBean) sqlSession.selectOne(namespace + ".getArticle", map);
		} finally {
			sqlSession.commit();
			sqlSession.close();
			return article;
		}

	}
	
	public int getArticleCount(String boardid) throws Exception {
		SqlSession sqlSession=mybatisConnector.sqlSession();
		System.out.println("getArticleCount===old");
		try {
			return sqlSession.selectOne(namespace + ".getArticleCount", boardid);
		} finally {
			sqlSession.close();
		}
	}
	
	public List getArticles(int start, int end, String boardid) throws Exception {
		SqlSession sqlSession=mybatisConnector.sqlSession();
		System.out.println("getArticles===old");
		
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("boardid", boardid);
		try {
			return sqlSession.selectList(namespace + ".getArticles", map);
		} finally {
			sqlSession.close();
		}
	}
	/////////////////////////////조건 삽입
	public void insertArticle(Shop_conditionDataBean article, String boardid) throws Exception {
		SqlSession sqlSession=mybatisConnector.sqlSession();
		
		/*
		 * int num = article.getNum(); int ref = article.getRef(); int re_step =
		 * article.getRe_step(); int re_level = article.getRe_level();
		 */
		try {			
			HashMap map = new HashMap();
			int scon_no = sqlSession.selectOne(namespace + ".insertArticle_new");
			if (scon_no != 0)				
				scon_no = scon_no + 1;
			else	scon_no = 1;
			/*
			 * if (num != 0) { map.put("ref", ref); map.put("re_step", re_step);
			 * sqlSession.update(namespace + ".insertArticle_update", map); re_step =
			 * re_step + 1; re_level = re_level + 1; } else {ref = number; re_step =
			 * 0;re_level = 0; }
			 */	
			article.setScon_no(scon_no);
			article.setMain_cat(article.getMain_cat());
			article.setSub_cat(article.getSub_cat());
			article.setScon_title(article.getScon_title());
			article.setBrand(article.getBrand());
			article.setProduct_name(article.getProduct_name());
			article.setWish_price(article.getWish_price());
			article.setReg_date(article.getReg_date());
			article.setBoardid(boardid);
			System.out.println("insert:" + article);
			int result = sqlSession.insert(namespace + ".insertArticle_insert", article);
			System.out.println("insert  0k:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();		sqlSession.close();		}
	}
	
	
	/////////////////////////////////조건 삭제
	public int deleteArticle(int scon_no) throws Exception {
		SqlSession sqlSession=mybatisConnector.sqlSession();
		HashMap map = new HashMap();
		map.put("scon_no", scon_no);
		int x = -1;
		try {
			/*String dbpasswd = (String) sqlSession.selectOne(namespace + ".update_passwd", map);
			if (dbpasswd.equals(passwd)) {*/
				x = sqlSession.delete(namespace + ".delete", map);
//			}
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return x;
	}
	
	//////////////////////////////크롤링 마이바티스//////////////////////////////////////
	public int getCrawlingCount(String boardid) throws Exception {
		SqlSession sqlSession=mybatisConnector.sqlSession();
		System.out.println("getCrawlingCount===old");
		try {
			return sqlSession.selectOne(namespace + ".getCrawlingCount", boardid);
		} finally {
			sqlSession.close();
		}
	}
	
	public void insertCrawling(Crawling_product crawling, String boardid) throws Exception {
		SqlSession sqlSession=mybatisConnector.sqlSession();
		
		/*
		 * int num = article.getNum(); int ref = article.getRef(); int re_step =
		 * article.getRe_step(); int re_level = article.getRe_level();
		 */
		try {			
			HashMap map = new HashMap();
			int num = sqlSession.selectOne(namespace + ".crawlingInsertArticle_new");
			if (num != 0)				
				num = num + 1;
			else num = 1;
			/*
			 * if (num != 0) { map.put("ref", ref); map.put("re_step", re_step);
			 * sqlSession.update(namespace + ".insertArticle_update", map); re_step =
			 * re_step + 1; re_level = re_level + 1; } else {ref = number; re_step =
			 * 0;re_level = 0; }
			 */	
			
			crawling.setNum(num);
			crawling.setTitle(crawling.getTitle());
			crawling.setPrice(crawling.getPrice());
			crawling.setBrand(crawling.getBrand());
			crawling.setBoardid(boardid);
			System.out.println("insert:" + crawling);
			int result = sqlSession.insert(namespace + ".crawlingInsertArticle_insert", crawling);
			System.out.println("insert crawling 0k:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(1);
			sqlSession.commit();		
			sqlSession.close();		}
	}
	
	public List getCrawlings(int start, int end, String boardid) throws Exception {
		SqlSession sqlSession=mybatisConnector.sqlSession();
		System.out.println("getCrawlings===old");
		
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("boardid", boardid);
		
		System.out.println(map);
		try {
			return sqlSession.selectList(namespace + ".getCrawlings", map);
		} finally {
			sqlSession.close();
		}
	}
	
	
	

}
