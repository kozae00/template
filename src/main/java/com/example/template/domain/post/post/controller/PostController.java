package com.example.template.domain.post.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/posts") // 모든 요청에 /posts를 붙여줌
public class PostController {
    @GetMapping("/write")
    @ResponseBody
    public String showWrite() {
        return """
                <form action="/doWrite">
                    <input type="text" name="title" placeholder="제목" />
                    <textarea name = "content"></textarea>
                    <input type = "submit" value="등록" />
                </form>
                """;
    }
}
