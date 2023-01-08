package com.duzo.tutorialmod.item;

import com.duzo.tutorialmod.TutorialMod;
import com.duzo.tutorialmod.item.custom.Firestone;
import net.minecraft.item.Food;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> AMONGUS = ITEMS.register("amongus",() -> new Item(new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP).food(new Food.Builder().effect(() -> new EffectInstance(Effects.SPEED, 100, 2),0.5f).hunger(2).meat().saturation(1f).build())));
    public static final RegistryObject<Item> FIRESTONE = ITEMS.register("firestone",() -> new Firestone(new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP).maxDamage(8)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
