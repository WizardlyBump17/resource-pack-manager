package com.wizardlybump17.resourcepackmanager.api.sound;

import lombok.NonNull;

public record Sound(@NonNull String name, float volume, float pitch, int weight, boolean stream, int attenuationDistance, boolean preload, @NonNull Type type) {

    public enum Type {

        SOUND,
        EVENT
    }
}
