package com.wizardlybump17.resourcepackmanager.api.resource;

import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

/**
 * <p>
 *     {@link ResourceLocation}s (also known as namespaced IDs, namespaced identifiers, resource identifiers,[2] or namespaced strings[3])
 *     are a way to declare and specify game objects in Minecraft, which can identify built-in and user-defined objects without potential ambiguity or conflicts.
 * </p>
 * @param namespace the namespace of the resource
 * @param path the path of the resource
 */
public record ResourceLocation(@NonNull String namespace, @NonNull String path) {

    public @NonNull String fullPath() {
        return "assets/" + namespace + "/" + path;
    }

    public static @Nullable ResourceLocation fromString(@NonNull String string) {
        String[] split = string.split(":");
        if (split.length > 2)
            return null;
        return new ResourceLocation(split.length == 1 ? "minecraft" : split[0], split.length == 1 ? split[0] : split[1]);
    }

    public static @NonNull ResourceLocation textures(@NonNull String namespace, @NonNull String path) {
        return new ResourceLocation(namespace, "textures/" + path);
    }

    public static @NonNull ResourceLocation font(@NonNull String namespace, @NonNull String path) {
        return new ResourceLocation(namespace, "font/" + path);
    }

    public static @NonNull ResourceLocation sounds(@NonNull String namespace, @NonNull String path) {
        return new ResourceLocation(namespace, "sounds/" + path);
    }
}
