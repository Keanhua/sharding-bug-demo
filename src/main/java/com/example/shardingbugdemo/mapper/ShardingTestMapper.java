package com.example.shardingbugdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingbugdemo.entity.ShardingTest;
import org.springframework.stereotype.Component;


@Component
public interface ShardingTestMapper extends BaseMapper<ShardingTest> {
}
