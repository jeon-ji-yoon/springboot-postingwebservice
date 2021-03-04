package com.goodmorningmovie.springboot.web;

import com.goodmorningmovie.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    //가장 최근에 만들엇습니다
    @GetMapping("/hello/dto")
    public HelloResponseDto dto(@RequestParam("name") String name,
                                @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);

    }
}
