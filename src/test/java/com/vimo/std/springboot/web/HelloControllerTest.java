package com.vimo.std.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Junit 실행자가 아닌 스프링실행자 SpringRuuner로 실행 -> 스프링부트테스트랑 Junit 연결자 역할을 해 준다 
@RunWith(SpringRunner.class)
// Web에 집중하여 테스트 할 수 있는 어노테이션으로
// @Service, @Component, @Repository 같은 어노테이션은 사용 할 수 없다. @Controller, @ControllerAdvice 등은 사용 가능하다
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    
    @Autowired
    public MockMvc mvc;
    
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";
        
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void hellwDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name",name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}
