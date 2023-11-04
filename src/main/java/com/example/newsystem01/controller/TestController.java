package com.example.newsystem01.controller;

import com.example.newsystem01.config.MicroServiceUrl;
import com.example.newsystem01.entity.User;
import com.example.newsystem01.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    private final UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/adduser")
    public String addUser(@RequestBody User user) throws Exception {
        if (null != user) {
            userService.insertUser(user);
            return "success";
        } else {
            return "false";
        }
    }

    @GetMapping("/user")
    public User getUser(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        return (User) application.getAttribute("user");
    }

    /**
     * 获取当前在线人数，该方法有bug
     * @param request
     * @return
     */
    @GetMapping("/total")
    public String getTotalUser(HttpServletRequest request) {
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }

    @GetMapping("/request")
    public String getRequestInfo(HttpServletRequest request) {
        System.out.println("requestListener中的初始化的name数据：" + request.getAttribute("name"));
        return "success";
    }


    @RequestMapping("/log")
    public String testLog() {
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");

        // 可以使用占位符打印出一些参数信息
        String str1 = "blog.itcodai.com";
        String str2 = "blog.csdn.net/eson_15";
        logger.info("======倪升武的个人博客：{}；倪升武的CSDN博客：{}", str1, str2);

        return "success";
    }




}
