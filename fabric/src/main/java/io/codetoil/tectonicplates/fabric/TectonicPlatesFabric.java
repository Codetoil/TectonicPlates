/**
 * TectonicPlates is a Minecraft Mod adds tectonic plates to Minecraft.
 * Copyright (C) 2025  Anthony Michalek (Codetoil)

 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.

 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>
 */

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
