package cn.imacoder.eurakaclient02.service;

import cn.imacoder.common.model.DemoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @ Project:spring-boot-start-euraka
 * @ Package:cn.imacoder.eurakaclient01.service
 * @ Created By: QIUYANJUN
 * @ Description:TODO
 * @ Date:2019/10/11 13:52
 * @ Modify By: QIUYANJUN
 * @ Author:QIUYANJUN
 */

@RestController
@RequestMapping("/client02")
public class Client02Service {

    private Logger log =LoggerFactory.getLogger(Client02Service.class);

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/getInfo/{msg}")
    public String GetInfo(@PathVariable String msg) {
        log.info("开始调用 euraka-client-02 的 GetInfo ,msg : " + msg);
        return "调用 euraka-client-02 的 GetInfo 返回: " + msg;
    }


    @PostMapping("/postInfo")
    public String PostInfo(@RequestBody(required=false) DemoRequest request) {
        if(request == null) {
            request = new DemoRequest();
        }
        String req=request.toString();
        log.info("开始调用 euraka-client-02 的 PostInfo ,接收到请求 request : " + req);
        request.setName("updateName");
        return String.format("请求: %s , 输出: %s", req, request.toString());
    }
}
