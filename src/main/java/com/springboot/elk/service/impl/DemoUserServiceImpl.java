package com.springboot.elk.service.impl;

import com.springboot.elk.model.DemoUser;
import com.springboot.elk.service.IDemoUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoUserServiceImpl implements IDemoUserService {
    @Override
    public List<DemoUser> findAll() {
        DemoUser user = null;
        List<DemoUser> demoUsers = new ArrayList<>();
        int count = 3;
        for(int i = 0; i<count;i++){
            user = new DemoUser(i+1,"DEMOUSER"+i, "DEMOPASS"+i);
            demoUsers.add(user);
        }
        return demoUsers;
    }
}
