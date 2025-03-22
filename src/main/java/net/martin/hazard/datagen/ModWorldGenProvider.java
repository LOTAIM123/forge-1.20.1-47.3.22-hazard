package net.martin.hazard.datagen;

import net.martin.hazard.Hazard;
import net.martin.hazard.worldgen.biome.Rad1Biome;
import net.martin.hazard.worldgen.biome.Rad2Biome;
import net.martin.hazard.worldgen.biome.Rad3Biome;
import net.martin.hazard.worldgen.biome.Rad4Biome;
import net.martin.hazard.worldgen.dimension.ModDimensions;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType)
            //.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            //.add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            //.add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
            .add(Registries.BIOME, context -> {
                Rad1Biome.boostrap(context);
                Rad2Biome.boostrap(context);
                Rad3Biome.boostrap(context);
                Rad4Biome.boostrap(context);
            })
            .add(Registries.LEVEL_STEM, ModDimensions::bootstrapStem);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Hazard.MOD_ID));
    }
}
