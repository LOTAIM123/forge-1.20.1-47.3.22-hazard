package net.martin.hazard.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModFoods {

    public static final FoodProperties SOUP = new FoodProperties.Builder()
            .nutrition(8)
            .saturationMod(2)
            .build();

    /*public static final FoodProperties MEDKIT = new FoodProperties.Builder()
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 120, 3),1)
            .build();*/

    public static final FoodProperties SPEED_SYRINGE = new FoodProperties.Builder()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 4),1)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 120, 12),0.6F)
            .build();
}