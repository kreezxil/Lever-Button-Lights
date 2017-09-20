package com.kreezcraft.leverbuttonlights.blocks;

import java.util.Random;

import com.kreezcraft.leverbuttonlights.LeverButtonLights;
import com.kreezcraft.leverbuttonlights.client.IHasModel;
import com.kreezcraft.leverbuttonlights.items.InitItems;

import net.minecraft.block.BlockButtonStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GlassButton extends BlockButtonStone implements IHasModel {
	
	protected String name;
	protected boolean lightState;
	protected int interval;
	protected int counter;
	
	public GlassButton(String name) {
		super();
		this.counter=0;
		this.name = name;
		this.lightState = true;
		setTickRandomly(true);
		setLightOpacity(0);
		setUnlocalizedName(LeverButtonLights.MODID + "." + name);
		setCreativeTab(CreativeTabs.REDSTONE);
		setRegistryName(name);
		InitBlocks.BLOCKS.add(this);
		InitItems.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
	}

	public GlassButton setInterval(int ticks) {
		this.interval = ticks;
		return this;
	}
	
	@Override
	public void registerModels() {
		LeverButtonLights.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	@Override
	public int getLightValue(IBlockState state) {
		if(this.counter<this.interval) {
			return 15;
		}
		return 0;
	}
	
	//don't ask why, just explain what I did wrong
	/*
	 * What I'm trying to do.
	 * 
	 * this object on creation is passed an int value to setInterval.
	 * This number is used to control flashing effect.
	 * 
	 * The object has a counter that is incremented each time the getLightValue is accessed
	 * If the counter value is higher than the interval multiplied by 2 then we reset it to 0
	 * the interval gives us x amount of on ticks and x amount of off ticks
	 * if the counter is value 0 to interval then the light state is on, or here 15 is returned
	 * if the counter is value of interval thru to interval multiplied by 2 then it is off
	 * and 0 is returned.
	 * 
	 * this does not work as intended.
	 * 
	 * I was told to use blockstates or rather go back the true false state I used two days ago.
	 * the said it goes in the updatetick, but that wasn't updating. They suggest scheduling the update, which 
	 * I tried but probably didn't integrate correctly.
	 * 
	 * so probably in the blockplaced event I'll start a schedule and then keep it scheduled in update tick.
	 * 
	 * Personally I think the counter is the way to go, however I have to get to actually change the light
	 * when we're in the off phase of counter.
	 * 
	 * 
	 * 
	 */
	@Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
		int myass=2;
		if(myass==1) return;
        if (!worldIn.isRemote)
        {
    		if(this.counter>this.interval * 2) {
    			this.counter=0;
    		}
    		this.counter++;
        }
        LeverButtonLights.logger.info("Counter is "+this.counter);
    	super.updateTick(worldIn, pos, state, rand);

    }

    //player.sendStatusMessage(new TextComponentTranslation(Chococraft.MODID + ".entity_chocobo.tame_success"), true);
    
    private void notifyNeighbors(World worldIn, BlockPos pos, EnumFacing facing)
    {
        worldIn.notifyNeighborsOfStateChange(pos, this, false);
        worldIn.notifyNeighborsOfStateChange(pos.offset(facing.getOpposite()), this, false);
    }

    @Override
	protected void playClickSound(EntityPlayer player, World worldIn, BlockPos pos) {
	      worldIn.playSound(player, pos, SoundEvents.BLOCK_GLASS_HIT, SoundCategory.BLOCKS, 0.3F, 0.6F);
	}

	@Override
	protected void playReleaseSound(World worldIn, BlockPos pos) {
          worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_GLASS_PLACE, SoundCategory.BLOCKS, 0.3F, 0.5F);
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
	

}

