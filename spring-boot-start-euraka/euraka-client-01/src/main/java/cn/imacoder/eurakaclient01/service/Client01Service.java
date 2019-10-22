package cn.imacoder.eurakaclient01.service;

import cn.imacoder.common.model.DemoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

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
@RequestMapping("/client01")
public class Client01Service {

    private static String client02Name="euraka-client-02".toUpperCase();
    private Logger log=LoggerFactory.getLogger(Client01Service.class);
    @Autowired
    private HttpServletRequest servletRequest;
    @Autowired
    private RestOperations restTemplate;

    @GetMapping("/getInfo/{msg}")
    public String GetInfo(@PathVariable String msg) {
        String token=servletRequest.getHeader("token");
        String rsp = "调用 euraka-client-01 的 GetInfo ,msg : " + msg + " , Token: " +token;
        log.info(rsp);
        return rsp;
    }

    @PostMapping("/postInfo")
    public String PostInfo(@RequestBody(required=false) DemoRequest request) throws URISyntaxException {
        if (request == null) {
            request=new DemoRequest();
        }
        String req=request.toString();
        log.info("开始调用 euraka-client-01 的 PostInfo ,接收到请求 request : " + req);

        String url=String.format("http://%s/client02/postInfo/", client02Name);

        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<DemoRequest> requestEntity=new HttpEntity<>(request, headers);

        log.info("开始 RestTemplate 远程调用 euraka-client-02 的 PostInfo ,URL : " + url + " 请求参数request : " + req);

        ResponseEntity<String> result=this.restTemplate.postForEntity(url, requestEntity, String.class);

        return String.format("请求: %s , 输出: %s", req, result.getBody());
    }
}
