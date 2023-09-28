import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shardingbugdemo.ShardingBugDemoApplication;
import com.example.shardingbugdemo.entity.ShardingTest;
import com.example.shardingbugdemo.service.ShardingTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest(classes = {ShardingBugDemoApplication.class})
@RunWith(SpringRunner.class)
public class TempTest {

    @Autowired
    private ShardingTestService shardingTestService;


    @Test
    public void test(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("产品","相机");
        jsonObject.put("规格","台");
        ShardingTest shardingTest =new ShardingTest();
        shardingTest.setAliveFlag(1);
        shardingTest.setTitle("aaaaa");
        shardingTest.setContent(jsonObject.toJSONString());
        shardingTest.setCreateTime(new Date());
        shardingTestService.save(shardingTest);
        List<ShardingTest> saveShardingTest=new ArrayList<>();
        ShardingTest shardingTest1 =new ShardingTest();
        shardingTest.setAliveFlag(1);
        shardingTest.setTitle("111");
        shardingTest.setATitle("222");
        shardingTest.setContent(jsonObject.toJSONString());
        shardingTest.setCreateTime(new Date());
        saveShardingTest.add(shardingTest1);
        ShardingTest shardingTest2 =new ShardingTest();
        shardingTest2.setAliveFlag(1);
        shardingTest2.setTitle("333");
        shardingTest2.setATitle("444");
        shardingTest2.setContent(jsonObject.toJSONString());
        shardingTest2.setCreateTime(new Date());
        saveShardingTest.add(shardingTest2);
        shardingTestService.saveBatch(saveShardingTest);
        System.out.println(JSON.toJSONString(shardingTest));
    }

}
