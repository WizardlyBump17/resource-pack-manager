package com.wizardlybump17.resourcepackmanager.api;

import lombok.NonNull;

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
