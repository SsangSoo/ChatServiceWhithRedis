package com.nineonesoft.appwhitredis.service;

import com.nineonesoft.appwhitredis.domain.ChatSession;
import com.nineonesoft.appwhitredis.repository.RedisChatRepository;
import com.nineonesoft.appwhitredis.service.request.RegisterChatServiceRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;

import static org.assertj.core.api.Assertions.*;


@DataRedisTest
class RedisChatServiceImplTest {

    @Autowired
    private RedisChatRepository redisChatRepository;

    @AfterEach
    void afterEach() {
        redisChatRepository.deleteAll();
    }

    @DisplayName("채팅 방을 만들 수 있다.")
    @Test
    void makeChatGroupTest() {
        // given
        ChatSession chatSession = new ChatSession(1L);

        // when
        ChatSession savedChat = redisChatRepository.save(chatSession);

        // than
        assertThat(savedChat.getChatId()).isEqualTo(1L);
        assertThat(savedChat.getChatMessageList()).isEmpty();
    }

    @DisplayName("채팅방에 대화를 이어나갈 수 있다.")
    @Test
    void chatInsertTest() {
        // given

        RegisterChatServiceRequest chat1 = makeChat("성수", "안녕하세요");
        RegisterChatServiceRequest chat2 = makeChat("정환", "네~ 안녕하세요");
        ChatSession chatSession = new ChatSession(1L);
        chatSession.insert(chat1);
        chatSession.insert(chat2);

        // when
        ChatSession savedChat = redisChatRepository.save(chatSession);

        // than
        assertThat(savedChat.getChatId()).isEqualTo(1L);
        assertThat(savedChat.getChatMessageList()).hasSize(2);
        assertThat(savedChat.getChatMessageList())
                .extracting("user", "text")
                .containsExactly(
                        tuple("성수", "안녕하세요"),
                        tuple("정환", "네~ 안녕하세요")
                );
    }

    private static RegisterChatServiceRequest makeChat(String user, String text) {
        return RegisterChatServiceRequest.builder()
                .user(user)
                .text(text)
                .build();
    }
}