package io.codetoil.tectonic_plates.world.level.levelgen.density_function;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.DensityFunction;

public class FluidLevelFloodness implements DensityFunction {
    public static final MapCodec<FluidLevelFloodness> DATA_CODEC = MapCodec.of();
    public static final KeyDispatchDataCodec<FluidLevelFloodness> CODEC = KeyDispatchDataCodec.of(DATA_CODEC);

    @Override
    public double compute(FunctionContext context) {
        return 0;
    }

    @Override
    public void fillArray(double[] output, ContextProvider contextProvider) {

    }

    @Override
    public DensityFunction mapAll(Visitor visitor) {
        return null;
    }

    @Override
    public double minValue() {
        return 0;
    }

    @Override
    public double maxValue() {
        return 0;
    }

    @Override
    public KeyDispatchDataCodec<? extends DensityFunction> codec() {
        return CODEC;
    }
}
