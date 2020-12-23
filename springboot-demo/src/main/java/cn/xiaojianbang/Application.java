package cn.xiaojianbang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lf on 2020/12/23
 */
@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }


    @GetMapping("/api/v1/hello")
    public String getHelloWorld(){
        return "hello springboot2.x";
    }
}
