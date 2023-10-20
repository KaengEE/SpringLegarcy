package com.demo.sample;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImple implements BookService {
	
	@Autowired
	BookDao bookDao;
	
	@Override
	public String create(Map<String, Object> map) {
		
		int affectRowCount = this.bookDao.insert(map);
		if(affectRowCount == 1 ) { // 한줄입력했을때! 값은 1개 들어가니까
			//정상적으로 테이블에 입력 후 book_id를 리턴함
			return map.get("book_id").toString();
		}
		return null; //에러
	}
	
	@Override
	public Map<String, Object> detail(Map<String, Object> map){
		return bookDao.selectDetail(map);
	}
	
	@Override
	public boolean edit(Map<String, Object> map) {
		int affectRowCount = this.bookDao.update(map);
		return affectRowCount == 1; //정상적으로 업데이트시 true 리턴
	}
	
	@Override
	public boolean remove(Map<String, Object> map) {
		int affectRowCount = this.bookDao.delete(map);
		return affectRowCount == 1; //정상적으로 삭제시 true 리턴
	}
	
	@Override
	public List<Map<String, Object>> list(Map<String, Object> map){
		return bookDao.selectList(map);
	}
	
	
}
