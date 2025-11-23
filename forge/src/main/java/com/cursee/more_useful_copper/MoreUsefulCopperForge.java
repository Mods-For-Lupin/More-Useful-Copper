package com.cursee.more_useful_copper;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLLoader;

@Mod(Constants.MOD_ID)
public class MoreUsefulCopperForge {

  public static IEventBus eventBus;

  public MoreUsefulCopperForge(final FMLJavaModLoadingContext context) {

    MoreUsefulCopperForge.eventBus = context.getModEventBus();

    MoreUsefulCopper.init();

    if (FMLLoader.getDist() == Dist.CLIENT || FMLEnvironment.dist == Dist.CLIENT) {
      new MoreUsefulCopperClientForge();
    }
  }

  public MoreUsefulCopperForge() {
    this(FMLJavaModLoadingContext.get());
  }
}