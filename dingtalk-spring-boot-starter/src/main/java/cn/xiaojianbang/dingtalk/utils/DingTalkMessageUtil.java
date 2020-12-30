package cn.xiaojianbang.dingtalk.utils;

/**
 * Created by lf on 2020/12/30
 */
public class DingTalkMessageUtil {
    public static String serviceInstanceDownText(String serviceName,String ip, Integer port) {
        String markDownStr = "#### 【严重】服务实例下线 \n" +
                "> ServiceName: " + serviceName + "\n " +
                "> Ip: " + ip + "\n " +
                "> port: " + port + "\n " +
                "> ###### 请及时处理";
        return markDownStr;
    }
}
