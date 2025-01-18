package net.martin.hazard.sound;

import net.martin.hazard.Hazard;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeDeferredRegistriesSetup;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Hazard.MOD_ID);

    public static final RegistryObject<SoundEvent> SOUP_DRINKING = registerSoundEvents("soup_dinking");





//after each sound place ","
public static final ForgeSoundType FOOD_CONSUMPTION = new ForgeSoundType(
        1.0F, // Volume
        1.0F, // Pitch
        ModSounds.SOUP_DRINKING, // Break sound
        ModSounds.SOUP_DRINKING, // Step sound
        ModSounds.SOUP_DRINKING, // Place sound
        ModSounds.SOUP_DRINKING, // Hit sound
        ModSounds.SOUP_DRINKING  // Fall sound
);


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, ()-> SoundEvent.createVariableRangeEvent(new ResourceLocation(Hazard.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

}
