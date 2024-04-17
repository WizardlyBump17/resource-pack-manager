package com.wizardlybump17.resourcepackmanager.api.font;

import com.wizardlybump17.resourcepackmanager.api.font.provider.Provider;
import lombok.NonNull;

import java.util.List;

public record Font(@NonNull List<Provider> providers) {
}
