package com.taemin.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/chatroom") // 실제 매핑은 publisher/chatroom
    @SendTo("/subscriber/chatroom")
    public String hello(String message) {
        return message;
    }
}
