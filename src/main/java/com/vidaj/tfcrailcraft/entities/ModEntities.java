package com.vidaj.tfcrailcraft.entities;

import com.vidaj.tfcrailcraft.TFCRailcraft;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntities {

	public static void setup() {
		EntityRegistry.registerGlobalEntityID(EntityWoodenMinecartChest.class, "woodenMinecartChest", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityWoodenMinecartChest.class, "woodenMinecartChest", 12, TFCRailcraft.instance, 80, 5, true);
	}
}
