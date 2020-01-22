package com.springboot.elk.service;

import com.springboot.elk.model.DemoUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IDemoUserService {
    List<DemoUser> findAll();
}