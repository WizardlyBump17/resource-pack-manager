package com.wizardlybump17.resourcepackmanager.api;

import lombok.NonNull;

public record ResourceLocation(@NonNull String namespace, @NonNull String path) {
}
