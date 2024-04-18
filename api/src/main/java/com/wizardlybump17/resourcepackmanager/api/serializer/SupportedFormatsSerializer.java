package com.wizardlybump17.resourcepackmanager.api.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.wizardlybump17.resourcepackmanager.api.resource.PackMeta;

import java.io.IOException;

public class SupportedFormatsSerializer extends JsonSerializer<PackMeta.SupportedFormats> {

    @Override
    public void serialize(PackMeta.SupportedFormats formats, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeNumberField("min_inclusive", formats.minInclusive());
        generator.writeNumberField("max_inclusive", formats.maxInclusive());
        generator.writeEndObject();
    }

    @Override
    public Class<PackMeta.SupportedFormats> handledType() {
        return PackMeta.SupportedFormats.class;
    }
}
