package api.redis.repositories;

import api.redis.models.HashMapDTO;
import api.redis.models.StringDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisRepository {

    private long ttl = 2678400L;

    @Autowired
    private RedisTemplate redisTemplate;

    public void setSessionString(StringDTO stringDTO){
        redisTemplate.opsForValue().set(stringDTO.getKey(), stringDTO.getData(), ttl, TimeUnit.SECONDS);
    }

    public String getSessionString(String key){
        return redisTemplate.opsForValue().get(key).toString();
    }

    public void deleteSessionString(String key){
        redisTemplate.opsForValue().getAndDelete(key);
    }

    public void setSessionHashMap(HashMapDTO hashMapDTO){
        redisTemplate.opsForHash().put(hashMapDTO.getHashName(), hashMapDTO.getKey(), hashMapDTO.getData());
    }

    public Map<String, Object> getSessionHashMap(String hashName, String key){
        return (Map<String, Object>) redisTemplate.opsForHash().get(hashName, key);
    }

    public void deleteSessionHashMap(String hashName, String key){
        redisTemplate.opsForHash().delete(hashName , key);
    }

}
