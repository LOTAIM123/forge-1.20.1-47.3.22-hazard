package net.martin.hazard.item.client;

import net.martin.hazard.item.custom.MedkitAnimation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class MedkitRenderer extends GeoItemRenderer<MedkitAnimation> {
    public MedkitRenderer() {
        super(new MedkitModel());
    }
}
