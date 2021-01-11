package cn.xiaojianbang;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * Created by lf on 2021/1/6
 */
public class Junit5Test {

    private static final Logger log = LoggerFactory.getLogger(Junit5Test.class);

    @DisplayName("每个测试方法前运行")
    @BeforeEach
    void testBefore(){
        log.info("测试方法开始了");
    }


    @Test
    void testMain(){
        List<String> strings = Arrays.asList("1", "2", "3");
        List<Map<String,String>> listMap = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("mobile","13275749888");
        map.put("content","test");
        log.info(map.toString());
        Map<String,String> map1 = new HashMap<>();
        map1.put("mobile","115509090112");
        map1.put("content","test");

        log.info(map.toString());
        listMap.add(map);
        listMap.add(map1);
        log.info(JSONObject.toJSONString(listMap));
        log.info(strings.toString());
    }

    @DisplayName("每个测试方法后运行")
    @AfterEach
    void testAfter(){
        log.info("测试方法结束了");
    }

    @DisplayName("测试前置条件")
    @Test
    void testAssumptions(){
        Assumptions.assumeTrue(false,"结果不是true");
        log.info("通过前置条件，正常执行");
    }

    @Test
    void testTime(){
        LocalTime localTime = LocalTime.now();
        String substring = localTime.toString().substring(0, 8);
        log.info(substring);
    }

    @DisplayName("参数测试")
    @Test
    @ValueSource(ints = {1,2,3,4,5})
    void testParam(int i){
        System.out.println(i);
//        log.info(String.valueOf(i));
    }
}
