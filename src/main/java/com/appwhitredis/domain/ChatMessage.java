package com.appwhitredis.domain;

import com.appwhitredis.controller.response.ResponseChatMessage;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class ChatMessage {

    String user;
    String text;
    private long timestamp;

    private ChatMessage(String user, String text) {
        this.user = user;
        this.text = text;
        this.timestamp = System.currentTimeMillis();
    }

    public static ChatMessage of(String user, String text) {
        return new ChatMessage(user, text);
    }


    public ResponseChatMessage toResponse() {
        return ResponseChatMessage.of(user, text, timestamp);
    }
}
