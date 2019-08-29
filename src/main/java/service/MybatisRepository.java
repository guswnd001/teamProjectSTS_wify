package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis.MyBatisConnector;


@Service
public class MybatisRepository {
	
	private final String namespace = "mybatis.mybatis_mapper";
	
	@Autowired
	public MyBatisConnector myBatisConnector;
	
	

}
