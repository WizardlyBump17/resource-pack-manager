package com.wizardlybump17.resourcepackmanager.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.wizardlybump17.resourcepackmanager.api.deserializer.font.provider.*;
import com.wizardlybump17.resourcepackmanager.api.resource.ResourceLocation;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.*;
import com.wizardlybump17.resourcepackmanager.api.serializer.font.provider.UnihexProviderSerializer;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

class FontProviderTest {

    public static final @NonNull ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module
                .addDeserializer(FontProvider.class, new FontProviderDeserializer())
                .addDeserializer(BitmapProvider.class, new BitmapProviderDeserializer())
                .addDeserializer(LegacyUnicodeProvider.class, new LegacyUnicodeProviderDeserializer())
                .addDeserializer(ReferenceProvider.class, new ReferenceProviderDeserializer())
                .addDeserializer(SpaceProvider.class, new SpaceProviderDeserializer())
                .addDeserializer(TtfProvider.class, new TtfProviderDeserializer())
                .addDeserializer(UnihexProvider.class, new UnihexProviderDeserializer())
                .addSerializer(new UnihexProviderSerializer());

        MAPPER.registerModule(module);
    }

    @Test
    void testBitmapProvider() throws IOException {
        BitmapProvider provider = new BitmapProvider(
                new ResourceLocation("test", "test.png"),
                8,
                6,
                List.of(
                        "abc",
                        "def"
                )
        );

        String value = MAPPER.writeValueAsString(provider);
        BitmapProvider deserialized = MAPPER.readValue(value, BitmapProvider.class);

        Assertions.assertEquals(provider, deserialized);
    }

    @Test
    void testLegacyUnicodeProvider() throws IOException {
        LegacyUnicodeProvider provider = new LegacyUnicodeProvider(
                new ResourceLocation("test", "test.bin"),
                new ResourceLocation("test", "test.png")
        );

        String value = MAPPER.writeValueAsString(provider);
        LegacyUnicodeProvider deserialized = MAPPER.readValue(value, LegacyUnicodeProvider.class);

        Assertions.assertEquals(provider, deserialized);
    }

    @Test
    void testReferenceProvider() throws IOException {
        ReferenceProvider provider = new ReferenceProvider(new ResourceLocation("test", "test"));

        String value = MAPPER.writeValueAsString(provider);
        ReferenceProvider deserialized = MAPPER.readValue(value, ReferenceProvider.class);

        Assertions.assertEquals(provider, deserialized);
    }

    @Test
    void testSpaceProvider() throws IOException {
        SpaceProvider provider = new SpaceProvider(
                Map.of(
                        'a', 1f,
                        'b', 2f,
                        'c', 3f
                )
        );

        String value = MAPPER.writeValueAsString(provider);
        SpaceProvider deserialized = MAPPER.readValue(value, SpaceProvider.class);

        Assertions.assertEquals(provider, deserialized);
    }

    @Test
    void testTtfProvider() throws IOException {
        TtfProvider provider = new TtfProvider(
                new ResourceLocation("test", "test.ttf"),
                List.of(1f, 2f),
                6,
                3,
                List.of('a', 'b', 'c')
        );

        String value = MAPPER.writeValueAsString(provider);
        TtfProvider deserialized = MAPPER.readValue(value, TtfProvider.class);

        Assertions.assertEquals(provider, deserialized);
    }

    @Test
    void testUnihexProvider() throws IOException {
        UnihexProvider provider = new UnihexProvider(
                new ResourceLocation("test", "test.hex"),
                List.of(
                        new UnihexProvider.SizeOverride('a', 'c', 1, 2),
                        new UnihexProvider.SizeOverride('d', 'f', 3, 4)
                )
        );

        String value = MAPPER.writeValueAsString(provider);
        UnihexProvider deserialized = MAPPER.readValue(value, UnihexProvider.class);

        Assertions.assertEquals(provider, deserialized);
    }
}
