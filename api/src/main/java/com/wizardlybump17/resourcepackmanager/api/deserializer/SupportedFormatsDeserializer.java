package com.wizardlybump17.resourcepackmanager.api.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.wizardlybump17.resourcepackmanager.api.resource.PackMeta;

import java.io.IOException;

public class SupportedFormatsDeserializer extends JsonDeserializer<PackMeta.SupportedFormats> {

    @Override
    public PackMeta.SupportedFormats deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        return new PackMeta.SupportedFormats(
                node.get("min_inclusive").asInt(),
                node.get("max_inclusive").asInt()
        );
    }
}
