package com.kreezcraft.leverbuttonlights.items;

import com.kreezcraft.leverbuttonlights.LeverButtonLights;
import com.kreezcraft.leverbuttonlights.client.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	protected String name;

	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(LeverButtonLights.MODID + "." + name);
		setRegistryName(name);
		InitItems.ITEMS.add(this);
	}

	public void registerItemModel() {
		LeverButtonLights.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public ItemBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

	@Override
	public void registerModels() {
		LeverButtonLights.proxy.registerItemRenderer(this, 0, "inventory");
	}

}