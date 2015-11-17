package com.vidaj.tfcrailcraft;

import com.vidaj.tfcrailcraft.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(
		modid = Constants.ModId, 
		version = Constants.Version, 
		dependencies = Constants.Dependencies)
public class TFCRailcraft {
	
	@SidedProxy(clientSide="com.vidaj.tfcrailcraft.proxy.ClientProxy", serverSide="com.vidaj.tfcrailcraft.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static TFCRailcraft instance;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerOreDict();
		proxy.registerRecipes();
		proxy.registerEventHandlers();
		proxy.registerRenderers();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.registerFluids();
		proxy.registerBlocks();
		proxy.registerItems();
		proxy.registerEntities();
	}
}
