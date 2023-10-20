package com.demo.user;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired //자동으로 등록된 객체 주입
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String, Object> map) {
		return sqlSessionTemplate.insert("user.insert", map);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return sqlSessionTemplate.selectOne("user.select_detail", map);
	}
	
	public int update(Map<String, Object> map){
		return sqlSessionTemplate.update("user.update", map);
	}
	
	public int delete(Map<String, Object> map) {
		return sqlSessionTemplate.delete("user.delete", map);
	}
	
	public List<Map<String, Object>> selectList(Map<String, Object> map){
		return sqlSessionTemplate.selectList("user.select_list", map);
	}
	
}
