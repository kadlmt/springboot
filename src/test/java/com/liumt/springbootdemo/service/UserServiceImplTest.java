package com.liumt.springbootdemo.service;

import com.liumt.springbootdemo.dao.UserDAO;
import com.liumt.springbootdemo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @Author liumt
 * @Description 准备spring容器
 * @Date 14:34 2020/10/27
 * @Param
 * @return
 **/
@RunWith(SpringRunner.class)
/**
 * @Author liumt
 * @Description 找启动类
 * @Date 14:34 2020/10/27
 * @Param
 * @return
 **/
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    /**
     * @Author liumt
     * @Description 测试替身,不会使用我们定义的dao
     * 这里会由spring boot整合mockito框架，然后创建一个实现了UserDAO接口的匿名实现类
     * @Date 14:33 2020/10/27
     * @Param
     * @return
     **/
    @MockBean
    private UserDAO userDAO;

    /**
     * @Author liumt
     * @Description 查询所有用户信息
     * @Date 15:35 2020/10/27
     * @Param []
     * @return void
     **/
    @Test
    public void testListUsers(){
        //构建mock userDao的返回数据
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1L);
        user.setName("测试用户");
        user.setAge(20);

        //对userDao进行mock逻辑设置
        when(userDAO.listUsers()).thenReturn(users);

        //开始测试service
        List<User> resultUsers = userService.listUsers();

        //断言
        assertEquals(users, resultUsers);
    }

    /**
     * @Author liumt
     * @Description 查询单个用户
     * @Date 15:36 2020/10/27
     * @Param []
     * @return void
     **/
    @Test
    public void testGetUserById(){
        Long id = 1L;

        User user = new User();
        user.setId(1L);
        user.setName("测试用户");
        user.setAge(20);

        when(userDAO.getUserById(id)).thenReturn(user);
        User resultUser = userService.getUserById(id);
        assertEquals(user, resultUser);
    }

    /**
     * @Author liumt
     * @Description 测试保存用户
     * @Date 15:40 2020/10/27
     * @Param []
     * @return void
     **/
    @Test
    public void testSaveUser(){
        Long id = 1L;

        User user = new User();
        user.setName("测试用户");
        user.setAge(20);

        when(userDAO.saveUser(user)).thenReturn(id);

        Long resultId = userService.saveUser(user);

        assertEquals(id, resultId);
    }

    /**
     * @Author liumt
     * @Description 测试更新用户
     * @Date 15:56 2020/10/27
     * @Param []
     * @return void
     **/
    @Test
    public void testUpdateUser() {
        Long userId = 1L;

        User user = new User();
        user.setId(userId);
        user.setName("测试用户");
        user.setAge(20);

        when(userDAO.updateUser(user)).thenReturn(true);

        Boolean updateResult = userService.updateUser(user);

        assertTrue(updateResult);
    }

    /**
     * @Author liumt
     * @Description 测试删除用户
     * @Date 15:56 2020/10/27
     * @Param []
     * @return void
     **/
    @Test
    public void testRemoveUser() {
        Long userId = 1L;
        when(userDAO.removeUser(userId)).thenReturn(true);
        Boolean removeResult = userService.removeUser(userId);
        assertTrue(removeResult);
    }

}
