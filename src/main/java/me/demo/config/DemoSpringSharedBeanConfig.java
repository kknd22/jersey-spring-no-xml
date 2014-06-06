package me.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by chrislin on 5/28/2014.
 */
@Configuration
//@PropertySource("classpath:/app-spring.properties")
//@ImportResource(["classpath:applicationContext.xml"])
@ComponentScan(basePackages = {"me.demo.service"})
public class DemoSpringSharedBeanConfig {
    //@Value('${mb_value1}') String v1

    @Bean
    static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

/*
    @Bean(name="myBean")
    MyBean MyBean() {
        return new MyBean(value1:v1);
    }

*/
}