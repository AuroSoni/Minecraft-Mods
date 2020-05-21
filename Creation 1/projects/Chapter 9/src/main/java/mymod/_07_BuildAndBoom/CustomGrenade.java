package mymod._07_BuildAndBoom;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class CustomGrenade extends Item{
	
	public CustomGrenade(){
		
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		if(!worldIn.isRemote){
			EntityGrenade grenade = new EntityGrenade(worldIn, playerIn);
			grenade.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, playerIn.getEyeHeight(), 0.9F, 0);
			worldIn.spawnEntity(grenade);
			playerIn.getHeldItem(handIn).shrink(1);
		}
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
