package mymod._09_EpicWeapons;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class LavaLauncher extends Item{

	public LavaLauncher(){
		this.setCreativeTab(CreativeTabs.TOOLS);
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		if(!worldIn.isRemote){
			EntityLavaTrail lavaTrail = new EntityLavaTrail(worldIn, playerIn);
			lavaTrail.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, playerIn.getEyeHeight(), 2.0F, 0);
			worldIn.spawnEntity(lavaTrail);
		}
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
