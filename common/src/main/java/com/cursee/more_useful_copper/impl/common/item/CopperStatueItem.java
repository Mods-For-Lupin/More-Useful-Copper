package com.cursee.more_useful_copper.impl.common.item;

import com.cursee.more_useful_copper.impl.common.entity.CopperStatueEntity;
import com.cursee.more_useful_copper.impl.common.registry.ModEntities;
import java.util.function.Consumer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CopperStatueItem extends Item {

  public CopperStatueItem(Properties properties) {
    super(properties);
  }

  /// When the player clicks on any side of a block
  @Override
  public InteractionResult useOn(UseOnContext context) {

    Direction clickDirection = context.getClickedFace();

    if (clickDirection == Direction.DOWN) {
      return InteractionResult.FAIL;
    }

    BlockPlaceContext blockPlaceContext = new BlockPlaceContext(context);

    Level level = context.getLevel();
    BlockPos clickedBlockPos = blockPlaceContext.getClickedPos();
    Vec3 bottomCenter = Vec3.atBottomCenterOf(clickedBlockPos);
    AABB boundingBox = EntityType.ARMOR_STAND.getDimensions().makeBoundingBox(bottomCenter);

    if (!level.noCollision(null, boundingBox) || !level.getEntities(null, boundingBox).isEmpty()) {
      return InteractionResult.FAIL;
    }

    ItemStack stackInHand = context.getItemInHand();

    if (level instanceof ServerLevel serverLevel) {

      // Uses the entity, sets the player as the owner in the entity tag?
      Consumer<CopperStatueEntity> consumer = EntityType.createDefaultStackConfig(serverLevel, stackInHand, context.getPlayer());

      CopperStatueEntity copperStatue = ModEntities.COPPER_STATUE.create(serverLevel, stackInHand.getTag(), consumer, clickedBlockPos, MobSpawnType.SPAWN_EGG, true, true);

      // if we fail to create the armor stand due to mob cap or some other reason, fail early.
      if (copperStatue == null) {
        return InteractionResult.FAIL;
      }

      float armorStandYRotation = (float) Mth.floor((Mth.wrapDegrees(context.getRotation() - 180.0F) + 22.5F) / 45.0F) * 45.0F;
      copperStatue.moveTo(copperStatue.getX(), copperStatue.getY(), copperStatue.getZ(), armorStandYRotation, 0.0F);
      serverLevel.addFreshEntityWithPassengers(copperStatue); // ?? passengers??

      level.playSound(null, copperStatue.getX(), copperStatue.getY(), copperStatue.getZ(), SoundEvents.ARMOR_STAND_PLACE, SoundSource.BLOCKS, 0.75F, 0.8F);
      copperStatue.gameEvent(GameEvent.ENTITY_PLACE, context.getPlayer());
    }

    stackInHand.shrink(1);
    return InteractionResult.sidedSuccess(level.isClientSide());
  }
}
