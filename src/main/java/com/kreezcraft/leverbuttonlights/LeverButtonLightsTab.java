package com.kreezcraft.leverbuttonlights;

import com.kreezcraft.leverbuttonlights.blocks.InitBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class LeverButtonLightsTab extends CreativeTabs {

	public LeverButtonLightsTab(String label) {
		super(LeverButtonLights.MODID);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(InitBlocks.LIME_BUTTON);
	}
	
	@Override
	public boolean hasSearchBar() {
		return false;
	}

	
}