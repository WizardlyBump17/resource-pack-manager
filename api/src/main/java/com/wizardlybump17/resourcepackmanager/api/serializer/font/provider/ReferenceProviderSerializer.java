package com.wizardlybump17.resourcepackmanager.api.serializer.font.provider;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.ReferenceProvider;

import java.io.IOException;

public class ReferenceProviderSerializer extends JsonSerializer<ReferenceProvider> {

    @Override
    public void serialize(ReferenceProvider value, JsonGenerator generator, SerializerProvider serializers) throws IOException {
        generator.writeStartObject();
        generator.writeStringField("type", value.getType());
        generator.writeStringField("id", value.getId().toString());
        generator.writeEndObject();
    }

    @Override
    public Class<ReferenceProvider> handledType() {
        return ReferenceProvider.class;
    }
}
