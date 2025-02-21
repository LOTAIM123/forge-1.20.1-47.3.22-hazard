package net.martin.hazard.item.client;

import net.martin.hazard.Hazard;
import net.martin.hazard.item.custom.MedkitAnimation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MedkitModel extends GeoModel<MedkitAnimation> {
    @Override
    public ResourceLocation getModelResource(MedkitAnimation animatable) {
        return new ResourceLocation(Hazard.MOD_ID, "geo/medkit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MedkitAnimation animatable) {
        return new ResourceLocation(Hazard.MOD_ID, "textures/item/medkit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MedkitAnimation animatable) {
        return new ResourceLocation(Hazard.MOD_ID, "animations/medkit.animation.json");
    }
}
