package com.vidaj.tfcrailcraft.proxy;

import com.vidaj.tfcrailcraft.entities.EntityWoodenMinecartChest;
import com.vidaj.tfcrailcraft.entities.renderers.WoodenMinecartRenderer;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {

	@Override
	@SideOnly(Side.CLIENT)
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodenMinecartChest.class, new WoodenMinecartRenderer());
	}
}
