package com.cursee.more_useful_copper;

import com.cursee.more_useful_copper.impl.common.registry.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class MoreUsefulCopperClientFabric implements ClientModInitializer {

  @Override
  public void onInitializeClient() {

    MoreUsefulCopperClient.init();

    BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(), ModBlocks.COPPER_STATUE, ModBlocks.EXPOSED_COPPER_STATUE, ModBlocks.WEATHERED_COPPER_STATUE, ModBlocks.OXIDIZED_COPPER_STATUE);
  }
}
