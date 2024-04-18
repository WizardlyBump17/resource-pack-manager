package com.wizardlybump17.resourcepackmanager.api.resource.font;

import com.wizardlybump17.resourcepackmanager.api.resource.ResourceLocation;
import com.wizardlybump17.resourcepackmanager.api.resource.font.provider.Provider;
import lombok.NonNull;

import java.util.List;

/**
 * <p>
 *     A {@link Font} file is a JSON file located at {@code assets/<namespace>/font} within a resource pack and contains a {@link List} of {@link Provider}s that each define how different characters appear.
 *     The default font is defined by the font {@code minecraft:default} while the default font used by enchantment tables is defined by the font {@code minecraft:alt}.
 * </p>
 * <p>
 *     The {@link ResourceLocation}s referenced in {@link Provider}s should also include the file extensions, as there is no sole file extension used throughout.
 * </p>
 * @param providers a {@link List} of {@link Provider}s that make up {@code this} {@link Font}
 */
public record Font(@NonNull List<Provider> providers) {
}
