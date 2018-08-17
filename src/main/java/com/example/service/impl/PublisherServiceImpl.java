package com.example.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.example.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {
    private static final Logger log = LoggerFactory.getLogger(PublisherServiceImpl.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String pubMsg(String id) {
        if ("shuye".equals(id)){
            stringRedisTemplate.convertAndSend("phone","15221275860");
            log.info("Publisher sendes Topic... ");
            return "success";
        }else {
            return "no my phone";
        }
    }
}
