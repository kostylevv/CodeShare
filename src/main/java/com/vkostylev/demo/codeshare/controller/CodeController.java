package com.vkostylev.demo.codeshare.controller;

import com.vkostylev.demo.codeshare.dto.CodeDto;
import com.vkostylev.demo.codeshare.model.Code;
import com.vkostylev.demo.codeshare.service.CodeSerivce;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CodeController {
    private final CodeSerivce codeSerivce;
    private static final String NEW_CODE_HTML = "<html>\n" +
            "<head>\n" +
            "    <title>Create</title>\n" +
            """
            <script type=\"text/javascript\"">
                    function send() {
                        let object = {
                            "code": document.getElementById("code_snippet").value
                        };
                       \s
                        let json = JSON.stringify(object);
                       \s
                        let xhr = new XMLHttpRequest();
                        xhr.open("POST", '/api/code/new', false)
                        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
                        xhr.send(json);
                       \s
                        if (xhr.status == 200) {
                          alert("Success!");
                        }
                    }
            </script>
            """ +
            "</head>\n" +
            "<body>\n" +
            "<textarea id=\"code_snippet\"> ... </textarea>" +
            "<button id=\"send_snippet\" type=\"submit\" onclick=\"send()\">Submit</button>" +
            "</body></html>\n";

    public CodeController(CodeSerivce codeSerivce) {
        this.codeSerivce = codeSerivce;
    }

    @GetMapping(path = "/code")
    public ResponseEntity<String> getCodeHtml() {
        Optional<String> result = codeSerivce.getHtml(1L);

        return result.map(s -> ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(s)).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping(path = "/api/code")
    public ResponseEntity<String> getCodeJson() {
        Optional<String> result = codeSerivce.getJson(1L);

        return result.map(s -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(s)).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping(path = "/code/new")
    public ResponseEntity<String> createCodeGet() {
        return ResponseEntity.ok().body(NEW_CODE_HTML);
    }

    @PostMapping(path = "/api/code/new")
    public ResponseEntity<String> createCodePost(@RequestBody CodeDto codeDto) {
        Optional<String> result = codeSerivce.setCode(codeDto);
        return result.map(s -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(s)).orElseGet(() -> ResponseEntity.notFound().build());
    }



}