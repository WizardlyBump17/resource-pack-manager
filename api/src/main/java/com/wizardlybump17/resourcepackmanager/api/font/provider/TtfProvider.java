package com.wizardlybump17.resourcepackmanager.api.font.provider;

import com.wizardlybump17.resourcepackmanager.api.ResourceLocation;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class TtfProvider extends Provider {

    public static final @NonNull String TYPE = "ttf";

    private final @NonNull ResourceLocation file;

    private final @NonNull List<Float> shift;
    private final float size;
    private final float oversample;
    private final @NonNull List<Character> skip;

    @Override
    public @NonNull String getType() {
        return TYPE;
    }
}
