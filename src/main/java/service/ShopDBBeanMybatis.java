package service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Shop_conditionDataBean;
import mybatis.MyBatisConnector;


@Service
public class ShopDBBeanMybatis {
	
	private final String namespace = "mybatis.mybatis_mapper";
	
	
	@Autowired
	public MyBatisConnector myBatisConnector;
	
	public Shop_conditionDataBean getArticle(int num, String boardid) throws Exception {
		SqlSession sqlSession = myBatisConnector.sqlSession();
		HashMap map = new HashMap();
		map.put("num", num);
		map.put("boardid", boardid);
		Shop_conditionDataBean article = new Shop_conditionDataBean();
		try {
			int result = sqlSession.update(namespace + ".update_readcount", map);
			article = (Shop_conditionDataBean) sqlSession.selectOne(namespace + ".getArticle", map);
		} finally {
			sqlSession.commit();
			sqlSession.close();
			return article;
		}

	}
	

}
