package net.martin.hazard.entity.custom;

import net.martin.hazard.Hazard;
import net.martin.hazard.item.custom.MolotovItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Hazard.MOD_ID);

    public static final RegistryObject<EntityType<Molotov>> MOLOTOV_PROJECTILE =
            ENTITY_TYPES.register("molotov_projectile", () -> EntityType.Builder.<Molotov>of(Molotov::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("molotov_projectile"));
}
