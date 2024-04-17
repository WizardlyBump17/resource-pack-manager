package com.wizardlybump17.resourcepackmanager.api.font.provider;

import com.wizardlybump17.resourcepackmanager.api.ResourceLocation;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class UnihexProvider extends Provider {

    public static final @NonNull String TYPE = "unihex";

    private final @NonNull ResourceLocation file;
    private final @NonNull List<SizeOverride> sizeOverrides;

    @Override
    public @NonNull String getType() {
        return TYPE;
    }

    public record SizeOverride(char from, char to, int left, int right) {
    }
}
