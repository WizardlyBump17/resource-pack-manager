package com.wizardlybump17.resourcepackmanager.api.serializer.font.provider;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.SpaceProvider;

import java.io.IOException;

public class SpaceProviderSerializer extends JsonSerializer<SpaceProvider> {

    @Override
    public void serialize(SpaceProvider value, JsonGenerator generator, SerializerProvider serializers) throws IOException {
        generator.writeStartObject();
        generator.writeStringField("type", value.getType());
        generator.writeObjectField("advances", value.getAdvances());
        generator.writeEndObject();
    }

    @Override
    public Class<SpaceProvider> handledType() {
        return SpaceProvider.class;
    }
}
