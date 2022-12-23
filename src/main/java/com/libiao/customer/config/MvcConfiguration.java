package com.libiao.customer.config;

import com.libiao.customer.interceptor.TokenAuthInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Xu
 * @date 2022/6/28
 */
@Configuration
@Slf4j
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> commonExcludePath = new ArrayList<>();
        commonExcludePath.add("/");
        commonExcludePath.add("index.html#/**");
        commonExcludePath.add("index.html/**");
        commonExcludePath.add("/static/**");
        commonExcludePath.add("/404");
        commonExcludePath.add("/403");
        commonExcludePath.add("/500");
        commonExcludePath.add("/favicon.ico");
        commonExcludePath.add("/swagger**");
        commonExcludePath.add("/error");
        commonExcludePath.add("/swagger-resources/**");
        commonExcludePath.add("/v2/api-docs");
        commonExcludePath.add("/webjars/**");
        commonExcludePath.add("/doc.html");
        commonExcludePath.add("/api/login/account");
        commonExcludePath.add("/api/certification/downloadByEncryptionKey");
        commonExcludePath.add("/api/certification/uploadFile");
        commonExcludePath.add("/api/certification/uploadVertification");
        commonExcludePath.add("/api/certification/queryFileNameByEncryptionKey");
        commonExcludePath.add("/api/certification/previewByCertificationId");
        commonExcludePath.add("/api/certification/previewByEncryptionKey");
        commonExcludePath.add("/api/certification/previewTest");
        commonExcludePath.add("/api/file");

        registry.addInterceptor(new TokenAuthInterceptor()).addPathPatterns("/**").excludePathPatterns(commonExcludePath.toArray(new String[]{}));
    }

    /**
     * 添加静态资源文件，外部可以直接访问地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
    }
}
