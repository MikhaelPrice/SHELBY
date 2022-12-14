package com.SHELBY.repos;

import com.SHELBY.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {
    List<Message> findByDate(String date);
}
