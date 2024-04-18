package com.wizardlybump17.resourcepackmanager.api.deserializer.font.provider;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.FontProvider;
import com.wizardlybump17.resourcepackmanager.api.resource.registry.FontProviderTypesRegistry;

import java.io.IOException;

public class FontProviderDeserializer extends JsonDeserializer<FontProvider> {

    @Override
    public FontProvider deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        String type = node.get("type").asText();
        JsonParser traverse = node.traverse(parser.getCodec());
        traverse.nextToken();
        return context.readValue(traverse, FontProviderTypesRegistry.INSTANCE.get(type).orElseThrow());
    }
}
