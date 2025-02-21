package net.martin.hazard.item.client;

import net.martin.hazard.Hazard;
import net.martin.hazard.item.custom.Anim_test_itemAnimation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Anim_test_itemModel extends GeoModel<Anim_test_itemAnimation> {
    @Override
    public ResourceLocation getModelResource(Anim_test_itemAnimation animatable) {
        return new ResourceLocation(Hazard.MOD_ID, "geo/anim_test_item.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Anim_test_itemAnimation animatable) {
        return new ResourceLocation(Hazard.MOD_ID, "textures/item/anim_test_item.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Anim_test_itemAnimation animatable) {
        return new ResourceLocation(Hazard.MOD_ID, "animations/anim_test_item.animation.json");
    }
}
