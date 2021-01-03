package cn.xiaojianbang.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lf on 2020/12/30
 */
@SpringBootApplication
@RestController
public class DockerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class, args);
    }

    @GetMapping("/api/v1/docker")
    public String message() {
        return "welcome to docker service power by spring boot !";
    }
}
