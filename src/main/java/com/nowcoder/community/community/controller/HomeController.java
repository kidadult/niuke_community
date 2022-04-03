package com.nowcoder.community.community.controller;

import com.nowcoder.community.community.entity.DiscussPost;
import com.nowcoder.community.community.entity.Page;
import com.nowcoder.community.community.entity.User;
import com.nowcoder.community.community.service.DiscussService;
import com.nowcoder.community.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussService discussService;
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String getIndexPage(Model model, Page page){
        // 方法调用前,Springmvc会自动实例化Model和Page,并将Page注入Model,所以在thymeleaf中可以直接访问Page对象中数据
        // 封装的page信息
        page.setRows(discussService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> discusspost = discussService.findDiscusspost(0, page.getOffset(), page.getLimit());
        ArrayList<Map<String,Object>> discussPostAndUser = new ArrayList<>();
        if (discusspost != null){
            for (DiscussPost post:discusspost) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("post",post);
                User user = userService.findUserNameById(post.getUserId());
                map.put("user",user);
                discussPostAndUser.add(map);
            }
        }
        model.addAttribute("discussPosts",discussPostAndUser);
        return "/index";
    }

    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String getErrorPage() {
        return "/error/500";
    }
}
