package cn.xiaojianbang.common.annotation;

import java.lang.annotation.*;

/**
 * Created by lf on 2021/1/4
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassLogin {
}
