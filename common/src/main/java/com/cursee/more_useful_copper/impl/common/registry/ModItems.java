package com.cursee.more_useful_copper.impl.common.registry;

import com.cursee.more_useful_copper.MoreUsefulCopper;
import com.cursee.more_useful_copper.impl.common.block.CopperStatueBlock;
import java.util.function.BiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WeatheringCopper.WeatherState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class ModItems {

  public static Item COPPER_STATUE;
  public static Item EXPOSED_COPPER_STATUE;
  public static Item WEATHERED_COPPER_STATUE;
  public static Item OXIDIZED_COPPER_STATUE;

  public static Item WAXED_COPPER_STATUE;
  public static Item WAXED_EXPOSED_COPPER_STATUE;
  public static Item WAXED_WEATHERED_COPPER_STATUE;
  public static Item WAXED_OXIDIZED_COPPER_STATUE;

  public static void register(BiConsumer<Item, ResourceLocation> consumer) {
    COPPER_STATUE = new BlockItem(ModBlocks.COPPER_STATUE, new Item.Properties());
    EXPOSED_COPPER_STATUE = new BlockItem(ModBlocks.EXPOSED_COPPER_STATUE, new Item.Properties());
    WEATHERED_COPPER_STATUE = new BlockItem(ModBlocks.WEATHERED_COPPER_STATUE, new Item.Properties());
    OXIDIZED_COPPER_STATUE = new BlockItem(ModBlocks.OXIDIZED_COPPER_STATUE, new Item.Properties());

    WAXED_COPPER_STATUE = new BlockItem(ModBlocks.WAXED_COPPER_STATUE, new Item.Properties());
    WAXED_EXPOSED_COPPER_STATUE = new BlockItem(ModBlocks.WAXED_EXPOSED_COPPER_STATUE, new Item.Properties());
    WAXED_WEATHERED_COPPER_STATUE = new BlockItem(ModBlocks.WAXED_WEATHERED_COPPER_STATUE, new Item.Properties());
    WAXED_OXIDIZED_COPPER_STATUE = new BlockItem(ModBlocks.WAXED_OXIDIZED_COPPER_STATUE, new Item.Properties());

    consumer.accept(COPPER_STATUE, MoreUsefulCopper.identifier("copper_statue"));
    consumer.accept(EXPOSED_COPPER_STATUE, MoreUsefulCopper.identifier("exposed_copper_statue"));
    consumer.accept(WEATHERED_COPPER_STATUE, MoreUsefulCopper.identifier("weathered_copper_statue"));
    consumer.accept(OXIDIZED_COPPER_STATUE, MoreUsefulCopper.identifier("oxidized_copper_statue"));

    consumer.accept(WAXED_COPPER_STATUE, MoreUsefulCopper.identifier("waxed_copper_statue"));
    consumer.accept(WAXED_EXPOSED_COPPER_STATUE, MoreUsefulCopper.identifier("waxed_exposed_copper_statue"));
    consumer.accept(WAXED_WEATHERED_COPPER_STATUE, MoreUsefulCopper.identifier("waxed_weathered_copper_statue"));
    consumer.accept(WAXED_OXIDIZED_COPPER_STATUE, MoreUsefulCopper.identifier("waxed_oxidized_copper_statue"));
  }
}
