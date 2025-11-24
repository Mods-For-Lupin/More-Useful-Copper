package com.cursee.more_useful_copper.api.common.block;

import com.cursee.more_useful_copper.api.common.block.ModWeatheringCopper.WeatherState;
import com.cursee.more_useful_copper.impl.common.registry.ModBlocks;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Optional;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public interface ModWeatheringCopper extends ChangeOverTimeBlock<WeatherState> {

  Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(
      () -> ImmutableBiMap.<Block, Block>builder().put(ModBlocks.COPPER_STATUE, ModBlocks.EXPOSED_COPPER_STATUE).put(ModBlocks.EXPOSED_COPPER_STATUE, ModBlocks.WEATHERED_COPPER_STATUE)
          .put(ModBlocks.WEATHERED_COPPER_STATUE, ModBlocks.OXIDIZED_COPPER_STATUE).build());

  Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> NEXT_BY_BLOCK.get().inverse());

  static Optional<Block> getPrevious(Block block) {
    return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(block));
  }

  static Block getFirst(Block p_block) {
    Block block = p_block;

    for (Block block1 = PREVIOUS_BY_BLOCK.get().get(p_block); block1 != null; block1 = PREVIOUS_BY_BLOCK.get().get(block1)) {
      block = block1;
    }

    return block;
  }

  static Optional<BlockState> getPrevious(BlockState state) {
    return getPrevious(state.getBlock()).map((p_154903_) -> p_154903_.withPropertiesOf(state));
  }

  static Optional<Block> getNext(Block block) {
    return Optional.ofNullable(NEXT_BY_BLOCK.get().get(block));
  }

  static BlockState getFirst(BlockState state) {
    return getFirst(state.getBlock()).withPropertiesOf(state);
  }

  default @NotNull Optional<BlockState> getNext(BlockState state) {
    return getNext(state.getBlock()).map((p_154896_) -> p_154896_.withPropertiesOf(state));
  }

  default float getChanceModifier() {
    return this.getAge() == ModWeatheringCopper.WeatherState.UNAFFECTED ? 0.75F : 1.0F;
  }

  enum WeatherState {
    UNAFFECTED, EXPOSED, WEATHERED, OXIDIZED
  }
}
