package mymod._09_EpicWeapons;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ThunderHammer extends ItemSword{

	public ThunderHammer(ToolMaterial material) {
		super(material);
		
		this.setCreativeTab(CreativeTabs.COMBAT);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		Vec3d blockHit = playerIn.rayTrace(200, 1F).hitVec;
		worldIn.spawnEntity(new EntityLightningBolt(worldIn, blockHit.x, blockHit.y, blockHit.z, false));
		worldIn.spawnEntity(new EntityLightningBolt(worldIn, blockHit.x, blockHit.y, blockHit.z, false));
		worldIn.spawnEntity(new EntityLightningBolt(worldIn, blockHit.x, blockHit.y, blockHit.z, false));
		worldIn.spawnEntity(new EntityLightningBolt(worldIn, blockHit.x, blockHit.y, blockHit.z, false));
		
		worldIn.createExplosion(playerIn, blockHit.x, blockHit.y, blockHit.z, 5.0F, false);
		
		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}
}
