package com.geekerstar.test;

import com.geekerstar.Application;
import com.geekerstar.service.StuService;
import com.geekerstar.service.TestTransService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
public class TransTest {

    @Autowired
    private StuService stuService;

    @Autowired
    private TestTransService testTransService;

//    @Test
    public void myTest() {
//        stuService.testPropagationTrans();
        testTransService.testPropagationTrans();
    }

}
