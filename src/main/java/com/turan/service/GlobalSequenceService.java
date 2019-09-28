package com.turan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GlobalSequenceService
{
    @Autowired
    private SequenceGenerator sequenceGenerator;

    public long nextId()
    {
        // todo turan 唯一id生成
        return sequenceGenerator.nextId();
    }
}
