package io.refactor.numericgenerateservice.redis.service;

public interface RedisService {
    void addToSet(String key, Long... value);
    Boolean existsToSet(String key, Long value);
}
