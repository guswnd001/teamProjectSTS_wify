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
	
	//총 게시글 카운트
	public int sh_ReadCount() throws Exception {
		SqlSession sqlSession= mybatisConnector.sqlSession();
		System.out.println("--------------sh_ReadCount");
		try {
			return sqlSession.selectOne(namespace + ".sh_ReadCount");
		} finally {
			sqlSession.close();
		}
	}
	
	
	//글리스트 -> 글내용보기
	public List QnAList(int start, int end) throws Exception {
		SqlSession sqlSession= mybatisConnector.sqlSession();
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
	
	
	
	
	

}
