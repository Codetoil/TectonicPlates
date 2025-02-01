package io.codetoil.tectonicplates.fabric;

import io.codetoil.tectonicplates.TectonicPlates;
import net.fabricmc.api.ModInitializer;

public final class TectonicPlatesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        TectonicPlates.init();
    }
}
