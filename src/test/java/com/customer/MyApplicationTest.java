package com.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplicationTest.class)
public class MyApplicationTest {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testMain() {
        MyApplication.main(new String[] {});
        assertTrue(true);
    }
}