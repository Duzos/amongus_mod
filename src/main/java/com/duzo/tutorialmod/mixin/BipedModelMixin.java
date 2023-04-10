package com.duzo.tutorialmod.mixin;

import com.duzo.tutorialmod.client.ClientModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedModel.class)
public class BipedModelMixin {

    @Inject(at = @At("TAIL"), method = "setRotationAngles(Lnet/minecraft/entity/Entity;FFFFF)V", cancellable = true)
    private void setRotationAngles(Entity entity, float par2, float par3, float par4, float par5, float par6, CallbackInfo ci) {
        BipedModel bipedModel = (BipedModel) (Object) this;
//
//        System.out.println("LOOK HERE");
//        System.out.println(entity.getDisplayName());
//        if (entity.getDisplayName().toString() == "Dev") {
//            System.out.println("IS DEV TRUE");
//            ClientModel.disable(bipedModel);
//        }
    }

}
