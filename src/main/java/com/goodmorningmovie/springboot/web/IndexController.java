package com.goodmorningmovie.springboot.web;


import com.goodmorningmovie.springboot.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor //이건 왜 필요한 어노테이션이지?? 이거 왜 쓰는거?
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts",postsService
                .findAllDesc());

        return "index";
    }


    @GetMapping("/posts/save")
    public String savingPosts() {
        return "posts-save";
        //application.properties 에만 두줄 추가
        //application.properties 에만 두줄 추가
        //application.properties 에만 두줄 추가 
        //h2 database 웹콘솔을 띄우려고 application.properties에'만' 두줄 추가!!!
    }
}
