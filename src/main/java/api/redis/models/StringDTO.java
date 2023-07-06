package api.redis.models;

import jakarta.validation.constraints.NotBlank;

public class StringDTO {
    String key;

    @NotBlank(message = "Required filed value is missing.")
    String value;

    public StringDTO() {
    }

    public StringDTO(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
