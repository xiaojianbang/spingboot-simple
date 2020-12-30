package cn.xiaojianbang.dingtalk;

import cn.xiaojianbang.dingtalk.entity.DingTalkRobotParams;
import cn.xiaojianbang.dingtalk.properties.DingTalkRobotProperties;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;

/**
 * Created by lf on 2020/12/30
 */
@Slf4j
public class DingTalkRobotClient {
    DingTalkRobotProperties dingTalkRobotProperties;

    RestTemplate restTemplate;

    DingTalkRobotClient(DingTalkRobotProperties dingTalkRobotProperties, RestTemplate restTemplate) {
        this.dingTalkRobotProperties = dingTalkRobotProperties;
        this.restTemplate = restTemplate;
    }

    public void robotNotify(DingTalkRobotParams dingTalkRobotParams) {
        long timeMillis = System.currentTimeMillis();
        try {
            String sign = signBySecret(dingTalkRobotProperties.getSecret(), timeMillis);

            StringBuilder urlBuilder = new StringBuilder(dingTalkRobotProperties.DING_TALK_ROBOT_URL);
            urlBuilder.append("?access_token=" + dingTalkRobotProperties.getAccessToken())
                    .append("&timestamp=" + timeMillis)
                    .append("&sign=" + sign);
            executeRobot(urlBuilder.toString(), dingTalkRobotParams);
        } catch (Exception e) {
            log.error("DingTalk Robot Send Message Error", e);
        }
    }

    private void executeRobot(String url, DingTalkRobotParams dingTalkRobotParams) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        restTemplate.postForEntity(url, new HttpEntity<>(JSON.toJSONString(dingTalkRobotParams), headers), String.class);
    }

    private String signBySecret(String secret, long timeMillis) throws Exception {
        String stringToSign = timeMillis + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        return URLEncoder.encode(new String(Base64.encodeBase64(signData)),"UTF-8");
    }
}
