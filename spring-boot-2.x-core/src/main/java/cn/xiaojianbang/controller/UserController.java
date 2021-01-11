package cn.xiaojianbang.controller;

import cn.xiaojianbang.common.annotation.PassLogin;
import cn.xiaojianbang.dingtalk.DingTalkRobotClient;
import cn.xiaojianbang.dingtalk.entity.DingTalkRobotParams;
import cn.xiaojianbang.dingtalk.utils.DingTalkMessageUtil;
import cn.xiaojianbang.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lf on 2020/12/24
 */
@Api(tags = {"用户模块"})
@RestController
@RequestMapping("/api/v1/user")
@EnableConfigurationProperties({User.class})
public class UserController {

    @Autowired
    private DingTalkRobotClient dingTalkRobotClient;

    @Autowired
    private User user;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PassLogin
    @GetMapping("/sql")
    public String getSql(){
        Long count = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        return count.toString();
    }

//    @PassLogin
    @GetMapping("/id")
    public User getUserById(Long id) {
        user.setId(id.toString());
        return user;
    }

    @PassLogin
    @ApiOperation(value = "获取用户详情")
    @GetMapping("/details")
    public User userDetails() {
        int i = 10 / 0;
        return user;
    }

    @PassLogin
    @GetMapping("/moniter")
    public String sendStatus(String message) {
        DingTalkRobotParams.MarkdownParams markdownParams = new DingTalkRobotParams.MarkdownParams();
        markdownParams.setTitle("【 严重警告 】服务实例下线");

//        markdownParams.setText(DingTalkMessageUtil.serviceInstanceDownText("营商环境系统","127.0.0.1",22));
        markdownParams.setText("#### 杭州天气 @150XXXXXXXX \n> 9度，西北风1级，空气良89，相对温度73%\n> ![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png) \n> ###### 10点20分发布 [天气](https://www.dingtalk.com) \n");
        DingTalkRobotParams dingTalkRobotParams = new DingTalkRobotParams();
        dingTalkRobotParams.setMsgtype(DingTalkRobotParams.MARKDOWN_MSGTYPE);
        dingTalkRobotParams.setMarkdown(markdownParams);
        dingTalkRobotClient.robotNotify(dingTalkRobotParams);
        System.out.println("推送成功---");
        return "success";
    }
}
