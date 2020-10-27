package com.liumt.springbootdemo.dao.impl;

import java.util.List;

import com.liumt.springbootdemo.dao.UserDAO;
import com.liumt.springbootdemo.domain.User;
import com.liumt.springbootdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 用户管理模块的DAO组件实现类
 * @author liumt
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	/**
	 * 用户管理模块的mapper组件
	 */
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 查询所有用户
	 * @return 用户信息
	 */
	public List<User> listUsers() {
		return userMapper.listUsers();
	}
	
	/**
	 * 根据ID查询用户
	 * @param id 用户ID
	 * @return 用户信息
	 */
	public User getUserById(Long id) {
		return userMapper.getUserById(id);
	}
	
	/**
	 * 新增用户
	 * @param user 用户信息
	 */
	public Long saveUser(User user) {
		userMapper.saveUser(user);
		return user.getId();
	}
	
	/**
	 * 更新用户
	 * @param user 用户信息
	 */
	public boolean updateUser(User user) {
		userMapper.updateUser(user);
		return true;
	}
	
	/**
	 * 删除用户
	 * @param id 用户ID
	 */
	public boolean removeUser(Long id) {
		userMapper.removeUser(id);
		return true;
	}
	
}
