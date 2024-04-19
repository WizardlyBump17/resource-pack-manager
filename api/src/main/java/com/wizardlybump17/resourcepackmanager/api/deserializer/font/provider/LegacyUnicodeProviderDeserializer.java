package com.wizardlybump17.resourcepackmanager.api.deserializer.font.provider;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.wizardlybump17.resourcepackmanager.api.resource.ResourceLocation;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.LegacyUnicodeProvider;
import com.wizardlybump17.resourcepackmanager.api.util.DeserializationUtil;

import java.io.IOException;

public class LegacyUnicodeProviderDeserializer extends JsonDeserializer<LegacyUnicodeProvider> {

    @Override
    public LegacyUnicodeProvider deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        return new LegacyUnicodeProvider(
                DeserializationUtil.getValue(parser, node, context, "sizes", ResourceLocation.class),
                DeserializationUtil.getValue(parser, node, context, "template", ResourceLocation.class)
        );
    }
}
