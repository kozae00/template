package com.example.template.domain.post.post.controller;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/posts") // 모든 요청에 /posts를 붙여줌
@Validated
public class PostController {

    @GetMapping("/write") // 폼 보여주기 -> 값을 받으니깐 GET
    @ResponseBody
    public String showWrite() {
        return getFormHtml("");
    }

    @PostMapping("/write") // 처리 -> 값을 보내니깐 POST
    @ResponseBody
    public String doWrite(
            @NotBlank @Length(min=5) String title, // null이면 안되고, 5글자 이상이어야 함
            @NotBlank @Length(min = 10) String content // null이면 안되고, 10글자 이상이어야 함
    ) {

            return """
                    <h1>게시물 조회</h1>
                    <div>%s</div>
                    <div>%s</div>
                    """.formatted(title, content);

    }

    private String getFormHtml(String errorMessage) {
        return """
                <div>%s</div>
                <form method="post">
                    <input type="text" name="title" placeholder="제목" /><br>
                    <textarea name = "content"></textarea><br>
                    <input type = "submit" value="등록"  /><br>
                </form>
                """.formatted(errorMessage);
    }

}
