package cn.xiaojianbang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by lf on 2021/1/5
 */
@SpringBootTest
public class UnderTowApplicationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void testJdbcTemplate(){
        Long count = jdbcTemplate.queryForObject("select count(*) from student", Long.class);
        System.out.println(count);
    }
}
