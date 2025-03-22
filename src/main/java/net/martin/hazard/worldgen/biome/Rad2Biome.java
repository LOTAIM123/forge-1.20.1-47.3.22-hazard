package net.martin.hazard.worldgen.biome;

import net.martin.hazard.Hazard;
import net.martin.hazard.particle.ModParticles;
import net.minecraft.core.particles.ParticleTypes;
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
        context.register(RAD2, rad1(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static Biome rad1(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        // Ensure surface spawns for creatures like zombies
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 5, 4, 4));

        // Common spawns
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        // Setting up biome generation with updated cave and surface generation
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        // Overworld generation features
        globalOverworldGeneration(biomeBuilder);

        // Adding default vegetation and ores
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

        // Add trees and vegetation
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS);

        // Add mushrooms for additional detail
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);

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
                        .skyColor(0x5abcd8)
                        .grassColorOverride(0x637f40)
                        .foliageColorOverride(0x637f40)
                        .fogColor(0x526935)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .ambientParticle(new AmbientParticleSettings(ModParticles.RADIATION_PARTICLE.get(), 0.01f))
                        .build())
                .build();
    }
}