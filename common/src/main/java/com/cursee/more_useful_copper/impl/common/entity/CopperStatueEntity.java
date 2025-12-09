package com.cursee.more_useful_copper.impl.common.entity;

import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CopperStatueEntity extends LivingEntity {

  private final NonNullList<ItemStack> handItems;
  private final NonNullList<ItemStack> armorItems;

  public CopperStatueEntity(EntityType<? extends LivingEntity> entityType, Level level) {
    super(entityType, level);
    this.handItems = NonNullList.withSize(2, ItemStack.EMPTY);
    this.armorItems = NonNullList.withSize(4, ItemStack.EMPTY);
    this.setMaxUpStep(0.0f);
  }

  public CopperStatueEntity(Level level, double x, double y, double z) {
    this(EntityType.ARMOR_STAND, level);
    this.setPos(x, y, z);
  }

  @Override
  public Iterable<ItemStack> getArmorSlots() {
    return this.armorItems;
  }

  @Override
  public ItemStack getItemBySlot(EquipmentSlot slot) {
    switch (slot.getType()) {
      case HAND -> {
        return this.handItems.get(slot.getIndex());
      }
      case ARMOR -> {
        return this.armorItems.get(slot.getIndex());
      }
      default -> {
        return ItemStack.EMPTY;
      }
    }
  }

  @Override
  public void setItemSlot(EquipmentSlot equipmentSlot, ItemStack itemStack) {

  }

  @Override
  public HumanoidArm getMainArm() {
    return HumanoidArm.RIGHT;
  }
}
