package com.wizardlybump17.resourcepackmanager.api.resource.sound;

import lombok.NonNull;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *     A sound event.
 *     The name is usually separated in categories (such as entity.enderman.stare).
 *     To get a different namespace than minecraft the file must be under a different namespace.
 * </p>
 * @param category the category of {@code this} {@link SoundEvent}
 * @param replace {@code true} if the sounds listed in {@link #sounds()} should replace the sounds listed in the default sounds.json for this sound event. {@code false} if the sounds listed should be added to the list of default sounds
 * @param subtitle translated as the subtitle of the sound if Show Subtitles is enabled in-game. Accepts formatting codes and displays them properly in-game
 * @param sounds the sound files {@code this} {@link SoundEvent} uses. One of the listed {@link Sound}s is randomly selected to play when {@code this} {@link SoundEvent} is triggered
 */
public record SoundEvent(@NonNull String category, boolean replace, @NonNull String subtitle, @NonNull List<Sound> sounds) {

    public SoundEvent {
        sounds = Collections.unmodifiableList(sounds);
    }

    public static final boolean DEFAULT_REPLACE = false;
    public static final @NonNull String DEFAULT_SUBTITLE = "";
    public static final @NonNull List<Sound> DEFAULT_SOUNDS = Collections.emptyList();
}
