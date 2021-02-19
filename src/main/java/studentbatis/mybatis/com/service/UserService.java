package studentbatis.mybatis.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import studentbatis.mybatis.com.entity.User;
import studentbatis.mybatis.com.repository.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	
	public List<User> getListUser() {
		List<User> listUser = userMapper.getListUser();
		return listUser;
	}

	
	public User getUserById(Integer id) {
		User user= userMapper.getUserById(id);
		if(user != null) {
			return user;
		}else {
			return null;
		}
	}

	public int insertUser(User user) {
		userMapper.insertUser(user);
		return 0;
	}

	
	public int updateUser(User user) {
		userMapper.updateUser(user);
		return 0;
	}

	
	public int deleteUser(Integer id) {
		userMapper.deleteUser(id);
		return 0;
	}

}
