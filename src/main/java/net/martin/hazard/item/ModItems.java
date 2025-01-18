package net.martin.hazard.item;

import net.martin.hazard.Hazard;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Hazard.MOD_ID);

    //Item
    public static final RegistryObject<Item> CAN = ITEMS.register("can",
            ()-> new Item(new Item.Properties().stacksTo(16)));
    //public static final RegistryObject<Item> BATTERY = ITEMS.register("battery",
    //        () -> new Item(new Item.Properties().stacksTo(1)));

    //material
    public static final RegistryObject<Item> RUBBER = ITEMS.register("rubber",
            ()-> new Item(new Item.Properties()));

    //armor
    public static final RegistryObject<Item> HAZMAT_HELMET = ITEMS.register("hazmat_helmet",
            ()-> new ArmorItem(ModArmorMaterials.HAZMAT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> HAZMAT_CHESTPLATE = ITEMS.register("hazmat_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.HAZMAT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> HAZMAT_LEGGINGS = ITEMS.register("hazmat_leggings",
            ()-> new ArmorItem(ModArmorMaterials.HAZMAT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> HAZMAT_BOOTS = ITEMS.register("hazmat_boots",
            ()-> new ArmorItem(ModArmorMaterials.HAZMAT, ArmorItem.Type.BOOTS, new Item.Properties()));
    //tools

    //food
    public static final RegistryObject<Item> SOUP = ITEMS.register("soup",
            () -> new CustomSoupItem(new Item.Properties().food(ModFoods.SOUP).stacksTo(16)));

    //consumable


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
