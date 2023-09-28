package com.example.shardingbugdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingbugdemo.entity.ShardingTest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ShardingTestMapper extends BaseMapper<ShardingTest> {
}
