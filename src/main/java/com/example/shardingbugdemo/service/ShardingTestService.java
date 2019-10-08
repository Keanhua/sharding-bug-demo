package com.example.shardingbugdemo.service;


import com.example.shardingbugdemo.entity.ShardingTest;
import com.example.shardingbugdemo.mapper.ShardingTestMapper;
import org.springframework.stereotype.Service;


@Service
public class ShardingTestService extends BaseService<ShardingTestMapper, ShardingTest> {

}
