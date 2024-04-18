package com.wizardlybump17.resourcepackmanager.api.resource.font.provider;

import com.wizardlybump17.resourcepackmanager.api.resource.ResourceLocation;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * <p>
 *     A legacy unicode font.
 *     This format is deprecated, prioritized only when the "Force Unicode Font" option is turned on.
 * </p>
 * @deprecated
 */
@Data
@Builder
@Deprecated
public class LegacyUnicodeProvider extends Provider {

    public static final @NonNull String TYPE = "legacy_unicode";

    /**
     * -- GETTER --
     * <p>
     *     The {@link ResourceLocation} of a binary file describing the horizontal start and end positions for each character from 0 to 15.
     *     The file extension of the target file should be {@code .bin}.
     *     The {@link ResourceLocation} path is relative to the namespace root.
     * </p>
     * @return the {@link ResourceLocation} of the binary file
     */
    private final @NonNull ResourceLocation sizes;
    /**
     * -- GETTER --
     * <p>
     *     The {@link ResourceLocation} inside {@code assets/<namespace>/textures} that leads to the texture files that should be used for {@code this} {@link LegacyUnicodeProvider}.
     *     The game replaces %s from the value of this tag with the first two characters of the hex code of the replaced characters, so a single provider of this type can point into multiple texture files.
     * </p>
     * @return the {@link ResourceLocation} of the texture files
     */
    private final @NonNull ResourceLocation template;

    @Override
    public @NonNull String getType() {
        return TYPE;
    }
}
