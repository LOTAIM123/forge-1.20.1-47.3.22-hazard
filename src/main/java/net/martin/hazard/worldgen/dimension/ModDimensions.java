package net.martin.hazard.worldgen.dimension;

import com.mojang.datafixers.util.Pair;
import net.martin.hazard.Hazard;
import net.martin.hazard.worldgen.biome.Rad1Biome;
import net.martin.hazard.worldgen.biome.Rad2Biome;
import net.martin.hazard.worldgen.biome.Rad3Biome;
import net.martin.hazard.worldgen.biome.Rad4Biome;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import java.util.List;
import java.util.OptionalLong;

public class ModDimensions {
    public static final ResourceKey<LevelStem> HAZARDDIM_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(Hazard.MOD_ID, "hazarddim"));
    public static final ResourceKey<Level> HAZARDDIM_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(Hazard.MOD_ID, "hazarddim"));
    public static final ResourceKey<DimensionType> HAZARD_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(Hazard.MOD_ID, "hazarddim_type"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(HAZARD_DIM_TYPE, new DimensionType(
                OptionalLong.empty(), // Allow normal day-night cycle
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                384, // height (ensuring full world height range)
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                0, // ambientLight
                new DimensionType.MonsterSettings(false, true, ConstantInt.of(0), 0)));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(
                                Pair.of(
                                        Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F),
                                        biomeRegistry.getOrThrow(Rad1Biome.RAD1)),
                                Pair.of(
                                        Climate.parameters(0.1F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F),
                                        biomeRegistry.getOrThrow(Rad2Biome.RAD2)),
                                Pair.of(
                                        Climate.parameters(0.3F, 0.6F, 0.1F, 0.1F, 0.0F, 0.0F, 0.0F),
                                        biomeRegistry.getOrThrow(Rad3Biome.RAD3)),
                                Pair.of(
                                        Climate.parameters(0.4F, 0.3F, 0.2F, 0.1F, 0.0F, 0.0F, 0.0F),
                                        biomeRegistry.getOrThrow(Rad4Biome.RAD4))
                        ))
                ),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD)
        );

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDimensions.HAZARD_DIM_TYPE), noiseBasedChunkGenerator);
        context.register(HAZARDDIM_KEY, stem);
    }
}