package com.wizardlybump17.resourcepackmanager.api.sound;

import lombok.NonNull;

import java.util.List;

public record SoundEvent(@NonNull String category, @NonNull String subtitle, @NonNull List<Sound> sounds) {
}
