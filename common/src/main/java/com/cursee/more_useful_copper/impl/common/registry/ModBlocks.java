package com.cursee.more_useful_copper.impl.common.registry;

import com.cursee.more_useful_copper.MoreUsefulCopper;
import com.cursee.more_useful_copper.api.common.block.ModWeatheringCopper;
import com.cursee.more_useful_copper.api.common.block.ModWeatheringCopper.WeatherState;
import com.cursee.more_useful_copper.impl.common.block.CopperStatueBlock;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.function.BiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {

  public static Block COPPER_STATUE;
  public static Block EXPOSED_COPPER_STATUE;
  public static Block WEATHERED_COPPER_STATUE;
  public static Block OXIDIZED_COPPER_STATUE;

  public static List<Block> OXIDIZING_STATUE_BLOCKS = List.of();

  public static Block WAXED_COPPER_STATUE;
  public static Block WAXED_EXPOSED_COPPER_STATUE;
  public static Block WAXED_WEATHERED_COPPER_STATUE;
  public static Block WAXED_OXIDIZED_COPPER_STATUE;

  public static void register(BiConsumer<Block, ResourceLocation> consumer) {
    COPPER_STATUE = new CopperStatueBlock(WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion());
    EXPOSED_COPPER_STATUE = new CopperStatueBlock(WeatherState.EXPOSED, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion());
    WEATHERED_COPPER_STATUE = new CopperStatueBlock(WeatherState.WEATHERED, BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_STEM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion());
    OXIDIZED_COPPER_STATUE = new CopperStatueBlock(WeatherState.OXIDIZED, BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_NYLIUM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion());

    OXIDIZING_STATUE_BLOCKS = Lists.newArrayList(COPPER_STATUE, EXPOSED_COPPER_STATUE, WEATHERED_COPPER_STATUE, OXIDIZED_COPPER_STATUE);

    WAXED_COPPER_STATUE = new Block(BlockBehaviour.Properties.copy(COPPER_STATUE));
    WAXED_EXPOSED_COPPER_STATUE = new Block(BlockBehaviour.Properties.copy(EXPOSED_COPPER_STATUE));
    WAXED_WEATHERED_COPPER_STATUE = new Block(BlockBehaviour.Properties.copy(WEATHERED_COPPER_STATUE));
    WAXED_OXIDIZED_COPPER_STATUE = new Block(BlockBehaviour.Properties.copy(OXIDIZED_COPPER_STATUE));

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
