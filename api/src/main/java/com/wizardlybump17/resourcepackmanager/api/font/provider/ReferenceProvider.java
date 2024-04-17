package com.wizardlybump17.resourcepackmanager.api.font.provider;

import com.wizardlybump17.resourcepackmanager.api.ResourceLocation;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ReferenceProvider extends Provider {

    public static final @NonNull String TYPE = "reference";

    private final @NonNull ResourceLocation id;

    @Override
    public @NonNull String getType() {
        return TYPE;
    }
}
