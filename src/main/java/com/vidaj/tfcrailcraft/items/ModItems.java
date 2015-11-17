package com.vidaj.tfcrailcraft.items;

import com.bioxx.tfc.api.TFCItems;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.railcraft.common.fluids.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class ModItems {

	public static Item WoodenCreosoteBucket;
	
	public static Item WoodenMinecartChest;
	
	public static void setup() {
		createItems();
		registerItems();
	}

	private static void createItems() {
		WoodenCreosoteBucket = new WoodenCreosoteBucket().setUnlocalizedName("woodenCreosoteBucket");
		WoodenMinecartChest = new ItemWoodenMinecartChest(1).setUnlocalizedName("woodenminecart_chest").setTextureName("woodenminecart_chest");
	}
	
	private static void registerItems() {
		GameRegistry.registerItem(WoodenCreosoteBucket, "woodenCreosoteBucket");
		FluidContainerRegistry.FluidContainerData container = new FluidContainerRegistry.FluidContainerData(Fluids.CREOSOTE.get(1000), new ItemStack(WoodenCreosoteBucket), new ItemStack(TFCItems.woodenBucketEmpty));
		FluidContainerRegistry.registerFluidContainer(container);
		
		GameRegistry.registerItem(WoodenMinecartChest, "woodenMinecartChest");
	}
}
