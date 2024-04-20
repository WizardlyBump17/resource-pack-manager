package com.wizardlybump17.resourcepackmanager.api.deserializer.font.provider;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.wizardlybump17.resourcepackmanager.api.resource.ResourceLocation;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.BitmapProvider;

import java.io.IOException;
import java.util.stream.StreamSupport;

public class BitmapProviderDeserializer extends JsonDeserializer<BitmapProvider> {

    @Override
    public BitmapProvider deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        ArrayNode charsNode = (ArrayNode) node.get("chars");

        return new BitmapProvider(
                ResourceLocation.fromString(node.get("file").asText()),
                node.get("height").asInt(BitmapProvider.DEFAULT_HEIGHT),
                node.get("ascent").asInt(),
                StreamSupport.stream(charsNode.spliterator(), false).map(JsonNode::asText).toList()
        );
    }
}
