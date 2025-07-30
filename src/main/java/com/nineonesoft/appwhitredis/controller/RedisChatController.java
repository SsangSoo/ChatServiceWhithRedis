package com.nineonesoft.appwhitredis.controller;


import com.nineonesoft.appwhitredis.controller.request.RegisterChatRequest;
import com.nineonesoft.appwhitredis.controller.response.RedisChatResponse;
import com.nineonesoft.appwhitredis.service.RedisChatService;
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
    public ResponseEntity<RedisChatResponse> registerChat(@PathVariable Long chatId, @RequestBody RegisterChatRequest request) {
        log.info("chatId = {}, request = {}", chatId, request);
        RedisChatResponse redisChatResponse = redisChatService.registerChat(chatId, request.toServiceRequest());
        return new ResponseEntity<>(redisChatResponse, HttpStatus.CREATED);
    }

}
