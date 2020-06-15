package com.janguo;

import com.janguo.janguolibrary.JanGuoLibraryApplication;
import com.janguo.janguolibrary.utils.MD5;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = JanGuoLibraryApplication.class)
public class TestUtils {

    @Test
    public void testMd5(){
        System.out.println(MD5.next("nihao"));
    }
}
