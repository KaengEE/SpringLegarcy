package com.demo.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService {
	@Autowired
	UserDao userDao;
	
	@Override
	public String create(Map<String, Object> map) {
		int affectRowCount = this.userDao.insert(map);
		if(affectRowCount == 1) {
			return map.get("user_id").toString();
		}
		return null;
	}
	
	@Override
	public Map<String, Object> detail(Map<String, Object> map){
		return userDao.selectDetail(map);
	}
	
	@Override
	public boolean edit(Map<String, Object> map) {
		int affectRowCount = this.userDao.update(map);
		return affectRowCount == 1; //정상적으로 업데이트시 true 리턴
	}
	
	@Override
	public boolean delete(Map<String, Object> map) {
		int affectRowCount = this.userDao.delete(map);
		return affectRowCount == 1; //정상적으로 삭제시 true 리턴
	}
	
	public List<Map<String, Object>> list(Map<String, Object> map){
		return userDao.selectList(map);
	}
}
