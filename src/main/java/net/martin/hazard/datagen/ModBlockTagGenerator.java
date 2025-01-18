package net.martin.hazard.datagen;

import net.martin.hazard.Hazard;
import net.martin.hazard.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Hazard.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //this.tag(ModTags.Block.)
        //        .add(ModBlocks.BATTERY_BLOCK.get()).addTag(Tags.Blocks.ORES);

      //  this.tag(ModTags.NEEDS_IRON_TOOLS)
        //        .add(ModBlocks..get());
    }
}
