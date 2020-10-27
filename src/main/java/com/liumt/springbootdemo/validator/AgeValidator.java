package com.liumt.springbootdemo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/27 10:58
 * @description：
 * @modified By：
 * @version: 1.1
 */
public class AgeValidator implements ConstraintValidator<Age, Integer> {
    private Age age;
    private int max;
    private int min;
    @Override
    public void initialize(Age age) {
        this.age = age;
        this.max = age.max();
        this.min = age.min();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return value < max && value > min;
    }
}
