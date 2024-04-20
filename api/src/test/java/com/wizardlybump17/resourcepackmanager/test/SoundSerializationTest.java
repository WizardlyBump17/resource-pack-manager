package com.wizardlybump17.resourcepackmanager.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wizardlybump17.resourcepackmanager.api.resource.sound.Sound;
import com.wizardlybump17.resourcepackmanager.api.resource.sound.SoundEvent;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class SoundSerializationTest {

    static final @NonNull ObjectMapper MAPPER = new ObjectMapper();

    @Test
    void testSound() throws Throwable {
        List<Sound> sounds = new ArrayList<>();
        Random random = new Random(0);
        int amount = 100;
        for (int i = 0; i < amount; i++) {
            sounds.add(new Sound(
                    "test" + i,
                    random.nextInt(amount),
                    random.nextInt(amount),
                    random.nextInt(amount),
                    random.nextBoolean(),
                    random.nextInt(amount),
                    random.nextBoolean(),
                    Sound.Type.values()[random.nextInt(Sound.Type.values().length)]
            ));
        }

        SoundEvent event = new SoundEvent(
                "test",
                false,
                "test",
                sounds
        );

        String value = MAPPER.writeValueAsString(event);
        SoundEvent deserialized = MAPPER.readValue(value, SoundEvent.class);

        Assertions.assertEquals(event, deserialized);
    }
}
