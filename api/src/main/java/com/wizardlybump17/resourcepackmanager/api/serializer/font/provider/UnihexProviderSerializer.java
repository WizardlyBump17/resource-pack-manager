package com.wizardlybump17.resourcepackmanager.api.serializer.font.provider;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.UnihexProvider;

import java.io.IOException;

public class UnihexProviderSerializer extends JsonSerializer<UnihexProvider> {

    @Override
    public void serialize(UnihexProvider value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeObjectField("hex_file", value.getHexFile());
        generator.writeObjectField("size_overrides", value.getSizeOverrides());
        generator.writeEndObject();
    }

    @Override
    public Class<UnihexProvider> handledType() {
        return UnihexProvider.class;
    }
}
