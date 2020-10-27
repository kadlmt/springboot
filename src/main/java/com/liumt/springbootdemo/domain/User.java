package com.liumt.springbootdemo.domain;

import com.liumt.springbootdemo.validator.Age;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * 一个领域模型类
 * @author liumt
 *
 */
public class User {
    public interface Update{}
    public interface Add{}

    @NotNull(groups = {Update.class})
    @Null(groups = {Add.class})
    private Long id;
    @Size(min = 3, max = 20, groups = {Add.class, Update.class})
    private String name;
//    @Range(min = 3, max = 20, groups = {Add.class, Update.class})
    @Age(min = 18, max = 70, groups = {Add.class, Update.class})
    private Integer age;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
    
}
