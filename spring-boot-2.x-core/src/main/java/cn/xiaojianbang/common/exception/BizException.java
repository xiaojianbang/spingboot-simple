package cn.xiaojianbang.common.exception;

/**
 * Created by lf on 2021/1/5
 */
public class BizException extends RuntimeException{

    private String code;

    private String msg;

    public BizException() {
        super();
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BizException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
