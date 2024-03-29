package com.duzo.tutorialmod.block;

import com.duzo.tutorialmod.TutorialMod;
import com.duzo.tutorialmod.block.custom.AmongUsBlock;
import com.duzo.tutorialmod.block.custom.LightningChannelerBlock;
import com.duzo.tutorialmod.block.custom.PlayerMonitorBlock;
import com.duzo.tutorialmod.item.ModItemGroup;
import com.duzo.tutorialmod.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.world.NoteBlockEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sun.reflect.generics.visitor.Reifier;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> AMONGUS_ORE = registerBlock("amongus_ore",() -> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));
    public static final RegistryObject<Block> AMONGUS_BLOCK = registerBlock("amongus_block", () -> new AmongUsBlock(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(2f)));
    public static final RegistryObject<Block> AMONGUS_STAIRS = registerBlock("amongus_stairs", () -> new StairsBlock(() -> AMONGUS_BLOCK.get().getDefaultState(), AbstractBlock.Properties.create(Material.IRON).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(2f)));
    public static final RegistryObject<Block> LIGHTNING_CHANNELER = registerBlock("lightning_channeler", () -> new LightningChannelerBlock(AbstractBlock.Properties.create(Material.IRON)));
    public static final RegistryObject<Block> PLAYER_MONITOR_BLOCK = registerBlock("player_monitor", () -> new PlayerMonitorBlock(Block.Properties.create(Material.IRON)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
