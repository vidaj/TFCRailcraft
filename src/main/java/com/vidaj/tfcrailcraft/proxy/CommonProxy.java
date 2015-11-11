package com.vidaj.tfcrailcraft.proxy;

import mods.railcraft.common.items.ItemPlate.EnumPlate;
import mods.railcraft.common.items.RailcraftItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.bioxx.tfc.api.TFCItems;
import com.vidaj.tfcrailcraft.recipes.RecipeManager;

public class CommonProxy {

	public void registerRecipes() {
		new RecipeManager().registerRecipes();
	}
	
	public void registerEventHandlers() {
		
	}
	
	public void registerBlocks() {
		
	}
	
	public void registerItems() {
		com.vidaj.tfcrailcraft.items.ModItems.setup();
	}
	
	public void registerFluids() {
		
	}

	public void registerOreDict() {
		OreDictionary.registerOre("plateIron", new ItemStack(TFCItems.wroughtIronSheet));
		OreDictionary.registerOre("ingotDoubleIron", new ItemStack(TFCItems.wroughtIronIngot2x));
		
		OreDictionary.registerOre("plateSteel", (ItemStack) RailcraftItem.plate.getRecipeObject(EnumPlate.STEEL));
		OreDictionary.registerOre("plateIron", (ItemStack) RailcraftItem.plate.getRecipeObject(EnumPlate.IRON));
		OreDictionary.registerOre("plateWroughtIron", (ItemStack) RailcraftItem.plate.getRecipeObject(EnumPlate.IRON));
		OreDictionary.registerOre("plateCopper", (ItemStack) RailcraftItem.plate.getRecipeObject(EnumPlate.COPPER));
		OreDictionary.registerOre("plateTin", (ItemStack) RailcraftItem.plate.getRecipeObject(EnumPlate.TIN));
	}
}
