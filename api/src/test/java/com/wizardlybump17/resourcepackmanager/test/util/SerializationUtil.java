package com.wizardlybump17.resourcepackmanager.test.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

@UtilityClass
public class SerializationUtil {

    public static void testSerialization(@NonNull ObjectMapper mapper, @NonNull Object object) throws IOException {
        String value = mapper.writeValueAsString(object);
        Object deserialized = mapper.readValue(value, object.getClass());

        Assertions.assertEquals(object, deserialized);
    }
}
