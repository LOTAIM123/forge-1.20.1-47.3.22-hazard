package net.martin.hazard.item;

import net.martin.hazard.Hazard;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Hazard.MOD_ID);

    public static final RegistryObject<Item> AIR_CAN = ITEMS.register("air_can",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_AIR_CAN = ITEMS.register("raw_air_can",
            ()-> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
