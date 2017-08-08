package com.kreezcraft.leverbuttonlights.init;

import com.kreezcraft.leverbuttonlights.blocks.InitBlocks;
import com.kreezcraft.leverbuttonlights.client.IHasModel;
import com.kreezcraft.leverbuttonlights.items.InitItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class Registrar {

	@SubscribeEvent
	public static void onItemRegister(Register<Item> event) {
		event.getRegistry().registerAll(InitItems.ITEMS.toArray(new Item[0]));
	}

	@SubscribeEvent
	public static void onBlockRegister(Register<Block> event) {
		event.getRegistry().registerAll(InitBlocks.BLOCKS.toArray(new Block[0]));
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent e) {
		for (Item i : InitItems.ITEMS) {
			if (i instanceof IHasModel)
				((IHasModel) i).registerModels();
		}
		for (Block b : InitBlocks.BLOCKS) {
			if (b instanceof IHasModel)
				((IHasModel) b).registerModels();
		}
	}

//    @SubscribeEvent
//    public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
//    {
//    	ResourceLocation WoodenButton = new ResourceLocation("minecraft:wooden_button");
//    	ResourceLocation StoneButton = new ResourceLocation("minecraft:stone_button");
//
//    	IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
//        
//    	modRegistry.remove(WoodenButton);
//        modRegistry.remove(StoneButton);
//        
//    }
}
