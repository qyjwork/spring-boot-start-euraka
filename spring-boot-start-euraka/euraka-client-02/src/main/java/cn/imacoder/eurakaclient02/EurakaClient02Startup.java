package cn.imacoder.eurakaclient02;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
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
public class EurakaClient02Startup {

    public static void main(String[] args) {
        SpringApplication.run(EurakaClient02Startup.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
