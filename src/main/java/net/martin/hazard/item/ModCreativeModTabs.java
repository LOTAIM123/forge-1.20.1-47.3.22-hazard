package net.martin.hazard.item;

import net.martin.hazard.Hazard;
import net.martin.hazard.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Hazard.MOD_ID);
//Creative tab texture
    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("hazard_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CAN.get()))
                    .title(Component.translatable("creativetab.hazard_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RUBBER.get());
                        pOutput.accept(ModItems.CAN.get());
                        pOutput.accept(ModItems.SOUP.get());
                        //armor
                        pOutput.accept(ModItems.HAZMAT_HELMET.get());
                        pOutput.accept(ModItems.HAZMAT_CHESTPLATE.get());
                        pOutput.accept(ModItems.HAZMAT_LEGGINGS.get());
                        pOutput.accept(ModItems.HAZMAT_BOOTS.get());
                        //blocks
                        pOutput.accept(ModBlocks.BATTERY.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
