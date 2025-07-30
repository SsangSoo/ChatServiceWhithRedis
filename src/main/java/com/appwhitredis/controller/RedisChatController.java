package com.appwhitredis.controller;


import com.appwhitredis.controller.request.RegisterChatRequest;
import com.appwhitredis.controller.response.RedisChatResponse;
import com.appwhitredis.service.RedisChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/chat")
@RestController
@RequiredArgsConstructor
public class RedisChatController {

    private final RedisChatService redisChatService;

    @PostMapping("/{chatId}")
    public ResponseEntity<RedisChatResponse> registerChat(@PathVariable Long chatId, @RequestBody RegisterChatRequest request) throws InterruptedException {
        log.info("chatId = {}, request = {}", chatId, request);
        RedisChatResponse redisChatResponse = redisChatService.registerChat(chatId, request.toServiceRequest());
        return new ResponseEntity<>(redisChatResponse, HttpStatus.CREATED);
    }

}
