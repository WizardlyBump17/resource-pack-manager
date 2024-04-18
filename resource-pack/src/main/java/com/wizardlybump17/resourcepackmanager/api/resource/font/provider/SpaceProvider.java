package com.wizardlybump17.resourcepackmanager.api.resource.font.provider;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Map;

/**
 * <p>
 *     Show chosen characters as spaces.
 * </p>
 */
@Data
@Builder
public class SpaceProvider extends FontProvider {

    public static final @NonNull String TYPE = "space";

    /**
     * <p>
     *     The amount of pixels that the following characters are moved to the right.
     *     Can be negative.
     *     Decimal numbers can be used for precise movement on higher GUI scales.
     * </p>
     */
    private final @NonNull Map<Character, Float> advances;

    @Override
    public @NonNull String getType() {
        return TYPE;
    }
}
