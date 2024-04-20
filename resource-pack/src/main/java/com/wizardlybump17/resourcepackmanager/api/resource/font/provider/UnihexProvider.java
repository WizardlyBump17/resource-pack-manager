package com.wizardlybump17.resourcepackmanager.api.resource.font.provider;

import com.wizardlybump17.resourcepackmanager.api.resource.ResourceLocation;
import lombok.Data;
import lombok.NonNull;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *     Replacement for {@link LegacyUnicodeProvider}.
 *     Uses the GNU Unifont .hex format
 * </p>
 */
@Data
public class UnihexProvider extends FontProvider {

    public static final @NonNull String TYPE = "unihex";

    /**
     * -- GETTER --
     * <p>
     *     Path to a ZIP archive containing one or more *.hex files at the root (files in ZIP archive with different extensions are ignored).
     *     Does not walk recursively inside archive.
     * </p>
     * @return the {@link ResourceLocation} of the ZIP archive
     */
    private final @NonNull ResourceLocation hexFile;
    /**
     * -- GETTER --
     * <p>
     *     {@link List} of {@link SizeOverride} that contains character ranges that should have widths different than auto-detected.
     * </p>
     * @return the {@link List} of {@link SizeOverride}
     */
    private final @NonNull List<SizeOverride> sizeOverrides;

    public UnihexProvider(@NonNull ResourceLocation hexFile, @NonNull List<SizeOverride> sizeOverrides) {
        this.hexFile = hexFile;
        this.sizeOverrides = Collections.unmodifiableList(sizeOverrides);
    }

    @Override
    public @NonNull String getType() {
        return TYPE;
    }

    /**
     * @param from The character to start override range at. Inclusive
     * @param to The character to end override range at. Inclusive
     * @param left Position of left-most column of glyphs in override range
     * @param right Position of right-most column of glyphs in override range
     */
    public record SizeOverride(char from, char to, int left, int right) {
    }
}
