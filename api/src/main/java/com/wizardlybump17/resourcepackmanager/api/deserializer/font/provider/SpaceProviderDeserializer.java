package com.wizardlybump17.resourcepackmanager.api.deserializer.font.provider;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.SpaceProvider;
import com.wizardlybump17.resourcepackmanager.api.util.DeserializationUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SpaceProviderDeserializer extends JsonDeserializer<SpaceProvider> {

    @SuppressWarnings("unchecked")
    @Override
    public SpaceProvider deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        Map<String, Number> map = DeserializationUtil.getValue(parser, node, context, "advances", Map.class);
        Map<Character, Float> advances = new HashMap<>(map.size());
        map.forEach((key, value) -> advances.put(key.charAt(0), value.floatValue()));
        return new SpaceProvider(advances);
    }
}
