package com.wizardlybump17.resourcepackmanager.api.font.provider;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Map;

@Data
@Builder
public class SpaceProvider extends Provider {

    public static final @NonNull String TYPE = "space";

    private final @NonNull Map<Character, Float> advances;

    @Override
    public @NonNull String getType() {
        return TYPE;
    }
}
