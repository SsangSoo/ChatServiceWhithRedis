package com.appwhitredis.controller.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseChatMessage {

    private String user;
    private String text;
    private Long timestamp;

    private ResponseChatMessage(String user, String text, Long timestamp) {
        this.user = user;
        this.text = text;
        this.timestamp = timestamp;
    }

    public static ResponseChatMessage of(String user, String text, Long timestamp) {
        return new ResponseChatMessage(user, text, timestamp);
    }
}
