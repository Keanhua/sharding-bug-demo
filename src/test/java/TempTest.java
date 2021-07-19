import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shardingbugdemo.ShardingBugDemoApplication;
import com.example.shardingbugdemo.entity.ShangbaoIdcardVerify;
import com.example.shardingbugdemo.entity.ShardingTest;
import com.example.shardingbugdemo.service.ShangbaoIdcardVerifyService;
import com.example.shardingbugdemo.service.ShardingTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@SpringBootTest(classes = {ShardingBugDemoApplication.class})
@RunWith(SpringRunner.class)
public class TempTest {

    @Autowired
    private ShardingTestService shardingTestService;

    @Autowired
    private ShangbaoIdcardVerifyService shangbaoIdcardVerifyService;


    @Test
    public void test(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("产品","相机");
        jsonObject.put("规格","台");
        ShardingTest shardingTest =new ShardingTest();
        shardingTest.setSort(1);
        shardingTest.setAliveFlag(1);
        shardingTest.setTitle("aaaaa");
        shardingTest.setContent(jsonObject.toJSONString());
        shardingTest.setCreateTime(new Date());
        shardingTestService.save(shardingTest);
       List<ShardingTest> shardingTestList = shardingTestService.list();
       ShardingTest shardingTest1=shardingTestService.getById(26L);
/*
        ShardingTest shardingTestData = shardingTestService.getById(403924290937815041L);
*/
        //List<ShardingTest> shardingTestList = shardingTestService.getBaseMapper().selectA("\"YrNhYYqCR9P7RJJrYWwHbA==\",\"YrNhYYqCR9P7RJJrYWwHbA==\"");
        QueryWrapper<ShardingTest> queryWrapper=new QueryWrapper<>();
/*        queryWrapper.eq("alive_flag",1);
        queryWrapper.lambda().and(i -> i.eq(ShardingTest::getTitle, "111").or().eq(ShardingTest::getATitle, "111"));*/
   /*     queryWrapper.lambda()
                .and(i -> i.in(ShardingTest::getTitle, Arrays.asList("aaaaa"))
                        .or()
                        .in(ShardingTest::getATitle, Arrays.asList("aaaaa"))
                        .or()
                        .in(ShardingTest::getContent, Arrays.asList("aaaaa")));*/
        IPage<ShardingTest> pageList=shardingTestService.page(new Page(1, 10),queryWrapper.orderByDesc("id"));
    /*    List<ShardingTest> saveShardingTest=new ArrayList<>();
        JSONObject jsonObject=new JSONObject();
        ShardingTest shardingTest =new ShardingTest();
        shardingTest.setSort(1);
        shardingTest.setAliveFlag(1);
        shardingTest.setTitle("111");
        shardingTest.setATitle("222");
        shardingTest.setContent(jsonObject.toJSONString());
        shardingTest.setCreateTime(new Date());
        saveShardingTest.add(shardingTest);
        ShardingTest shardingTest1 =new ShardingTest();
        shardingTest1.setSort(1);
        shardingTest1.setAliveFlag(1);
        shardingTest1.setTitle("333");
        shardingTest1.setATitle("444");
        shardingTest1.setContent(jsonObject.toJSONString());
        shardingTest1.setCreateTime(new Date());
        saveShardingTest.add(shardingTest1);
        shardingTestService.saveBatch(saveShardingTest);*/
        System.out.println(JSON.toJSONString(pageList));
    }


    @Test
    public void testA(){
        shardingTestService.getBaseMapper().insertSelect();
    }


    @Test
    public void testB(){
        QueryWrapper<ShangbaoIdcardVerify> queryWrapper=new QueryWrapper<>();
        IPage<ShangbaoIdcardVerify> page= shangbaoIdcardVerifyService.page(new Page(1, 10),queryWrapper.orderByDesc("id"));
        System.out.println(JSON.toJSONString(page));
    }
}
