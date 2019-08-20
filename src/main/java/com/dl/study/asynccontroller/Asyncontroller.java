package com.dl.study.asynccontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 *@ClassName Asyncontroller
 *@Description TODO
 *@Author DL
 *@Date 2019/8/20 15:52    
 *@Version 1.0
 */
@RestController
@RequestMapping("async")
@Slf4j
public class Asyncontroller {

    @GetMapping("/oreder")
    public String order() throws InterruptedException {
        log.info("主线程开始");
        Thread.sleep(10);
        log.info("主线程结束");

        return "success";

    }

    /**
     * 异步处理
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/oreder")
    public Callable<String> order2() throws InterruptedException {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("副线程处理逻辑");
                return "success2";
            }
        };
        log.info("主线程返回值");
        return callable;
    }

}
