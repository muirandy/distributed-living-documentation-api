package com.github.muirandy.docs.living.api.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Map;

public class KafkaBody {
    private Map<String, Object> headers;
    private byte[] rawKey;
    private byte[] rawValue;

    public KafkaBody() {
    }

    public KafkaBody(Map<String, Object> headers, byte[] rawKey, byte[] rawValue) {
        this.headers = headers;
        this.rawKey = rawKey;
        this.rawValue = rawValue;
    }



    public Map<String, Object> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, Object> headers) {
        this.headers = headers;
    }

    public byte[] getRawKey() {
        return rawKey;
    }

    public void setRawKey(byte[] rawKey) {
        this.rawKey = rawKey;
    }

    public byte[] getRawValue() {
        return rawValue;
    }

    public void setRawValue(byte[] rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public String asJsonString() {
        return asJsonString(this);
    }

    private String asJsonString(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Class classForHeader(String key) {
        Object o = headers.get(key);
        return o.getClass();
    }

    public <T> T headerToType(String key) {
        T value = (T) headers.get(key);
        return value;
    }

    public <C> C headerToClassType(String key, Class<C> type) {
        C value = (C) headers.get(key);
        return value;
    }

    public static KafkaBody fromString(String s) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(s, KafkaBody.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
