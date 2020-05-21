package mymod._09_EpicWeapons;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class CreatureSpawner extends Item{
	
	public CreatureSpawner(){
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		Random rand = new Random();
		
		if(!worldIn.isRemote){
			for(int i=0; i<10; i++){
				EntityCow cow= new EntityCow(worldIn);
				cow.setPosition(playerIn.posX, playerIn.posY, playerIn.posZ);
				
				cow.motionX = playerIn.getLookVec().x*5 +rand.nextInt(3)-1;
				cow.motionY = playerIn.getLookVec().y*3 +rand.nextInt(3)-1;
				cow.motionZ = playerIn.getLookVec().z*5 +rand.nextInt(3)-1;
				
				worldIn.spawnEntity(cow);
			}
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}
}
