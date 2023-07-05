package api.redis.services;

import api.redis.models.HashMapDTO;
import api.redis.models.StringDTO;
import api.redis.repositories.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RedisService {

    @Autowired
    RedisRepository redisRepository;

    public StringDTO setString(StringDTO stringDTO) throws Exception{
        try {
            stringDTO.setKey(generateUUID());
            redisRepository.setSessionString(stringDTO);
            return stringDTO;
        }catch (RedisConnectionFailureException ex){
            throw new Exception(ex.getMessage());
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public StringDTO getString(String key) throws Exception{
        try {
            StringDTO stringDTO = new StringDTO();
            stringDTO.setKey(key);
            stringDTO.setData(redisRepository.getSessionString(key));
            return stringDTO;
        }catch (RedisConnectionFailureException ex){
            throw new Exception(ex.getMessage());
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public boolean deleteString(String key) throws Exception{
        try {
            redisRepository.deleteSessionString(key);
            return true;
        }catch (RedisConnectionFailureException ex){
            throw new Exception(ex.getMessage());
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public HashMapDTO setToHashMap(HashMapDTO hashMapDTO) throws Exception{
        try {
            hashMapDTO.setKey(generateUUID());
            redisRepository.setSessionHashMap(hashMapDTO);
            return hashMapDTO;
        }catch (RedisConnectionFailureException ex){
            throw new Exception(ex.getMessage());
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public HashMapDTO getFromHashMap(String hashName, String key) throws Exception{
        try{
            HashMapDTO hashMapDTO = new HashMapDTO();
            hashMapDTO.setHashName(hashName);
            hashMapDTO.setKey(key);
            hashMapDTO.setData(redisRepository.getSessionHashMap(hashName, key));
            return hashMapDTO;
        }catch (RedisConnectionFailureException ex){
            throw new Exception(ex.getMessage());
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public boolean deleteFromHashMap(String hashName, String key) throws Exception{
        try{
            redisRepository.deleteSessionHashMap(hashName, key);
            return true;
        }catch (RedisConnectionFailureException ex){
            throw new Exception(ex.getMessage());
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    private String generateUUID(){
        return UUID.randomUUID().toString();
    }

}
