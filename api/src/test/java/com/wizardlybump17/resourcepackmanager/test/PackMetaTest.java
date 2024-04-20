package com.wizardlybump17.resourcepackmanager.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wizardlybump17.resourcepackmanager.api.resource.PackMeta;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

class PackMetaTest {

    static final @NonNull ObjectMapper MAPPER = new ObjectMapper();

    @Test
    void testPackMeta() throws Throwable {
        PackMeta meta = new PackMeta(
                new PackMeta.Pack(
                        28,
                        new PackMeta.SupportedFormats(3, 30)
                ),
                Map.of(
                        "en_US", new PackMeta.Language("English", "United States", false),
                        "en_UK", new PackMeta.Language("English", "United Kingdom", false),
                        "pt_BR", new PackMeta.Language("Portuguese", "Brazil", true)
                ),
                new PackMeta.Filter(
                        List.of(
                                new PackMeta.Filter.PatternEntry(Pattern.compile("test"), Pattern.compile("test")),
                                new PackMeta.Filter.PatternEntry(Pattern.compile("test2"), Pattern.compile("test2"))
                        )
                ),
                new PackMeta.Overlays(
                        List.of(
                                new PackMeta.Overlays.OverlayEntry("test", new PackMeta.SupportedFormats(4, 34)),
                                new PackMeta.Overlays.OverlayEntry("test2", new PackMeta.SupportedFormats(9, 86)),
                                new PackMeta.Overlays.OverlayEntry("test3", new PackMeta.SupportedFormats(356, 1235))
                        )
                )
        );

        String value = MAPPER.writeValueAsString(meta);
        PackMeta deserialized = MAPPER.readValue(value, PackMeta.class);

        meta.filter().block().forEach(entry -> System.out.print(entry.namespace().hashCode() + " " + entry.path().hashCode() + " "));
        System.out.println();
        deserialized.filter().block().forEach(entry -> System.out.print(entry.namespace().hashCode() + " " + entry.path().hashCode() + " "));

        Assertions.assertEquals(meta, deserialized);
    }
}
