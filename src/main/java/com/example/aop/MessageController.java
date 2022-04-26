package com.example.aop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/")
public class MessageController {

    @GetMapping()
    public ResponseEntity<String> getMessage() throws Exception {
        String message = null;
        if (message == null) {
            throw new Exception("Mensagem é nula!");
        } else {
            return ResponseEntity.ok().body(message);
        }
    }

    @GetMapping(value = "/throw")
    public void getThrow() {
        throw new RuntimeException();
    }
}
