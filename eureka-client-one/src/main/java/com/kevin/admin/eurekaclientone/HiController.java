package com.kevin.admin.eurekaclientone;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HiController
 * @Description:
 * @Author: Kevin
 * @Date: 2018/5/30 14:08
 */
@RestController
public class HiController {
    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam String name){
        return "hi,"+name+", this port="+port;
    }
    public String hiError(String name){
        return "hi,"+name+",this is error";
    }
}
