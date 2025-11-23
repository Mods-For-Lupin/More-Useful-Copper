package com.cursee.more_useful_copper.mixin.client;

import com.cursee.more_useful_copper.MoreUsefulCopper;
import com.cursee.more_useful_copper.platform.Services;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {

  @Inject(at = @At("TAIL"), method = "<init>")
  private void init(CallbackInfo info) {

    if (Services.PLATFORM.isDevelopmentEnvironment()) {
      MoreUsefulCopper.LOG.info("This line is printed by an example mixin from Common!");
      MoreUsefulCopper.LOG.info("MC Version: {}", Minecraft.getInstance().getVersionType());
    }
  }
}