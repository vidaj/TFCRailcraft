package com.vidaj.tfcrailcraft.recipes;

import java.util.ArrayList;
import java.util.List;

import com.bioxx.tfc.Core.Recipes;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Constant.Global;
import com.bioxx.tfc.api.Crafting.BarrelManager;
import com.bioxx.tfc.api.Crafting.BarrelRecipe;

import mods.railcraft.api.crafting.RailcraftCraftingManager;
import mods.railcraft.common.blocks.RailcraftBlocks;
import mods.railcraft.common.blocks.aesthetics.cube.EnumCube;
import mods.railcraft.common.blocks.machine.alpha.EnumMachineAlpha;
import mods.railcraft.common.blocks.machine.beta.EnumMachineBeta;
import mods.railcraft.common.fluids.Fluids;
import mods.railcraft.common.items.ItemRailcraft;
import mods.railcraft.common.items.RailcraftItem;
import mods.railcraft.common.items.RailcraftToolItems;
import mods.railcraft.common.plugins.forge.OreDictPlugin;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeManager {
	
	private static final int COKE_COOK_CREOSOTE = 500;
	private static final int COKE_COOK_TIME = 1800;
	
	private final List<ItemStack> itemsToRemove = new ArrayList<ItemStack>();
	

	public void registerRecipes() {
		setupItemsToRemove();
		removeRecipes();
		registerCokeOven();
		registerWoodenTieBarrelRecipes();
		registerSteelTankRecipes();
		registerIronTankRecipes();
	}
	
	private void setupItemsToRemove() {
		itemsToRemove.add(EnumMachineBeta.TANK_STEEL_WALL.getItem(8));
		itemsToRemove.add(EnumMachineBeta.TANK_STEEL_GAUGE.getItem(8));
		itemsToRemove.add(EnumMachineBeta.TANK_STEEL_VALVE.getItem(8));
		itemsToRemove.add(EnumMachineBeta.TANK_IRON_WALL.getItem(8));
		itemsToRemove.add(EnumMachineBeta.TANK_IRON_GAUGE.getItem(8));
		itemsToRemove.add(EnumMachineBeta.TANK_IRON_VALVE.getItem(8));
		itemsToRemove.add(RailcraftToolItems.getSteelShears());
		itemsToRemove.add(RailcraftToolItems.getSteelArmor());
		itemsToRemove.add(RailcraftToolItems.getSteelAxe());
		itemsToRemove.add(RailcraftToolItems.getSteelBoots());
		itemsToRemove.add(RailcraftToolItems.getSteelHelm());
		itemsToRemove.add(RailcraftToolItems.getSteelHoe());
		itemsToRemove.add(RailcraftToolItems.getSteelLegs());
		itemsToRemove.add(RailcraftToolItems.getSteelPickaxe());
		itemsToRemove.add(RailcraftToolItems.getSteelShovel());
		itemsToRemove.add(RailcraftToolItems.getSteelSword());
	}

	private void registerSteelTankRecipes() {
		GameRegistry.addRecipe(new ShapedOreRecipe(EnumMachineBeta.TANK_STEEL_WALL.getItem(8),
				new Object[] {
	                "PP",
	                "PP",
	                'P', "plateSteel" }));

		GameRegistry.addRecipe(new ShapedOreRecipe(EnumMachineBeta.TANK_STEEL_GAUGE.getItem(8),
	        		new Object[] {
	                "GPG",
	                "PGP",
	                "GPG",
	                'P', "plateSteel",
	                'G', new ItemStack(Blocks.glass_pane)
	        }));

		GameRegistry.addRecipe(new ShapedOreRecipe(EnumMachineBeta.TANK_STEEL_VALVE.getItem(8),
				new Object[] {
	                "GPG",
	                "PLP",
	                "GPG",
	                'P', "steelPlate",
	                'L', new ItemStack(Blocks.lever),
	                'G', new ItemStack(Blocks.iron_bars)}));		
	}
	
	private void registerIronTankRecipes() {
		GameRegistry.addRecipe(new ShapedOreRecipe(EnumMachineBeta.TANK_IRON_WALL.getItem(8),
				new Object[] {
	                "PP",
	                "PP",
	                'P', "plateIron" }));

		GameRegistry.addRecipe(new ShapedOreRecipe(EnumMachineBeta.TANK_IRON_GAUGE.getItem(8),
	        		new Object[] {
	                "GPG",
	                "PGP",
	                "GPG",
	                'P', "plateIron",
	                'G', new ItemStack(Blocks.glass_pane)
	        }));

		GameRegistry.addRecipe(new ShapedOreRecipe(EnumMachineBeta.TANK_IRON_VALVE.getItem(8),
				new Object[] {
	                "GPG",
	                "PLP",
	                "GPG",
	                'P', "plateIron",
	                'L', new ItemStack(Blocks.lever),
	                'G', new ItemStack(Blocks.iron_bars)}));		
	}

	private void registerCokeOven() {
		removeRecipe(EnumMachineAlpha.COKE_OVEN.getItem());
		
		GameRegistry.addRecipe(new ShapedOreRecipe(EnumMachineAlpha.COKE_OVEN
				.getItem(1), new Object[] { "sbs", "bsb", "sbs",
				Character.valueOf('s'), "blockSand", Character.valueOf('b'),
				new ItemStack(TFCItems.FireBrick, 1, 1) }));

		if (RailcraftToolItems.getCoalCoke() != null) {
			for (int i = 0; i < Global.WOOD_ALL.length; i++) {
				RailcraftCraftingManager.cokeOven.addRecipe(new ItemStack(
						TFCItems.Logs, 1, i), true, false, new ItemStack(
						TFCItems.Coal, 1, 1), Fluids.CREOSOTE
						.get(COKE_COOK_CREOSOTE), COKE_COOK_TIME);
			}
		}
	}
	
	private void registerWoodenTieBarrelRecipes() {
		Item tie = GameRegistry.findItem("Railcraft", "part.tie");
		ItemStack woodenTie = new ItemStack(tie, 1);
		FluidStack creosote = new FluidStack(Fluids.CREOSOTE.get(), 1000);

		for (int i = 0; i < Global.WOOD_ALL.length; i++) {
			BarrelManager.getInstance().addRecipe(
					new BarrelRecipe(new ItemStack(TFCItems.SinglePlank, 1, i),
							creosote,
							woodenTie, creosote)
							.setMinTechLevel(0));
		}
	}
	
	private void removeRecipes()
	{
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		for (int i = 0; i < recipes.size(); i++)
		{
			if (recipes.get(i) != null)
			{
				IRecipe tmpRecipe = recipes.get(i);

				IRecipe recipe = tmpRecipe;
				if (recipe == null) {
					continue;
				}
				
				ItemStack recipeResult = recipe.getRecipeOutput();
				
				if (recipeResult == null) {
					continue;
				}
				
				if (shouldRemoveItem(recipe)) {
					recipes.remove(i--);
				}
			}
		}
	}
	
	private boolean shouldRemoveItem(IRecipe recipe) {
		ItemStack recipeResult = recipe.getRecipeOutput();
		
		if  (OreDictPlugin.isOreType("ingotSteel", recipeResult) && recipeResult.stackSize == 9) {
			return true;
		}
		
		for (ItemStack removableItem : itemsToRemove)  {
			if (recipeResult.isItemEqual(removableItem)) {
				return true;
			}
		}
		
		return false;
	}
	
	private void removeRecipe(Item item) {
		Recipes.RemoveRecipe(new ItemStack(item));
	}
	
	private void removeRecipe(ItemStack itemStack) {
		Recipes.RemoveRecipe(itemStack);
	}
}
