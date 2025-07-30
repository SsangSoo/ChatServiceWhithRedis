package com.nineonesoft.appwhitredis.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class RedisChatResponse {

    private Long chatId;
    private List<ResponseChatMessage> chatMessageList = new ArrayList<>();


    @Builder
    private RedisChatResponse(Long chatId, List<ResponseChatMessage> chatMessageList) {
        this.chatId = chatId;
        this.chatMessageList = chatMessageList;
    }

    public static RedisChatResponse of(Long chatId, List<ResponseChatMessage> chatMessageList) {
        return RedisChatResponse.builder()
                .chatId(chatId)
                .chatMessageList(chatMessageList)
                .build();
    }

}

