package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.TeamMemberDataBean;
import mybatis.MyBatisConnector;

@Service
public class TeamMemberDBBeanMybatis {
	private final String namespace = "mybatis.mybatis_mapper";

	@Autowired
	public MyBatisConnector mybatisConnector;

	// 로그인
	public HashMap login_check(String id, String passwd) throws Exception {
		SqlSession sqlSession = mybatisConnector.sqlSession();
		System.out.println("-----------login_check");
		HashMap map = new HashMap();
		map.put("id", id);
		map.put("password", passwd);
		HashMap<String, Boolean> error = new HashMap<String, Boolean>();
		try {
			String idValue = sqlSession.selectOne(namespace + ".login_idCheck", id);
			if(idValue == null) {
				error.put("id", Boolean.TRUE);
				return error;
			}
			String password = sqlSession.selectOne(namespace+ ".login_pwCheck", map);
			if(password == null) {
				error.put("passwd", Boolean.TRUE);
			}
			
			return error;
		} finally {
			sqlSession.close();
		}
	}
	
	
	
//	public TeamMemberDataBean sh_login(String id, String password) throws Exception {
//		SqlSession sqlSession = mybatisConnector.sqlSession();
//		HashMap map = new HashMap();
//		map.put("id", id);
//		map.put("password", password);
//		System.out.println("---------service_login");
//		try {
//			return sqlSession.selectOne(namespace + ".sh_login", map); // teammemberOracle.xml에서 id=sh_login
//		} finally {
//			sqlSession.close();
//		}
//	}
	
	// 회원가입
	public int sh_insert(TeamMemberDataBean joinmember) throws Exception {
		SqlSession sqlSession = mybatisConnector.sqlSession();

		System.out.println("-----------service_insert");
		try {
			return sqlSession.insert(namespace + ".sh_insert", joinmember); // teammemberOracle.xml에서 id=sh_insert
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	public boolean idCheck(String id) throws Exception {
		SqlSession sqlSession = mybatisConnector.sqlSession();
		try {
			String idValue = sqlSession.selectOne(namespace+".login_idCheck", id);
			if(idValue == null) {
				return true;
			}
			return false;
		} finally {
			sqlSession.close();
		}
	}
	
	
	
	
	
	
}
