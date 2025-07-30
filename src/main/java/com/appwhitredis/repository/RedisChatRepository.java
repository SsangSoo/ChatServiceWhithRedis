package com.appwhitredis.repository;

import com.appwhitredis.domain.ChatSession;
import org.springframework.data.repository.CrudRepository;

public interface RedisChatRepository extends CrudRepository<ChatSession, Long> {


}
