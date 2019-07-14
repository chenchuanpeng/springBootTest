package com.ccp.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.ResourceServlet;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {


    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return  new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> param = new HashMap<>();
        // 登陆用户名
        param.put(ResourceServlet.PARAM_NAME_USERNAME,"admin");
        // 登陆密码
        param.put(ResourceServlet.PARAM_NAME_PASSWORD,"123456");
        // 允许谁访问，默认允许所有
        param.put(ResourceServlet.PARAM_NAME_ALLOW,"");
        // 拒绝谁访问
        param.put(ResourceServlet.PARAM_NAME_DENY,"192.168.2.110");
        bean.setInitParameters(param);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        Map<String, String> initParam = new HashMap<>();
        initParam.put(WebStatFilter.PARAM_NAME_EXCLUSIONS,"*.css,*.js,/druid/*");
        bean.setInitParameters(initParam);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
