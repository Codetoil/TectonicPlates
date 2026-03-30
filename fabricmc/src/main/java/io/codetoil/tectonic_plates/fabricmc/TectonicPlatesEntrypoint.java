package io.codetoil.tectonic_plates.fabricmc;

import io.codetoil.tectonic_plates.world.level.levelgen.density_function.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class TectonicPlatesEntrypoint implements ModInitializer {
    @Override
    public void onInitialize() {
        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                Identifier.parse("tectonic_plates:barrier"),
                Barrier.CODEC.codec());
        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                Identifier.parse("tectonic_plates:fluid_level_floodness"),
                FluidLevelFloodness.CODEC.codec());
        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                Identifier.parse("tectonic_plates:fluid_level_spread"),
                FluidLevelSpread.CODEC.codec());
        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                Identifier.parse("tectonic_plates:lava"),
                Lava.CODEC.codec());
        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                Identifier.parse("tectonic_plates:vein_toggle"),
                VeinToggle.CODEC.codec());
        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                Identifier.parse("tectonic_plates:vein_rigged"),
                VeinRidged.CODEC.codec());
        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                Identifier.parse("tectonic_plates:vein_gap"),
                VeinGap.CODEC.codec());
        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                Identifier.parse("tectonic_plates:temperature"),
                Temperature.CODEC.codec());
        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                Identifier.parse("tectonic_plates:vegetation"),
                Vegetation.CODEC.codec());
        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                Identifier.parse("tectonic_plates:continents"),
                Continents.CODEC.codec());
        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                Identifier.parse("tectonic_plates:erosion"),
                Erosion.CODEC.codec());
        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                Identifier.parse("tectonic_plates:depth"),
                Depth.CODEC.codec());
        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                Identifier.parse("tectonic_plates:ridges"),
                Ridges.CODEC.codec());
        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                Identifier.parse("tectonic_plates:preliminary_surface_level"),
                PreliminarySurfaceLevel.CODEC.codec());
        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                Identifier.parse("tectonic_plates:final_density"),
                FinalDensity.CODEC.codec());
    }
}
