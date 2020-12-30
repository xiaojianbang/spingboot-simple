package cn.xiaojianbang.dingtalk.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by lf on 2020/12/30
 */
@ConfigurationProperties(prefix = "dingtalk")
@Data
public class DingTalkRobotProperties {
    public static final String DING_TALK_ROBOT_URL = "https://oapi.dingtalk.com/robot/send";

    private String accessToken;

    private String secret;
}
