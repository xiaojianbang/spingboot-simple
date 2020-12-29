package cn.xiaojianbang.utils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lf on 2020/12/24
 */
public class TestDemo {

    /**
     * Local Name.
     */
    static final String local_name = "loacl_name";

    /**
     * Local Name1.
     */
    static final String local_name1 = "loacl_name1";

    /**
     * @param args - 空数组
     * @see #setMain(LocalDateTime)
     */
    public static void main(String[] args) {

        // 自动装箱原理
        Integer.valueOf(1);
        Integer integer = new Integer(1);
        // 自动拆箱原理
        integer.intValue();

        String basePackage = "cn.xiaojianbang";
        List<String> strings = Arrays.asList(basePackage);
        System.out.println(strings.toArray(new String[0]));
    }

    /**
     *
     * @param localDateTime
     * @return
     * @throws Exception
     */
    private static LocalDateTime setMain(LocalDateTime localDateTime) throws Exception{
        return localDateTime;
    }





}
