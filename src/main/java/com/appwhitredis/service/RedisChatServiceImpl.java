package com.appwhitredis.service;

import com.appwhitredis.controller.response.RedisChatResponse;
import com.appwhitredis.domain.ChatMessage;
import com.appwhitredis.domain.ChatSession;
import com.appwhitredis.repository.RedisChatRepository;
import com.appwhitredis.service.request.RegisterChatServiceRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisChatServiceImpl implements RedisChatService {

    private final RedisChatRepository redisChatRepository;

    @Override
    @Transactional
    public RedisChatResponse registerChat(Long chatId, RegisterChatServiceRequest request) throws InterruptedException {
        ChatSession chatSession = redisChatRepository.findById(chatId)
                .orElseGet(() -> new ChatSession(chatId));
        chatSession.insert(request);
        ChatSession saveChat = redisChatRepository.save(chatSession);

        return RedisChatResponse.of(
                saveChat.getChatId(),
                saveChat.getChatMessageList().stream()
                        .map(ChatMessage::toResponse)
                        .toList()
        );
    }

    @Transactional(readOnly = true)
    public RedisChatResponse retrieveChat(Long chatId) {
        ChatSession chatSession = redisChatRepository.findById(chatId)
                .orElseThrow();
        return RedisChatResponse.of(
                chatSession.getChatId(),
                chatSession.getChatMessageList().stream()
                        .map(ChatMessage::toResponse)
                        .toList()
        );

    }
}
