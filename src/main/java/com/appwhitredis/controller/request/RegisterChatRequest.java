package com.appwhitredis.controller.request;

import com.appwhitredis.service.request.RegisterChatServiceRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class RegisterChatRequest {

    private String user;
    private String text;


    private RegisterChatRequest(String user, String text) {
        this.user = user;
        this.text = text;
    }

    public RegisterChatServiceRequest toServiceRequest() {
        return RegisterChatServiceRequest.builder()
                .user(user)
                .text(text)
                .build();
    }
}
