package com.jerry.main.client.render.item;

import com.brandon3055.brandonscore.api.TechLevel;
import com.brandon3055.draconicevolution.blocks.energynet.EnergyCrystal.CrystalType;
import com.brandon3055.draconicevolution.client.render.item.RenderItemEnergyCrystal;

public class RenderItemChaoticIOCrystal extends RenderItemEnergyCrystal {
    public RenderItemChaoticIOCrystal() {
        super(CrystalType.CRYSTAL_IO, TechLevel.CHAOTIC);
    }
}