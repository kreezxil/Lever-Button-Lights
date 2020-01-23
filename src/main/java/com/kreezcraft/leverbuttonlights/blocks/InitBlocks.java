package com.kreezcraft.leverbuttonlights.blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockButtonWood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.AxisAlignedBB;

public class InitBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	   	
	public static final GlassLever GLASS_LEVER = new GlassLever("glass_lever");
	public static final GlassLever GLASS_LIGHT_BLOCK = new GlassLever("glass_light_block");

	public static final ColoredLightButton GLASS_BUTTON = new ColoredLightButton("glass_button");

	public static final ColoredLightButton BLUE_BUTTON = new ColoredLightButton("blue_button");
	public static final ColoredLightButton BLACK_BUTTON = new ColoredLightButton("black_button");
	public static final ColoredLightButton BROWN_BUTTON = new ColoredLightButton("brown_button");
	public static final ColoredLightButton CYAN_BUTTON = new ColoredLightButton("cyan_button");

	public static final ColoredLightButton GRAY_BUTTON = new ColoredLightButton("gray_button");
	public static final ColoredLightButton GREEN_BUTTON = new ColoredLightButton("green_button");
	public static final ColoredLightButton LIGHT_BLUE_BUTTON = new ColoredLightButton("light_blue_button");
	public static final ColoredLightButton LIME_BUTTON = new ColoredLightButton("lime_button");
	
	public static final ColoredLightButton MAGENTA_BUTTON = new ColoredLightButton("magenta_button");
	public static final ColoredLightButton ORANGE_BUTTON = new ColoredLightButton("orange_button");
	public static final ColoredLightButton PINK_BUTTON = new ColoredLightButton("pink_button");
	public static final ColoredLightButton PURPLE_BUTTON = new ColoredLightButton("purple_button");
	
	public static final ColoredLightButton RED_BUTTON = new ColoredLightButton("red_button");
	public static final ColoredLightButton SILVER_BUTTON = new ColoredLightButton("silver_button");
	public static final ColoredLightButton WHITE_BUTTON = new ColoredLightButton("white_button");
	public static final ColoredLightButton YELLOW_BUTTON = new ColoredLightButton("yellow_button");

}