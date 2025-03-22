package net.martin.hazard.entity.custom;

import net.martin.hazard.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class Molotov extends ThrowableItemProjectile {

    public Molotov(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public Molotov(Level level) {
        super(ModEntities.MOLOTOV_PROJECTILE.get(), level);
    }

    public Molotov(Level level, LivingEntity thrower) {
        super(ModEntities.MOLOTOV_PROJECTILE.get(), thrower, level);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.MOLOTOV.get();
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, (byte) 3); // Explosion effect
            this.discard(); // Remove the entity
        } else {
            for (int i = 0; i < 20; i++) {
                this.level().addParticle(ParticleTypes.FLAME,
                        this.getX(), this.getY() + 0.5, this.getZ(),
                        (this.random.nextDouble() - 0.5) * 0.1,
                        this.random.nextDouble() * 0.2,
                        (this.random.nextDouble() - 0.5) * 0.1);
            }
        }
    }
}
