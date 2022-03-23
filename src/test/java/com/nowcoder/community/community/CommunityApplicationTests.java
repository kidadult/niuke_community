package com.nowcoder.community.community;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nowcoder.community.community.dao.DiscussPostMapper;
import com.nowcoder.community.community.entity.DiscussPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CommunityApplication.class)
public class CommunityApplicationTests implements ApplicationContextAware {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    // 容器,用于管理spring中装配的bean
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext=applicationContext;
    }


    @Test
     public void testApplicationContext() {
        System.out.println(applicationContext);
    }

    @Test
    public void testSelectPost(){
//        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(0, 0, 10);
//        System.out.println(discussPosts.toString());
        int i = discussPostMapper.selectDiscussPostRows(0);
        System.out.println("总行数"+i);
    }
    @Test
    public void testPageHelper(){
        int pageNum=1;
        int pageSize=10;
        PageHelper.startPage(pageNum,pageSize);
        List<DiscussPost> discussPosts = discussPostMapper.selectAll();
        PageInfo<DiscussPost> discussPostPageInfo = new PageInfo<>(discussPosts, 3);
        for (DiscussPost t: discussPosts) {
            System.out.println(t.toString());
        }
        System.out.println("----------"+discussPostPageInfo);
    }

}
