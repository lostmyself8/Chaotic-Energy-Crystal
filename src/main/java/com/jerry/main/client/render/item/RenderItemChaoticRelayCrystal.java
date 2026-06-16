package com.jerry.main.client.render.item;

import com.brandon3055.brandonscore.api.TechLevel;
import com.brandon3055.draconicevolution.blocks.energynet.EnergyCrystal.CrystalType;
import com.brandon3055.draconicevolution.client.render.item.RenderItemEnergyCrystal;

public class RenderItemChaoticRelayCrystal extends RenderItemEnergyCrystal {
    public RenderItemChaoticRelayCrystal() {
        super(CrystalType.RELAY, TechLevel.CHAOTIC);
    }
}