package com.demo.sample;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//DB 연결 메서드
@Repository
public class BookDao {
	
	//자동으로 등록된 객체를 주입
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String, Object> map) {
		return sqlSessionTemplate.insert("book.insert", map);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return sqlSessionTemplate.selectOne("book.select_detail", map);
	}
	
	public int update(Map<String, Object> map) {
		return sqlSessionTemplate.update("book.update", map);
	}

	public int delete(Map<String, Object> map) {
		return sqlSessionTemplate.delete("book.delete", map);
	}
	
	public List<Map<String, Object>> selectList(Map<String, Object> map){
		return sqlSessionTemplate.selectList("book.select_list", map);
	}
}
