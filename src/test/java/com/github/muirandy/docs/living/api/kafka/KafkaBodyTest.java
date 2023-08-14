package com.github.muirandy.docs.living.api.kafka;

import com.github.muirandy.docs.living.api.Log;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class KafkaBodyTest {
    private static final String KEY = newUuid();

    private static String newUuid() {
        return UUID.randomUUID().toString();
    }

    private static final String VALUE = newUuid();
    private static final String KEY1 = "Kafka Key 1";
    private static final String VALUE1 = "Kafka Value 1";
    private static final String KEY2 = "Kafka Key 2";
    private static final String VALUE2 = "Kafka Value 2";

    @Test
    void reSerialisation() {
        KafkaBody kafkaBody = new KafkaBody(Map.of(KEY1, VALUE1), rawKey(), rawValue());
        String s = kafkaBody.asJsonString();
        KafkaBody result = KafkaBody.fromString(s);
        assertThat(result).isEqualTo(kafkaBody);
    }

    @Test
    void headerAsString() {
        KafkaBody kafkaBody = new KafkaBody(Map.of(KEY1, VALUE1), rawKey(), rawValue());
        String headerValue = kafkaBody.headerToType(KEY1);
        assertThat(headerValue).isEqualTo(VALUE1);
    }

    @Test
    void headerAsListOfString() {
        List<String> value = List.of(VALUE1, VALUE2);
        KafkaBody kafkaBody = new KafkaBody(Map.of(KEY1, value), rawKey(), rawValue());
        List<String> headerValue = kafkaBody.headerToType(KEY1);
        assertThat(headerValue).isEqualTo(List.of(VALUE1, VALUE2));
    }

    @Test
    void headerAsInstanceofClass() {
        List<String> value = List.of(VALUE1, VALUE2);
        KafkaBody kafkaBody = new KafkaBody(Map.of(KEY1, value), rawKey(), rawValue());

        Class<? extends List<String>> desiredType = kafkaBody.classForHeader(KEY1);
        List<String> headerValue = kafkaBody.headerToClassType(KEY1, desiredType);

        assertThat(headerValue).isEqualTo(List.of(VALUE1, VALUE2));
    }

    private byte[] rawKey() {
        return KEY.getBytes();
    }

    private byte[] rawValue() {
        return VALUE.getBytes();
    }
}
