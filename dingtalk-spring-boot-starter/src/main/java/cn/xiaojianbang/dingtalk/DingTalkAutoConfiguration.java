package cn.xiaojianbang.dingtalk;

import cn.xiaojianbang.dingtalk.properties.DingTalkRobotProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lf on 2020/12/30
 */
@EnableConfigurationProperties({DingTalkRobotProperties.class})
@Configuration(proxyBeanMethods = false)
public class DingTalkAutoConfiguration {
    @Bean
    public DingTalkRobotProperties dingTalkRobotProperties() {
        return new DingTalkRobotProperties();
    }

    @Bean
    public DingTalkRobotClient dingTalkRobotClient(DingTalkRobotProperties dingTalkRobotProperties) {
        RestTemplate restTemplate = new RestTemplate();
        return new DingTalkRobotClient(dingTalkRobotProperties, restTemplate);
    }
}
