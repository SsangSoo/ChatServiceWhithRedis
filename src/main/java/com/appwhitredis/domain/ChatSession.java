package com.appwhitredis.domain;

import com.appwhitredis.service.request.RegisterChatServiceRequest;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.*;


@Getter
@RedisHash(value = "number", timeToLive = 180)
public class ChatSession {

    @Id
    private Long chatId;

    private List<ChatMessage> chatMessageList = new ArrayList<>();

    public ChatSession(Long chatId) {
        this.chatId = chatId;
    }


    public void insert(RegisterChatServiceRequest request) {
        chatMessageList.add(ChatMessage.of(request.getUser(), request.getText()));
    }


}
