package net.martin.hazard.item.client;

import net.martin.hazard.item.custom.Anim_test_itemAnimation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class Anim_test_itemRenderer extends GeoItemRenderer<Anim_test_itemAnimation> {
    public Anim_test_itemRenderer() {
        super(new Anim_test_itemModel());
    }
}
