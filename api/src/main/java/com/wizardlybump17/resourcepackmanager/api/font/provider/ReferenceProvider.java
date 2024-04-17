package com.wizardlybump17.resourcepackmanager.api.font.provider;

import com.wizardlybump17.resourcepackmanager.api.ResourceLocation;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * <p>
 *     Links to another {@link com.wizardlybump17.resourcepackmanager.api.font.Font} file to be copied and included in this {@link com.wizardlybump17.resourcepackmanager.api.font.Font}.
 *     Guarantees the referenced provider is loaded only once.
 *     Inclusion is performed after all fonts are loaded.
 * </p>
 * <p>
 *     Description taken from <a href="https://minecraft.fandom.com/wiki/Resource_Pack#Fonts">Minecraft Wiki</a>.
 * </p>
 */
@Data
@Builder
public class ReferenceProvider extends Provider {

    public static final @NonNull String TYPE = "reference";

    /**
     * -- GETTER --
     * <p>
     *     {@link ResourceLocation} to another font provider.
     * </p>
     * <p>
     *     Description taken from <a href="https://minecraft.fandom.com/wiki/Resource_Pack#Fonts">Minecraft Wiki</a>.
     * </p>
     * @return the {@link ResourceLocation} to another font provider
     */
    private final @NonNull ResourceLocation id;

    @Override
    public @NonNull String getType() {
        return TYPE;
    }
}
