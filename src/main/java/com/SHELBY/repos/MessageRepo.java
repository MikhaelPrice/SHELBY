package com.SHELBY.repos;

import com.SHELBY.domain.Messages;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Messages, Long> {
    List<Messages> findByTag(String tag);
}
