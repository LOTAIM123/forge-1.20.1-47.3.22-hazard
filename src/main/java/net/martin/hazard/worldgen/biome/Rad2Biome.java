package net.martin.hazard.worldgen.biome;

import net.martin.hazard.Hazard;
import net.martin.hazard.particle.ModParticles;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class Rad2Biome {
    public static final ResourceKey<Biome> RAD2 = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Hazard.MOD_ID, "rad2"));

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(RAD2, rad2(context));
    }

    public static Biome rad2(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        // Only allow zombies to spawn
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 100, 4, 8));

        // Setting up biome generation
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        // Add standard plains features
        BiomeDefaultFeatures.addPlainGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS);

        // Remove water and lava pools by not adding them

        // Return the customized biome
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0f5e9c)
                        .waterFogColor(0x0f5e9c)
                        .skyColor(0x448844) // More radioactive sky color
                        .grassColorOverride(0x4a7f2d) // More radioactive grass
                        .foliageColorOverride(0x3f6b1a)
                        .fogColor(0x2f4f1a)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .ambientParticle(new AmbientParticleSettings(ModParticles.RADIATION_PARTICLE.get(), 0.01f))
                        .build())
                .build();
    }
}
