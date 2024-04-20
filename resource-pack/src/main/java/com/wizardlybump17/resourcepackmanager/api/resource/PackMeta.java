package com.wizardlybump17.resourcepackmanager.api.resource;

import lombok.NonNull;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * <p>
 *     A resource pack is identified by Minecraft based on the presence of the file pack.mcmeta in the root directory, which contains a JSON file with the following information:
 *     <ul>
 *         <li>{@link #pack()}</li>
 *         <li>{@link #languages()}</li>
 *         <li>{@link #filter()}</li>
 *         <li>{@link #overlays()}</li>
 *     </ul>
 * </p>
 * @param pack the resource pack information
 * @param languages a {@link Map} of language codes to {@link Language} objects, where the key is the code for a language, corresponding to a .json file with the same name in the folder {@code assets/<namespace>/lang}
 * @param filter section for filtering out files from resource packs applied below this one
 * @param overlays the resource pack overlays information
 */
public record PackMeta(@NonNull Pack pack, @NonNull Map<String, Language> languages, @NonNull Filter filter, @NonNull Overlays overlays) {

    public PackMeta {
        languages = Collections.unmodifiableMap(languages);
    }

    /**
     * <p>
     *     Holds the resource pack information.
     * </p>
     * @param packFormat pack version.
     *                   If this number does not match the current required number, the resource pack displays an error and requires additional confirmation to load the pack.
     *                   See <a href="https://minecraft.wiki/w/Pack_format">Pack format</a> for a full list of pack format numbers.
     * @param supportedFormats section for describing the range of <a href="https://minecraft.wiki/w/Pack_format">Pack formats</a> the resource pack supports, from the first number to the second.
     *                         If the resource pack is loaded in a version out of the specified range, it is displayed as unsupported
     */
    public record Pack(int packFormat, @NonNull SupportedFormats supportedFormats) {
    }

    /**
     * @param minInclusive the minimum format which should display as supported
     * @param maxInclusive the maximum format which should display as supported
     */
    public record SupportedFormats(int minInclusive, int maxInclusive) {
    }

    /**
     * @param name the full name of the language
     * @param region the country or region name
     * @param bidirectional if {@code true}, the language reads right to left
     */
    public record Language(@NonNull String name, @NonNull String region, boolean bidirectional) {
    }

    /**
     * <p>
     *     Section for filtering out files from resource packs applied below this one.
     *     Any file that matches one of the patterns inside {@link #block()} is treated as if it was not present in the pack at all.
     * </p>
     */
    public record Filter(@NonNull List<PatternEntry> block) {

        public Filter {
            block = Collections.unmodifiableList(block);
        }

        /**
         * @param namespace a {@link Pattern} for the namespace of files to be filtered out
         * @param path a {@link Pattern} for the paths of files to be filtered out
         */
        public record PatternEntry(@NonNull Pattern namespace, @NonNull Pattern path) {

            @Override
            public boolean equals(Object object) {
                if (this == object)
                    return true;
                if (object == null || getClass() != object.getClass())
                    return false;
                PatternEntry that = (PatternEntry) object;
                return Objects.equals(namespace.pattern(), that.namespace.pattern()) && Objects.equals(path.pattern(), that.path.pattern());
            }

            @Override
            public int hashCode() {
                return Objects.hash(namespace.pattern(), path.pattern());
            }
        }
    }

    /**
     * <p>
     *     Holds the resource pack overlays information.
     * </p>
     * @param entries {@link List} of resource pack {@link OverlayEntry}, which is read from the bottom to top by the game
     */
    public record Overlays(@NonNull List<OverlayEntry> entries) {

        public Overlays {
            entries = Collections.unmodifiableList(entries);
        }

        /**
         * @param directory the directory where the overlay pack is located relative to the resource packs root directory.
         *                  In this directory, pack.mcmeta and pack.png would be ignored
         * @param formats section for describing the range of <a href="https://minecraft.wiki/w/Pack_format">Pack formats</a> in which the {@link OverlayEntry} should be applied
         */
        public record OverlayEntry(@NonNull String directory, @NonNull SupportedFormats formats) {
        }
    }
}
