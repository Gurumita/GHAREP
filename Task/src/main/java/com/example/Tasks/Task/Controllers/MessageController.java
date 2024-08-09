package com.example.Tasks.Task.Controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    @GetMapping("/message")
    public String getMessage(){
        return "messages";
    }

    @MessageMapping("/send")
    @SendTo("/topic/response")
    public String sendMessage(String message) {
        return message;
    }

}
