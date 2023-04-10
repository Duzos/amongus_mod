package com.duzo.tutorialmod.block.custom;

import com.duzo.tutorialmod.screen.PlayerMonitorScreen;
import com.duzo.tutorialmod.tileentity.ModTileEntities;
import com.duzo.tutorialmod.tileentity.PlayerMonitorTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class PlayerMonitorBlock extends Block {
    public PlayerMonitorBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote()) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);

            if(!player.isCrouching()) {
                if (tileEntity instanceof PlayerMonitorTile) {
                    Minecraft.getInstance().displayGuiScreen(new PlayerMonitorScreen(new TranslationTextComponent("epic screen")));

//                    NetworkHooks.openGui(((ServerPlayerEntity) player), containerProvider, tileEntity.getPos());
                } else {
                    throw new IllegalStateException("Container Provider Missing.");
                }
            }
        }        return ActionResultType.SUCCESS;
    }

//    private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos) {
//        return new INamedContainerProvider() {
//            @Override
//            public ITextComponent getDisplayName() {
//                return new TranslationTextComponent("screen.tutorialmod.player_monitor");
//            }
//
//            @Nullable
//            @Override
//            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity player) {
//                return new PlayerMonitorContainer(i,worldIn,pos,playerInventory,player);
//            }
//        };
//    }
    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.PLAYER_MONITOR_TILE.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}
