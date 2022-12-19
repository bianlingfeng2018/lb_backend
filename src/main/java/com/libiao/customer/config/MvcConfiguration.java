package com.libiao.customer.config;

import com.libiao.customer.interceptor.TokenAuthInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
        commonExcludePath.add("/swagger-ui.html");
        commonExcludePath.add("/swagger-resources/**");
        commonExcludePath.add("/v2/api-docs");
        commonExcludePath.add("/webjars/**");
        commonExcludePath.add("/api/login/account");
        commonExcludePath.add("/api/certification/downloadByEncryptionKey");
        commonExcludePath.add("/api/certification/uploadFile");
        commonExcludePath.add("/api/certification/uploadVertification");
        commonExcludePath.add("/api/certification/queryFileNameByEncryptionKey");
        commonExcludePath.add("/api/certification/previewByCertificationId");
        commonExcludePath.add("/api/certification/previewByEncryptionKey");
        commonExcludePath.add("/api/certification/previewTest");
        commonExcludePath.add("/api/file");

        registry.addInterceptor(new TokenAuthInterceptor()).addPathPatterns("/**/").excludePathPatterns(commonExcludePath.toArray(new String[]{}));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 所有的当前站点的请求地址，都支持跨域访问。
                .allowedOriginPatterns("*") // 所有的外部域都可跨域访问。
                .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")// 当前站点支持的跨域请求方式
                .allowCredentials(true) // 是否支持跨域用户凭证，支持cookie
                .maxAge(3600)// 跨域允许时间。 时间单位是秒。
                .allowedHeaders("*");
        log.info("跨域已释放");
    }
}
