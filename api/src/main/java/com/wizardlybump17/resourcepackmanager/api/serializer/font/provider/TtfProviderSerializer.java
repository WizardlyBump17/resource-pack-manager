package com.wizardlybump17.resourcepackmanager.api.serializer.font.provider;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.TtfProvider;

import java.io.IOException;

public class TtfProviderSerializer extends JsonSerializer<TtfProvider> {

    @Override
    public void serialize(TtfProvider value, JsonGenerator generator, SerializerProvider serializers) throws IOException {
        generator.writeStartObject();
        generator.writeStringField("type", value.getType());
        generator.writeStringField("file", value.getFile().toString());
        generator.writeObjectField("shift", value.getShift());
        generator.writeNumberField("size", value.getSize());
        generator.writeNumberField("oversample", value.getOversample());
        generator.writeObjectField("skip", value.getSkip());
        generator.writeEndObject();
    }

    @Override
    public Class<TtfProvider> handledType() {
        return TtfProvider.class;
    }
}
