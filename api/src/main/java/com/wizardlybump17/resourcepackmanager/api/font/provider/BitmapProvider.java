package com.wizardlybump17.resourcepackmanager.api.font.provider;

import com.wizardlybump17.resourcepackmanager.api.ResourceLocation;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class BitmapProvider extends Provider {

    public static final @NonNull String TYPE = "bitmap";

    private final @NonNull ResourceLocation file;
    private final int height;
    private final int ascent;
    private final @NonNull List<String> chars;

    @Override
    public @NonNull String getType() {
        return TYPE;
    }
}
