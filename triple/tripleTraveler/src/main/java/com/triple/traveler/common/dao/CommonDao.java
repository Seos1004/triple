package com.triple.traveler.common.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Object selectOne(String namespace , Object obj) {
		return sqlSession.selectOne(namespace , obj);
	}
	
	public List<?> selectList(String namespace , Object obj) {
		return sqlSession.selectList(namespace , obj);
	}
	
//	public List<Map<String , Object>> selectList(String namespace , Object obj) {
//		return sqlSession.selectList(namespace , obj);
//	}
	
	public int insert(String namespace , Object obj) {
		return sqlSession.insert(namespace, obj);
	}
	
	public int update(String namespace , Object obj) {
		return sqlSession.insert(namespace, obj);
	}
	
	public int delete(String namespace , Object obj) {
		return sqlSession.delete(namespace, obj);
	}

}
