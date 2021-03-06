package com.kreezcraft.leverbuttonlights.blocks;

import java.util.Random;

import com.kreezcraft.leverbuttonlights.LeverButtonLights;
import com.kreezcraft.leverbuttonlights.client.IHasModel;
import com.kreezcraft.leverbuttonlights.items.InitItems;

import net.minecraft.block.BlockButtonStone;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class GlassButton extends BlockButtonStone implements IHasModel {

	protected String name;
	protected boolean lightState;

	public GlassButton(String name) {
		super();
		this.name = name;
		this.lightState = true;
		setTickRandomly(true);
		setLightOpacity(0);
		setUnlocalizedName(LeverButtonLights.MODID + "." + name);
		setCreativeTab(LeverButtonLights.creativeTab);
		setRegistryName(name);
		InitBlocks.BLOCKS.add(this);
		InitItems.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
	}

	@Override
	public boolean canProvidePower(IBlockState state) {
		return !this.lightState;
	}

	@Override
	public void registerModels() {
		LeverButtonLights.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	@Override
	public int getLightValue(IBlockState state) {
		return this.lightState ? 15 : 0;
	}

	private void notifyNeighbors(World worldIn, BlockPos pos, EnumFacing facing) {
		worldIn.notifyNeighborsOfStateChange(pos, this, false);
		worldIn.notifyNeighborsOfStateChange(pos.offset(facing.getOpposite()), this, false);
	}

	@Override
	protected void playClickSound(EntityPlayer player, World worldIn, BlockPos pos) {
		worldIn.playSound(player, pos, SoundEvents.BLOCK_GLASS_HIT, SoundCategory.BLOCKS, 0.3F, 0.6F);
	}

	@Override
	protected void playReleaseSound(World worldIn, BlockPos pos) {
		worldIn.playSound((EntityPlayer) null, pos, SoundEvents.BLOCK_GLASS_PLACE, SoundCategory.BLOCKS, 0.3F, 0.5F);
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			if (state.getValue(POWERED)) {
				setLightLevel(15f);
			} else {
				setLightLevel(0f);
			}
		}
	}

}
