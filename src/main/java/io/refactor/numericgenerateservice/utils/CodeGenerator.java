package io.refactor.numericgenerateservice.utils;

import io.refactor.numericgenerateservice.redis.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class CodeGenerator {
    private final RedisServiceImpl redisService;

    @Value("${redis.key}")
    private String redisKey;

    public CodeGenerator(RedisServiceImpl redisService) {
        this.redisService = redisService;
    }

    public Optional<Number> generateNumber() {

        for (int i = 0; i < 30; i++) {
            Long generatedCode = this.generator();
            if (!redisService.existsToSet(redisKey, generatedCode)) {
                redisService.addToSet(redisKey, generatedCode);
                return Optional.of(generatedCode);
            }
        }
        return Optional.empty();
    }

    private Long generator() {
        Date date = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");

        int randomNumber = Randomize.rnd(11111, 99999);

        return Long.parseLong(randomNumber + dateFormatter.format(date));
    }
}
