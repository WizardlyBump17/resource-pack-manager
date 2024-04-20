package com.wizardlybump17.resourcepackmanager.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.wizardlybump17.resourcepackmanager.api.deserializer.font.provider.*;
import com.wizardlybump17.resourcepackmanager.api.resource.ResourceLocation;
import com.wizardlybump17.resourcepackmanager.api.resource.font.Font;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.*;
import com.wizardlybump17.resourcepackmanager.api.resource.registry.FontProviderTypesRegistry;
import com.wizardlybump17.resourcepackmanager.api.serializer.font.provider.*;
import com.wizardlybump17.resourcepackmanager.test.util.SerializationUtil;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

class FontTest {

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
                .addSerializer(new UnihexProviderSerializer())
                .addSerializer(new BitmapProviderSerializer())
                .addSerializer(new LegacyUnicodeProviderSerializer())
                .addSerializer(new ReferenceProviderSerializer())
                .addSerializer(new SpaceProviderSerializer())
                .addSerializer(new TtfProviderSerializer())
                .addSerializer(new UnihexProviderSerializer());

        MAPPER.registerModule(module);
    }

    @Test
    void testBitmapSerialization() throws IOException {
        BitmapProvider provider = new BitmapProvider(
                new ResourceLocation("test", "test.png"),
                8,
                6,
                List.of(
                        "abc",
                        "def"
                )
        );
        SerializationUtil.testSerialization(MAPPER, provider);
    }

    @Test
    void testLegacyUnicodeSerialization() throws IOException {
        LegacyUnicodeProvider provider = new LegacyUnicodeProvider(
                new ResourceLocation("test", "test.bin"),
                new ResourceLocation("test", "test.png")
        );
        SerializationUtil.testSerialization(MAPPER, provider);
    }

    @Test
    void testReferenceSerialization() throws IOException {
        ReferenceProvider provider = new ReferenceProvider(new ResourceLocation("test", "test"));
        SerializationUtil.testSerialization(MAPPER, provider);
    }

    @Test
    void testSpaceSerialization() throws IOException {
        SpaceProvider provider = new SpaceProvider(
                Map.of(
                        'a', 1f,
                        'b', 2f,
                        'c', 3f
                )
        );
        SerializationUtil.testSerialization(MAPPER, provider);
    }

    @Test
    void testTtfSerialization() throws IOException {
        TtfProvider provider = new TtfProvider(
                new ResourceLocation("test", "test.ttf"),
                List.of(1f, 2f),
                6,
                3,
                List.of('a', 'b', 'c')
        );
        SerializationUtil.testSerialization(MAPPER, provider);
    }

    @Test
    void testUnihexSerialization() throws IOException {
        UnihexProvider provider = new UnihexProvider(
                new ResourceLocation("test", "test.hex"),
                List.of(
                        new UnihexProvider.SizeOverride('a', 'c', 1, 2),
                        new UnihexProvider.SizeOverride('d', 'f', 3, 4)
                )
        );
        SerializationUtil.testSerialization(MAPPER, provider);
    }

    @Test
    void testFontSerialization() throws IOException {
        FontProviderTypesRegistry.INSTANCE.register(BitmapProvider.TYPE, BitmapProvider.class);
        FontProviderTypesRegistry.INSTANCE.register(LegacyUnicodeProvider.TYPE, LegacyUnicodeProvider.class);
        FontProviderTypesRegistry.INSTANCE.register(ReferenceProvider.TYPE, ReferenceProvider.class);
        FontProviderTypesRegistry.INSTANCE.register(SpaceProvider.TYPE, SpaceProvider.class);
        FontProviderTypesRegistry.INSTANCE.register(TtfProvider.TYPE, TtfProvider.class);
        FontProviderTypesRegistry.INSTANCE.register(UnihexProvider.TYPE, UnihexProvider.class);

        List<FontProvider> possibleProviders = List.of(
                new BitmapProvider(
                        new ResourceLocation("test", "test.png"),
                        8,
                        6,
                        List.of(
                                "abc",
                                "def"
                        )
                ),
                new LegacyUnicodeProvider(
                        new ResourceLocation("test", "test.bin"),
                        new ResourceLocation("test", "test.png")
                ),
                new ReferenceProvider(new ResourceLocation("test", "test")),
                new SpaceProvider(
                        Map.of(
                                'a', 1f,
                                'b', 2f,
                                'c', 3f
                        )
                ),
                new TtfProvider(
                        new ResourceLocation("test", "test.ttf"),
                        List.of(1f, 2f),
                        6,
                        3,
                        List.of('a', 'b', 'c')
                ),
                new UnihexProvider(
                        new ResourceLocation("test", "test.hex"),
                        List.of(
                                new UnihexProvider.SizeOverride('a', 'c', 1, 2),
                                new UnihexProvider.SizeOverride('d', 'f', 3, 4)
                        )
                )
        );

        int amount = 100;
        List<FontProvider> providers = new ArrayList<>(amount);
        Random random = new Random(0);
        for (int i = 0; i < amount; i++)
            providers.add(possibleProviders.get(random.nextInt(possibleProviders.size())));

        Font font = new Font(providers);
        SerializationUtil.testSerialization(MAPPER, font);
    }
}
