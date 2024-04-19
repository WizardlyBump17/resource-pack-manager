package com.wizardlybump17.resourcepackmanager.api.deserializer.font.provider;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.SpaceProvider;
import com.wizardlybump17.resourcepackmanager.api.util.DeserializationUtil;

import java.io.IOException;
import java.util.Map;

public class SpaceProviderDeserializer extends JsonDeserializer<SpaceProvider> {

    @Override
    public SpaceProvider deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        return new SpaceProvider(DeserializationUtil.getValue(parser, node, context, "advances", Map.class));
    }
}
