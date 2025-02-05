package net.martin.hazard.sound;

import net.martin.hazard.Hazard;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Hazard.MOD_ID);

    public static final RegistryObject<SoundEvent> MEDKIT_USE = registerSoundEvents("heal_use");

/*
    public static final RegistryObject<SoundEvent> HEAL_BREAK = registerSoundEvents("heal_use");
    public static final RegistryObject<SoundEvent> HEAL_STEP = registerSoundEvents("heal_use");
    public static final RegistryObject<SoundEvent> HEAL_USE = registerSoundEvents("heal_use");
    public static final RegistryObject<SoundEvent> HEAL_HIT = registerSoundEvents("heal_use");
    public static final RegistryObject<SoundEvent> HEAL_FALL = registerSoundEvents("heal_use");




//after each sound place ","
public static final ForgeSoundType MEDKIT_USEAGE = new ForgeSoundType(
        1.0F, // Volume
        1.0F, // Pitch
        ModSounds.MEDKIT_USE, // Break sound
        ModSounds.MEDKIT_USE, // Step sound
        ModSounds.MEDKIT_USE, // Place sound
        ModSounds.MEDKIT_USE, // Hit sound
        ModSounds.MEDKIT_USE  // Fall sound
);
*/

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, ()-> SoundEvent.createVariableRangeEvent(new ResourceLocation(Hazard.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

}
