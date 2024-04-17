package com.wizardlybump17.resourcepackmanager.api;

import lombok.NonNull;

public record ResourceLocation(@NonNull String namespace, @NonNull String path) {

    public static @NonNull ResourceLocation textures(@NonNull String namespace, @NonNull String path) {
        return new ResourceLocation(namespace, "textures/" + path);
    }
}
