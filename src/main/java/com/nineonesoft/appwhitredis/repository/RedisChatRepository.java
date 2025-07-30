package com.nineonesoft.appwhitredis.repository;

import com.nineonesoft.appwhitredis.domain.ChatSession;
import org.springframework.data.repository.CrudRepository;

public interface RedisChatRepository extends CrudRepository<ChatSession, Long> {


}
