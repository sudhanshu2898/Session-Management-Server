package api.redis.models;

import jakarta.validation.constraints.NotBlank;

import java.util.Map;

public class HashMapDTO {
    @NotBlank(message = "Required filed hashName is missing.")
    String hashName;
    String key;

    @NotBlank(message = "Required filed data is missing.")
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