package com.duzo.tutorialmod.container;

import com.duzo.tutorialmod.TutorialMod;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.swing.*;

public class ModContainers {
    public static DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, TutorialMod.MOD_ID);

    public static final RegistryObject<ContainerType<LightningChannelerContainer>> LIGHTNING_CHANNELER_CONTAINER = CONTAINERS.register("lightning_channeler_container", () -> IForgeContainerType.create(((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new LightningChannelerContainer(windowId, world, pos, inv, inv.player);
    })));

//    public static final RegistryObject<ContainerType<PlayerMonitorContainer>> PLAYER_MONITOR_CONTAINER = CONTAINERS.register("player_monitor_container", () -> IForgeContainerType.create(((windowId, inv, data) -> {
//        BlockPos pos = data.readBlockPos();
//        World world = inv.player.getEntityWorld();
//        return new PlayerMonitorContainer(windowId, world, pos, inv, inv.player);
//    })));

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
