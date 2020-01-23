package com.kreezcraft.leverbuttonlights.blocks;

import com.kreezcraft.leverbuttonlights.LeverButtonLights;
import com.kreezcraft.leverbuttonlights.client.IHasModel;
import com.kreezcraft.leverbuttonlights.items.InitItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class GlassBlock extends GlassLever implements IHasModel {

	private static final boolean isOn = false;
	protected String name;
    protected final AxisAlignedBB FULL_BOX = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	   
	public GlassBlock(String name) {
		super(name);
		setLightOpacity(0);
		this.name = name;
		setUnlocalizedName(LeverButtonLights.MODID + "." + name);
		setCreativeTab(LeverButtonLights.creativeTab);
		setRegistryName(name);
		InitBlocks.BLOCKS.add(this);
		InitItems.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
	}

   
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return FULL_BOX; 
	}

  
}
