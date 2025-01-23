package com.example.template.domain.post.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/posts") // 모든 요청에 /posts를 붙여줌
public class PostController {
    @GetMapping("/write") // 폼 보여주기 -> 값을 받으니깐 GET
    @ResponseBody
    public String showWrite() {
        return """
                <form method="post">
                    <input type="text" name="title" placeholder="제목" />
                    <textarea name = "content"></textarea>
                    <input type = "submit" value="등록" />
                </form>
                """;
    }

    @PostMapping("/write") // 처리 -> 값을 보내니깐 POST
    @ResponseBody
    public String doWrite(String title, String content) {

        if (title.isBlank() || title == null) {
            return """
                <div>%s</div>
                <form method="post">
                    <input type="text" name="title" placeholder="제목" />
                    <textarea name = "content"></textarea>
                    <input type = "submit" value="등록" />
                </form>
                """.formatted("제목을 입력해주세요");
        }

        if (content.isBlank() || content == null) {
            return """
                <div>%s</div>
                <form method="post">
                    <input type="text" name="title" placeholder="제목" />
                    <textarea name = "content"></textarea>
                    <input type = "submit" value="등록" />
                </form>
                """.formatted("내용을 입력해주세요");
        }

        if (title.length() < 5) {
            return """
                <div>%s</div>
                <form method="post">
                    <input type="text" name="title" placeholder="제목" />
                    <textarea name = "content"></textarea>
                    <input type = "submit" value="등록" />
                </form>
                """.formatted("제목을 5글자 이상 입력해주세요");
        }
        
        if(content.length() < 10) {
            return """
                <div>%s</div>
                <form method="post">
                    <input type="text" name="title" placeholder="제목" />
                    <textarea name = "content"></textarea>
                    <input type = "submit" value="등록" />
                </form>
                """.formatted("내용을 10글자 이상 입력해주세요");
        }

            return """
                    <h1>게시물 조회</h1>
                    <div>%s</div>
                    <div>%s</div>
                    """.formatted(title, content);

    }
}
