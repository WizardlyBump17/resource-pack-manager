package com.wizardlybump17.resourcepackmanager.api.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.wizardlybump17.resourcepackmanager.api.resource.PackMeta;

import java.io.IOException;

public class PackSerializer extends JsonSerializer<PackMeta.Pack> {

    @Override
    public void serialize(PackMeta.Pack pack, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();

        generator.writeNumberField("pack_format", pack.packFormat());
        generator.writeObjectField("supported_formats", pack.supportedFormats());

        generator.writeEndObject();
    }

    @Override
    public Class<PackMeta.Pack> handledType() {
        return PackMeta.Pack.class;
    }
}
