package io.refactor.numericgenerateservice.redis;

import io.refactor.numericgenerateservice.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    private final RedisTemplate<String, Long[]> redisTemplate;

    public RedisServiceImpl(RedisTemplate<String, Long[]> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void addToSet(String key, Long... values) {
        redisTemplate.opsForSet().add(key, values);
    }

    @Override
    public Boolean existsToSet(String key, Long value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }
}
