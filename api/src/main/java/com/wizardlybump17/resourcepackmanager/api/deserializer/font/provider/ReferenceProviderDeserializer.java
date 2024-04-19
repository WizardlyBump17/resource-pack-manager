package com.wizardlybump17.resourcepackmanager.api.deserializer.font.provider;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.wizardlybump17.resourcepackmanager.api.resource.ResourceLocation;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.ReferenceProvider;
import com.wizardlybump17.resourcepackmanager.api.util.DeserializationUtil;

import java.io.IOException;

public class ReferenceProviderDeserializer extends JsonDeserializer<ReferenceProvider> {

    @Override
    public ReferenceProvider deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        return new ReferenceProvider(DeserializationUtil.getValue(parser, node, context, "id", ResourceLocation.class));
    }
}
