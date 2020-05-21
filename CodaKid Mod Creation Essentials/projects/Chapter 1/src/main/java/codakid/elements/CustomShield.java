package codakid.elements;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.client.audio.Sound;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CustomShield extends Item {
	
	//Declare variables here
	public int range=7;
	public int power=6;
	public String shieldName="my_shield";
	
	public CustomShield() { 
		this.setUnlocalizedName(shieldName);
		this.setRegistryName(shieldName);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		List<Entity> mobs= CK.getTargets(world, player, range);
		for(Entity mob : mobs){
			CK.sendOppositeDirection(world, mob, player, power);
		}
		return super.onItemRightClick(world, player, hand);
	}	
}
