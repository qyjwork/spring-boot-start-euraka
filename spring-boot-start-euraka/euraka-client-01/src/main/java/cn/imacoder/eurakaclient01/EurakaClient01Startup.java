package cn.imacoder.eurakaclient01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @ Project:spring-boot-start-euraka
 * @ Package:cn.imacoder.eurakaclient01.service
 * @ Created By: QIUYANJUN
 * @ Description:TODO
 * @ Date:2019/10/11 13:50
 * @ Modify By: QIUYANJUN
 * @ Author:QIUYANJUN
 */

@EnableEurekaClient  //启用EurekaClient服务注册
@SpringBootApplication
public class EurakaClient01Startup {

    public static void main(String[] args) {
        SpringApplication.run(EurakaClient01Startup.class, args);
    }

    @Bean
    @LoadBalanced
    public RestOperations restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
