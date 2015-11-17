package com.vidaj.tfcrailcraft.entities;

import com.vidaj.tfcrailcraft.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.entity.item.EntityMinecartContainer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityWoodenMinecartChest extends EntityMinecartContainer{

	public EntityWoodenMinecartChest(World p_i1714_1_) {
		super(p_i1714_1_);
	}
	
	public EntityWoodenMinecartChest(World p_i1715_1_, double p_i1715_2_, double p_i1715_4_, double p_i1715_6_)
    {
        super(p_i1715_1_, p_i1715_2_, p_i1715_4_, p_i1715_6_);
    }

	@Override
	public int getSizeInventory()
    {
        return 9;
    }
	
	public void killMinecart(DamageSource p_94095_1_)
    {
        super.killMinecart(p_94095_1_);
//        this.func_145778_a(Item.getItemFromBlock(Blocks.chest), 1, 0.0F);
    }

    public int getMinecartType()
    {
        return 1;
    }

    public Block func_145817_o()
    {
        return Blocks.chest;
    }

    public int getDefaultDisplayTileOffset()
    {
        return 8;
    }
    
    public EntityItem entityDropItem(ItemStack p_70099_1_, float p_70099_2_)
    {
    	return super.entityDropItem(new ItemStack(ModItems.WoodenMinecartChest, 1), p_70099_2_);
    }
}
