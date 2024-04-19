package com.wizardlybump17.resourcepackmanager.api.deserializer.font.provider;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.wizardlybump17.resourcepackmanager.api.resource.ResourceLocation;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.TtfProvider;
import com.wizardlybump17.resourcepackmanager.api.util.DeserializationUtil;

import java.io.IOException;
import java.util.stream.StreamSupport;

public class TtfProviderDeserializer extends JsonDeserializer<TtfProvider> {

    @Override
    public TtfProvider deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        return new TtfProvider(
                DeserializationUtil.getValue(parser, node, context, "file", ResourceLocation.class),
                StreamSupport.stream(node.get("shift").spliterator(), false).map(value -> value.numberValue().floatValue()).toList(),
                node.get("size").numberValue().floatValue(),
                node.get("oversample").numberValue().floatValue(),
                StreamSupport.stream(node.get("skip").spliterator(), false).map(value -> value.asText().charAt(0)).toList()
        );
    }
}
