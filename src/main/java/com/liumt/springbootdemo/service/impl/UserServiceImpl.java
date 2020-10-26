package com.liumt.springbootdemo.service.impl;

import java.util.List;

import com.liumt.springbootdemo.dao.UserDAO;
import com.liumt.springbootdemo.domain.User;
import com.liumt.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户管理模块的service组件实现类
 * @author liumt
 *
 */
@Service
public class UserServiceImpl implements UserService {

	/**
	 * 用户管理模块的DAO组件
	 */
	@Autowired
	private UserDAO userDAO;
	
	/**
	 * 查询所有用户
	 * @return 用户信息
	 */
	public List<User> listUsers() {
		return userDAO.listUsers();
	}
	
	/**
	 * 根据ID查询用户
	 * @param id 用户ID
	 * @return 用户信息
	 */
	public User getUserById(Long id) {
		return userDAO.getUserById(id);
	}
	
	/**
	 * 新增用户
	 * @param user 用户信息
	 */
	public void saveUser(User user) {
		userDAO.saveUser(user); 
	}
	
	/**
	 * 更新用户
	 * @param user 用户信息
	 */
	public void updateUser(User user) {
		userDAO.updateUser(user); 
	}
	
	/**
	 * 删除用户
	 * @param id 用户ID
	 */
	public void removeUser(Long id) {
		userDAO.removeUser(id); 
	}
	
}
