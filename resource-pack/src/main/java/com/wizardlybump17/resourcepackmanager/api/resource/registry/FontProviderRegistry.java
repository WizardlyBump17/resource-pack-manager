package com.wizardlybump17.resourcepackmanager.api.resource.registry;

import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.Provider;
import lombok.NonNull;

public class FontProviderRegistry extends Registry<String, Provider> {

    @Override
    protected @NonNull String extractKey(@NonNull Provider value) {
        return value.getType().toLowerCase();
    }

    @Override
    protected @NonNull String mapKey(@NonNull String key) {
        return key.toLowerCase();
    }
}
