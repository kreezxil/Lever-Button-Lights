package com.kreezcraft.leverbuttonlights.recipes;

import com.kreezcraft.leverbuttonlights.blocks.InitBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.util.ResourceLocation;

public class ModRecipes {

	public static void init() {
		//GameRegistry.addSmelting(InitBlocks.DIAMOND_SAND, new ItemStack(InitBlocks.DIAMOND_GLASS), 10f);
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocks.GLASS_LEVER), "s","g", 's', Items.STICK, 'g', Blocks.GLASS);
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocks.GLASS_LIGHT_BLOCK), "t","g",'t',Blocks.TORCH,'g',Blocks.GLASS);
		
	}

}
