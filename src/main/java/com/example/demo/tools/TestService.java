package com.example.demo.tools;

import com.example.demo.bean.TestClass;

/**
 * @author Joker
 * @since 2020/9/14 20:10
 */
public class TestService {
    public static TestClass testClass = new TestClass();

    public static void main(String[] args) {
        System.out.println(testClass.setId(1).setName("2"));
    }
}
