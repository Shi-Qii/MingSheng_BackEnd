package com.example.demo.service;

import com.example.demo.service.Interface_type.SampleServe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleServe {
    private final Logger log = LoggerFactory.getLogger(SampleServe.class);


}
