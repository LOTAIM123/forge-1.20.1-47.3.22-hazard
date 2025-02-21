package net.martin.hazard.item.client;

import net.martin.hazard.Hazard;
import net.martin.hazard.item.custom.MedkitAnimation;
import net.martin.hazard.item.custom.SpeedSyringeAnimation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpeedSyringeModel extends GeoModel<SpeedSyringeAnimation> {
    @Override
    public ResourceLocation getModelResource(SpeedSyringeAnimation animatable) {
        return new ResourceLocation(Hazard.MOD_ID, "geo/speed_syringe.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpeedSyringeAnimation animatable) {
        return new ResourceLocation(Hazard.MOD_ID, "textures/item/speed_syringe.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpeedSyringeAnimation animatable) {
        return new ResourceLocation(Hazard.MOD_ID, "animations/speed_syringe.animation.json");
    }
}
