package com.cursee.more_useful_copper.impl.common.registry;

import com.cursee.more_useful_copper.Constants;
import com.cursee.more_useful_copper.MoreUsefulCopper;
import com.cursee.more_useful_copper.platform.Services;
import java.util.function.BiConsumer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabs {

  public static CreativeModeTab MORE_USEFUL_COPPER;

  public static void register(BiConsumer<CreativeModeTab, ResourceLocation> consumer) {
    MORE_USEFUL_COPPER = Services.PLATFORM.itemTabBuilder().icon(() -> new ItemStack(ModItems.COPPER_STATUE)).title(Component.literal(Constants.MOD_NAME))
        .displayItems((itemDisplayParameters, output) -> {
          output.accept(ModItems.COPPER_STATUE);
          output.accept(ModItems.EXPOSED_COPPER_STATUE);
          output.accept(ModItems.WEATHERED_COPPER_STATUE);
          output.accept(ModItems.OXIDIZED_COPPER_STATUE);

          output.accept(ModItems.WAXED_COPPER_STATUE);
          output.accept(ModItems.WAXED_EXPOSED_COPPER_STATUE);
          output.accept(ModItems.WAXED_WEATHERED_COPPER_STATUE);
          output.accept(ModItems.WAXED_OXIDIZED_COPPER_STATUE);
        }).build();

    consumer.accept(MORE_USEFUL_COPPER, MoreUsefulCopper.identifier(Constants.MOD_ID));
  }
}
