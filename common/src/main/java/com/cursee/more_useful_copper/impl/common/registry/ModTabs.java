package com.cursee.more_useful_copper.impl.common.registry;

import com.cursee.more_useful_copper.Constants;
import com.cursee.more_useful_copper.platform.Services;
import java.util.function.BiConsumer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class ModTabs {

  public static CreativeModeTab MORE_USEFUL_COPPER;

  public static void register(BiConsumer<Block, ResourceLocation> consumer) {
    MORE_USEFUL_COPPER = Services.PLATFORM.itemTabBuilder()
        .icon(() -> new ItemStack(ModItems.COPPER_STATUE))
        .title(Component.literal(Constants.MOD_NAME)).build();
  }
}
