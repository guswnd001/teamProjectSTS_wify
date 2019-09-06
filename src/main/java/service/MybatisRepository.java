package service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.TheaterCondition;
import model.TheaterInfo;
import mybatis.MyBatisConnector;

@Service
public class MybatisRepository {
	
	private final String namespace = "mybatis.mybatis_mapper";
	
	@Autowired
	public MyBatisConnector myBatisConnector;
	
	// ===================================== 영화관 정보 ================
	public List<TheaterInfo> getTheaterInfos() throws Exception {
		SqlSession sqlSession = myBatisConnector.sqlSession();
		
		try {
			return sqlSession.selectList(namespace+ ".theater_information");
		} finally {
			sqlSession.close();
		}
		
	}
	
	public List theaterInfo_region() throws Exception {
		SqlSession sqlSession = myBatisConnector.sqlSession();
		
		try {
			return sqlSession.selectList(namespace+ ".theaterInfo_region");
		} finally {
			sqlSession.close();
		}
	}
	
	public List theaterInfo_theater(String region_code) throws Exception {
		SqlSession sqlSession = myBatisConnector.sqlSession();
		try {
			return sqlSession.selectList(namespace+ ".theaterInfo_theater", region_code);
		} finally {
			sqlSession.close();
		}
	}
	
	public List theaterInfo_room(String theater_code) throws Exception {
		SqlSession sqlSession = myBatisConnector.sqlSession();
		try {
			return sqlSession.selectList(namespace+ ".theaterInfo_room", theater_code);
		} finally {
			sqlSession.close();
		}
	}
	
	public String theaterInfo_region_name(String region_code) throws Exception {
		SqlSession sqlSession = myBatisConnector.sqlSession();
		try {
			return sqlSession.selectOne(namespace+ ".theaterInfo_region_name", region_code);
		} finally {
			sqlSession.close();
		}
	}
	
	public String theaterInfo_theater_name(String theater_code) throws Exception {
		SqlSession sqlSession = myBatisConnector.sqlSession();
		try {
			return sqlSession.selectOne(namespace+ ".theaterInfo_theater_name", theater_code);
		} finally {
			sqlSession.close();
		}
	}
	
	// ===================================== 조건 정보 ================
	
	public List theater_condition() throws Exception {
		SqlSession sqlSession = myBatisConnector.sqlSession();
		try {
			return sqlSession.selectList(namespace+ ".theater_condition");
		} finally {
			sqlSession.close();
		}
	}
	
	public List theater_conditionById(String id) throws Exception {
		
		SqlSession sqlSession = myBatisConnector.sqlSession();
		try {
			return sqlSession.selectList(namespace+ ".theater_conditionById", id);
		} finally {
			sqlSession.close();
		}
	}
	
	public void insertTheaterCondition(TheaterCondition condition) throws Exception {
		SqlSession sqlSession = myBatisConnector.sqlSession();
		try {
			sqlSession.insert(namespace+".insertTheaterCondition", condition);
			System.out.println("insert 성공");
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	public int lastNum() throws Exception {
		SqlSession sqlSession = myBatisConnector.sqlSession();
		int lastNum = 0;
		try {
			lastNum = sqlSession.selectOne(namespace+".lastNum");
			if(lastNum == 0) {
				lastNum = 1;
			}
		} catch(NullPointerException e) {
			if(lastNum == 0) {
				lastNum = 1;
			}
		} finally {
			sqlSession.close();
		}
		return lastNum;
		
	}
	
	public void deleteTheaterCondition(int num) throws Exception {
		SqlSession sqlSession = myBatisConnector.sqlSession();
		try {
			sqlSession.delete(namespace+".deleteTheaterCondition", num);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	public List theater_condition_today() throws Exception {
		SqlSession sqlSession = myBatisConnector.sqlSession();
		try {
			return sqlSession.selectList(namespace+ ".theater_condition_today");
		} finally {
			sqlSession.close();
		}
	}
	
	public TheaterCondition theater_conditionByNum(int num) throws Exception{
		SqlSession sqlSession = myBatisConnector.sqlSession();
		try {
			return sqlSession.selectOne(namespace+ ".theater_conditionByNum", num);
		} finally {
			sqlSession.close();
		}
	}
	
	public int theater_conditionExistById(String id) throws Exception {
		SqlSession sqlSession = myBatisConnector.sqlSession();
		try {
			return sqlSession.selectOne(namespace+".theater_conditionExistById", id);
		} finally {
			sqlSession.close();
		}
	}
	
}
