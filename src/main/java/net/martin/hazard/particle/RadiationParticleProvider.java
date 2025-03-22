package net.martin.hazard.particle;

import net.martin.hazard.particle.custom.RadiationParticle;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;

public class RadiationParticleProvider implements ParticleProvider<SimpleParticleType> {
    private final SpriteSet sprites;

    public RadiationParticleProvider(SpriteSet sprites) {
        this.sprites = sprites;
    }

    @Override
    public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double dx, double dy, double dz) {
        return new RadiationParticle(level, x, y, z, this.sprites, dx, dy, dz);
    }
}
