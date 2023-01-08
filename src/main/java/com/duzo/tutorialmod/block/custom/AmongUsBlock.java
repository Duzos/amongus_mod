package com.duzo.tutorialmod.block.custom;

import com.duzo.tutorialmod.item.ModItems;
import com.duzo.tutorialmod.item.custom.Firestone;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class AmongUsBlock extends Block {
    public AmongUsBlock(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,BlockRayTraceResult hit) {

        if(!worldIn.isRemote()) {
            if (checkHeldItemIsEqualToDesired(player, ModItems.FIRESTONE.get())) {
                worldIn.destroyBlock(pos, false);
                player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 200));
                player.addPotionEffect(new EffectInstance(Effects.SPEED, 200));
                player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 200));
                player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 200));
                player.addPotionEffect(new EffectInstance(Effects.GLOWING, 200));
            }
        }

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        Firestone.lightEntityOnFire(entityIn,5);
        super.onEntityWalk(worldIn, pos, entityIn);
    }

    public static boolean checkHeldItemIsEqualToDesired(PlayerEntity player, Item item) {
        if (player.getHeldItem(Hand.MAIN_HAND).getItem() == item) {
            return true;
        }
        return false;
    }

}
