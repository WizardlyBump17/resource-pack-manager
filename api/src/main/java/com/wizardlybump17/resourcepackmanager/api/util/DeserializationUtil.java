package com.wizardlybump17.resourcepackmanager.api.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

@UtilityClass
public class DeserializationUtil {

    public static <T> @Nullable T getValue(@NonNull JsonParser parser, @NonNull JsonNode node, @NonNull DeserializationContext context, @NonNull String key, @NonNull Class<T> type) throws IOException {
        JsonParser referenceParser = node.get(key).traverse(parser.getCodec());
        referenceParser.nextToken();
        return context.readValue(referenceParser, type);
    }

    public static <T> @Nullable List<T> getList(@NonNull JsonParser parser, @NonNull JsonNode node, @NonNull DeserializationContext context, @NonNull String key, @NonNull Class<T> type) throws IOException {
        JsonParser traverse = node.get(key).traverse(parser.getCodec());
        traverse.nextToken();
        return context.readValue(traverse, context.getTypeFactory().constructCollectionType(List.class, type));
    }
}
