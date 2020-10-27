package com.liumt.springbootdemo.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liumt.springbootdemo.domain.User;
import com.liumt.springbootdemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/27 16:38
 * @description：
 * @modified By：
 * @version: 1.1
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    /**
     * 注入一个mockMvc,模拟向controller发起http请求
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * 模拟UserService组件
     */
    @MockBean
    private UserService userService;

    @Test
    public void testListUsers(){
        try {
            User user = new User();
            user.setId(1L);
            user.setName("测试用户");
            user.setAge(20);
            List<User> users = new ArrayList<>();
            users.add(user);
            when(userService.listUsers()).thenReturn(users);

            mockMvc.perform(get("/api/v1.0/user/"))
                    .andExpect(content().json(JSONArray.toJSONString(users)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUserById() {
        try {
            Long userId = 1L;

            User user = new User();
            user.setId(userId);
            user.setName("测试用户");
            user.setAge(20);

            when(userService.getUserById(userId)).thenReturn(user);

            mockMvc.perform(get("/api/v1.0/user/{id}", userId))
                    .andExpect(content().json(JSONObject.toJSONString(user)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSaveUser() {
        Long userId = 1L;

        User user = new User();
        user.setName("测试用户");
        user.setAge(20);

        when(userService.saveUser(user)).thenReturn(userId);

        try {
            mockMvc.perform(post("/api/v1.0/user/").contentType("application/json").content(JSONObject.toJSONString(user)))
                    .andExpect(content().json("success"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
