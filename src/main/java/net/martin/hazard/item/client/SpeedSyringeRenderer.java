package net.martin.hazard.item.client;

import net.martin.hazard.item.custom.MedkitAnimation;
import net.martin.hazard.item.custom.SpeedSyringeAnimation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SpeedSyringeRenderer extends GeoItemRenderer<SpeedSyringeAnimation> {
    public SpeedSyringeRenderer() {
        super(new SpeedSyringeModel());
    }
}
