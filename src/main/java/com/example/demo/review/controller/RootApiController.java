package com.example.demo.review.controller;

import com.example.demo.review.entiry.ReviewEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RootApiController {

    @GetMapping("/")
    public String root(){
        return "Hello, world! \n\n\n" +
                "Это пример тестового приложения REST на java, с помощью которого можно оставлять и просматривать отзывы.";
    }

}
