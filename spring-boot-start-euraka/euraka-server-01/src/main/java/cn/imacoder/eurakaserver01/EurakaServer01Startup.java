package cn.imacoder.eurakaserver01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ Project:spring-boot-start-euraka
 * @ Package:cn.imacoder.eurakaclient01.service
 * @ Created By: QIUYANJUN
 * @ Description:TODO
 * @ Date:2019/10/11 13:50
 * @ Modify By: QIUYANJUN
 * @ Author:QIUYANJUN
 */

@EnableEurekaServer  //启用EurekaServer服务发现
@SpringBootApplication
public class EurakaServer01Startup {

    public static void main(String[] args) {
        SpringApplication.run(EurakaServer01Startup.class, args);
    }
}
