package cn.xiaojianbang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * Created by lf on 2020/12/23
 */
@ServletComponentScan(basePackages = "cn.xiaojianbang.common.servlet")
@SpringBootApplication
public class UndertowApplication {

    //    private static Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(UndertowApplication.class, args);
    }


}
