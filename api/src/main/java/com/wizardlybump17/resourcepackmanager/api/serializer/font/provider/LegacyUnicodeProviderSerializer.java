package com.wizardlybump17.resourcepackmanager.api.serializer.font.provider;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.LegacyUnicodeProvider;

import java.io.IOException;

public class LegacyUnicodeProviderSerializer extends JsonSerializer<LegacyUnicodeProvider> {

    @Override
    public void serialize(LegacyUnicodeProvider value, JsonGenerator generator, SerializerProvider serializers) throws IOException {
        generator.writeStartObject();
        generator.writeStringField("type", value.getType());
        generator.writeStringField("sizes", value.getSizes().toString());
        generator.writeStringField("template", value.getTemplate().toString());
        generator.writeEndObject();
    }

    @Override
    public Class<LegacyUnicodeProvider> handledType() {
        return LegacyUnicodeProvider.class;
    }
}
