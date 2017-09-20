package com.kreezcraft.leverbuttonlights;

import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;

import com.kreezcraft.leverbuttonlights.proxy.CommonProxy;
import com.kreezcraft.leverbuttonlights.recipes.ModRecipes;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

//@Mod(
//		modid = LeverButtonLights.MODID, 
//		version = LeverButtonLights.VERSION, 
//		name = LeverButtonLights.NAME, 
//		dependencies = "required-after:morebeautifulbuttons@[1.12.1-1.4.0.7,)"
//)
@Mod(
modid = LeverButtonLights.MODID, 
version = LeverButtonLights.VERSION, 
name = LeverButtonLights.NAME
)
public class LeverButtonLights
{
    public static final String MODID = "leverbuttonlights";
    public static final String NAME = "Lever & Button Lights";
    public static final String VERSION = "1.12.2-1.5";

    public static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(MODID);
    
    @Mod.Instance(MODID)
	public static LeverButtonLights instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		ModRecipes.init();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	@SidedProxy(serverSide = "com.kreezcraft.leverbuttonlights.proxy.CommonProxy", clientSide = "com.kreezcraft.leverbuttonlights.proxy.ClientProxy")
	public static CommonProxy proxy;

}
