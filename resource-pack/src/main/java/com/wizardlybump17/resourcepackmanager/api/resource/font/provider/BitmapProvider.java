package com.wizardlybump17.resourcepackmanager.api.resource.font.provider;

import com.wizardlybump17.resourcepackmanager.api.resource.ResourceLocation;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

/**
 * <p>
 *     A bitmap font.
 * </p>
 */
@Data
public class BitmapProvider extends FontProvider {

    public static final @NonNull String TYPE = "bitmap";
    public static final int DEFAULT_HEIGHT = 8;

    /**
     * -- GETTER --
     * <p>
     *     The {@link ResourceLocation} of the used file, starting from {@code assets/minecraft/textures} by default. Prefacing the location with {@code <namespace>:} changes the location to {@code assets/<namespace>/textures}.
     * </p>
     * @return the {@link ResourceLocation} of the file
     */
    @Getter
    private final @NonNull ResourceLocation file;
    /**
     * -- GETTER --
     * <p>
     *     The height of the character, measured in pixels. Can be negative. This tag is separate from the area used in the source texture and just re-scales the displayed result. Default is 8.
     * </p>
     * @return the height of the character
     */
    private final int height;
    /**
     * -- GETTER --
     * <p>
     *     The ascent of the character, measured in pixels. This value adds a vertical shift to the displayed result.
     * </p>
     * @return the ascent of the character
     */
    private final int ascent;
    /**
     * -- GETTER --
     * <p>
     *     A {@link List} of {@link String}s containing the characters replaced by this provider, as well as their order within the texture.
     *     All elements must describe the same number of characters.
     *     The texture is split into one equally sized row for each element of this list.
     *     Each row is split into one equally sized character for each character within one list element.
     * </p>
     * @return a {@link List} of {@link String}s containing the characters replaced by this provider
     */
    private final @NonNull List<String> chars;

    @Override
    public @NonNull String getType() {
        return TYPE;
    }
}
