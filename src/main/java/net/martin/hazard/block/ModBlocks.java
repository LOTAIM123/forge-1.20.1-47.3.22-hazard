package net.martin.hazard.block;

import net.martin.hazard.Hazard;
import net.martin.hazard.block.Custom.HazardDimPortalBlock;
import net.martin.hazard.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Hazard.MOD_ID);

    public static final RegistryObject<Block> BATTERY = registerBlock("battery",
            ()-> new BatteryVoxel(BlockBehaviour.Properties.copy(Blocks.REDSTONE_BLOCK).dynamicShape().noOcclusion()));

    public static final RegistryObject<Block> PLUSHY = registerBlock("plushy",
            ()-> new PlushyVoxel(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).dynamicShape()));

    public static final RegistryObject<Block> HAZARDDIM_PORTAL = registerBlock("hazarddim_portal",
            ()-> new HazardDimPortalBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).dynamicShape()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
