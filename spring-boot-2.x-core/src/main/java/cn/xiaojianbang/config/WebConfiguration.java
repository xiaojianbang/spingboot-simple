package cn.xiaojianbang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lf on 2021/1/4
 */
@Configuration(proxyBeanMethods = false)
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> path = new ArrayList<>();

        path.add("/api/**");
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(path)
                .excludePathPatterns("/swagger-resources/**","/swagger-ui.html/**","/webjars/**","/v2/**");
    }

    //    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//    }

    //    @Bean
//    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter(){
//        return new MappingJackson2HttpMessageConverter();
//    }
//
//    /**
//     * 添加消息转换器
//     * @param converters
//     */
//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(0,)
//    }
}
