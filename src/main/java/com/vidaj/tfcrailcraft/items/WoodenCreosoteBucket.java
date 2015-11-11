package com.vidaj.tfcrailcraft.items;

import java.util.List;

import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Enums.EnumItemReach;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import com.bioxx.tfc.api.Interfaces.ISize;
import com.vidaj.tfcrailcraft.Constants;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.BlockFluidFinite;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.railcraft.common.fluids.Fluids;
import mods.railcraft.common.fluids.ItemBucketRailcraft;

public class WoodenCreosoteBucket extends ItemBucketRailcraft implements ISize{

	private final ItemStack container = new ItemStack(TFCItems.woodenBucketEmpty);
	
	public WoodenCreosoteBucket() {
		super(Fluids.CREOSOTE.get());
	}
	
	public Item setUnlocalizedName(String name)
	{
	  return super.setUnlocalizedName(name);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
	  this.itemIcon = par1IconRegister.registerIcon(Constants.ModId + ":WoodenCreosoteBucket");
	}
	
	public ItemStack getContainerItem(ItemStack stack)
	{
	  return this.container.copy();
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		return stack;
	}

	@Override
	public EnumSize getSize(ItemStack paramItemStack) {
		return EnumSize.MEDIUM;
	}

	@Override
	public EnumWeight getWeight(ItemStack paramItemStack) {
		return EnumWeight.LIGHT;
	}

	@Override
	public EnumItemReach getReach(ItemStack paramItemStack) {
		return EnumItemReach.SHORT;
	}

	@Override
	public boolean canStack() {
		return false;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List arraylist, boolean flag)
	{
		ItemTerra.addSizeInformation(is, arraylist);
	}
}
