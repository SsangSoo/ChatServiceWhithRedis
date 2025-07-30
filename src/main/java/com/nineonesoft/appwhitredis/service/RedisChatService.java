package com.nineonesoft.appwhitredis.service;

import com.nineonesoft.appwhitredis.controller.response.RedisChatResponse;
import com.nineonesoft.appwhitredis.service.request.RegisterChatServiceRequest;

public interface RedisChatService {

    RedisChatResponse registerChat(Long chatId, RegisterChatServiceRequest request);
}
