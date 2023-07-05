package api.redis.models;

import java.util.Map;

public class HashMapDTO {
    String hashName;
    String key;
    Map<String, Object> data;

    public HashMapDTO() {
    }

    public HashMapDTO(String hashName, String key, Map<String, Object> data) {
        this.hashName = hashName;
        this.key = key;
        this.data = data;
    }

    public String getHashName() {
        return hashName;
    }

    public void setHashName(String hashName) {
        this.hashName = hashName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}