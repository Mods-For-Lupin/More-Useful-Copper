package com.cursee.more_useful_copper.impl.common.registry;

import com.cursee.more_useful_copper.MoreUsefulCopper;
import com.cursee.more_useful_copper.impl.common.entity.CopperStatueEntity;
import java.util.function.BiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {

  public static EntityType<CopperStatueEntity> COPPER_STATUE;

  public static void register(BiConsumer<EntityType<?>, ResourceLocation> consumer) {
    COPPER_STATUE = EntityType.Builder.<CopperStatueEntity>of(CopperStatueEntity::new, MobCategory.MISC).build(MoreUsefulCopper.identifier("copper_statue").toString());

    consumer.accept(COPPER_STATUE, MoreUsefulCopper.identifier("copper_statue"));
  }
}
