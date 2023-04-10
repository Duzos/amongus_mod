package com.duzo.tutorialmod.tileentity;

import com.duzo.tutorialmod.TutorialMod;
import com.duzo.tutorialmod.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, TutorialMod.MOD_ID);

    public static RegistryObject<TileEntityType<LightningChannelerTile>> LIGHTNING_CHANNELER_TILE = TILE_ENTITIES.register("lightning_channeler_tile", () -> TileEntityType.Builder.create(LightningChannelerTile::new, ModBlocks.LIGHTNING_CHANNELER.get()).build(null));
    public static RegistryObject<TileEntityType<PlayerMonitorTile>> PLAYER_MONITOR_TILE = TILE_ENTITIES.register("player_monitor_tile", () -> TileEntityType.Builder.create(PlayerMonitorTile::new, ModBlocks.PLAYER_MONITOR_BLOCK.get()).build(null));
    //public static RegistryObject<TileEntityType<LoqorMonitorTile>> LOQOR_MONITOR_TILE = TILE_ENTITIES.register("loqor_monitor_tile", () -> TileEntityType.Builder.create(LoqorMonitorTile::new, ModBlocks.LOQOR_MONITOR.get()).build(null));
    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
