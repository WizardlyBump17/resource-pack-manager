package com.wizardlybump17.resourcepackmanager.api.deserializer.font.provider;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.wizardlybump17.resourcepackmanager.api.resource.ResourceLocation;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.UnihexProvider;
import com.wizardlybump17.resourcepackmanager.api.util.DeserializationUtil;

import java.io.IOException;

public class UnihexProviderDeserializer extends JsonDeserializer<UnihexProvider> {

    @Override
    public UnihexProvider deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        return new UnihexProvider(
                DeserializationUtil.getValue(parser, node, context, "hex_file", ResourceLocation.class),
                DeserializationUtil.getList(parser, node, context, "size_overrides", UnihexProvider.SizeOverride.class)
        );
    }
}
