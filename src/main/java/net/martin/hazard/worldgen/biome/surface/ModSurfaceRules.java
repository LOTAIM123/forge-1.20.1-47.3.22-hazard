package net.martin.hazard.worldgen.biome.surface;

import net.martin.hazard.worldgen.biome.Rad1Biome;
import net.martin.hazard.worldgen.biome.Rad2Biome;
import net.martin.hazard.worldgen.biome.Rad3Biome;
import net.martin.hazard.worldgen.biome.Rad4Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(0, 0);
        SurfaceRules.ConditionSource isExposedToAir = SurfaceRules.abovePreliminarySurface();

        SurfaceRules.RuleSource validGrassSurface = SurfaceRules.ifTrue(isAtOrAboveWaterLevel,
                SurfaceRules.ifTrue(isExposedToAir, GRASS_BLOCK));

        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Rad1Biome.RAD1),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, validGrassSurface)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE)),

                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Rad2Biome.RAD2),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, validGrassSurface)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE)),

                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Rad3Biome.RAD3),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, validGrassSurface)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE)),

                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Rad4Biome.RAD4),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, validGrassSurface)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE)),

                // Default rule ensuring grass follows the new constraints
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, validGrassSurface)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
