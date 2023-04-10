//package com.duzo.tutorialmod.container;
//
//
//import com.duzo.tutorialmod.block.ModBlocks;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.inventory.container.Container;
//import net.minecraft.inventory.container.Slot;
//import net.minecraft.item.ItemStack;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.util.IWorldPosCallable;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//import net.minecraftforge.items.CapabilityItemHandler;
//import net.minecraftforge.items.IItemHandler;
//import net.minecraftforge.items.SlotItemHandler;
//import net.minecraftforge.items.wrapper.InvWrapper;
//
//public class PlayerMonitorContainer extends Container {
//    private final TileEntity tileEntity;
//    private final PlayerEntity playerEntity;
//    private final IItemHandler playerInventory;
//    public PlayerMonitorContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player) {
//        super(ModContainers.PLAYER_MONITOR_CONTAINER.get(), windowId);
//        this.tileEntity = world.getTileEntity(pos);
//        playerEntity = player;
//        this.playerInventory = new InvWrapper(playerInventory);
//
//        //layoutPlayerInventorySlots(8,86);
//
////        if (tileEntity != null) {
////            tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
////                addSlot(new SlotItemHandler(h, 0,80,31));
////                addSlot(new SlotItemHandler(h, 1,80,53));
////            });
////        }
//    }
//
//
//    @Override
//    public boolean canInteractWith(PlayerEntity playerIn) {
//        return isWithinUsableDistance(IWorldPosCallable.of(tileEntity.getWorld(),tileEntity.getPos()), playerIn, ModBlocks.PLAYER_MONITOR_BLOCK.get());
//    }
//}
