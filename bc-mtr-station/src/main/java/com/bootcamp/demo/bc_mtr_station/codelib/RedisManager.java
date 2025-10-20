package com.bootcamp.demo.bc_mtr_station.codelib;

import java.time.Duration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Purpose:
// LineEntity[] lineEntities = new RedisManager().get("mtr_lines", LineEntity[].class)

public class RedisManager {
  private RedisTemplate<String, String> redisTemplate;
  private ObjectMapper objectMapper;

  // constructor (DI)
  public RedisManager(RedisConnectionFactory factory,
      ObjectMapper objectMapper) {
    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(factory);
    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(RedisSerializer.json());
    redisTemplate.afterPropertiesSet();
    this.redisTemplate = redisTemplate;
    this.objectMapper = objectMapper;
  }

  // get()
  public <T> T read(String key, Class<T> clazz) throws JsonProcessingException {
    // read from redis
    String jsonForRead = this.redisTemplate.opsForValue().get(key);
    // serialize String to java object
    if (jsonForRead == null)
      return null;
    return this.objectMapper.readValue(jsonForRead, clazz);
  }

  // set()
  public <T> void write(String key, T value, Duration duration)
      throws JsonProcessingException {
    String jsonForWrite = this.objectMapper.writeValueAsString(value);
    this.redisTemplate.opsForValue().set(key, jsonForWrite, duration);
  }


}
