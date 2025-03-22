package net.martin.hazard.item.client;

import net.martin.hazard.Hazard;
import net.martin.hazard.item.custom.HazmatArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public final class HazmatArmorRenderer extends GeoArmorRenderer<HazmatArmorItem> {
    public HazmatArmorRenderer() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(Hazard.MOD_ID, "armor/hazmat_armor"))); // Using DefaultedItemGeoModel like this puts our 'location' as item/armor/example armor in the assets folders.
    }
}