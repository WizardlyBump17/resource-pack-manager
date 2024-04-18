package com.wizardlybump17.resourcepackmanager.api.resource.font.provider;

import com.wizardlybump17.resourcepackmanager.api.resource.ResourceLocation;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

/**
 * <p>
 *     A TrueType font or OpenType font.
 *     Despite its name, it supports both TTF and OTF.
 * </p>
 */
@Data
@Builder
public class TtfProvider extends FontProvider {

    public static final @NonNull String TYPE = "ttf";

    /**
     * -- GETTER --
     * <p>
     *     The {@link ResourceLocation} of the TrueType/OpenType font file within {@code assets/<namespace>/font}.
     * </p>
     * @return the {@link ResourceLocation} of the file
     */
    private final @NonNull ResourceLocation file;
    /**
     * -- GETTER --
     * <p>
     *     The distance by which the characters of {@code this} {@link TtfProvider} are shifted.
     *     <ol>
     *         <li>Left shift, negative values are allowed.</li>
     *         <li>Downward shift, negative values are allowed.</li>
     *     </ol>
     * </p>
     * @return the distance by which the characters are shifted
     */
    private final @NonNull List<Float> shift;
    /**
     * -- GETTER --
     * <p>
     *     Font size to render at.
     * </p>
     * @return the font size to render at
     */
    private final float size;
    /**
     * -- GETTER --
     * <p>
     *     Resolution to render at, increasing anti-aliasing factor.
     * </p>
     * @return the resolution to render at
     */
    private final float oversample;
    /**
     * -- GETTER --
     * <p>
     *     {@link List} of characters to exclude.
     * </p>
     * @return the characters to exclude
     */
    private final @NonNull List<Character> skip;

    @Override
    public @NonNull String getType() {
        return TYPE;
    }
}
