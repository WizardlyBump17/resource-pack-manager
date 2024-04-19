package com.wizardlybump17.resourcepackmanager.api.resource.sound;

import lombok.NonNull;

/**
 * <p>
 *     A sound.
 * </p>
 * @param name the path to this sound file from the "namespace/sounds" folder (excluding the .ogg file extension).
 *             The namespace defaults to {@code minecraft}, but it can be changed by prepending a namespace and separating it with a {@code :}.
 *             Use forward slashes instead of backslashes.
 *             May instead be the name of another {@link SoundEvent} (according to value of {@link #type()}).
 *             If the sound file has one channel (mono), it can be played locationally (sound volume decreases the farther you are from the source).
 *             If the file has two channels (stereo), the volume does not change (for example, music, ambient sounds)
 * @param volume the volume for playing {@code this} {@link Sound}
 * @param pitch plays the pitch at the specified value
 * @param weight the chance that {@code this} {@link Sound} is selected to play when this sound event is triggered.
 *               An example: putting 2 in for the value would be like placing in the name twice
 * @param stream {@code true} if {@code this} {@link Sound} should be streamed from its file.
 *               It is recommended that this is set to {@code true} for sounds that have a duration longer than a few seconds to avoid lagging.
 *               Used for all sounds in the "music" and "record" categories (except Note Block sounds), as (almost) all the sounds that belong to those categories are over a minute-long.
 *               Setting this to {@code false} allows many more instances of the sound to be run at the same time while setting it to {@code true} only allows four instances (of that type) to be run at the same time.
 * @param attenuationDistance modify sound reduction rate based on distance
 * @param preload {@code true} if {@code this} {@link Sound} should be loaded when loading the pack instead of when the sound is played
 * @param type the type of {@code this} {@link Sound}
 */
public record Sound(@NonNull String name, float volume, float pitch, int weight, boolean stream, int attenuationDistance, boolean preload, @NonNull Type type) {

    public static final float DEFAULT_VOLUME = 1.0F;
    public static final float DEFAULT_PITCH = 1.0F;
    public static final int DEFAULT_WEIGHT = 1;
    public static final boolean DEFAULT_STREAM = false;
    public static final int DEFAULT_ATTENUATION_DISTANCE = 16;
    public static final boolean DEFAULT_PRELOAD = false;
    public static final @NonNull Type DEFAULT_TYPE = Type.SOUND;

    public enum Type {

        /**
         * <p>
         *     Causes the value of {@link Sound#name()} to be interpreted as the name of a file.
         * </p>
         */
        SOUND,
        /**
         * <p>
         *     Causes the value of {@link Sound#name()} to be interpreted as the name of an already defined event.
         * </p>
         */
        EVENT
    }
}
