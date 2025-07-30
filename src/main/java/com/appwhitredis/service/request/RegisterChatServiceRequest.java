package com.appwhitredis.service.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterChatServiceRequest {

    private String user;
    private String text;

    @Builder
    private RegisterChatServiceRequest(String user, String text) {
        this.user = user;
        this.text = text;
    }
}
