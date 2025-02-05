package net.martin.hazard.datagen;

import net.martin.hazard.Hazard;
import net.martin.hazard.block.ModBlocks;
import net.martin.hazard.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Hazard.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RUBBER);
        simpleItem(ModItems.CAN);
        simpleItem(ModItems.SOUP);
        simpleItem(ModItems.MEDKIT);
        simpleItem(ModItems.SPEED_SYRINGE);
        simpleItem(ModItems.BATTERY_ACID);
        simpleItem(ModItems.PLASTIC_SHEET);
        simpleItem(ModItems.HAZMAT_BOOTS);
        simpleItem(ModItems.HAZMAT_LEGGINGS);
        simpleItem(ModItems.HAZMAT_CHESTPLATE);
        simpleItem(ModItems.HAZMAT_HELMET);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Hazard.MOD_ID,"item/" + item.getId().getPath()));

    }
}
