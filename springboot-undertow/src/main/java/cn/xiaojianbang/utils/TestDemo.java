package cn.xiaojianbang.utils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lf on 2020/12/24
 */
public class TestDemo {
    public static void main(String[] args) {
        String basePackage = "cn.xiaojianbang";
        List<String> strings = Arrays.asList(basePackage);
        System.out.println(strings.toArray(new String[0]));
    }
}
