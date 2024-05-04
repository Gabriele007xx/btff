
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bttf.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.bttf.BttfMod;

public class BttfModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BttfMod.MODID);
	public static final RegistryObject<Item> DMC = REGISTRY.register("dmc_spawn_egg",
			() -> new ForgeSpawnEggItem(BttfModEntities.DMC, -10066330, -16737793, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
