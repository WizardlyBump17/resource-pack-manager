package com.wizardlybump17.resourcepackmanager.api.serializer.font.provider;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.BitmapProvider;

import java.io.IOException;

public class BitmapProviderSerializer extends JsonSerializer<BitmapProvider> {

    @Override
    public void serialize(BitmapProvider value, JsonGenerator generator, SerializerProvider serializers) throws IOException {
        generator.writeStartObject();
        generator.writeStringField("type", value.getType());
        generator.writeObjectField("file", value.getFile().toString());
        generator.writeNumberField("height", value.getHeight());
        generator.writeNumberField("ascent", value.getAscent());
        generator.writeObjectField("chars", value.getChars());
        generator.writeEndObject();
    }

    @Override
    public Class<BitmapProvider> handledType() {
        return BitmapProvider.class;
    }
}
