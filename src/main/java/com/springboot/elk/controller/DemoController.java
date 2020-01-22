package com.springboot.elk.controller;

import com.springboot.elk.model.DemoUser;
import com.springboot.elk.service.impl.DemoUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    private DemoUserServiceImpl demoUserService;

    @Autowired
    public DemoController(DemoUserServiceImpl demoUserService) {
        this.demoUserService = demoUserService;
    }

    @GetMapping
    public List<DemoUser> getAll() {
        List<DemoUser> user = demoUserService.findAll();

        return user;
    }
}
