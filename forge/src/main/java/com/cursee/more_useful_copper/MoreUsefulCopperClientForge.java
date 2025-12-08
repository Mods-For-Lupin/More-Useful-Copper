package com.cursee.more_useful_copper;

import com.cursee.more_useful_copper.impl.common.registry.ModBlocks;
import java.util.function.Consumer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class MoreUsefulCopperClientForge {

  @SuppressWarnings("deprecation")
  public MoreUsefulCopperClientForge() {

    MoreUsefulCopperClient.init();

    MoreUsefulCopperForge.eventBus.addListener((Consumer<FMLClientSetupEvent>) event -> {
//      event.enqueueWork(() -> {
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_STATUE, RenderType.cutout());
//      });
      System.out.println("registered block render type");
      ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_STATUE, RenderType.cutout());
    });
  }
}
