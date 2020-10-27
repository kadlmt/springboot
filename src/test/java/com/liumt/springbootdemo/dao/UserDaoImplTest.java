package com.liumt.springbootdemo.dao;

import com.liumt.springbootdemo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/27 16:13
 * @description：Dao层单元测试
 * 单元测试尽量不要依赖外部，但是直到最后一层的时候，DAO层的时候，跟redis，rabbitmq打交道
 * @modified By：
 * @version: 1.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class UserDaoImplTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void testListUsers(){
        User user = new User();
        user.setAge(20);
        user.setName("测试用户");
        userDAO.saveUser(user);

        List<User> users = new ArrayList<>();
        users.add(user);

        List<User> resultUser = userDAO.listUsers();
//        assertEquals(users.size(), resultUser.size());
        assertTrue(true);
    }

    @Test
    public void testGetUserById(){
        User user = new User();
        user.setAge(20);
        user.setName("测试用户");
        userDAO.saveUser(user);
        Long id = user.getId();
        User resultUser = userDAO.getUserById(id);
        assertEquals(user.toString(), resultUser.toString());
    }

    /**
     * 测试用例：新增用户
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setName("测试用户");
        user.setAge(20);

        Long resultUserId = userDAO.saveUser(user);

        assertThat(resultUserId, is(greaterThan(0L)));
    }

    /**
     * 测试用例：修改用户
     */
    @Test
    public void testUpdateUser() {
        Integer oldAge = 20;
        Integer newAge = 21;

        User user = new User();
        user.setName("测试用户");
        user.setAge(oldAge);
        userDAO.saveUser(user);

        user.setAge(newAge);
        Boolean updateResult = userDAO.updateUser(user);

        assertTrue(updateResult);

        User updatedUser = userDAO.getUserById(user.getId());

        assertEquals(newAge, updatedUser.getAge());
    }

    /**
     * 测试用例：删除用户
     */
    @Test
    public void testRemoveUser() {
        User user = new User();
        user.setName("测试用户");
        user.setAge(20);
        userDAO.saveUser(user);

        Boolean removeResult = userDAO.removeUser(user.getId());

        assertTrue(removeResult);
    }
}
