package com.wizardlybump17.resourcepackmanager.api.font.provider;

import com.wizardlybump17.resourcepackmanager.api.ResourceLocation;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class LegacyUnicodeProvider extends Provider {

    public static final @NonNull String TYPE = "legacy_unicode";

    private final @NonNull ResourceLocation sizes;
    private final @NonNull ResourceLocation template;

    @Override
    public @NonNull String getType() {
        return TYPE;
    }
}
