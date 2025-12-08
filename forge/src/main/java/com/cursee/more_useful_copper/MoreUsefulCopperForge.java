package com.cursee.more_useful_copper;

import com.cursee.more_useful_copper.impl.common.registry.ModBlocks;
import com.cursee.more_useful_copper.impl.common.registry.ModItems;
import com.cursee.more_useful_copper.impl.common.registry.ModTabs;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
public class MoreUsefulCopperForge {

  public static IEventBus eventBus;

  public MoreUsefulCopperForge(final FMLJavaModLoadingContext context) {

    MoreUsefulCopperForge.eventBus = context.getModEventBus();

    bind(Registries.BLOCK, ModBlocks::register);
    bind(Registries.ITEM, ModItems::register);
    bind(Registries.CREATIVE_MODE_TAB, ModTabs::register);

    MoreUsefulCopper.init();

    if (FMLLoader.getDist() == Dist.CLIENT || FMLEnvironment.dist == Dist.CLIENT) {
      new MoreUsefulCopperClientForge();
    }
  }

  private <T> void bind(ResourceKey<Registry<T>> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {
    eventBus.addListener((Consumer<? extends RegisterEvent>) event -> {
      if (registry.equals(event.getRegistryKey())) {
        source.accept((t, rl) -> event.register(registry, rl, () -> t));
      }
    });
  }

  public MoreUsefulCopperForge() {
    this(FMLJavaModLoadingContext.get());
  }
}