package cn.xiaojianbang.dingtalk.entity;

import lombok.Data;

/**
 * Created by lf on 2020/12/30
 */
@Data
public class DingTalkRobotParams {
    public static final String MARKDOWN_MSGTYPE = "markdown";
    public static final String TEXT_MSGTYPE = "text";
    private String msgtype;

    private TextParams text;

    private MarkdownParams markdown;

    @Data
    public static class TextParams {
        private String content;
    }

    @Data
    public static class MarkdownParams {
        private String title;
        private String text;
    }
}
