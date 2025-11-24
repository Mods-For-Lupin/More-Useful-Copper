package com.cursee.more_useful_copper.impl.common.block;

import com.cursee.more_useful_copper.api.common.block.ModWeatheringCopper;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CopperStatueBlock extends Block implements ModWeatheringCopper {

  private final ModWeatheringCopper.WeatherState weatherState;

  public CopperStatueBlock(ModWeatheringCopper.WeatherState weatherState, BlockBehaviour.Properties properties) {
    super(properties);
    this.weatherState = weatherState;
  }

  @SuppressWarnings("deprecation")
  public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
    this.onRandomTick(state, level, pos, random);
  }

  public boolean isRandomlyTicking(BlockState state) {
    return ModWeatheringCopper.getNext(state.getBlock()).isPresent();
  }

  public @NotNull ModWeatheringCopper.WeatherState getAge() {
    return this.weatherState;
  }
}
