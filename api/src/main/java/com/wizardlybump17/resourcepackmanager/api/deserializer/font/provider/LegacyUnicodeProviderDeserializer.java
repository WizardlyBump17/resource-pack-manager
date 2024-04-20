package com.wizardlybump17.resourcepackmanager.api.deserializer.font.provider;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.wizardlybump17.resourcepackmanager.api.resource.ResourceLocation;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.LegacyUnicodeProvider;

import java.io.IOException;

public class LegacyUnicodeProviderDeserializer extends JsonDeserializer<LegacyUnicodeProvider> {

    @Override
    public LegacyUnicodeProvider deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        return new LegacyUnicodeProvider(
                ResourceLocation.fromString(node.get("sizes").asText()),
                ResourceLocation.fromString(node.get("template").asText())
        );
    }
}
