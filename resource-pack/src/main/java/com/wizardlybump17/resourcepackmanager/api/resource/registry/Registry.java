package com.wizardlybump17.resourcepackmanager.api.resource.registry;

import lombok.NonNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class Registry<K, V> {

    private final @NonNull Map<K, V> map = new HashMap<>();

    protected abstract @NonNull K extractKey(@NonNull V value);

    protected @NonNull K mapKey(@NonNull K key) {
        return key;
    }

    public void register(@NonNull V value) {
        map.put(extractKey(value), value);
    }

    public void unregister(@NonNull K key) {
        map.remove(mapKey(key));
    }

    public void unregisterValue(@NonNull V value) {
        map.remove(extractKey(value));
    }

    public @NonNull Optional<V> get(@NonNull K key) {
        return Optional.ofNullable(map.get(mapKey(key)));
    }

    public boolean has(@NonNull K key) {
        return map.containsKey(mapKey(key));
    }

    public boolean hasValue(@NonNull V value) {
        return map.containsKey(extractKey(value));
    }

    public @NonNull Map<K, V> getMap() {
        return Collections.unmodifiableMap(map);
    }
}
