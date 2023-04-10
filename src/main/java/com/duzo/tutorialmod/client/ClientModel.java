package com.duzo.tutorialmod.client;

import com.duzo.tutorialmod.TutorialMod;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModel {
    public static void disable(BipedModel bipedModel) {
        bipedModel.setVisible(false);
    }
    public static void enable(BipedModel bipedModel) {
        bipedModel.setVisible(true);
    }
}
