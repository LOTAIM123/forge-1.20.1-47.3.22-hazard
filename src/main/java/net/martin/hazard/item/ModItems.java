package net.martin.hazard.item;

import net.martin.hazard.Hazard;
import net.martin.hazard.item.custom.Anim_test_itemAnimation;
import net.martin.hazard.item.custom.MedkitAnimation;
import net.martin.hazard.item.custom.BlueSyringeItem;
import net.martin.hazard.item.custom.SpeedSyringeAnimation;
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

    //material
    public static final RegistryObject<Item> RUBBER = ITEMS.register("rubber",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BATTERY_ACID = ITEMS.register("battery_acid",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLASTIC_SHEET = ITEMS.register("plastic_sheet",
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
            () -> new DrinkItem(new Item.Properties().food(ModFoods.SOUP).stacksTo(16)));

    //consumable
    public static final RegistryObject<Item> MEDKIT = ITEMS.register("medkit",
            () -> new MedkitAnimation(new Item.Properties().stacksTo(8)));

    public static final RegistryObject<Item> SPEED_SYRINGE = ITEMS.register("speed_syringe",
            () -> new SpeedSyringeAnimation(new Item.Properties().stacksTo(8)));

    //tests
    public static final RegistryObject<Item> ANIM_TEST_ITEM = ITEMS.register("anim_test_item",
            () -> new Anim_test_itemAnimation(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}