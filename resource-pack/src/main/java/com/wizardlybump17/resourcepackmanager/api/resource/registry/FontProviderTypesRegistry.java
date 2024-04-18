package com.wizardlybump17.resourcepackmanager.api.resource.registry;

import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.FontProvider;
import lombok.NonNull;

public class FontProviderTypesRegistry extends Registry<String, Class<? extends FontProvider>> {

    public static final @NonNull FontProviderTypesRegistry INSTANCE = new FontProviderTypesRegistry();

    @Override
    protected @NonNull String mapKey(@NonNull String key) {
        return key.toLowerCase();
    }
}
