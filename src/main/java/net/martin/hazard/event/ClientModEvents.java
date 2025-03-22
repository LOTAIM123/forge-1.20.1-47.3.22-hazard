package net.martin.hazard.event;

import net.martin.hazard.particle.FlameParticleProvider;
import net.martin.hazard.particle.ModParticles;
import net.martin.hazard.particle.RadiationParticleProvider;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.FLAME_PARTICLES.get(),
                FlameParticleProvider::new);
        event.registerSpriteSet(ModParticles.RADIATION_PARTICLE.get(),
                RadiationParticleProvider::new);
    }
}