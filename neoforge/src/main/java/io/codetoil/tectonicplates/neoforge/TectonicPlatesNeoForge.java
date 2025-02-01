package io.codetoil.tectonicplates.neoforge;

import io.codetoil.tectonicplates.TectonicPlates;
import net.neoforged.fml.common.Mod;

@Mod(TectonicPlates.MOD_ID)
public final class TectonicPlatesNeoForge {
    public TectonicPlatesNeoForge() {
        // Run our common setup.
        TectonicPlates.init();
    }
}
