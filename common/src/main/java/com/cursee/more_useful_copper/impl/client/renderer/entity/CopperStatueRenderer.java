package com.cursee.more_useful_copper.impl.client.renderer.entity;

import com.cursee.more_useful_copper.MoreUsefulCopper;
import com.cursee.more_useful_copper.impl.client.model.CopperStatueModel;
import com.cursee.more_useful_copper.impl.common.entity.CopperStatueEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;

public class CopperStatueRenderer extends LivingEntityRenderer<CopperStatueEntity, CopperStatueModel> {

  public static final ResourceLocation DEFAULT_SKIN_LOCATION = MoreUsefulCopper.identifier("textures/entity/copper_statue/spider.png");

  public CopperStatueRenderer(Context context) {
    super(context, new CopperStatueModel(context.bakeLayer(CopperStatueModel.LAYER_LOCATION)), 0.0f);
  }

  @Override
  public ResourceLocation getTextureLocation(CopperStatueEntity copperStatueEntity) {
    return DEFAULT_SKIN_LOCATION;
  }

  @Override
  protected boolean shouldShowName(CopperStatueEntity entity) {
    double d0 = this.entityRenderDispatcher.distanceToSqr(entity);
    float f = entity.isCrouching() ? 32.0F : 64.0F;
    return !(d0 >= (double) (f * f)) && entity.isCustomNameVisible();
  }

  @Nullable
  protected RenderType getRenderType(CopperStatueEntity livingEntity, boolean bodyVisible, boolean translucent, boolean glowing) {
//    if (!livingEntity.isMarker()) {
//      return super.getRenderType(livingEntity, bodyVisible, translucent, glowing);
//    } else {
//      ResourceLocation resourcelocation = this.getTextureLocation(livingEntity);
//      if (translucent) {
//        return RenderType.entityTranslucent(resourcelocation, false);
//      } else {
//        return bodyVisible ? RenderType.entityCutoutNoCull(resourcelocation, false) : null;
//      }
//    }

    ResourceLocation resourcelocation = this.getTextureLocation(livingEntity);
    if (translucent) {
      return RenderType.entityTranslucent(resourcelocation, false);
    } else {
      return bodyVisible ? RenderType.entityCutoutNoCull(resourcelocation, false) : null;
    }
  }

  @Override
  public void render(CopperStatueEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
    super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
  }
}
