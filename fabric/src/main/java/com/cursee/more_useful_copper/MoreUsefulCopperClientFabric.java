package com.cursee.more_useful_copper;

import com.cursee.more_useful_copper.impl.client.model.CopperStatueModel;
import com.cursee.more_useful_copper.impl.client.renderer.entity.CopperStatueRenderer;
import com.cursee.more_useful_copper.impl.common.registry.ModBlocks;
import com.cursee.more_useful_copper.impl.common.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.client.rendering.EntityModelLayerImpl;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;

public class MoreUsefulCopperClientFabric implements ClientModInitializer {

  @Override
  public void onInitializeClient() {

    MoreUsefulCopperClient.init();

    BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(), ModBlocks.COPPER_STATUE, ModBlocks.EXPOSED_COPPER_STATUE, ModBlocks.WEATHERED_COPPER_STATUE, ModBlocks.OXIDIZED_COPPER_STATUE);

    EntityRendererRegistry.register(ModEntities.COPPER_STATUE, CopperStatueRenderer::new);
    EntityModelLayerRegistry.registerModelLayer(CopperStatueModel.LAYER_LOCATION, CopperStatueModel::createBodyLayer);
  }
}
