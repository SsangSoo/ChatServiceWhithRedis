package com.appwhitredis.service;

import com.appwhitredis.controller.response.RedisChatResponse;
import com.appwhitredis.service.request.RegisterChatServiceRequest;

public interface RedisChatService {

    RedisChatResponse registerChat(Long chatId, RegisterChatServiceRequest request) throws InterruptedException;
}
