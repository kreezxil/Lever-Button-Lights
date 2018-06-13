package com.kreezcraft.leverbuttonlights.blocks;

import java.util.Random;

import com.kreezcraft.leverbuttonlights.LeverButtonLights;
import com.kreezcraft.leverbuttonlights.client.IHasModel;
import com.kreezcraft.leverbuttonlights.items.InitItems;

import net.minecraft.block.BlockLever;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class GlassLever extends BlockLever implements IHasModel {

	protected String name;
    protected final AxisAlignedBB FULL_BOX = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);


	public GlassLever(String name) {
		super();
		
		setLightOpacity(0);
		this.name = name;
		setUnlocalizedName(LeverButtonLights.MODID + "." + name);
		setCreativeTab(LeverButtonLights.creativeTab);
		setRegistryName(name);
		InitBlocks.BLOCKS.add(this);
		InitItems.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if (this.name == "glass_light_block") return FULL_BOX;
		return super.getBoundingBox(state, source, pos);
	}

	@Override
	public void registerModels() {
		LeverButtonLights.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	@Override
	public int getLightValue(IBlockState state) {
		return state.getValue(POWERED) ? 15 : 0;
	}
	
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (state.getValue(POWERED))
            {
                setLightLevel(15f);
            } else {
            	setLightLevel(0f);
            }
        }
    }

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
		
	//Minecraft.getMinecraft().effectRenderer.addEffect(new YourParticle())
	
	protected void playClickSound(EntityPlayer player, World worldIn, BlockPos pos) {
	      worldIn.playSound(player, pos, SoundEvents.BLOCK_GLASS_HIT, SoundCategory.BLOCKS, 0.3F, 0.6F);
	}

	protected void playReleaseSound(World worldIn, BlockPos pos) {
          worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_GLASS_PLACE, SoundCategory.BLOCKS, 0.3F, 0.5F);
	}
}
