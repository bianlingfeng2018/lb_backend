package com.libiao.customer.config;

import com.libiao.customer.interceptor.SessionInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Xu
 * @date 2022/6/28
 */
@Configuration
@Slf4j
public class MvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

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

        SessionInterceptor sessionInterceptor = new SessionInterceptor();
        sessionInterceptor.setRedisTemplate(redisTemplate);

        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**").excludePathPatterns(commonExcludePath.toArray(new String[]{}));
    }

    /**
     * ?????????????????????????????????????????????????????????
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

    /**
     * ????????????????????????
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        String location = System.getProperty("user.dir") + "/data/tmp";
        File tmpFile = new File(location);
        if (!tmpFile.exists()) {
            tmpFile.mkdirs();
        }
        factory.setLocation(location);
        return factory.createMultipartConfig();
    }

}
