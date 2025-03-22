package net.martin.hazard.particle;

import net.martin.hazard.particle.custom.FlameParticles;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.SimpleParticleType;

public class FlameParticleProvider implements ParticleProvider<SimpleParticleType> {
    private final SpriteSet sprites;

    public FlameParticleProvider(SpriteSet sprites) {
        this.sprites = sprites;
    }

    @Override
    public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double dx, double dy, double dz) {
        return new FlameParticles(level, x, y, z, this.sprites, dx, dy, dz);
    }
}
