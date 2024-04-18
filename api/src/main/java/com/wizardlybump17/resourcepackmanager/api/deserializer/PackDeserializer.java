package com.wizardlybump17.resourcepackmanager.api.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.wizardlybump17.resourcepackmanager.api.resource.PackMeta;

import java.io.IOException;

public class PackDeserializer extends JsonDeserializer<PackMeta.Pack> {

    @Override
    public PackMeta.Pack deserialize(JsonParser parser, DeserializationContext context) throws IOException, JacksonException {
        JsonNode node = parser.getCodec().readTree(parser);
        return new PackMeta.Pack(
                node.get("pack_format").asInt(),
                node.get("supported_formats").traverse(parser.getCodec()).readValueAs(PackMeta.SupportedFormats.class)
        );
    }
}
