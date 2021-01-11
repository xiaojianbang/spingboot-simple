package cn.xiaojianbang;

import de.codecentric.boot.admin.client.config.SpringBootAdminClientAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * Created by lf on 2020/12/23
 */
@ServletComponentScan(basePackages = "cn.xiaojianbang.common.servlet")
@SpringBootApplication(exclude = {SpringBootAdminClientAutoConfiguration.class})
public class CoreApplication {

    //    private static Logger logger = LoggerFactory.getLogger(CoreApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }


}
